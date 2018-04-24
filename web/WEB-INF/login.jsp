<%@taglib prefix="p" tagdir="/WEB-INF/tags" %>
<p:header titre="Page de connexion"/>
  </head>
  <body>
    <h3>Veuillez-vous identifier</h3>
    <form action="connexion" method="POST">
      Identifiant :  <input type="text" name="login" ><br/>
      Mot de passe :  <input type="password" name="password" ><br/>
      <input type="submit" name="connexion" >
       <section class="container-fluid banner">
      <div class="ban">
        <img src="img/ban.png" alt="bannière du site" />
      </div>
      <div class="inner-banner">
        <h1> Agriote, formation à la biodiversité </h1>
    </section>
    </form>
  </body>
</html>
