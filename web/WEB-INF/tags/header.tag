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
            <a href="contact.html"> Contact </a>
            <a href="document">Document</a>
            <c:if test="${user == null}">
                <a href="connexion"> Se connecter</a>
                <a href="inscrire"> S'inscrire</a>
            </c:if>
            <c:if test="${user != null}">
                <c:if test="${user.isEstAdministration()}">
                    <a href="historiqueEchanges">Historique des echanges</a>
                    <a href="ListerCandidatures">Lister les candidatures</a>
                    <a href="evaluationsFormateur">Evaluation formateur</a>
                    <a href="creerEvaluation">Créer evaluation</a>
                    <a href="evaluationsStagiaire">Evaluation stagiaire</a>
                    <a href="saisirNotes">Saisir Notes</a>
                    <a href="update_presence">Mise a jour présence</a>
                </c:if>
                 <c:if test="${user.isEstFormateur()}">
                    <a href="evaluationsFormateur">Evaluation formateur</a>
                    <a href="creerEvaluation">Créer evaluation</a>
                    <a href="saisirNotes">Saisir Notes</a>
                    <a href="update_presence">Mise a jour présence</a>
                 </c:if>
                <a href="AvisServlet">Donner son Avis</a>
                <a href="DemandeAvisServlet">Voir les Avis</a>
                <a href="Deconnexion">Deconnexion</a>
                <a href="gestion_profil"><c:out value="${user.getNom()}"/></a>
            </c:if>
        </nav>
  </header>