<%-- 
    Document   : listerCandidatures
    Created on : 10 avr. 2018, 09:59:40
    Author     : Kiiaroto
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
        <h1>Liste des candidatures.</h1>
        <form action="ListerCandidatures" method="get" >
            Etat: 
            <select id="etatFilter" name="etatFilter">
                <option value="0">Tout voir</option>
                <c:forEach begin="1" end="${etatCandidature.getValues().size()}" varStatus="loop">
                    <option value="${loop.index}" <c:if test="${param['etatFilter'] == loop.index}"> selected="selected" </c:if>>${etatCandidature.getValues().get(loop.index)}</option>
                </c:forEach>
            </select> <br>
            Session: 
            <select id="sessionFiler" name="sessionFilter">
                <option value="0">Tout voir</option>
                <c:forEach begin="1" end="4" varStatus="loop">
                    <option value="${loop.index}" <c:if test="${param['sessionFilter'] == loop.index}"> selected="selected" </c:if>>Session ${loop.index}</option>
                </c:forEach>
            </select> <br>
            <input type="submit">
        </form>

        <table style="border: 1px solid black;border-collapse: collapse;">
            <tr style="border: 1px solid black;">
                <th style="border: 1px solid black;">Date de candidature</th>
                <th style="border: 1px solid black;">Nom du candidat</th>
                <th style="border: 1px solid black;">Contact du candidat</th>
                <th style="border: 1px solid black;">Formation</th>
                <th style="border: 1px solid black;">Statut</th>
            </tr>

            <c:forEach items="${listeCandidature}" var="uneCandidature" varStatus="boucle">
                <tr style="border: 1px solid black;">
                    <td style="border: 1px solid black;">
                        <c:out value="${uneCandidature.getDateEffetToString()}" />
                    </td>
                    <td style="border: 1px solid black;">
                        <c:out value="${uneCandidature.getPersonne().getNom()}" /> <c:out value="${uneCandidature.getPersonne().getPrenom()}" />
                    </td>
                    <td style="border: 1px solid black;">
                        <a href="mailto:<c:out value="${uneCandidature.getPersonne().getMail()}" />"><c:out value="${uneCandidature.getPersonne().getMail()}" /></a><br>
                        <c:out value="${uneCandidature.getPersonne().getFormatedTel()}" /> 
                    </td>
                    <td style="border: 1px solid black;">
                        <c:out value="${uneCandidature.getSessionFormation().getNomFormation()}" /> <c:out value="${uneCandidature.getSessionFormation().getIdSession()}" /> <br>
                        (<c:out value="${uneCandidature.getSessionFormation().getDateDebutToString()}" /> à <c:out value="${uneCandidature.getSessionFormation().getDateFinToString()}" />)
                    </td>
                    <td style="border: 1px solid black;">
                        <select id="<c:out value="${uneCandidature.getPersonne().getId()}"/>-<c:out value="${uneCandidature.getSessionFormation().getIdSession()}" />">
                            <c:forEach begin="1" end="${etatCandidature.getValues().size()}" varStatus="loop">
                                <option value="${loop.index}" <c:if test="${uneCandidature.getEtatCandidature() == loop.index}"> selected="selected" </c:if>>${etatCandidature.getValues().get(loop.index)}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <script type="text/javascript" src="jquery.min.js"></script>
        <script type="text/javascript" src="modifierCandidature.js"></script>
    </body>
</html>
