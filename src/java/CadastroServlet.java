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

/**
 *
 * @author bruno
 */
@WebServlet(urlPatterns = {"/cadastrar"})
public class CadastroServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String login = request.getParameter("login");
        String email = request.getParameter("email");
        String nome = request.getParameter("nome");
        String senha = request.getParameter("senha");
        
        Usuario u = new Usuario(login, email, nome, senha, 0);
        BancoDeDados b = new BancoDeDados();
        
        b.inserir(u);
        
        request.setAttribute("msgCadastradoComSucesso", "Usuário cadastrado com sucesso!");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

}
