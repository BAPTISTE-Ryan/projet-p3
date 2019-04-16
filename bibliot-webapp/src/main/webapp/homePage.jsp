<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false"%>
<!doctype html>
<title>mainPage</title>
<style>
  * {
   box-sizing: border-box; 
  }
  body {
    margin: 0;
    background-image: url(https://cdn.dribbble.com/users/463836/screenshots/1876492/33457.gif)
    ;background-repeat: no-repeat;
    background-size: cover; 
  }
  
  .cards {
    display: flex;
    flex-wrap: wrap;
    align-items: center;
  }
  .card {
    flex: 0 0 200px;
    margin: 10px;
    border: 1px solid #ccc;
    box-shadow: 2px 2px 6px 0px  rgba(0,0,0,0.3);
  } 
  .card img {
    max-width: 100%;
  }
  .card .text {
    padding: 0 20px 20px;
  }
  .card .text > button {
    background: gray;
    border: 0;
    color: white;
    padding: 10px;
    width: 100%;
    }
  .logo{max-height: 5vh;}
  .main-nav {
    opacity:0.7;
    display: flex;
    background: orangered;
    color: white;
    border-radius: 3px;
    padding: 1em;
    font-family: sans-serif;
  }
  .main-nav > ul {
    list-style-type: none;
    padding: 0;
    margin: 0;
    display: flex;
    flex: 3;
  }
  .main-nav li {
    margin-right: 1em;
  }
  .main-nav > form {
    display: flex;
    justify-content: flex-end;
    flex: 1;
  }
  .main-nav input {
    flex: 1;
  }
  .main-nav button {
    background: white;
    border: 0;
    border-radius: 1em;
    color: orangered;
    padding: 0 1em;
    margin-left: .3em;
  }
 @media screen and (max-width: 575px) {
   .main-nav {
     flex-direction: column;
   }
   .main-nav ul {
     flex-direction: row; /* Change this to 'column' to stack the links */
     margin-bottom: 1em;
   }
  }
 
</style>
<body>
    <nav class="main-nav">
        <ul>
          <li> <img src="https://www.fleron.be/loisirs/culture/bibliotheque/logo-minisite.png" alt="" class="logo"> 
          </li>
          <li>Home</li>
          <li>Products</li>
          <li>Services</li>
        </ul>
        
         
        
                  <form class="element2" action="/bibliot-webapp/resultsPage" method="post">
    
 
                    <input type="text" id="search" name="search" placeholder="search">
                     
                    <input type="submit" id="input" value="Submit">
    
</form>
      </nav>
  
      <main class="cards">
          <article class="card">
            <img src="eyes.gif"  alt="Sample photo">
            <div class="text">
              <h3>Seamlessly visualize quality</h3>
              <p>Collaboratively administrate empowered markets via plug-and-play networks.</p>
              <button>Read this book now!</button>
            </div>
          </article>
          <article class="card">
            <img src="eyes.gif"  alt="Sample photo">
            <div class="text">
              <h3>Completely Synergize</h3>
              <p>Dramatically engage seamlessly visualize quality intellectual capital without superior collaboration and idea-sharing.</p>
              <button>Read this book now!</button>
            </div>
          </article>
          <article class="card">
            <img src="eyes.gif"  alt="Sample photo">
            <div class="text">
              <h3>Dynamically Procrastinate</h3>
              <p>Completely synergize resource taxing relationships via premier niche markets.</p>
              <button>Read this book now!</button>
            </div>
          </article>
          <article class="card">
            <img src="eyes.gif" alt="Sample photo">
            <div class="text">
              <h3>Best in class</h3>
              <p>Imagine jumping into that boat, and just letting it sail wherever the wind takes you...</p>
              <button>Read this book now!</button>
            </div>
          </article>
          <article class="card">
            <img src="eyes.gif"  alt="Sample photo">
            <div class="text">
              <h3>Dynamically innovate supply chains</h3>
              <p>Holisticly predominate extensible testing procedures for reliable supply chains.</p>
              <button>Read this book now!</button>
            </div>
          </article>
          <article class="card">
            <img src="eyes.gif"  alt="Sample photo">
            <div class="text">
              <h3>Sanity check</h3>
              <p>Objectively innovate empowered manufactured products whereas parallel platforms.</p>
               <button>Read this book now!</button>
            </div>
          </article>
        </main>
   
</body>




