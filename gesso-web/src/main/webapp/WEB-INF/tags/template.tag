<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@attribute name="body" fragment="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author" content="gesso">
	<meta name="keyword" content="Gestión de seguridad y salud laboral, salud, seguridad, gestión, laboral, prevencion,riesgos laborales,riesgos profesionales,prl,prevencion de riesgos laborales,seguridad e higiene,sistema erp, sistemas erp,programa,informatico,aplicacion,app,seguridad industrial,prevengos,software,prevencion,laboral,riesgos,laborales,medicina,trabajo,vigilancia,salud,servicio,ajeno,propio,mancomunado,gespreven,medtra,senmut,navision,evalua,prevention,world">

	<title>Gesso</title>

	<!-- Bootstrap core CSS -->
	<link href="${pageContext.request.contextPath}/resources/assets/css/bootstrap.css" rel="stylesheet">
	<!--external css-->
	<link href="${pageContext.request.contextPath}/resources/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/assets/css/zabuto_calendar.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/assets/js/gritter/css/jquery.gritter.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/assets/lineicons/style.css">

	<!-- Custom styles for this template -->
	<link href="${pageContext.request.contextPath}/resources/assets/css/style.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/resources/assets/css/style-responsive.css" rel="stylesheet">

	<script src="${pageContext.request.contextPath}/resources/assets/js/chart-master/Chart.js"></script>

	<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
	<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
	<![endif]-->

	<script src="${pageContext.request.contextPath}/resources/angular/angular.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.3.15/angular-route.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.3.15/angular-resource.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.3.15/i18n/angular-locale_es-ec.js"></script>

	<script src="${pageContext.request.contextPath}/resources/angular/smart-table.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/gesso/ng-gesso-app.js"></script>
</head>

<body ng-app="app-gesso">
<div ng-view></div>
<section id="container">
	<!-- **********************************************************************************************************************************************************
  TOP BAR CONTENT & NOTIFICATIONS
  *********************************************************************************************************************************************************** -->
	<!--header start-->
	<%@ include file="include/header.jsp" %>
	<!--header end-->

	<!--sidebar start-->
	<%@ include file="include/sidebar.jsp" %>
	<!--sidebar end-->


	<!--main content start-->
	<section id="main-content">
		<section class="wrapper">
			<jsp:invoke fragment="body"/>
		</section>
	</section>
	<!--main content end-->

	<!--footer start-->
	<footer class="site-footer">
		<%@ include file="include/footer.jsp" %>
	</footer>
	<!--footer end-->

</section>

<!-- js placed at the end of the document so the pages load faster -->
<script src="${pageContext.request.contextPath}/resources/assets/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/jquery-1.8.3.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/bootstrap.min.js"></script>
<script class="include" type="text/javascript" src="${pageContext.request.contextPath}/resources/assets/js/jquery.dcjqaccordion.2.7.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/jquery.scrollTo.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/jquery.nicescroll.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/jquery.sparkline.js"></script>


<!--common script for all pages-->
<script src="${pageContext.request.contextPath}/resources/assets/js/common-scripts.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/assets/js/gritter/js/jquery.gritter.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/assets/js/gritter-conf.js"></script>

<!--script for this page-->
<script src="${pageContext.request.contextPath}/resources/assets/js/sparkline-chart.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/zabuto_calendar.js"></script>

<script type="text/javascript">
	$(document)
			.ready(
			function() {
				var unique_id = $.gritter
						.add({
							// (string | mandatory) the heading of the notification
							title : 'Welcome to Dashgum!',
							// (string | mandatory) the text inside the notification
							text : 'Hover me to enable the Close Button. You can hide the left sidebar clicking on the button next to the logo. Free version for <a href="http://blacktie.co" target="_blank" style="color:#ffd777">BlackTie.co</a>.',
							// (string | optional) the image to display on the left

							// (bool | optional) if you want it to fade out on its own or just sit there
							sticky : true,
							// (int | optional) the time you want it to be alive for before fading out
							time : '',
							// (string | optional) the class name you want to apply to that specific message
							class_name : 'my-sticky-class'
						});

				return false;
			});
</script>

<script type="application/javascript">

	$(document).ready(function () {
		$("#date-popover").popover({html: true, trigger: "manual"});
		$("#date-popover").hide();
		$("#date-popover").click(function (e) {
			$(this).hide();
		});

		$("#my-calendar").zabuto_calendar({
			action: function () {
				return myDateFunction(this.id, false);
			},
			action_nav: function () {
				return myNavFunction(this.id);
			},
			ajax: {
				url: "show_data.php?action=1",
				modal: true
			},
			legend: [
				{type: "text", label: "Special event", badge: "00"},
				{type: "block", label: "Regular event", }
			]
		});
	});


	function myNavFunction(id) {
		$("#date-popover").hide();
		var nav = $("#" + id).data("navigation");
		var to = $("#" + id).data("to");
		console.log('nav ' + nav + ' to: ' + to.month + '/' + to.year);
	}

</script>


</body>
</html>