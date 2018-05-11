<%@taglib prefix="p" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<p:header titre="Trombinoscope de la session ${param['idSession']}"/>
<h1>Trombinoscope de la session ${param['idSession']}  (${stagiaires.size()} stagiaires)</h1>
        <style>

            #trombino {
                display: flex;
                flex-wrap: wrap;
                justify-content: flex-start; /*space-around;*/
            }

            #trombino div {
                width: 150px;
                border: solid 1px orange;
                padding: 4px;
                text-align: center;
                word-wrap: break-word;
                margin: 5px; 
            }
        </style>
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
