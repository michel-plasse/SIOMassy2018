<%-- 
    Document   : consulterAvis
    Created on : 26 avr. 2018, 17:05:39
    Author     : Ronan
--%>
<%@taglib prefix="p" tagdir="/WEB-INF/tags" %>
<p:header titre="Consulter les Avis"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
            <form method="post" action="DemandeAvisServlet">
            <input type="submit" name="demanderLesAvis" value="Demander les avis">    
            </form>

            </body>
</html>
