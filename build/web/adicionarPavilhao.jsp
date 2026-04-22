<%-- 
    Document   : adicionarPavilhao
    Created on : 22/04/2026, 15:21:47
    Author     : formando
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adicionar Pavilhões</title>
    </head>
    <body>
        <h1>Adicionar Pavilhão</h1>
        
        <form action="GestorEstruturaServlet" method="POST" >
            <input type="text" name="txtDesignacao" placeholder="Designação . . ."/><br>
            <input type="number" name="txtNumero" placeholder="Numero . . ."/><br><br>
            <input type="submit" value="Adicionar" />
        </form>  
    </body>
</html>
