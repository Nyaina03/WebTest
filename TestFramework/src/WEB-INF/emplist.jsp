<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Liste des employés</title>
</head>
<body>
	<h1>Liste des employés</h1>
	<table>
		<tr>
			<th>Nom</th>
			<th>Prénom</th>
			<th>Poste</th>
			<th>Salaire</th>
		</tr>
		<c:forEach items="${employees}" var="employee">
			<tr>
				<td>${employee.nom}</td>
				<td>${employee.prenom}</td>
				<td>${employee.poste}</td>
				<td>${employee.salaire}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
