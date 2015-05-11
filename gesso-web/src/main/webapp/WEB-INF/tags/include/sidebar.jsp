<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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
	            <a  href="${pageContext.request.contextPath}/home">
	                <i class="fa fa-dashboard"></i>
	                <span>Dashboard</span>
	            </a>
	        </li>
			<div ng-repeat="userProfileDto in ctrlMenu.lstUserProfileDto">
			
		        <li class="sub-menu" ng-repeat="userProfileMenuDto in userProfileDto.lstUserProfileMenu">
		            <a href="javascript:;">
		                <i class="fa fa-desktop"></i>
		                <span>{{userProfileMenuDto.menu.menuName}}    </span>
		            </a>
		            
		            <ul class="subNooooo" ng-repeat="option in userProfileMenuDto.menu.lstOption">
		                <li><a href="${pageContext.request.contextPath}/user-administration">{{option.optionName}}</a></li>
		            </ul>
		        </li>
	        </div>
	    </ul>
	    <!-- sidebar menu end-->
	</div>
</aside>