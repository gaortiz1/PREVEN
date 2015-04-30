<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>


<t:template>
	<jsp:attribute name="body">
		<form:form class="form-horizontal" role="form" >
            <script src="${pageContext.request.contextPath}/resources/gesso/ng-gesso-user.js" type="text/javascript"></script>
            <div ng-app="app-gesso" ng-controller="gesso-user-adm as ctrlUser">



                <table st-table="ctrlUser.lstUsers" class="table table-striped">
                    <thead>
                    <tr>
                        <th st-sort="nickName">Nombre</th>
                        <th st-sort="password">apellido</th>

                        <th>Editar</th>
                    </tr>

                    </thead>
                    <tbody>
                    <tr ng-repeat="row in ctrlUser.lstUsers">
                        <td>{{row.nickName | uppercase}}</td>
                        <td>{{row.password}}</td>

                        <td>
                            <input type="button" value="Editar"/>
                        </td>
                    </tr>
                    </tbody>
                    <tfoot>
                    <tr>
                        <td colspan="5" class="text-center">
                            <div st-pagination="" st-items-by-page="itemsByPage" st-displayed-pages="7"></div>
                        </td>
                    </tr>
                    </tfoot>
                </table>
                <input type="button" ng-click="ctrlUser.findUsers()" value="asdasd">

            </div>
		</form:form>
	</jsp:attribute>




</t:template>

