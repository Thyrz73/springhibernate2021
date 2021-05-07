<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>Product List</title>
 </head>
 <body>
 
    <jsp:include page="../../../WebContent/WEB-INF/views/_menu.jsp"></jsp:include>
 
    <h3>Liste des Produits</h3>
 
    <p style="color: red;">${errorString}</p>
 
    <table border="1" cellpadding="5" cellspacing="1" >
       <tr>
          <th>Code du Produit</th>
          <th>Nom</th>
          <th>Quantite</th>
          <th>Editer</th>
          <th>Supprimer</th>
       </tr>
       <c:forEach items="${listProduits}" var="produit" >
          <tr>
             <td>${produit.codeProduit}</td>
             <td>${produit.nom}</td>
             <td>${produit.quantite}</td>
             <td>
                <a href="updateP?code=${produit.codeProduit}">Editer</a>
             </td>
             <td>
                <a href="deleteP?code=${produit.codeProduit}">Supprimer</a>
             </td>
          </tr>
       </c:forEach>
    </table>
 
    <a href="saveP" >Creer un produit</a>
 
 </body>
</html>
