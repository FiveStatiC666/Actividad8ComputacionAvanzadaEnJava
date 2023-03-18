<%-- 
    Document   : muestraResultado
    Created on : 16 feb 2023, 21:53:51
    Author     : crome
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Calculos.triangulo"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Area y perimetro</h1>
        
        <%
            triangulo s=(triangulo) request.getAttribute("calculo");
        %>
        <h1>Area: </h1>
        <%=s.getArea()%>
        <h1>Perimetro: </h1>
        <%=s.getPerimetro()%>
    </body>
</html>
