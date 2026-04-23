<%-- 
    Document   : listarPavilhoes
    Created on : 21/04/2026, 12:48:42
    Author     : formando
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Pavilhões</title>
    </head>
    <body>
        <h1>Listas de Pavilhões</h1>


        <c:forEach var="pavilhao" items="${listaPavilhoes}" varStatus="pos">
            <p>Designação: ${pavilhao.designacao}</p>
            <p>Numero: ${pavilhao.numero}</p>
            
            <!--
            <form action="GestorEstruturaServlet" method="POST">
                <input type="hidden" name="excluirPavilhao" value="${pavilhao.id}" 
                <input type="submit" value="Excluir Pavilhão"/>
            </form>
            <hr>
            
             -->
        </c:forEach>
    </body>
</html>