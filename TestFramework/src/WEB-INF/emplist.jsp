<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
			<th>Mot de passe</th>
			<th>Departement</th>

		</tr>
		<c:forEach items="${employees}" var="employee">
			<tr>
				<td>${employee.nom}</td>
				<td>${employee.prenom}</td>
				<td>${employee.poste}</td>
				<td>${employee.salaire}</td>
				<td>${employee.mdp}</td>
				<td>${employee.departement}</td>
			</tr>
		</c:forEach>
	</table>
	<%
	String nom;
	String prenom;
	String poste;
	decimal salaire;
	String mdp;
	String departement;
	

		// Définition de la fonction sauvegarder
		void sauvegarder(String nomFichier, String contenu,String url) {
			try {
				FileWriter fw = new FileWriter(D:/S4/INF209-Mr Naina/Project/Sprint6/Saisie.txt);
				fw.write(contenu);
				fw.close();
				out.println("Données sauvegardées avec succès dans le fichier " + nomFichier);
			} catch (IOException e) {
				out.println("Erreur lors de la sauvegarde des données dans le fichier " + nomFichier);
				e.printStackTrace();
			}
		}

		//setters,getters

		public String getNom(){
			return this.Nom;
		}

		public void SetNom(String name){
			this.nom=name;
		}

		public String getPrenom(){
			return this.Prenom;
		}

		public void SetPrenom(String prenom){
			this.prenom=prenom;
		}

		public String getPoste(){
			return this.poste;
		}

		public void SetPoste(String poste){
			this.poste=poste;
		}

		public decimal getSalaire(){
			return this.salaire;
		}

		public void SetSalaire(String name){
			this.salaire=salaire;
		}

		public String getmdp(){
			return this.mdp;
		}

		public void Setmdp(String mdp){
			this.mdp=mdp;
		}

		public String getDept(){
			return this.departenent;
		}

		public void SetDept(String dept){
			this.departement=dept;
		}
		

%>

