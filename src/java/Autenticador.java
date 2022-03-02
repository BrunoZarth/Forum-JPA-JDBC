import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Autenticador {
    
    static{
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
    }
    
    String senhaBancoDeDados = "admin";
    
    public String autenticar(String login, String senha) throws Exception{
        
        try {
            Connection c = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/coursera", "postgres", senhaBancoDeDados);
			
            String sql = "select nome from usuario where login = ? and senha = ?";
            PreparedStatement stm = c.prepareStatement(sql);	
            stm.setString(1, login);
            stm.setString(2, senha);
            ResultSet rs = stm.executeQuery();
            if(rs.next()){
                return rs.getString("nome");
            } else{
                throw new Exception("Não foi possível autenticar o usuário!");
            }
        } catch(Exception e){
            throw new Exception("Não foi possível autenticar o usuário!");
        }
    }
    
}
