<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!doctype html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="CSS/Menu.css"> 
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  
<title>Menu</title>
</head>

<body>


<!-- /////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->




	<ul>

		<!-- 		<li><a href="/bibliot-webapp/home">HOME </a></li> -->
		<!-- 		 <li><a href="/bibliot-webapp/userPage">PROFILE</a></li>   -->
		<li class="nav-item">
			<a href="/bibliot-webapp/home" class="bg-light text-warning"> 
		       <span  class="glyphicon glyphicon-asterisk"></span>
		       <strong>	Resource Library</strong>
		       <span class="glyphicon glyphicon-asterisk"></span>
			</a>
		</li>
		<c:choose>
			<c:when test="${sessionScope.connected}">
				<li class="nav-item"><a href="/bibliot-webapp/exit">Déconnexion</a></li>
				<li class="nav-item"><a href="/bibliot-webapp/borrowlist">Lister
						mes Prêts</a></li>

				<li class="nav-item"><a href="/bibliot-webapp/loginPage">${sessionScope.userName}</a></li>





			</c:when>

			<c:otherwise>
				<li class="nav-item"><a href="/bibliot-webapp/loginPage">Connexion</a></li>
			</c:otherwise>
		</c:choose>




		<li>
			<form class="form-inline my-2 my-lg-0"
				action="${pageContext.request.contextPath}/searchByAuthor"
				method="post">
				<input  name="searchAuthor" class="form-control mr-sm-2" type="search"
					placeholder="Search" aria-label="Search">
				<button
					class="inputs btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			</form>
		</li>




<!-- 
		<li>
			<form class="form_class"
				action="${pageContext.request.contextPath}/searchByAuthor"
				method="post">
				<input class="inputs" name="searchAuthor" type="search" />
				
				<button type="submit" class="inputs">Submit</button>
				<input type="checkbox" name="Auteur" value="True" checked />Auteur</label>
			</form>

		</li>
 -->



</ul>


<li>


		<!-- Button trigger modal -->
<button type="button" class="btn btn-dark" data-toggle="modal" data-target="#exampleModalLong">
  Mentions légales
</button>

<!-- Modal -->
<div class="modal fade" id="exampleModalLong" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">  Mentions légales</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
    Nos mentions légales

Merci de lire attentivement les présentes modalités d'utilisation du présent site avant de le parcourir. En vous connectant sur ce site, vous acceptez sans réserve les présentes modalités.
Editeur du site
Site Internet Qualité
par Natural-net
49 boulevard Antoine Gautier
33000 Bordeaux
France
Tél. : + 33 (0)0 00 00 00 00 
Fax : + 33 (0)0 00 00 00 00
https://www.site-internet-qualite.fr
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>
	</li>
	
	
		
<!-- .///////////////////////////////////////////////////////////////////////////////////////////////////////////// -->




	<script type="text/javascript" src="jquery.min.js"></script>
	<script type="text/javascript" src="bootstrap.min.js"></script>
</body>
</html>