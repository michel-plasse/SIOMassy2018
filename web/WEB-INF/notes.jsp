<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Note</title>
    </head>
    <body>
        <h1>Note</h1>
        <br>
        <table style="border: 1px solid black;border-collapse: collapse;">
            <tr>
                <th>id_evaluation</th>
                <th>id_personne</th>
                <th>note</th>
            </tr>

            <c:forEach items="${notes}" var="uneNote">
                <tr>
                    <td>${uneNote.idEvaluation}</td>
                    <td>${uneNote.idPersonne}</td>
                    <td>
                        <input type="text" id="${uneNote.idEvaluation}-${uneNote.idPersonne}" value="${uneNote.note}"/>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <script src="jquery.min.js"></script>
        <script src="modifierNote.js"></script>
        
    </body>
</html>

