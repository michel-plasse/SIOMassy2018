<%@taglib prefix="p" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<p:header titre="Page de connexion"/>
<form  id="loginForm" action="connexion" method="POST">
    <h3>Veuillez-vous identifier</h3>
    Identifiant :  <input type="text" name="login"/><br/>
    Mot de passe :  <input type="password" name="password"/><br/>
    <!-- <c:if test="${nbFoi > 0}">Nombre de tentative effectuer: <c:out value="${nbFoi}" /><br></c:if>
    <input type="hidden" value="${nbFoi}" name="nbFoi"> -->
    <button type="submit">Connexion</button>
</form>
</body>
</html>