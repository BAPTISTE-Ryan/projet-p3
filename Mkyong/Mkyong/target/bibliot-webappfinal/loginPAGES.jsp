<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false"%>
    <!-- %@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> -->
<!DOCTYPE html>
<html lang="en">
<script type="text/javascript" src="includeHtml.js"></script>


<head>
<meta charset="ISO-8859-1"> 
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>  
<title>Login</title>
</head>

<body class="text-center"> 

<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
	
<!-- 
	<div class="view"
		style="background-image: url('https://www.ibraaz.org/usr/library/images/main/essay_ambs007_1.jpg'); background-repeat: no-repeat; background-size: cover; background-position: center center;">
	
	<div class="col-sm-3" >
	<form action="/bibliot-webapp/authentificate">
				<div class="input-group">
					<span class="input-group-addon"><i
						class="glyphicon glyphicon-user"></i></span> <input id="username"
						type="text" class="form-control" name="user" placeholder="Username">
				</div>
				<div class="input-group">
					<span class="input-group-addon"><i
						class="glyphicon glyphicon-lock"></i></span> <input id="password"
						type="password" class="form-control" name="password"
						placeholder="Password">
				</div>

	  <button type="submit" class="btn btn-default">Submit</button>

			</form>
	</div>
	</div>
	<div class="container">
</div> 

-->

<div class="col-sm-10 row align-items-center " >
<div class="col-sm-3  " >
    <form class="form-signin" action="${pageContext.request.contextPath}/authentificate">
      <img class="mb-4" src="https://getbootstrap.com/docs/4.0/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">
      <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
      <label for="inputEmail" class="sr-only">Email address</label>
      <input type="user" id="inputUser" class="form-control" placeholder="User name" name="user" required autofocus>
      <label for="inputPassword" class="sr-only">Password</label>
      <input type="password" id="inputPassword" class="form-control" name="password" placeholder="Password" required>
      <div class="checkbox mb-3">
        <label>
          <input type="checkbox" value="remember-me"> Remember me
        </label>
      </div>
      <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      <p class="mt-5 mb-3 text-muted">&copy; 2018-2019</p>
    </form>
</div>
</div>
<%@ include file="Menu.jsp" %>
</body> 
</html>