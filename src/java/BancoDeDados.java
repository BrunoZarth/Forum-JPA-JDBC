import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BancoDeDados implements UsuarioDAO {
	
	static{
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
    }
	
        String senhaBancoDeDados = "admin";
        
	@Override
	public void inserir(Usuario u) {
		try {
			Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/coursera", "postgres", senhaBancoDeDados);
			
			String sql = "INSERT INTO usuario(login, email, nome, senha, pontos) VALUES(?, ?, ?, ?, ?);";
			PreparedStatement stm = c.prepareStatement(sql);
			stm.setString(1, u.getLogin());
			stm.setString(2, u.getEmail());
			stm.setString(3, u.getNome());
			stm.setString(4, u.getSenha());
			stm.setInt(5, u.getPontos());
			stm.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Usuario recuperar(String login) {
			
		try {
			Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/coursera", "postgres", senhaBancoDeDados);
			
			String sql = "SELECT * FROM usuario WHERE login = ?;";
			PreparedStatement stm = c.prepareStatement(sql);
			stm.setString(1, login);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				Usuario u = new Usuario(rs.getString("login"), rs.getString("email"), rs.getString("nome"), rs.getString("senha"), rs.getInt("pontos"));
				return u;
			}

			
		} catch (SQLException e) {
                    System.out.println("Não recuperou, login passado: " + login);
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void adicionarPontos(String login, int pontos) {
		try {
			Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/coursera", "postgres", senhaBancoDeDados);
			
			String sql = "UPDATE usuario SET pontos = pontos + ? WHERE login = ?;";
			PreparedStatement stm = c.prepareStatement(sql);
			stm.setInt(1, pontos);
			stm.setString(2, login);
			stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Usuario> ranking() {
		List<Usuario> listaDeUsuarios = new ArrayList<>();
		try {
			Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/coursera", "postgres", senhaBancoDeDados);
			
			String sql = "SELECT * FROM usuario ORDER BY pontos DESC;";
			PreparedStatement stm = c.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				Usuario u = new Usuario(rs.getString("login"), rs.getString("email"), rs.getString("nome"), rs.getString("senha"), rs.getInt("pontos"));
				listaDeUsuarios.add(u);	
			}

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaDeUsuarios;
	}
        
        public List<Topico> listarTopicos() {
                List<Topico> listaDeTopicos = new ArrayList<>();
			
		try {
			Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/coursera", "postgres", senhaBancoDeDados);
			
			String sql = "SELECT * FROM topico;";
			PreparedStatement stm = c.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();

			while(rs.next()) {
                            String login = rs.getString("login");
                            String nome = this.recuperar(login).getNome();
                            Topico topico = new Topico(rs.getString("titulo"), rs.getString("conteudo"), login, rs.getInt("id_topico"), nome);
                            listaDeTopicos.add(topico);
			}

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaDeTopicos;
	}
        
        public Topico recuperarTopico(String tituloDoTopico) {
		Topico topicoRecuperado;
		try {
			Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/coursera", "postgres", senhaBancoDeDados);
			
			String sql = "SELECT * FROM topico where titulo = ?;";
			PreparedStatement stm = c.prepareStatement(sql);
                        stm.setString(1, tituloDoTopico.trim());
			ResultSet rs = stm.executeQuery();
                        while(rs.next()){
                           topicoRecuperado = new Topico(rs.getString("titulo"), rs.getString("conteudo"), rs.getString("login"), rs.getInt("id_topico")); 
                           return topicoRecuperado;
                        }      	
		} catch (SQLException e) {
                    e.printStackTrace();
                    return topicoRecuperado = new Topico("Tópico não encontrado", "", "", 0);
		}
            return topicoRecuperado = new Topico("Tópico não encontrado", "", "", 0);
	}

    public List<String> recuperaComentarios(int idDoTopico) {
        List<String> listaDeComentarios = new ArrayList<>();
			
	try {
            Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/coursera", "postgres", "tartarugo:le");
			
            String sql = "select * from comentario where id_topico = ?;";
            PreparedStatement stm = c.prepareStatement(sql);
            stm.setInt(1, idDoTopico);
            ResultSet rs = stm.executeQuery();

            while(rs.next()) {
                String comentario = "<b>" + rs.getString("login")+ ":</b> " + rs.getString("comentario");
                listaDeComentarios.add(comentario);
            }		
        } catch (SQLException e) {
            e.printStackTrace();
	}
        return listaDeComentarios;
    }

    public void adicionarComentario(String novoComentario, String login, int id_topico) {
        try {
            Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/coursera", "postgres", senhaBancoDeDados);
			
            String sql = "INSERT INTO public.comentario(" +
                "comentario, login, id_topico)" +
                "VALUES(?, ?, ?);";
            
            PreparedStatement stm = c.prepareStatement(sql);
            stm.setString(1, novoComentario);
            stm.setString(2, login);
            stm.setInt(3, id_topico);
            stm.executeUpdate();
		
            this.adicionarPontos(login, 3);
	} catch (SQLException e) {
            e.printStackTrace();
	}
    }
    
    public void inserirTopico(String titulo, String conteudo, String login) {
        try {
            Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/coursera", "postgres", senhaBancoDeDados);
			
            String sql = "INSERT INTO public.topico(" +
                "titulo, conteudo, login)" +
                "VALUES(?, ?, ?);";
            
            PreparedStatement stm = c.prepareStatement(sql);
            stm.setString(1, titulo);
            stm.setString(2, conteudo);
            stm.setString(3, login);
            stm.executeUpdate();
            
            this.adicionarPontos(login, 10);
	} catch (SQLException e) {
            e.printStackTrace();
	}
    }

}