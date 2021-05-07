<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Creation de produit</title>
</head>
<body>
<form:form method="POST" action="/saveP" modelAttribute="Produit">

    <table>
        <tr>
            <td><form:label path="codeProduit">Code du produit</form:label></td>
            <td><form:input path="codeProduit" /></td>
        </tr>
        <tr>
            <td><form:label path="nom">Nom du produit</form:label></td>
            <td><form:input path="nom" /></td>
        </tr>
        <tr>
            <td><form:label path="quantite">Quantite du produit </form:label></td>
            <td><form:input path="quantite" /></td>
        </tr>
        <tr>
            <td><form:label path="datePeremption">Date de Peremption</form:label></td>
            <td><form:input path="datePeremption" /></td>
        </tr>
        <tr>
            <td> <input type="submit" value="Submit"></input></td>
        </tr>
    </table>
</form:form>
</body>
</html>
