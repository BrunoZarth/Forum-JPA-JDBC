<%-- 
    Document   : inseretopico
    Created on : 19 de fev de 2022, 19:06:17
    Author     : bruno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Novo Topico</title>
    </head>
    <body>
        <p>Usuario logado: ${login}</p>
        <h1>Inserir novo tópico</h1>
        <form method="POST" action="topicos">
            <input type="hidden" name="login" value="${login}"/>
            Título: <input type="text" name="titulo" />
            Conteúdo: <input type="text" name="conteudo" />
            <input type="submit" value="Inserir tópico" />
        </form>
    </body>
</html>
