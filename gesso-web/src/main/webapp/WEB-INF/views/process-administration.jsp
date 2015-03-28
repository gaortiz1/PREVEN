<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page session="true"%>
<html lang="en">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>Treeview - Ace Admin</title>

		<meta name="description" content="with selectable items(single &amp; multiple) and custom icons" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

		<!-- bootstrap & fontawesome -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/bootstrap.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/font-awesome.css" />

		<!-- page specific plugin styles -->

		<!-- text fonts -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/ace-fonts.css" />

		<!-- ace styles -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/ace.css" class="ace-main-stylesheet" id="main-ace-style" />

		<!--[if lte IE 9]>
			<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/ace-part2.css" class="ace-main-stylesheet" />
		<![endif]-->

		<!--[if lte IE 9]>
		  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/ace-ie.css" />
		<![endif]-->

		<!-- inline styles related to this page -->

		<!-- ace settings handler -->
		<script src="${pageContext.request.contextPath}/resources/assets/js/ace-extra.js"></script>

		<!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->

		<!--[if lte IE 8]>
		<script src="${pageContext.request.contextPath}/resources/assets/js/html5shiv.js"></script>
		<script src="${pageContext.request.contextPath}/resources/assets/js/respond.js"></script>
		<![endif]-->
	</head>

	<body class="no-skin">
		<!-- #section:basics/navbar.layout -->
		<%@ include file="gesso-header.jspf" %>

		<!-- /section:basics/navbar.layout -->
		<div class="main-container" id="main-container">
			<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>

			<!-- #section:basics/sidebar -->
			<div id="sidebar" class="sidebar                  responsive">
				<script type="text/javascript">
					try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
				</script>

				<div class="sidebar-shortcuts" id="sidebar-shortcuts">
					<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
						<button class="btn btn-success">
							<i class="ace-icon fa fa-signal"></i>
						</button>

						<button class="btn btn-info">
							<i class="ace-icon fa fa-pencil"></i>
						</button>

						<!-- #section:basics/sidebar.layout.shortcuts -->
						<button class="btn btn-warning">
							<i class="ace-icon fa fa-users"></i>
						</button>

						<button class="btn btn-danger">
							<i class="ace-icon fa fa-cogs"></i>
						</button>

						<!-- /section:basics/sidebar.layout.shortcuts -->
					</div>

					<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
						<span class="btn btn-success"></span>

						<span class="btn btn-info"></span>

						<span class="btn btn-warning"></span>

						<span class="btn btn-danger"></span>
					</div>
				</div><!-- /.sidebar-shortcuts -->

				<ul class="nav nav-list">
			      <li class="">
			        <a href="${pageContext.request.contextPath}/home">
			          <i class="menu-icon fa fa-tachometer"></i>
			          <span class="menu-text"> Dashboard </span>
			        </a>
			
			        <b class="arrow"></b>
			      </li>
			
			      <li class="active open">
			        <a href="#" class="dropdown-toggle">
			          <i class="menu-icon fa fa-list"></i>
			          <span class="menu-text"> <spring:message code="menu.label.administration"/> </span>
			
			          <b class="arrow fa fa-angle-down"></b>
			        </a>
			
			        <b class="arrow"></b>
			
			        <ul class="submenu">
			          <li class="">
			            <a href="${pageContext.request.contextPath}/user-administration">
			              <i class="menu-icon fa fa-caret-right"></i>
			              <spring:message code="menu.label.user"/>
			            </a>
			
			            <b class="arrow"></b>
			          </li>
			
			          <li class="">
			            <a href="${pageContext.request.contextPath}/company-administration">
			              <i class="menu-icon fa fa-caret-right"></i>
			              <spring:message code="menu.label.company"/>
			            </a>
			
			            <b class="arrow"></b>
			          </li>
			
			          <li class="">
			            <a href="${pageContext.request.contextPath}/person-administration">
			              <i class="menu-icon fa fa-caret-right"></i>
			              <spring:message code="menu.label.person"/>
			            </a>
			
			            <b class="arrow"></b>
			          </li>
			
			          <li class="active">
			            <a href="${pageContext.request.contextPath}/process-administration">
			              <i class="menu-icon fa fa-caret-right"></i>
			              <spring:message code="menu.label.process"/>
			            </a>
			
			            <b class="arrow"></b>
			          </li>
			        </ul>
			      </li>
			
			      <li class="">
			        <a href="#" class="dropdown-toggle">
			          <i class="menu-icon fa fa-pencil-square-o"></i>
			          <span class="menu-text"> Forms </span>
			
			          <b class="arrow fa fa-angle-down"></b>
			        </a>
			
			        <b class="arrow"></b>
			
			        <ul class="submenu">
			          <li class="">
			            <a href="form-elements.html">
			              <i class="menu-icon fa fa-caret-right"></i>
			              Person
			            </a>
			
			            <b class="arrow"></b>
			          </li>
			
			          <li class="">
			            <a href="dropzone.html">
			              <i class="menu-icon fa fa-caret-right"></i>
			              Company
			            </a>
			
			            <b class="arrow"></b>
			          </li>
			        </ul>
			      </li>
			    </ul><!-- /.nav-list -->

				<!-- #section:basics/sidebar.layout.minimize -->
				<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
					<i class="ace-icon fa fa-angle-double-left" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
				</div>

				<!-- /section:basics/sidebar.layout.minimize -->
				<script type="text/javascript">
					try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
				</script>
			</div>

			<!-- /section:basics/sidebar -->
			<div class="main-content">
				<div class="main-content-inner">
					<!-- #section:basics/content.breadcrumbs -->
					<div class="breadcrumbs" id="breadcrumbs">
						<script type="text/javascript">
							try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
						</script>

						<ul class="breadcrumb">
							<li>
								<i class="ace-icon fa fa-home home-icon"></i>
								<a href="#">Home</a>
							</li>

							<li>
								<a href="#"><spring:message code="menu.label.administration"/></a>
							</li>
							<li class="active"><spring:message code="menu.label.process"/></li>
						</ul><!-- /.breadcrumb -->

						<!-- #section:basics/content.searchbox -->
						<div class="nav-search" id="nav-search">
							<form class="form-search">
								<span class="input-icon">
									<input type="text" placeholder="Search ..." class="nav-search-input" id="nav-search-input" autocomplete="off" />
									<i class="ace-icon fa fa-search nav-search-icon"></i>
								</span>
							</form>
						</div><!-- /.nav-search -->

						<!-- /section:basics/content.searchbox -->
					</div>

					<!-- /section:basics/content.breadcrumbs -->
					<div class="page-content">
						<!-- #section:settings.box -->
						<div class="ace-settings-container" id="ace-settings-container">
							<div class="btn btn-app btn-xs btn-warning ace-settings-btn" id="ace-settings-btn">
								<i class="ace-icon fa fa-cog bigger-130"></i>
							</div>

							<div class="ace-settings-box clearfix" id="ace-settings-box">
								<div class="pull-left width-50">
									<!-- #section:settings.skins -->
									<div class="ace-settings-item">
										<div class="pull-left">
											<select id="skin-colorpicker" class="hide">
												<option data-skin="no-skin" value="#438EB9">#438EB9</option>
												<option data-skin="skin-1" value="#222A2D">#222A2D</option>
												<option data-skin="skin-2" value="#C6487E">#C6487E</option>
												<option data-skin="skin-3" value="#D0D0D0">#D0D0D0</option>
											</select>
										</div>
										<span>&nbsp; Choose Skin</span>
									</div>

									<!-- /section:settings.skins -->

									<!-- #section:settings.navbar -->
									<div class="ace-settings-item">
										<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-navbar" />
										<label class="lbl" for="ace-settings-navbar"> Fixed Navbar</label>
									</div>

									<!-- /section:settings.navbar -->

									<!-- #section:settings.sidebar -->
									<div class="ace-settings-item">
										<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-sidebar" />
										<label class="lbl" for="ace-settings-sidebar"> Fixed Sidebar</label>
									</div>

									<!-- /section:settings.sidebar -->

									<!-- #section:settings.breadcrumbs -->
									<div class="ace-settings-item">
										<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-breadcrumbs" />
										<label class="lbl" for="ace-settings-breadcrumbs"> Fixed Breadcrumbs</label>
									</div>

									<!-- /section:settings.breadcrumbs -->

									<!-- #section:settings.rtl -->
									<div class="ace-settings-item">
										<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-rtl" />
										<label class="lbl" for="ace-settings-rtl"> Right To Left (rtl)</label>
									</div>

									<!-- /section:settings.rtl -->

									<!-- #section:settings.container -->
									<div class="ace-settings-item">
										<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-add-container" />
										<label class="lbl" for="ace-settings-add-container">
											Inside
											<b>.container</b>
										</label>
									</div>

									<!-- /section:settings.container -->
								</div><!-- /.pull-left -->

								<div class="pull-left width-50">
									<!-- #section:basics/sidebar.options -->
									<div class="ace-settings-item">
										<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-hover" />
										<label class="lbl" for="ace-settings-hover"> Submenu on Hover</label>
									</div>

									<div class="ace-settings-item">
										<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-compact" />
										<label class="lbl" for="ace-settings-compact"> Compact Sidebar</label>
									</div>

									<div class="ace-settings-item">
										<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-highlight" />
										<label class="lbl" for="ace-settings-highlight"> Alt. Active Item</label>
									</div>

									<!-- /section:basics/sidebar.options -->
								</div><!-- /.pull-left -->
							</div><!-- /.ace-settings-box -->
						</div><!-- /.ace-settings-container -->

						<!-- /section:settings.box -->
						

						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->

								<!-- #section:plugins/fuelux.treeview -->
								<div class="row">
									<div class="col-sm-4">
										<div class="widget-box widget-color-blue2">
											<div class="widget-header">
												<h4 class="widget-title lighter smaller">
													<spring:message code="menu.label.process"/>
												</h4>
											</div>

											<div class="widget-body">
												<div class="widget-main padding-8">
													<ul id="tree1"></ul>
												</div>
											</div>
										</div>
									</div>

									<div class="col-sm-8">
										<div class="widget-box widget-color-green2">
											<div class="widget-header">
												<h4 class="widget-title lighter smaller">Administrar procesos</h4>
											</div>

											<div class="widget-body">
												<div class="widget-main padding-8">
													<ul id="tree2"></ul>
												</div>
												
												
												<button class="btn btn-white btn-info btn-round" onclick="$('#modal-form-process').modal('show')">
													<i class="ace-icon fa fa-cogs bigger-120 blue"></i>
													<spring:message code="page.label.new.process"/>
												</button>
	
												<button class="btn btn-white btn-warning btn-round" onclick="$('#modal-form-subprocess').modal('show')">
													<i class="ace-icon fa fa-cogs bigger-120 orange"></i>
													<spring:message code="page.label.new.subprocess"/>
												</button>
	
												<button class="btn btn-white btn-default btn-round" onclick="$('#modal-form-job').modal('show')">
													<i class="ace-icon fa fa-cogs red2"></i>
													<spring:message code="page.label.new.job"/>
												</button>
											</div>
										</div>
									</div>
									
									
								</div>







								<div id="modal-form-process" class="modal" tabindex="-1">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal">&times;</button>
												<h4 class="blue bigger">
													<spring:message code="page.label.new.process"/>
												</h4>
											</div>
											
											<form:form action="new-process" method="POST">
												<div class="modal-body">
													<div class="row">
														<div class="col-xs-12 col-sm-7">
	
															<div class="form-group">
																<label for="form-field-first">
																	<spring:message code="page.label.name"/>
																</label>
																
																<div>
																	<form:input path="process.name" placeholder ="Nombre proceso" required="required"/>
																	
																</div>
															</div>
															
															<div class="form-group">
																<label for="form-field-first">
																	<spring:message code="page.label.description"/>
																</label>
																
																<div>
																	<form:input path="process.description" required="required"/>
																</div>
															</div>
															
														</div>
													</div>
												</div>
												
												<div class="modal-footer">
													<button class="btn btn-sm" data-dismiss="modal">
														<i class="ace-icon fa fa-times"></i>
														Cancel
													</button>
	
													<button class="btn btn-sm btn-primary" type="submit">
														<i class="ace-icon fa fa-check"></i>
														Save
													</button>
												</div>
											</form:form>
											
										</div>
									</div>
								</div>
								
								
								
								
								
								
								
								
								
								<div id="modal-form-subprocess" class="modal" tabindex="-1">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal">&times;</button>
												<h4 class="blue bigger">
													<spring:message code="page.label.new.subprocess"/>
												</h4>
											</div>
											
											<form:form action="new-subprocess" method="POST">
												<div class="modal-body">
													<div class="row">
														<div class="col-xs-12 col-sm-7">
														
														<div class="form-group">
																<label for="form-field-first">
																	<spring:message code="menu.label.process"/>
																</label>
																
																<div>
																	<form:select path="subProcess.idProcess" cssClass="chosen-select form-control" data-placeholder="Seleccionar proceso" >
																		<form:options items="${lstProcess}" itemLabel="name" itemValue="id" />
																	</form:select>
																</div>
															</div>
															
															<div class="form-group">
																<label for="form-field-first">
																	<spring:message code="page.label.name"/>
																</label>
																
																<div>
																	<form:input path="subProcess.name" placeholder ="Nombre proceso" required="required"/>
																	
																</div>
															</div>
															
															<div class="form-group">
																<label for="form-field-first">
																	<spring:message code="page.label.description" />
																</label>
																
																<div>
																	<form:input path="subProcess.description" required="required"/>
																</div>
															</div>
															
														</div>
													</div>
												</div>
												
												<div class="modal-footer">
													<button class="btn btn-sm" data-dismiss="modal">
														<i class="ace-icon fa fa-times"></i>
														Cancel
													</button>
	
													<button class="btn btn-sm btn-primary" type="submit">
														<i class="ace-icon fa fa-check"></i>
														Save
													</button>
												</div>
											</form:form>
											
										</div>
									</div>
								</div>
								
								
								
								
								
								
								
								
								
								
								
								
								<div id="modal-form-job" class="modal" tabindex="-1">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal">&times;</button>
												<h4 class="blue bigger">
													<spring:message code="page.label.new.job"/>
												</h4>
											</div>
											
											<form:form action="new-job" method="POST">
												<div class="modal-body">
													<div class="row">
														<div class="col-xs-12 col-sm-7">
														
														
															
															
															<div class="form-group">
																<label for="form-field-first">
																	<spring:message code="menu.label.process"/>
																</label>
																
																<div>
																	<form:select path="idProcesFormJob" cssClass="chosen-select form-control" data-placeholder="Seleccionar proceso" onchange="cargarSubProcesos(this, event)">
																		<form:options items="${lstProcess}" itemLabel="name" itemValue="id" />
																	</form:select>
																</div>
															</div>
															
															<div class="form-group">
																<label for="form-field-first">
																	<spring:message code="menu.label.process"/>
																</label>
																
																<div>
																	<select id="job.idSubProcess" name="job.idSubProcess" class="chosen-select form-control job-subprocess-selector" data-placeholder="Seleccionar sub-proceso" required="required">
																		
																	</select>
																</div>
															</div>
															
															<div class="form-group">
																<label for="form-field-first">
																	<spring:message code="page.label.name"/>
																</label>
																
																<div>
																	<form:input path="job.name" placeholder ="Nombre proceso" required="required"/>
																	
																</div>
															</div>
															
															<div class="form-group">
																<label for="form-field-first">
																	<spring:message code="page.label.description" />
																</label>
																
																<div>
																	<form:input path="job.description" required="required"/>
																</div>
															</div>
															
														</div>
													</div>
												</div>
												
												<div class="modal-footer">
													<button class="btn btn-sm" data-dismiss="modal">
														<i class="ace-icon fa fa-times"></i>
														Cancel
													</button>
	
													<button class="btn btn-sm btn-primary" type="submit">
														<i class="ace-icon fa fa-check"></i>
														Save
													</button>
												</div>
											</form:form>
											
										</div>
									</div>
								</div>
								<!-- /section:plugins/fuelux.treeview -->
								<script type="text/javascript">
									var $assets = "${pageContext.request.contextPath}/resources/assets";//this will be used in fuelux.tree-sampledata.js
								</script>

								<!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row -->
					</div><!-- /.page-content -->
				</div>
			</div><!-- /.main-content -->

			<div class="footer">
				<div class="footer-inner">
					<!-- #section:basics/footer -->
					<div class="footer-content">
						<span class="bigger-120">
							<span class="blue bolder">Gesso</span>
							Application &copy; 2015
						</span>

						&nbsp; &nbsp;
						<span class="action-buttons">
							<a href="#">
								<i class="ace-icon fa fa-twitter-square light-blue bigger-150"></i>
							</a>

							<a href="#">
								<i class="ace-icon fa fa-facebook-square text-primary bigger-150"></i>
							</a>

							<a href="#">
								<i class="ace-icon fa fa-rss-square orange bigger-150"></i>
							</a>
						</span>
					</div>

					<!-- /section:basics/footer -->
				</div>
			</div>

			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
			</a>
		</div><!-- /.main-container -->

		<!-- basic scripts -->

		<!--[if !IE]> -->
		<script type="text/javascript">
			window.jQuery || document.write("<script src='${pageContext.request.contextPath}/resources/assets/js/jquery.js'>"+"<"+"/script>");
		</script>

		<!-- <![endif]-->

		<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='${pageContext.request.contextPath}/resources/assets/js/jquery1x.js'>"+"<"+"/script>");
