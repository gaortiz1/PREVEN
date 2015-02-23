<%-- <jsp:forward page="Contact"></jsp:forward> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
	<title>gesso</title>
	<link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.css" rel="stylesheet" />
	<link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap-theme.css" rel="stylesheet" />
</head>
<body>
	<h1>pagina de prueba gesso</h1>
	<P>The time on the server is ${serverTime}.</P>
    <a class="btn btn-primary" href="login" role="button">Link</a>
</body>
</html>
