
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;


@WebServlet(urlPatterns = {"/topico"})
public class TopicoServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String tituloDoTopico = request.getParameter("topico");
        String novoComentario = request.getParameter("comentario");
        String loginUsuario = request.getParameter("login");
        
        BancoDeDados b = new BancoDeDados();
        Topico topico = b.recuperarTopico(tituloDoTopico);
        Usuario usuario = b.recuperar(loginUsuario);
        if(!(novoComentario == null))
            b.adicionarComentario(novoComentario, usuario.getLogin(), topico.getId_topico());
        
        List<String> comentarios = b.recuperaComentarios(topico.getId_topico());
        
        request.setAttribute("topico", topico);
        request.setAttribute("comentarios", comentarios);
        request.setAttribute("login", loginUsuario);
        request.getRequestDispatcher("topico.jsp").forward(request, response);
    }

}
