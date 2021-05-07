<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
     <meta charset="UTF-8">
     <title>Accueil</title>
  </head>
  <body>
 
     <jsp:include page="../../../WebContent/WEB-INF/views/_menu.jsp"></jsp:include>
    
      <h3>Page d'Accueil</h3>
      
      Une simple application web <br><br>
      <b>Elle permet de : </b>
      <ul>
         <li>Liste de Poduits</li>
         <li>Création d'un produit</li>
         <li>Edition d'un produit</li>
         <li>Suppression d'un produit</li>
         <li>Connexion</li>
         <li>Sauvegarde des informations utilisateur dans un cookie</li>
      </ul>
 
  </body>
</html>
