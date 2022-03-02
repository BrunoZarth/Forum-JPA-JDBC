
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            String login = request.getParameter("login");
            String senha = request.getParameter("senha");
            
            Autenticador a = new Autenticador();
            BancoDeDados b = new BancoDeDados();
            
            
        try {
            String nomeUsuario = a.autenticar(login, senha);
            
            List<Topico> listaDeTopicos = b.listarTopicos();
            request.setAttribute("listaDeTopicos", listaDeTopicos);
            
            request.setAttribute("nome", nomeUsuario);
            request.setAttribute("login", login);
            request.getRequestDispatcher("topicos.jsp").forward(request, response);
            
            //((Usuario)request.getSession()).usuarioLogado = b.recuperar(login);
        } catch (Exception ex) {
            request.setAttribute("erro", ex.getMessage());
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

}
