<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 
 <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
     
<html>
<head>
	<title>gesso</title>
	<link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.css" rel="stylesheet"/>
	<link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap-theme.css" rel="stylesheet"/>
	
</head>
<body>
 
<h2>Person Manager</h2>
<form:form method="post" action="login" >
	<div class="form-group">
    	<form:label path="firstname">User</form:label>
    	<form:input path="firstname" cssClass="form-control"></form:input>
  	</div>
  
  
  	<div class="form-group">
    	<form:label path="lastname">Password</form:label>
    	<form:input path="lastname" cssClass="form-control"></form:input>
  	</div>
    
	<button type="submit" class="btn btn-primary" >Login</button>
     
</form:form>
</body>
</html>