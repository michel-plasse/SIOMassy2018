<%@ tag description="En-tête des pages de Agriotes" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@attribute name="titre" description="Utilisé dans title et h1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${titre}</title>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
    <header>
        <nav id="menu">
            <a href="index.jsp">Accueil</a>
            <a href="sessionsOuvertes"> Formations </a>
            <!--<a href="contact.html"> Contact </a>-->
            <c:if test="${user == null}">
                <hr/>
                <a href="connexion"> Se connecter</a>
                <a href="inscrire"> S'inscrire</a>
            </c:if>
            <c:if test="${user != null}">
                <c:if test="${user.isEstAdministration()}">
                    <hr/>
                    <a href="historiqueEchanges">Historique des echanges</a>
                    <a href="ListerCandidatures">Candidatures</a>
                    <a href="evaluationsFormateur">Evaluations formateur</a>
                    <a href="creerEvaluation">Créer evaluation</a>
                    <a href="evaluationsStagiaire">Evaluations stagiaire</a>
                    <a href="saisirNotes">Saisir Notes</a>
                    <a href="update_presence">Mise a jour présence</a>
                </c:if>
                <c:if test="${user.isEstFormateur()}">
                    <hr/>
                    <a href="evaluationsFormateur">Mes évaluations</a>
                    <a href="creerEvaluation">Créer evaluation</a>
                    <a href="saisirNotes">Saisir Notes</a>
                    <a href="update_presence">Mise a jour présence</a>
                </c:if>
                <hr/>
                <a href="document">Document</a>
                <a href="DemandeAvisServlet">Voir les Avis</a>
                <a href="AvisServlet">Donner son Avis</a>
                <hr/>
                <a href="gestion_profil">Mon profil</a>
                <a href="Deconnexion">Deconnecter ${user.nom}</a>
            </c:if>
        </nav>
    </header>