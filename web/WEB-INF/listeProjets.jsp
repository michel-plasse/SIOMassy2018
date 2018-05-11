<%@taglib prefix="p" tagdir="/WEB-INF/tags" %>
<p:header titre="Liste des projets"/>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
        <h1>Liste de mes Projets.</h1>
         <table>
             <tr>
                 <th>Id</th>
                 <th>Titre</th>
                 <th>Id de session</th>
             </tr>

            <c:forEach items="${listeProjets}" var="projet">
                <tr>
                    <td>${projet.id}</td>
                    <td>${projet.titre}</td>
                    <td>${projet.idSessionFormation}</td>
                </tr>
            </c:forEach>
        </table>
     </body>
</html>
