<%-- 
    Document   : gestionDocuments
    Created on : 24 avr. 2018, 09:43:35
    Author     : YohanMA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@taglib prefix="p" tagdir="/WEB-INF/tags" %>
<p:header titre="Page de connexion"/>
<c:set var="estDuPersonnel" value="${sessionScope.user.isEstFormateur() || sessionScope.user.isEstAdministration()}"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Documents</title>
    </head>
    <body>
        <h1>Salon des Documents</h1>
        <br/>

        <c:if test="${estDuPersonnel}">
            <form action="ajoutDocument" method="GET">
                <input type="submit" name="uploadDocument" value="Ajouter"/>
            </form>
        </c:if>
        <p><c:if test="${retour != null}">${retour}</c:if></p>

        <h2>Liste des documents disponibles:</h2>
        <form action="document" method="GET">
            <input type="submit" name="refresh" value="Rafraichir"/>
        </form>
        <br/>
        <c:choose>
            <c:when test="${!empty sessionScope.lesDocuments}">
                <table style="border: 1px solid black;border-collapse: collapse;">
                    <tr style="border: 1px solid black;">
                        <th style="border: 1px solid black;">Nom</th>
                        <th style="border: 1px solid black;">Date d'ajout</th>
                    </tr>
                    <c:forEach items="${lesDocuments}" var="doc" varStatus="boucle">
                        <tr style="border: 1px solid black;">
                            <td style="border: 1px solid black;"><a href="${doc.getChemin()}"><c:out value="${doc.getNom()}"/></a></td>
                            <td style="border: 1px solid black;"><c:out value="${doc.getDateDepot()}"/></td>
                        </tr>
                    </c:forEach>
                </table>
            </c:when>
            <c:when test="${empty sessionScope.lesDocuments}">
                <p>Aucun document disponible.</p>
            </c:when>
        </c:choose>
    </body>
</html>