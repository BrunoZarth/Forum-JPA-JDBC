
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tópicos</title>
    </head>
    <body>
        <p>logado como: ${login}</p>
        <h1>Bem vindo, ${nome}!</h1>
        
        <br>
            <form method="POST" action="inseretopico">
                <input type="hidden" name="login" value="${login}">
                <input type="submit" value="Inserir novo tópico" />
            </form>  
            <br>
            <form method="POST" action="ranking">
                <input type="hidden" name="login" value="${login}">
                <input type="submit" value="Ranking" />
            </form>  
                
          <br><br>     
        
        <c:forEach items="${listaDeTopicos}" var="topico">
            <form method="POST" action="topico">
                <input type="hidden" name="login" value="${login}">
                <input type="hidden" name="topico" value="${topico.titulo}">
                <button type="submit" >
                    titulo: <c:out value="${topico.titulo}"/> <br><br>
                    Autor: <c:out value="${topico.nome}"/>
                </button>
            </form>
            <br>
        </c:forEach>
            
            
    </body>
</html>
