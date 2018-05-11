<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trombinoscope de la session ${param["idSession"]}</title>
        <style>

            #trombino {
                display: flex;
                flex-wrap: wrap;
                justify-content: space-around;
            }

            #trombino div {
                width: 150px;
                border: solid 1px orange;
                padding: 4px;
                text-align: center;
                word-wrap: break-word;
            }
        </style>
    </head>
    <body>
        <h1>Trombinoscope (${stagiaires.size()} stagiaires)</h1>
        <div id="trombino">
            <c:forEach items="${stagiaires}" var="stagiaire">
                <div>
                    <img src="photos/${stagiaire.nom}_${stagiaire.prenom}_${stagiaire.id}.jpg" 
                         width="100" alt="photo de ${stagiaire.prenom} ${stagiaire.nom}"/>
                    <br/>
                    ${stagiaire.prenom} ${stagiaire.nom}
                    <br/>
                    <a href="mailto: ${stagiaire.mail}">${stagiaire.mail}</a>
                    <br/>
                    ${stagiaire.tel}
                </div>
            </c:forEach>
        </div>
    </body>
</html>
