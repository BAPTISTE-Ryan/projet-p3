<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<html>
<body>

<br><br><br><br>
<a href="http://localhost:3080/Mkyong/resultsPAGES.jsp">http://localhost:3080/Mkyong/resultsPAGES.jsp</a>


      <form  action="${pageContext.request.contextPath}/searchByAuthor" method="post">
        <div class="form-group">
          <input placeholder="Search"  name="searchAuthor">
        </div>
        <button type="submit"  >Submit</button>
      </form>



<%@ include file="Menu.jsp" %>
</body>
</html>
