<%-- 
    Document   : gestion-profil
    Created on : 5 avr. 2018, 14:19:47
    Author     : Teixei_H
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestion de votre Profil</title>
    </head>
    <body>
        <div>
            <h2>Votre profil</h2>
            <form action="gestion_profil" method="POST" enctype="multipart/form-data">
                <label>Selectionnez une photo</label> <br>
                <input type="file" name ="photo" value="Selectionnez une photo"/>
                <br>
                <p><c:if test="${upload != null}">${upload}</c:if></p>
                    <p></p>
                    <input type="submit" name="uploadphoto" value="Envoyer"  />
                </form>
            </div>
            <div>
                <h3>Changer de Mot de Passe</h3>
                <form action="gestion_profil" method="POST">
                    <label>Mot de passe actuel</label> <br>
                    <input type="password" placeholder="Votre mot de passe actuel" name="pwdactuel"/>
                <c:if test="${pwdactuel_message != null}">${pwdactuel_message}</c:if>
                    <p></p>
                    <label>Entrez un nouveau mot de passe</label> <br>
                    <input type="password" placeholder="Votre nouveau mot de passe" name="newpwd"/>
                <c:if test="${newpwd_message != null}">${newpwd_message}</c:if>
                    <p></p>
                    <label>Confirmez votre mot de passe</label> <br>
                    <input type="password" placeholder="Rentrez à nouveau votre mot de passe" name="pwdcheck"/>
                <c:if test="${pwdcheck_message != null}">${pwdcheck_message}</c:if>
                <p></p>
                <input type="submit" name="pwdchange" value="Changer de mot de passe"/>
            </form>
        </div>
    </body>
</html>
