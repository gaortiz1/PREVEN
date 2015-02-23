<%-- <jsp:forward page="Contact"></jsp:forward> --%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>gesso</title>
	<link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.css" rel="stylesheet"/>
	<link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap-theme.css" rel="stylesheet"/>
	
</head>
<body>
<h1>
	pagina de prueba gesso
</h1>

<P>  The time on the server is ${serverTime}. </P>
<a href="newPerson">contact manager</a>

<span class="label label-default">Default</span>
<span class="label label-primary">Primary</span>
<span class="label label-success">Success</span>
<span class="label label-info">Info</span>
<span class="label label-warning">Warning</span>
<span class="label label-danger">Danger</span>
</body>
</html>
