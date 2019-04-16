<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <!-- <link rel="stylesheet" type="text/css" href="resultsPAGES.css"> -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <title>results</title>
</head>

<body>

<%@ include file="Menu.jsp" %>

  
 <br> <br> <br> <br> <br> <br>

 
<c:forEach items="${listOfWorks}" var="work">

<div class="col-sm-5" >
		<div class="panel panel-default">
			<div class="panel-heading">
				<strong> ${work.title}</strong> <span class="badge badge-secondary">${work.getAuthor()}</span>
			</div>
			<div class="panel-body">
				<div class="row">
					<div class="col-12 col-md-6">
					
<%-- 						<img src="${work.coverimageurl}" class="img-fluid" alt="${work.title}" --%>
<!-- 							style="width: 250px; height: 300px;"> -->
							
							<img src="${work.coverimageurl}" class="img-rounded" alt="Cinque Terre"  style="width: 200px; height: 250px;">
					</div>
					<div class="col-6 col-md-4">
						<strong>Summary</strong> ${work.description}<br> <strong>Year</strong>
						${work.getPublicationyear()}<br> <strong>ID</strong>
						${work.getId()}<br> <a class="btn btn-warning"
							href="/bibliot-webapp/borrow?workId=${work.getId()}">Emprunter
							ce livre</a>
					</div>
				</div>
			</div>
			<!--   <div class="panel-footer">Panel Footer -->
			<!--   </div> -->
		</div>
</div>







	</c:forEach>
 

 
 
 
 
 


  

</body>
</html>