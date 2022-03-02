

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author bruno
 */
@WebServlet(urlPatterns = {"/topicos"})
public class TopicosServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String login = request.getParameter("login");
            
        BancoDeDados b = new BancoDeDados();
            
            
        try {
            
            if(!(request.getParameter("titulo") == null) && !(request.getParameter("conteudo") == null)){
                String titulo = request.getParameter("titulo");
                String conteudo = request.getParameter("conteudo");
                b.inserirTopico(titulo, conteudo, login);
            }
            
            String nomeUsuario = b.recuperar(login).getNome();
            
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
