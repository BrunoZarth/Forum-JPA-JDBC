/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author bruno
 */
@WebServlet(urlPatterns = {"/ranking"})
public class RankingServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String login = request.getParameter("login");
        
        BancoDeDados b = new BancoDeDados();
        List<Usuario> listaDeUsuarios = b.ranking();
        
        request.setAttribute("listaDeUsuarios", listaDeUsuarios);
        request.setAttribute("login", login);
        request.getRequestDispatcher("ranking.jsp").forward(request, response);
    }

}
