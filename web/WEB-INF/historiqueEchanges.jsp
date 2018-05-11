<%@taglib prefix="p" tagdir="/WEB-INF/tags" %>
<p:header titre="Historique des echange"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Echange</title>
<style>
    .typeEchange1 {
        background-color: green;
    }
    .typeEchange2 {
        background-color: yellow;
    }
</style>

<body>
    <h1>Liste des echanges du contact n° ${idContact}</h1>
    <br>
    <table style="border-width: 0px;">
        <c:forEach items="${listeDesEchanges}" var="unEchange">
            <tr  class="typeEchange${unEchange.typeEchange}">
                <td >${unEchange.getDateTimeToString()}</td>
                <td >${unEchange.getTexte()}</td>
            </tr>
        </c:forEach>
    </table>
</body>
