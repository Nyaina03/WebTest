<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Emp"%>
<%@ page import="model.ModelView"%>
<%
    Emp emp1 = new Emp("Dupont", "Jean", "Ressources Humaines", 2500);
    Emp emp2 = new Emp("Martin", "Luc", "Comptabilité", 3000);

    // Création de la liste des employés
    java.util.List<Emp> empList = new java.util.ArrayList<>();
    empList.add(emp1);
    empList.add(emp2);

    // Ajout d'un nouvel employé
    Emp emp3 = new Emp("Tremblay", "Marie", "Marketing", 2800);
    empList.add(emp3);

    // Ajout de la liste dans le hashmap
    ModelView model = new ModelView();
    java.util.HashMap<String, Object> data = new java.util.HashMap<String, Object>();
    data.put("list", empList);
    model.setdata(data);
    model.addItem("list", emp3);
    
    // Ajout de la liste des employés à la page JSP
    request.setAttribute("employees", empList);
%>
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
