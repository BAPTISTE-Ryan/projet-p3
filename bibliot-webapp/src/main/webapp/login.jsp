<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false"%>
    <!-- %@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> -->
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>

<style>
    body{
        background-color:#14D6D6;
  
    }
     .header{display:flex;
         justify-content: center;
        text-align: center;
        align-items: center;
        height:2px;
        } 
     .baudy{
        display:flex;
    flex-direction: column;
    text-align: center;
    color: beige;
    font-weight: bold;
    font-size: 50px;

    }
    ::placeholder { /* Chrome, Firefox, Opera, Safari 10.1+ */
    color: turquoise;
    /* opacity: 0.51; Firefox */
    text-align: center;
}
    #input{
        color:crimson;
        font-weight: bold;
        opacity:0.6;
        border-radius: 15px;
        border: 5px solid #ccc;
        
            }
    .container{
      
        display:flex;
    padding-top: 10vh;
        align-self: center;justify-content: center;
    }
    .element2{display: flex;flex-direction: column;padding-top: 100px;}
    .undertext{opacity:0.5;}
</style>
<body>
    <div>
         <div class="header">

            

                   <!-- <img class=images src="https://ibb.co/qR5M0W5" alt="Book">
         --> 
                </div> 
        <div class="baudy">


            <div class="container">
                <div class="element1">
                    <img class=images src="${imageurl}" alt="auth">
                    
                </div>
                <div >
                
                <form class="element2" action="/bibliot-webapp/authentificate" method="post">
    
 
                    <input type="text" id="input" name="user" placeholder="user">
                    <input type="text" id="input" name="password" placeholder="password">
                    <input type="submit" id="input" value="Submit">
    
</form>
                
                
                </div>

            </div>
            <div class="undertext"> please enter your authentication info</div>


        </div>
${imageurl}
    </div>
</body>
<!--


 



 -->
</html>