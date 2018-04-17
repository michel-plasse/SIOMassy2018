<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
        <h1>Nouvelle évaluation</h1>
        <form action="creerEvaluation" method="Post">
            Module :
            <select name="idModule">
                <c:forEach items="${modules}" var="module">
                    <option value="${module.key}">${module.value}</option>
                </c:forEach>
            </select>
            <br/>          
            Session de formation :
            <select name="idSesionFormation">
                <c:forEach items="${sessions}" var="session">
                    <option value="${session.idSession}">${session.idSession}</option>
                </c:forEach>
            </select>
            <br/>            
            Date et heure:
            <br/>
            <input type= "datetime"  name = "dateHeure"/>
            <br/>
            Duree:
            <br/>
            <input type="number" name = "heure"/> (en minutes)
            <br/>
            
            <br/>
            <p></p>
            <input  type="submit" value="Soummettre" >
            <br/>
        </form>
    </div>

        <div><c:if test="${param.btn eq 'Soummettre'}" >${message}</c:if></div>
    </body>
</html>
