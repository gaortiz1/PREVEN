<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 
 <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
     
<html>
<head>
	<title>gesso</title>
	
	
	
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Dashboard">
    <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

	<title>Gesso</title>



    <script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.3.15/angular.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.3.15/angular-route.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.3.15/angular-resource.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.3.15/i18n/angular-locale_es-ec.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.3.15/angular-sanitize.js"></script>

    <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.css">
	
	<!--external css-->
    <link href="${pageContext.request.contextPath}/resources/select/select.min.css" rel="stylesheet" />
	<link href="${pageContext.request.contextPath}/resources/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/assets/js/gritter/css/jquery.gritter.css" />
    <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/select2/3.4.5/select2.css">
	<!-- Custom styles for this template -->
	<link href="${pageContext.request.contextPath}/resources/assets/css/style.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/resources/assets/css/style-responsive.css" rel="stylesheet">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/datepicker.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/gesso/gesso-styles.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/sweetalert/sweet-alert.css">



	
	<script src="${pageContext.request.contextPath}/resources/smarttable/smart-table.js"></script>
	<script src="${pageContext.request.contextPath}/resources/sweetalert/sweet-alert.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/sweetalert/SweetAlert.js"></script>
    <script src="${pageContext.request.contextPath}/resources/select/select.min.js"></script>
	
	<script src="${pageContext.request.contextPath}/resources/gesso/ng-gesso-app.js"></script>
	<script src="${pageContext.request.contextPath}/resources/gesso/ng-gesso-login.js"></script>
	<script src="${pageContext.request.contextPath}/resources/gesso/ng-gesso-user.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/resources/gesso/ng-gesso-menu.js"></script>
	<script src="${pageContext.request.contextPath}/resources/gesso/ng-gesso-person-edit.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/resources/gesso/ng-gesso-process.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/resources/gesso/ng-gesso-person-adm.js" type="text/javascript"></script>


    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- js placed at the end of the document so the pages load faster -->
	<script src="${pageContext.request.contextPath}/resources/assets/js/jquery.js"></script>
	<script src="${pageContext.request.contextPath}/resources/assets/js/jquery-1.8.3.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/assets/js/bootstrap.min.js"></script>
	<script class="include" type="text/javascript" src="${pageContext.request.contextPath}/resources/assets/js/jquery.dcjqaccordion.2.7.js"></script>
	<script src="${pageContext.request.contextPath}/resources/assets/js/jquery.scrollTo.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/assets/js/jquery.nicescroll.js" type="text/javascript"></script>

	<!--common script for all pages-->
	<script src="${pageContext.request.contextPath}/resources/assets/js/common-scripts.js"></script>

	<!--script for this page-->
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/assets/js/gritter/js/jquery.gritter.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/assets/js/gritter-conf.js"></script>

	<script src="${pageContext.request.contextPath}/resources/assets/js/fuelux/fuelux.tree.js"></script>
	<script src="${pageContext.request.contextPath}/resources/assets/js/ace/elements.treeview.js"></script>
	<script src="${pageContext.request.contextPath}/resources/assets/js/ace/ace.js"></script>

	<script src="${pageContext.request.contextPath}/resources/assets/js/chosen.jquery.js"></script>
	<script src="${pageContext.request.contextPath}/resources/assets/js/date-time/bootstrap-datepicker.js"></script>
	<script src="${pageContext.request.contextPath}/resources/assets/js/jquery.autosize.js"></script>
	<script src="${pageContext.request.contextPath}/resources/assets/js/jquery.inputlimiter.1.3.1.js"></script>
	<script src="${pageContext.request.contextPath}/resources/assets/js/jquery.maskedinput.js"></script>
	<script src="${pageContext.request.contextPath}/resources/assets/js/bootstrap-tag.js"></script>
    
</head>
<body ng-app="app-gesso">
	<header class="header black-bg">
		<div class="sidebar-toggle-box">
			<div class="fa fa-bars tooltips" data-placement="right"
				data-original-title="Toggle Navigation"></div>
		</div>
		<!--logo start-->
		<a href="${pageContext.request.contextPath}" class="logo"><b>GESSO</b></a>
		<!--logo end-->
		<div class="top-menu">
			<ul class="nav pull-right top-menu">
				<li><a class="logout" href="login.html">Logout</a></li>
			</ul>
		</div>
	</header>


<aside>
	<div id="sidebar"  class="nav-collapse " ng-controller="gesso-menu as ctrlMenu">
	    
	    <!-- sidebar menu start-->
	    <ul class="sidebar-menu" id="nav-accordion">
	
	        <p class="centered">
	            <a href="#/todo/">
	                
	            </a>
	        </p>
	
	        <h5 class="centered">Marcel Newman</h5>
	
	        <li class="mt">
	            <a >
	                <i class="fa fa-dashboard"></i>
	                <span>Dashboard</span>
	            </a>
	        </li>
	        
	        
            
			<div ng-repeat="userProfileDto in lstUserProfileDto">
			
		        <li class="sub-menu" ng-repeat="userProfileMenuDto in userProfileDto.lstUserProfileMenu">
		            <a href="javascript:;">
		                <i class="fa fa-desktop"></i>
		                <span>{{userProfileMenuDto.menu.menuName}}    </span>
		            </a>
		            
		            <ul class="subNooooo" ng-repeat="option in userProfileMenuDto.menu.lstOption">
		                <li><a href="{{option.optionPath}}">{{option.optionName}}</a></li>
		            </ul>
		        </li>
	        </div>
	    </ul>
	    <!-- sidebar menu end-->
	</div>
</aside>

	<section id="container"   >
		
		<section id="main-content">
			<section class="wrapper">
				<a href="#/login">loginForm.jsp</a>
		    	<div ng-view></div>
		    
	    		
	    	</section>
	    </section>
	</section>
	


  
	
</body>
</html>