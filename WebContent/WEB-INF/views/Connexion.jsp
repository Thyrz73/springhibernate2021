 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Connexion</title>
</head>
    <body>
            <form:form method="POST" action="/valider" modelAttribute="Utilisateur">

                <table>
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