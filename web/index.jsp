<html>
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Fa�a login ou cadastre um novo usu�rio:</h1>
        <form method="POST" action="login">
            Login: <input type="text" name="login" />
            Senha: <input type="password" name="senha" />
            <input type="submit" value="Fazer Login" />
        </form>
        
        <a href="/Forum-JPA-JDBC/cadastro.jsp"><input type="button" value="Cadastrar novo usu�rio"/></a>

        
        <h2>${erro}</h2>
        <h2>${msgCadastradoComSucesso}</h2>
    </body>
</html>