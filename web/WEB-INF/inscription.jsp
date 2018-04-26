<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="p" tagdir="/WEB-INF/tags" %>
<p:header titre="Inscription Agriotes"/>
<h1>Bienvenue sur Agriotes</h1>
<strong>Inscrivez-vous</strong> 
<form action="inscrire" method="post">
    <em>Tout les champs marqués d'un <strong>*</strong> sont obligatoires.</em>
    <label>Nom *</label> <br/> 
    <input type="text"
           placeholder="Votre nom ici" id="nom" name="nom" 
           value="${param['nom']}"/>
    <c:if test="${nom_message != null}">${nom_message}</c:if>
    <p></p>
    <label>Prenom *</label>
    <br/>
    <input type="text"
           placeholder="Votre prenom ici" id="prenom" name="prenom"
           value="${param['prenom']}"/>
    <c:if test="${prenom_message != null}">${prenom_message}</c:if>
    <p></p>
    <label>E-mail *</label> <br/> 
    <input type="text"
           placeholder="Votre e-mail ici" id="mail" name="mail"
           value="${param['mail']}"/>
    <c:if test="${mail_message != null}">${mail_message}</c:if>
    <p></p>
    <label>Téléphone *</label> <br/>
    <input type="text" placeholder="Votre numéro de téléphone ici" 
           id="telephone" name="telephone"
           value="${param['telephone']}"/>
    <c:if test="${telephone_message != null}">${telephone_message}</c:if>
    <p></p>
    <label>Adresse *</label> <br/> <input type="text"
                                          placeholder="Votre adresse ici" id="adresse" name="adresse"
                                          value="${param['adresse']}"/>
    <c:if test="${adresse_message != null}">${adresse_message}</c:if>
    <p></p>
    <label>Code Postal *</label> <br/> <input type="text"
                                              placeholder="Votre code postal ici" id="codepostal"
                                              name="codepostal" value="${param['codepostal']}">
    <c:if test="${codepostal_message != null}">${codepostal_message}</c:if>
    <p></p>

    <label>Ville *</label> <br> <input type="text"
                                       placeholder="Votre ville ici" id="ville" name="ville"
                                       value="${param['ville']}"/>
    <c:if test="${ville_message != null}">${ville_message}</c:if>
    <p></p>

    <input type="submit" value ="Soumettre"/>
    <c:if test="${param.btn eq 'Soumettre'}" >
        <div>${message}</div>
    </c:if>
</form>
</body>
</html>
