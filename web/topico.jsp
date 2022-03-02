<%-- 
    Document   : topico
    Created on : 17 de fev de 2022, 00:36:46
    Author     : bruno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p>logado como: ${login}</p>
        <hr>
        <h1>${topico.titulo}</h1>
        <h4>Autor: ${topico.login}</h4>
        <br>
        <p>${topico.conteudo}</p>
        <hr>
        <br><br>
        
        <c:forEach items="${comentarios}" var="comentario">
            <p>${comentario}</p> 
        </c:forEach>
        
        <br><br>
        
        <h3>Comentar:</h3>
        <form method="POST" action="topico">
            <input type="hidden" name="login" value="${login}">
            <input type="text" name="comentario" height="500px" width="700px"/>
            <button type="submit" name="topico" value="${topico.titulo}">
                    Adicionar novo comentário
                </button>
        </form>
         
                    
                    <br><br>            
        <form method="POST" action="topicos">
            <input type="hidden" name="login" value="${login}"/>
            <input type="submit" value="voltar para tópicos" />
        </form>           
    </body>
</html>

