<%@ tag description="En-tête des pages de Agriotes" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@attribute name="titre" description="Utilisé dans title et h1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>${titre}</title>
    <link href='https://fonts.googleapis.com/css?family=Raleway:300,400,500,600' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
  </head>
  <body>
  <header class="container-fluid header">
    <div class="container">
      <a href="index.html"><img src="img/DAFCO.png" alt="logo du site" /></a>
      <nav class="menu">
        <a href="formation.html"> Formation </a>
        <a href="informations.html"> Information </a>
        <a href="login.jsp"> Se connecter</a>
        <a href="sinscrire.html"> S'inscrire</a>
        <a href="contact.html"> Contact </a>
        <!--div id="searchbar">
          <span class="text">What would you like to search ?</span>
          <form action="">
            <input class="champ" type="text" placeholder="Recherche...)"/>
            <input class="bouton" type="button" value=" " />
          </form>
        </div-->
      </nav>
    </div>
  </header>