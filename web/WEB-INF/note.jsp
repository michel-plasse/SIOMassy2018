<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>

    
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Note</title>
    
    <body>
        <h1>Note</h1>
        <br>
        <table style="border: 1px solid black;border-collapse: collapse;">
            <tr style="border: 1px solid black;">
                <th style="border: 1px solid black;">id_evaluation</th>
                <th style="border: 1px solid black;">id_personne</th>
                <th style="border: 1px solid black;">note</th>
                <th style="border: 1px solid black;">saisie</th>
            </tr>

            <c:forEach items="${evaluation}" var="uneNote">
                <tr style="border: 1px solid black;">
                    <td style="border: 1px solid black;"  ><c:out value="${uneNote.idEvaluation}" /></td>
                    <td style="border: 1px solid black;"  ><c:out value="${uneNote.idPersonne}" /></td>
                    <td style="border: 1px solid black;"  ><c:out value="${uneNote.note}" /></td>
                    <td style="border: 1px solid black;"><input type="text" id="<c:out value="${uneNote.idEvaluation}" />-<c:out value="${uneNote.idPersonne}" />"></td>
                </tr>
            </c:forEach>
        </table>

        <script src="jquery.min.js"></script>
        <script src="modifierNote.js"></script>
        
    </body>


