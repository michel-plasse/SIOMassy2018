<%@taglib prefix="p" tagdir="/WEB-INF/tags" %>
<p:header titre="Page de connexion"/>
<form  id="loginForm" action="connexion" method="POST">
    <h3>Veuillez-vous identifier</h3>
    Identifiant :  <input type="text" name="login"/><br/>
    Mot de passe :  <input type="password" name="password"/><br/>
    <button type="submit">Connexion</button>
</form>
</body>
</html>
