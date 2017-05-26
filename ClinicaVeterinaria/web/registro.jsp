<%-- 
    Document   : registro
    Created on : 22/05/2017, 10:02:37
    Author     : usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrarme</title>
    </head>
    <body>
        <center>
        <div class="container">
        <h1>Registrarme</h1> 
        <form  class="col-md-5 col-md-offset-3" action="RegistroUsuarioController" method="post" >
            <label>Usuario</label>
            <p><input type="text" name="usuario"></p>
            <label>Nombre</label>
            <p><input type="text" name="nombre"></p>
            <label>Apellido</label>
            <p><input type="text" name="apellido"></p>
            <label>Password</label>
            <p><input type="text" name="password"></p>
            <p><input class="bg-primary" type="submit" name="Registrarme"></p>
        </form>
        </div>
    </center>
    </body>
</html>
