<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<aside>
    <div id="sidebar" class="nav-collapse ">
        <!-- sidebar menu start-->
        <ul class="sidebar-menu" id="nav-accordion">

            <p class="centered">
                <a href="#/todo/">
                    <img src="assets/img/ui-sam.jpg" class="img-circle" width="60">
                </a>
            </p>

            <h5 class="centered">Marcel Newman</h5>

            <li class="mt">
                <a class="active" href="${pageContext.request.contextPath}/home">
                    <i class="fa fa-dashboard"></i>
                    <span>Dashboard</span>
                </a>
            </li>

            <li class="sub-menu">
                <a href="javascript:;">
                    <i class="fa fa-desktop"></i>
                    <span><spring:message code="menu.label.administration"/></span>
                </a>
                <ul class="sub">
                    <li><a href="${pageContext.request.contextPath}/user-administration"><spring:message code="menu.label.user"/></a></li>
                    <li><a href="${pageContext.request.contextPath}/company-administration"><spring:message code="menu.label.company"/></a></li>
                    <li><a href="${pageContext.request.contextPath}/person-administration"><spring:message code="menu.label.person"/></a></li>
                    <li><a href="${pageContext.request.contextPath}/person-edit"><spring:message code="menu.label.person.edit"/></a></li>
                    <li><a href="${pageContext.request.contextPath}/process-administration"><spring:message code="menu.label.process"/></a></li>
                </ul>
            </li>
        </ul>
        <!-- sidebar menu end-->
    </div>
</aside>