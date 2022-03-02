<%-- 
    Document   : ranking
    Created on : 19 de fev de 2022, 19:06:40
    Author     : bruno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ranking</title>
    </head>
    <body>
        <h1>Ranking</h1>
        
        <table>
            <tr>
                <td>Colocação</td>
                <td>Nome</td>
                <td>Login</td>
                <td>Pontuação</td>
            </tr>
            <c:forEach items="${listaDeUsuarios}" var="usuario" varStatus="loop">
                <tr>
                <td><c:out value="${loop.index + 1}"/></td>
                <td><c:out value="${usuario.nome}"/></td>
                <td><c:out value="${usuario.login}"/></td>
                <td><c:out value="${usuario.pontos}"/></td>
                </tr>
            </c:forEach>
        </table>
        
        <br><br>
        <form method="POST" action="topicos">
            <input type="hidden" name="login" value="${login}"/>
            <input type="submit" value="voltar para tópicos" />
        </form>
    </body>
</html>
