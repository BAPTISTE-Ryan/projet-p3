<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!doctype html>
<html>
<head>
<meta charset="ISO-8859-1"> 
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
  
<title>Menu</title>
</head>

<body>
                    
                    
 <nav class="navbar navbar-default navbar-fixed-top">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand bg-light text-warning" href="${pageContext.request.contextPath}/home" >
      <span  class="glyphicon glyphicon-asterisk"></span>
      <strong>Resource Library</strong>
      <span  class="glyphicon glyphicon-asterisk"></span>
      </a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">       
      </ul>
      
      <form class="navbar-form navbar-left" action="${pageContext.request.contextPath}/searchByAuthor" method="post">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search"  name="searchAuthor">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form>
      
      <ul class="nav navbar-nav navbar-right">
        <li>
     <c:choose>
							<c:when test="${sessionScope.connected}">
								<li class="nav-item"><a href="${pageContext.request.contextPath}/loginPage">
								${sessionScope.userName}</a></li>
									<li class="nav-item"><a href="${pageContext.request.contextPath}/borrowlist">Lister
						mes Prêts
						<!--<span class="badge">${sessionScope.currentBorrows}</span>-->
						</a></li>
						<li class="nav-item"><a href="${pageContext.request.contextPath}/exit"><span
										class="glyphicon glyphicon-off"></span></a></li>
								<img src="${sessionScope.profilepic}" class="img-rounded" alt=""
									style="width: 50px; height: 50px;">

							</c:when>
							<c:otherwise>
								<li class="nav-item"><a href="${pageContext.request.contextPath}/loginPage">Connexion</a></li>
							</c:otherwise>
						</c:choose></li>
 
        
        
        
        
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
	
</body>
</html>