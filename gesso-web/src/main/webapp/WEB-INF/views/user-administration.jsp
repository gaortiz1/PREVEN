<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>


		<div ng-controller="gesso-user-adm as ctrlUser">
		     <table st-table="ctrlUser.lstUsersDisplayed" st-safe-src="ctrlUser.lstUsers"  class="table table-striped">
		         <thead>
		         <tr>
		             <th st-sort="userDto.nickName">Nombre</th>
		             <th st-sort="userDto.password">apellido</th>
		
		             <th>Editar</th>
		         </tr>
		
		         </thead>
		         <tbody>
		         <tr ng-repeat="row in ctrlUser.lstUsersDisplayed">
		             <td>{{row.userDto.nickName | uppercase}}</td>
		             <td>{{row.userDto.password}}</td>
		
		             <td>
		                 <input type="button" value="Editar" ng-click="ctrlUser.selectUser(row.userDto);"/>
		             </td>
		         </tr>
		         </tbody>
		         <tfoot>
		         <tr>
		             <td colspan="3" class="text-center">
		                 <div st-pagination="" st-items-by-page="4" st-displayed-pages="2"></div>
		             </td>
		         </tr>
		         </tfoot>
		     </table>

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
		                                 <label>
		                                     <spring:message code="page.label.password"></spring:message>
		                                 </label>
		
		                                 <div>
		                                     <input type="password"  placeholder="Nueva clave" ng-model="ctrlUser.userSelected.password" />
		                                 </div>
		                             </div>
		
		                             <div class="form-group">
		                                 <label>
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
		                         Cancelar
		                     </button>
		
		                     <button type="submit" class="btn btn-sm btn-primary" data-dismiss="modal" ng-click="ctrlUser.saveChangesUser();">
		                         <i class="ace-icon fa fa-check"></i>
		                         Guardar
		                     </button>
		                 </div>
		             </div>
		         </div>
		     </div>
		 </div>