<%-- 
    Document   : Avis
    Created on : 10 avr. 2018, 10:09:27
    Author     : Ronan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AvisAccueil</title>
    </head>
    <body>


        <form method="post" action="AvisServlet">
            
            
                        A combien cotez-vous la fonctionnalité du site (entre 5 et 0) :
                        
            <select name="avisFonctionnalite" size="1">
                <option selected value=5>5</option>
                <option value=4>4</option>
                <option value=3>3</option>
                <option value=2>2</option>
                <option value=1>1</option>
                <option value=0>0</option>
            </select>

                        <br>
            


            A combien côtez-vous l'ergonomie du site (entre 5 et 0) :
            <select name="avisErgonomie" size="1">
                <option selected value=5>5</option>
                <option value=4>4</option>
                <option value=3>3</option>
                <option value=2>2</option>
                <option value=1>1</option>
                <option value=0>0</option>
            </select>
            <br>
            
            A combien cotez-vous l'esthétisme du site (entre 5 et 0) :
            <select name="avisEsthetisme" size="1">
                <option selected value=5> 5 </option>
                <option value=4>4 </option>
                <option value=3>3</option>
                <option value=2>2</option>
                <option value=1>1</option>
                <option value=0>0</option>
            </select>
            <br>




            <textarea cols=30 rows="5" name="avisCommentaire" placeholder="Rentrez votre commentaire"></textarea>


            <br>
            <br>

            <label>Envoyez votre avis</label>
            <br>
            <input type="submit" name="envoyerLesAvis" value="Soumettre votre avis">
            </form>
    </body>
</html>
