<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">


<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge"><!--  
<link rel="stylesheet" type="text/css" href="borrowPAGES.css">-->
<link type="text/css" rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>borrowPAGES</title>
</head>


<body>


	<%@ include file="Menu.jsp"%>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>


	 
	<c:choose>
		<c:when test='${feedBackBorrowMessage!=null}'>
			<div class="alert alert-success" role="alert">
				 ${feedBackBorrowMessage}
				  <br> <br> <br>
			</div>

		</c:when>
	</c:choose>




 


	<div id="conteneur">



		
		<c:set var="count" value="0" scope="page" />
		<c:forEach items="${listOfBorrows}" var="borrows">
			<c:choose>
			
				<c:when test='${borrows.status.equals("ENCOURS")}'>
					<div class="panel panel-info">

						<div class="panel-heading">
					 
							<strong>${titles.get(count)}</strong>
							<span class="label label-info">${authors.get(count)}</span>
						</div>
						<div class="panel-body">
							<strong>StartDate</strong> ${borrows.startBorrowDate}<br> <strong>EndDate</strong>
							${borrows.endBorrowDate}<br> <strong>Id</strong>
							${borrows.id}<br> <strong>STATUT</strong> ${borrows.status}<br>


							    <a class="btn btn-primary"
								href="${pageContext.request.contextPath}/borrowEnd?borrow=${borrows.id} ">
									Restituer ce livre
								</a>
								
								<a class="btn btn-info" href="${pageContext.request.contextPath}/Extend?borrow=${borrows.id}">
									Extend 
								</a> 
							 

 
  

						</div>
					</div>
					
				</c:when>
			</c:choose>
			<c:set var="count" value="${count + 1}" scope="page"/>
			
		</c:forEach>

	<c:set var="count" value="0" scope="page" />
	<c:forEach items="${listOfBorrows}" var="borrows">
			<c:choose>
				<c:when test='${borrows.status.equals("EXTENDED")}'>
					<div class="panel panel-warning">

						<div class="panel-heading">
							<strong>${titles.get(count)}</strong>
							<span class="label label-warning">${authors.get(count)}</span>
						</div>
						<div class="panel-body">
							<strong>${titles.get(count)}</strong> ${borrows.startBorrowDate}<br> <strong>EndDate</strong>
							${borrows.endBorrowDate}<br> <strong>Id</strong>
							${borrows.id}<br> <strong>STATUT</strong> ${borrows.status}<br>


					 
								<a class="btn btn-warning"
								 href="${pageContext.request.contextPath}/borrowEnd?borrow=${borrows.id} ">
								 Restituer ce livre 
								 </a>
 								 

						</div>

					</div>
				</c:when>
			</c:choose>
			<c:set var="count" value="${count + 1}" scope="page"/>

		</c:forEach>



	<c:set var="count" value="0" scope="page" />
<c:forEach items="${listOfBorrows}" var="borrows">
			<c:choose>
				<c:when test='${borrows.status.equals("TERMINE")}'>
					<div class="panel panel-danger">
						<div class="panel-heading">
							<strong>${titles.get(count)}</strong>
							<span class="label label-danger">${authors.get(count)}</span>
						</div>


						<div class="panel-body">
							<strong>StartDate</strong> ${borrows.startBorrowDate}<br> <strong>EndDate</strong>
							${borrows.endBorrowDate}<br>
							<div></div>
						</div>


					</div>
				</c:when>
			</c:choose>
		 			<c:set var="count" value="${count + 1}" scope="page"/>
		</c:forEach>

	</div>




 

	<script type="text/javascript" src="jquery.min.js"></script>
	<script type="text/javascript" src="bootstrap.min.js"></script>
	
	
	
	
	
</body>

</html>