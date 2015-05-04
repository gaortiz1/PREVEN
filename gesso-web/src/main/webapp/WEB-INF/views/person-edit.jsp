<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>


<t:template>
	<jsp:attribute name="body">
		<form:form class="form-horizontal" role="form" >
          <script src="${pageContext.request.contextPath}/resources/gesso/ng-gesso-person-edit.js" type="text/javascript"></script>



          <div class="row" ng-controller="app-gesso-person-edt as ctrlPerEdt">
            <div class="col-xs-12">
              <!-- PAGE CONTENT BEGINS -->

              <div >
                <div>
                  <div ng-repeat=""></div>
                  <table st-table="ctrlPerEdt.lstPerson" class="table table-striped">
                    <thead>
                    <tr>
                      <th st-sort="firstName">Nombre</th>
                      <th st-sort="lastName">apellido</th>
                      <th st-sort="documentNumber">Documento</th>
                      <th st-sort="personalEmail">Email</th>
                      <th>Editar</th>
                    </tr>

                    </thead>
                    <tbody>
                    <tr ng-repeat="row in ctrlPerEdt.lstPerson">
                      <td>{{row.firstName | uppercase}}</td>
                      <td>{{row.lastName}}</td>
                      <td>{{row.documentNumber}}</td>
                      <td>{{row.personalEmail}}</td>
                      <td>
                        <input type="button" ng-click = "ctrlPerEdt.selectPerson(row)"value="Editar"/>
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
                </div>
              </div>

              <script type="text/javascript">
                $(document).ready(function() {
                  $("#form").submit(function() {
                    $.post($(this).attr("action"), $(this).serialize(), function(html) {

                    });
                    return false;
                  });
                });
              </script>

              <div class="hr hr-18 dotted hr-double"></div>



              <div class="hr hr-18 dotted hr-double"></div>

              <div id="modal-form" class="modal" tabindex="-1">
                <div class="modal-dialog">
                  <div class="modal-content">
                    <div class="modal-header">
                      <button type="button" class="close" data-dismiss="modal">&times;</button>
                      <h4 class="blue bigger">Please fill the following form fields</h4>
                    </div>

                    <div class="modal-body">
                      <div class="row">
                        <div class="col-xs-12 col-sm-5">
                          <div class="space"></div>

                          <input type="file" />
                        </div>

                        <div class="col-xs-12 col-sm-7">

                          <div class="space-4"></div>

                          <div class="form-group">
                            <label for="form-field-username">Primer nombre</label>

                            <div>
                              <input type="text" id="form-field-username" ng-model="personSelected.firstName"/>
                            </div>
                          </div>

                          <div class="space-4"></div>

                          <div class="form-group">
                            <label for="form-field-username">Primer apellido</label>

                            <div>
                              <input type="text" id="form-field-username" ng-model="personSelected.lastName"/>
                            </div>
                          </div>

                          <div class="space-4"></div>
                        </div>
                      </div>
                    </div>

                    <div class="modal-footer">
                      <button class="btn btn-sm" data-dismiss="modal">
                        <i class="ace-icon fa fa-times"></i>
                        Cancel
                      </button>

                      <button class="btn btn-sm btn-primary" ng-click="updatePerson()">
                        <i class="ace-icon fa fa-check"></i>
                        Save
                      </button>
                    </div>
                  </div>
                </div>
              </div><!-- PAGE CONTENT ENDS -->
            </div><!-- /.col -->
          </div><!-- /.row -->
        </form:form>
	</jsp:attribute>




</t:template>

