<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false"%>
    <!-- %@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> -->
<!DOCTYPE html>
<html lang="en">
<!--  TODO make the folder file with all the dummy pages  -->

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>

<style>
   @import url(https://fonts.googleapis.com/css?family=Advent+Pro:100);
html { 
  background:  url(http://upload.wikimedia.org/wikipedia/commons/d/dd/Muybridge_race_horse_animated.gif) no-repeat center center fixed; 
  background-size: cover;
}
h1{
  font-family: 'Advent Pro', sans-serif;
  font-size: 3em;
  margin: .2em .5em;
  color: rgba(0,0,0, 0.3);
}
body {
    height: 100%;
}
   
</style>
<body>
   <h1>Sallie</h1>
  <h1> ${user}</h1>
   </br>
   <h1>${password}</h1>
</body>
</html>