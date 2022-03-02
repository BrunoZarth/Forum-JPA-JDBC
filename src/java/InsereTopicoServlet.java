
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author bruno
 */
@WebServlet(urlPatterns = {"/inseretopico"})
public class InsereTopicoServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String login = request.getParameter("login");
        
        if(!(request.getParameter("titulo") == null) && !(request.getParameter("conteudo") == null)){
            String titulo = request.getParameter("titulo");
            String conteudo = request.getParameter("conteudo");
        
            BancoDeDados b = new BancoDeDados();
            b.inserirTopico(titulo, conteudo, login);
            request.setAttribute("login", login);
            request.getRequestDispatcher("topicos.jsp").forward(request, response);
        }else{
        request.setAttribute("login", login);
        request.getRequestDispatcher("inseretopico.jsp").forward(request, response);  
        }
    }

}
