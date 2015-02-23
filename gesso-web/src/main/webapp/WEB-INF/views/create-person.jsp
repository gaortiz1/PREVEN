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
<form:form method="post" action="newPerson" >
	<div class="form-group">
    	<form:label path="firstname">First Name</form:label>
    	<form:input path="firstname" cssClass="form-control"></form:input>
  	</div>
  
  
  	<div class="form-group">
    	<form:label path="lastname">Last Name</form:label>
    	<form:input path="lastname" cssClass="form-control"></form:input>
  	</div>
  	
  	<div class="form-group">
    	<form:label path="lastname">Email</form:label>
        <form:input path="email" cssClass="form-control"></form:input>
  	</div>
  	
  	<div class="form-group">
    	<form:label path="lastname">Telephone</form:label>
        <form:input path="telephone" cssClass="form-control"></form:input>
  	</div>
    
	<button type="submit" class="btn btn-primary" >Add Contact</button>
     
</form:form>
</body>
</html>