<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Inscription</title>
</head>
<body>
<form:form method="POST" action="/save" modelAttribute="Utilisateur">

    <table>
        <tr>
            <td><form:label path="nom">Votre Nom</form:label></td>
            <td><form:input path="nom" /></td>
        </tr>
        <tr>
            <td><form:label path="prenom">Votre Prenom</form:label></td>
            <td><form:input path="prenom" /></td>
        </tr>
        <tr>
            <td><form:label path="adresse">Votre Adresse </form:label></td>
            <td><form:input path="adresse" /></td>
        </tr>
        <tr>
            <td><form:label path="email">Votre Email</form:label></td>
            <td><form:input path="email" /></td>
        </tr>
        <tr>
            <td><form:label path="motDePasse">Votre Mot de Passe </form:label></td>
            <td><form:input path="motDePasse" /></td>
        </tr>
        <tr>
            <td> <input type="submit" value="Submit"></input></td>
        </tr>
    </table>
</form:form>
</body>
</html>