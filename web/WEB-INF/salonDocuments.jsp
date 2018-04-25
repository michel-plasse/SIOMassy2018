<%-- 
    Document   : gestionDocuments
    Created on : 24 avr. 2018, 09:43:35
    Author     : YohanMA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Documents</title>
    </head>
    <body>
        <h1>Salon des Documents</h1>
        <br/>

        <c:if test="${sessionScope.user.isEstFormateur() || sessionScope.user.isEstAdministration()}">
            <form action="document" method="POST">
                <input type="file" name ="document" value=""/>                
                <br/><br/>
                <input type="submit" name="uploadDocument" value="Upload"/>                
            </form>
            <p></p>
        </c:if>

        <h2>Liste des documents disponible:</h2>
        <br/>
        <c:choose>
            <c:when test="${!empty sessionScope.lesDocuments}">
                <c:if test="${sessionScope.user.isEstFormateur() || sessionScope.user.isEstAdministration()}">
                    <input type="submit" name="modifier" value="modifier"/>
                    <br/><br/>
                </c:if>
                <table style="border: 2px solid black;border-collapse: collapse;">
                    <tr style="border: 2px solid black;">
                        <th style="border: 2px solid black;">Nom</th>
                        <th style="border: 2px solid black;">Date d'ajout</th>
                    </tr>
                    <c:forEach items="${lesDocuments}" var="doc" varStatus="boucle">
                        <tr style="border: 2px solid black;">
                            <td style="border: 2px solid black;"><c:out value="${doc.getNom()}"/></td>
                            <td style="border: 2px solid black;"><c:out value="${doc.getDate_depot()}"/></td>
                        <tr>
                        </c:forEach>
                </table>
            </c:when>
            <c:when test="${empty sessionScope.lesDocuments}">
                <p>Aucun documents disponible.</p>
            </c:when>
        </c:choose>
    </body>
</html>
