<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>


<t:template>
	<jsp:attribute name="body">
		<form:form class="form-horizontal" role="form" >
            <script src="${pageContext.request.contextPath}/resources/gesso/ng-gesso-user.js" type="text/javascript"></script>
            <div  ng-controller="gesso-user-adm as ctrlUser">



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
                        <td>{{row.userDto.nickName | uppercase}}</td>
                        <td>{{row.userDto.password}}</td>

                        <td>
                            <input type="button" value="Editar" ng-click="ctrlUser.selectUser();"/>
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
                <input type="button" ng-click="ctrlUser.findUsers()" value="Editar">

                <!-- Modal -->
                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h4 class="modal-title" id="myModalLabel">Modal title</h4>
                            </div>
                            <div class="modal-body">
                                <div class="">
                                    <div class="form-group">
                                        <label >
                                            <spring:message code="page.label.password"></spring:message>
                                        </label>

                                        <div>
                                            <input type="text"  placeholder="Nueva clave" name="${userDto.usrNickName}" />

                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label >
                                            <spring:message code="page.label.status"></spring:message>
                                        </label>

                                        <div>
                                            <label>
                                                <input name="lactationPeriod" class="ace ace-switch ace-switch-6" type="checkbox" />
                                                <span class="lbl"></span>
                                            </label>

                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                <button type="button" class="btn btn-primary">Save changes</button>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- MODAL EDICION USUARIO -->
                <div id="modal-form" class="modal" tabindex="-1">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                <h4 class="blue bigger">
                                    <spring:message code="page.label.update.password.status"/>
                                </h4>
                            </div>

                            <div class="modal-body">
                                <div class="row">
                                    <div class="col-xs-12 col-sm-7">

                                        <div class="form-group">
                                            <label for="form-field-first">
                                                <spring:message code="page.label.password"></spring:message>
                                            </label>

                                            <div>
                                                <input type="text"  placeholder="Nueva clave" name="${userDto.usrNickName}" />

                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="form-field-first">
                                                <spring:message code="page.label.status"></spring:message>
                                            </label>

                                            <div>
                                                <label>
                                                    <input name="lactationPeriod" class="ace ace-switch ace-switch-6" type="checkbox" />
                                                    <span class="lbl"></span>
                                                </label>

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

                                <button class="btn btn-sm btn-primary" data-dismiss="modal">
                                    <i class="ace-icon fa fa-check"></i>
                                    Save
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
		</form:form>
	</jsp:attribute>




</t:template>

