<%@taglib prefix="p" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<p:header titre="Historique des echanges"/>
    <h1>Liste des echanges du contact n° ${idContact}</h1>
    <br>
    <table style="border-width: 0px;">
        <c:forEach items="${listeDesEchanges}" var="unEchange">
            <tr class="typeEchange${unEchange.typeEchange}">
                <td >${unEchange.getDateTimeToString()}</td>
                <td >${unEchange.getTexte()}</td>
            </tr>
        </c:forEach>
    </table>
</body>
