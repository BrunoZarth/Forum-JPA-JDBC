
public class Topico {
    
    String titulo;
    String conteudo;
    String login;
    int id_topico;
    String nome;

    
    public Topico(String titulo, String conteudo, String login, int id_topico) {
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.login = login;
        this.id_topico = id_topico;
    }

    public Topico(String titulo, String conteudo, String login, int id_topico, String nome) {
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.login = login;
        this.id_topico = id_topico;
        this.nome = nome;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getId_topico() {
        return id_topico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Topico{" + "titulo=" + titulo + ", conteudo=" + conteudo + ", login=" + login + ", id_topico=" + id_topico + ", nome=" + nome + '}';
    }

    

    
}
