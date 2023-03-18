<%-- 
    Document   : index
    Created on : 16 feb 2023, 21:03:08
    Author     : crome
--%>

<%@page import="java.util.Enumeration"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="controller.paso" %>

<!DOCTYPE html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <%
         HttpSession sesion = request.getSession(false);
         Enumeration e=sesion.getAttributeNames();
            
         Cookie[] ck= request.getCookies();
         if (!e.hasMoreElements()) 
            {
                out.println("Hola, escribe tu nombre: ");
                %>
                
                    <form action="paso" method="post">
                    Nombre: <br>
                    <input type="text" name="name" />
                    <br>
                
                
        <%
            } 
            else 
            {
                out.println("Bienvenido, " + sesion.getAttribute("nombre"));
            }
        %>
        <br><br>
        <%
            
            if (ck != null) {
                for (int i=0;i<ck.length; i++) {
                    String nombre = ck[i].getName();
                    String valorCk = ck[i].getValue();
                    if (nombre.equals("baseCk")) 
                    {
                        out.println("Tu ultima base ingresada fue: " + valorCk+", ");
                    } 
                    else if (nombre.equals("alturaCk")) 
                    {
                        out.println("tu ultima altura ingresada: " + valorCk+", ");
                    } 
                    else if (nombre.equals("areaCk")) 
                    {
                        out.println("tu ultima área calculada: " + valorCk+", ");
                    } 
                    else if (nombre.equals("perimetroCk")) 
                    {
                        out.println("tu ultimo perímetro calculado: " + valorCk+", ");
                    }
                }
            }
        %>
        
        
        
        <h1>Area y perimetro de un triangulo</h1>
              Base: <br>
              <input type="text" name="base" value=""><br>
              Altura: <br>
              <input type="text" name="altura" value="" ><br><br>
              <input type="submit" value="Calcular">
              <br><br>
        </form>
        
    </body>
