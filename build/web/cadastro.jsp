<%-- 
    Document   : cadastro
    Created on : 16 de fev de 2022, 19:48:46
    Author     : bruno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro</title>
    </head>
    <body>
        <h1>Insira seus dados para o cadastro:</h1>
        <form method="POST" action="cadastrar">
            Login: <input type="text" name="login" />
            E-mail: <input type="text" name="email" />
            Nome: <input type="text" name="nome" />
            Senha: <input type="password" name="senha" />
            <input type="submit" value="Criar conta" />
        </form>
    </body>
</html>