</script>
<![endif]-->
		<script type="text/javascript">
			if('ontouchstart' in document.documentElement) document.write("<script src='${pageContext.request.contextPath}/resources/assets/js/jquery.mobile.custom.js'>"+"<"+"/script>");
		</script>
		<script src="${pageContext.request.contextPath}/resources/assets/js/bootstrap.js"></script>

		<!-- page specific plugin scripts -->
		<script src="${pageContext.request.contextPath}/resources/assets/js/fuelux/fuelux.tree.js"></script>

		<!-- ace scripts -->
		<script src="${pageContext.request.contextPath}/resources/assets/js/ace/elements.scroller.js"></script>
		<script src="${pageContext.request.contextPath}/resources/assets/js/ace/elements.colorpicker.js"></script>
		<script src="${pageContext.request.contextPath}/resources/assets/js/ace/elements.fileinput.js"></script>
		<script src="${pageContext.request.contextPath}/resources/assets/js/ace/elements.typeahead.js"></script>
		<script src="${pageContext.request.contextPath}/resources/assets/js/ace/elements.wysiwyg.js"></script>
		<script src="${pageContext.request.contextPath}/resources/assets/js/ace/elements.spinner.js"></script>
		<script src="${pageContext.request.contextPath}/resources/assets/js/ace/elements.treeview.js"></script>
		<script src="${pageContext.request.contextPath}/resources/assets/js/ace/elements.wizard.js"></script>
		<script src="${pageContext.request.contextPath}/resources/assets/js/ace/elements.aside.js"></script>
		<script src="${pageContext.request.contextPath}/resources/assets/js/ace/ace.js"></script>
		<script src="${pageContext.request.contextPath}/resources/assets/js/ace/ace.ajax-content.js"></script>
		<script src="${pageContext.request.contextPath}/resources/assets/js/ace/ace.touch-drag.js"></script>
		<script src="${pageContext.request.contextPath}/resources/assets/js/ace/ace.sidebar.js"></script>
		<script src="${pageContext.request.contextPath}/resources/assets/js/ace/ace.sidebar-scroll-1.js"></script>
		<script src="${pageContext.request.contextPath}/resources/assets/js/ace/ace.submenu-hover.js"></script>
		<script src="${pageContext.request.contextPath}/resources/assets/js/ace/ace.widget-box.js"></script>
		<script src="${pageContext.request.contextPath}/resources/assets/js/ace/ace.settings.js"></script>
		<script src="${pageContext.request.contextPath}/resources/assets/js/ace/ace.settings-rtl.js"></script>
		<script src="${pageContext.request.contextPath}/resources/assets/js/ace/ace.settings-skin.js"></script>
		<script src="${pageContext.request.contextPath}/resources/assets/js/ace/ace.widget-on-reload.js"></script>
		<script src="${pageContext.request.contextPath}/resources/assets/js/ace/ace.searchbox-autocomplete.js"></script>

		<!-- inline scripts related to this page -->
		<script type="text/javascript">

		
		function cargarProcesos(){
			$.ajax({
				method: "GET",
				url: "load-process",
				contentType: "application/json; charset=utf-8",
				dataType: "json",
				success: loadProcessDataAjax,
	          	error: function( jqXhr, textStatus, errorThrown ){
		          	console.log( errorThrown );
	          	}
			});
		}
		
		function loadProcessDataAjax(data, textStatus, jQxhr){
			var tree_data = data;

			
			
			
			var dataSource1 = function(options, callback){
				var $data = null
				if(!("text" in options) && !("type" in options)){
					$data = tree_data;//the root tree
					callback({ data: $data });
					return;
				}
				else if("type" in options && options.type == "folder") {
					if("additionalParameters" in options && "children" in options.additionalParameters)
						$data = options.additionalParameters.children || {};
					else $data = {}//no data
				}
				
				if($data != null){
					setTimeout(function(){callback({ data: $data });} , parseInt(Math.random() * 500) + 200);
				}
			}


			$('#tree1').ace_tree({
				dataSource: dataSource1,
				multiSelect: true,
				cacheItems: true,
				'open-icon' : 'ace-icon tree-minus',
				'close-icon' : 'ace-icon tree-plus',
				'selectable' : true,
				'selected-icon' : 'ace-icon fa fa-check',
				'unselected-icon' : 'ace-icon fa fa-times',
				loadingHTML : '<div class="tree-loading"><i class="ace-icon fa fa-refresh fa-spin blue"></i></div>'
			});
		}


		function cargarSubProcesos(element, event){

			var selectResult=0;
			$(element).find("option:selected").each(function(indice, elemento) {
				selectResult= $(elemento).val();
			});
			
			$.ajax({
				method: "GET",
				url: "load-sub-process/"+selectResult,
				contentType: "application/json; charset=utf-8",
				dataType: "json",
				success:function( data, textStatus, errorThrown ){
					$(".job-subprocess-selector").find('option').remove();
					$.each( data, function( i, item ) {
						$(".job-subprocess-selector").append($("<option></option>").attr("value",item.id).text(item.text)); 
				   	});
		          	
	          	},
	          	error: function( jqXhr, textStatus, errorThrown ){
		          	alert( errorThrown );
	          	}
			});
		}
		jQuery(function($){
			//see below
	
			//please refer to docs for more info
			$('#tree1')
			.on('loaded.fu.tree', function(e) {
				
			})
			.on('updated.fu.tree', function(e, result) {
			})
			.on('selected.fu.tree', function(e, result) {
			})
			.on('deselected.fu.tree', function(e) {
			})
			.on('opened.fu.tree', function(e, result) {
				
			})
			.on('closed.fu.tree', function(e) {
			});
			cargarProcesos();
			
		});
		</script>
		
		
		
		<!-- the following scripts are used in demo only for onpage help and you don't need them -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/ace.onpage-help.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/docs/assets/js/themes/sunburst.css" />

		<script type="text/javascript"> ace.vars['base'] = '..'; </script>
		<script src="${pageContext.request.contextPath}/resources/assets/js/ace/elements.onpage-help.js"></script>
		<script src="${pageContext.request.contextPath}/resources/assets/js/ace/ace.onpage-help.js"></script>
		<script src="${pageContext.request.contextPath}/resources/docs/assets/js/rainbow.js"></script>
		<script src="${pageContext.request.contextPath}/resources/docs/assets/js/language/generic.js"></script>
		<script src="${pageContext.request.contextPath}/resources/docs/assets/js/language/html.js"></script>
		<script src="${pageContext.request.contextPath}/resources/docs/assets/js/language/css.js"></script>
		<script src="${pageContext.request.contextPath}/resources/docs/assets/js/language/javascript.js"></script>
	</body>
</html>
