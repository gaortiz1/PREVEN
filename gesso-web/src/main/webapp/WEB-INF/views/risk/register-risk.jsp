<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>

<h3>
	<i class="fa fa-angle-right"></i> Registrar riesgo
</h3>

<hr>

<div class="panel panel-primary">
	<div class="panel-heading">
		<h3 id="panel-title" class="panel-title">Riesgo</h3>
	</div>

	<div class="panel-body">
		<div class="row" ng-controller="gesso-register-risk">
			<div class="col-lg-12">
				<form class="form-horizontal" role="form" name="formCreateRisk">
					
					 <div class="content-panel">
						  <h4><i class="fa fa-angle-right"></i>Evaluacion Riesgos</h4>
                          <section id="no-more-tables">
                              <table class="table table-bordered table-striped table-condensed cf">
                              	<tr>
                              		<th>Factores</th>
                              		<th>Riesgos</th>
                              	</tr>
                              	 <tr ng-repeat="factor in factors | orderBy:'name':true">
								      <th id="{{factor.name}}">
								      	{{factor.name}}
								      </th>
								      <td data-title="Code" headers="{{factor.name}}">
                                      	<table>
                                      		<tr data-title="Code" ng-repeat="risk in factor.risks | orderBy:'name':true">
                                      			<td>{{risk.name}}</td>
                                      			<td ng-repeat="probability in probabilities">
                                      				<input type="radio" name="probability{{risk.id}}" ng-model="$parent.pageSet" ng-value="probability.id" />
                                      			</td>
                                      			<td ng-repeat="consequence in consequences">
                                      				<input type="radio" name="consequence{{risk.id}}" ng-model="$parent.pageSet" ng-value="consequence.id" />
                                      			</td>
                                      		</tr>
                                      	</table>
                                      </td>
									</tr>
                              </table>
                          </section>
                      </div><!-- /content-panel -->
                  
					<div class="hr hr-24"></div>

				</form>
			</div>
		</div>

	</div>
</div>