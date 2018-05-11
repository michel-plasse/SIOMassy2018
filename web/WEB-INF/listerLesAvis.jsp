<%-- 
    Document   : listerLesAvis
    Created on : 26 avr. 2018, 15:53:06
    Author     : Ronan
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Liste des avis :</h1>
        
        <table style="border: 1px solid black;border-collapse: collapse;">
            <tr style="border: 1px solid black;">
                <th style="border: 1px solid black;">Date</th>
                <th style="border: 1px solid black;">Fonctionnalité</th>
                <th style="border: 1px solid black;">Ergonomie</th>
                <th style="border: 1px solid black;">Esthétisme</th>
                <th style="border: 1px solid black;">Commentaires</th>
            </tr>
            <c:forEach items="${listeDesAvis}" var="unAvis">
                <tr style="border: 1px solid black;">
                    <td style="border: 1px solid black;">${unAvis.getDate()}</td>
                    <td style="border: 1px solid black;">${unAvis.getFonctionnalite()}</td>
                    <td style="border: 1px solid black;">${unAvis.getErgonomie()}</td>
                    <td style="border: 1px solid black;">${unAvis.getBeaute()}</td>
                    <td style="border: 1px solid black;">${unAvis.getCommentaire()}</td>
                </tr>
            </c:forEach>
        </table>
        
        
        
        
        
    </body>
</html>
