<%-- 
    Document   : ajoutDocument
    Created on : 26 avr. 2018, 15:56:14
    Author     : stagiaire
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ajouter un document</title>
    </head>
    <body>
        <h1>Ajouter un document</h1>
        <form action="ajoutDocument" method="post" enctype="multipart/form-data">
            1 - Selectionner un document:
            <br/><br/>
            <input type="file" name="doc"/>
            <br/><br/>
            2 - Renomer le document. Laisser le champs vide pour garder le nom par defaut.
            <br/><br/>
            <input type="text" name="nouveauNom" value="Renomer"/>
            <br/><br/>
            3 - Quelles sessions peuvent utiliser ce document ?
            <br/><br/>
            <table style="border: 1px solid black;border-collapse: collapse;">
                <tr style="border: 1px solid black;">
                    <th style="border: 1px solid black;">Selection</th>
                    <th style="border: 1px solid black;">Formation</th>
                    <th style="border: 1px solid black;">Dates debut - fin</th>
                </tr>
                <c:forEach items="${lesSession}" var="uneSession">
                    <tr style="border: 1px solid black;">
                        <td style="border: 1px solid black;"><input type="checkbox" name="idSession[]" value="${uneSession.getIdSession()}"></td>
                        <td style="border: 1px solid black;"><c:out value="${uneSession.getNomFormation()}"/></td>
                        <td style="border: 1px solid black;"><c:out value="${uneSession.getDateDebut()} - ${uneSession.getDateFin()}"/></td>                        
                    </tr>
                </c:forEach>
            </table>
            <br/><br/>
            4 - <input type="submit" name="uploadDoc" value="Envoyer"/>
        </form>

    </body>
</html>
