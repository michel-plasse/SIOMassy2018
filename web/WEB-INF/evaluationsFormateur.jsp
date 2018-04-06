<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>

    
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Evaluations Formateur</title>
    
    <body>
        <h1>Liste des evaluations Formateur</h1>
        <br>
        <table style="border: 1px solid black;border-collapse: collapse;">
            <tr style="border: 1px solid black;">
                <th style="border: 1px solid black;">id_evaluation</th>
                <th style="border: 1px solid black;">id_module</th>
                <th style="border: 1px solid black;">id_session_formation</th>
                <th style="border: 1px solid black;">id_formateur</th>
                <th style="border: 1px solid black;">date_debut</th>
                <th style="border: 1px solid black;">nb_minute</th>
                <th style="border: 1px solid black;">titre</th>
            </tr>

            <c:forEach items="${evaluation}" var="uneEvaluation">
                <tr style="border: 1px solid black;">
                    <td style="border: 1px solid black;"><c:out value="${uneEvaluation.idEvaluation}" /></td>
                    <td style="border: 1px solid black;"><c:out value="${uneEvaluation.idModule}" /></td>
                    <td style="border: 1px solid black;"><c:out value="${uneEvaluation.idSessionFormation}" /></td>
                    <td style="border: 1px solid black;"><c:out value="${uneEvaluation.idFormateur}" /></td>
                    <td style="border: 1px solid black;"><c:out value="${uneEvaluation.dateDebut}" /></td>
                    <td style="border: 1px solid black;"><c:out value="${uneEvaluation.nbMinutes}" /></td>
                    <td style="border: 1px solid black;"><c:out value="${uneEvaluation.titre}" /></td>
                </tr>
            </c:forEach>
        </table>
    </body>
