<%-- 
    Document   : ajoutPresence
    Created on : 5 avr. 2018, 16:03:02
    Author     : tonyd_wl3
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Emargement</title>
        <style>
            td, th {
                border:solid 1px black;
                padding-top: 10px; 
                padding-right: 10px; 
                padding-bottom: 10px; 
                padding-left: 10px;
            }
        </style>
    </head>
    <body>
        <h1>Bienvenue !</h1>
        <br>
        <table cellspacing="0">
            <tr>
                <th>Nom</th>
                <th>Prénom</th>
                <th>Présent(e) ?</th>
            </tr>
                
            <c:forEach items="${presences}" var="unePresence">
                <c:set var="personne" value="${unePresence.personne}" />
                <tr style="border: 1px solid black;">
                    <td>${personne.nom}</td>
                    <td>${personne.prenom}</td>
                    <td>
                        <form action="update_presence?idSeance=${unePresence.idSeance}&idPersonne=${personne.id}" method="post">
                            <c:if test="${unePresence.estPresent == true}">
                                <input type="radio" name="estPresent" value="true" checked="checked" />Présent(e)
                            </c:if>
                            <c:if test="${unePresence.estPresent != true}">
                                <input type="radio" name="estPresent" value="true" />Présent(e)
                            </c:if><br>
                            <c:if test="${unePresence.estPresent == false}">
                                <input type="radio" name="estPresent" value="false" checked="checked" />Absent(e)
                            </c:if>
                            <c:if test="${unePresence.estPresent != false}">
                                <input type="radio" name="estPresent" value="false" />Absent(e)
                            </c:if><br>
                            <c:if test="${unePresence.estPresent == null}">
                                <input type="radio" name="estPresent" value="null" checked="checked" />Non renseigné
                            </c:if>
                            <c:if test="${unePresence.estPresent != null}">
                                <input type="radio" name="estPresent" value="null" />Non renseigné
                            </c:if>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <script src="jquery.min.js"></script>
        <script src="modifierPresences.js"></script>
    </body>
</html>