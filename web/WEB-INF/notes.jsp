<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Note</title>
    </head>
    <body>
        <h1>Evaluation </h1>
        <table>
            <tr>
                <th>Nom</th>
                <th>Prénom</th>
                <th>Note</th>
            </tr>

            <c:forEach items="${notes}" var="uneNote">
                <tr>
                    <td>${uneNote.nom}</td>
                    <td>${uneNote.prenom}</td>
                    <td>
                        <input type="text" step="any" min="0" max="20" 
                               id="${uneNote.idEvaluation}-${uneNote.idPersonne}"  
                               name="${uneNote.idEvaluation}-${uneNote.idPersonne}" 
                               value="${uneNote.note}"/>
                        <span id="message${uneNote.idPersonne}"></span>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <script src="jquery.min.js"></script>
        <script src="modifierNote.js"></script>
    </body>
</html>

