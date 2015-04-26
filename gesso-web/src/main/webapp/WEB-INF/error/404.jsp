<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" dir="ltr" lang="ro-RO">
<head>
<title>Pagina no econtrada</title>
<meta charset="utf-8"/>
<meta http-equiv="Content-Language" content="ro"/>
<meta name="robots" content="all,index,follow"/>
<meta name="keywords" content="404 error page"/>
<meta name="author" content="gesso" />
<meta http-equiv="X-UA-Compatible" content="IE=8">
<link rel="stylesheet" type="text/css" media="all" href="${pageContext.request.contextPath}/resources/style.css" />
<link rel="stylesheet" type="text/css" media="all" href="${pageContext.request.contextPath}/resources/backgrounds.css" />
<link rel="stylesheet" type="text/css" media="all" href="${pageContext.request.contextPath}/resources/themes/green/css/style.css" />
<link rel="stylesheet" type="text/css" media="all" href="${pageContext.request.contextPath}/resources/themes/gray/css/style.css" />


<!--[if IE]>
<script type="text/javascript" src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->

</head>

<body>


<div class="wrapper">

	<div class="mainWrapper">
        <div class="leftHolder">
            <div class="errorNumber">404</div> 
        </div>
        <div class="rightHolder">
            <div class="message"><p>Ooops, p�gina no encontrada.</p></div>
            <div class="robotik"><img src="${pageContext.request.contextPath}/resources/images/error/404/obrero.jpg" alt="Oooops....we can’t find that page." title="Oooops....we can’t find that page." id="robot"></div>
            <div class="tryToMessage">
                Intente:
                <ul>
                    <li>Ir <a href="${pageContext.request.contextPath}" title="Back">Home</a></li>
                </ul>
            </div>
          </div>

	</div>

</div>
<!-- end .wrapper -->


</body>
</html>