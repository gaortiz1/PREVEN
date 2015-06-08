<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>

<h3>
	<i class="fa fa-angle-right"></i> Registrar compañia
</h3>

<hr>

<div class="panel panel-primary">
	<div class="panel-heading">
		<h3 id="panel-title" class="panel-title">Compañia</h3>
	</div>

	<div class="panel-body">
		<div class="row" ng-controller="gesso-register-company">
			<div class="col-lg-12">
				<form class="form-horizontal" role="form" name="formCreateCompny">
					<div class="form-group">
						<label class="col-sm-3 col-sm-3 control-label"> <spring:message
								code="page.label.company.razonSocial" />
						</label>
						<div class="col-sm-6">
							<input type="text" ng-model="companyModel.razonSocial"
								placeholder="Razón Social" class="form-control" size="35"
								title="Razón Social" required />
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-3 col-sm-3 control-label"> <spring:message
								code="page.label.ruc" />
						</label>

						<div class="col-sm-6">
							<input type="text" ng-model="companyModel.ruc" placeholder="Ruc"
								class="form-control" size="35" title="Ruc" maxlength="13"
								required />
						</div>
					</div>


					<div class="form-group">
						<label class="col-sm-3 col-sm-3 control-label"> <spring:message
								code="page.label.company.nombreComercial" />
						</label>

						<div class="col-sm-6">
							<input type="text" ng-model="companyModel.nombreComercial"
								placeholder="Nombre Comercial" class="form-control" size="35"
								title="Nombre Comercial" required />
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-3 col-sm-3 control-label"> <spring:message
								code="page.label.company.actividad.economica.principal" />
						</label>
						<div class="col-sm-6">
							<input type="text"
								ng-model="companyModel.actividadComercialPrincipal.name"
								placeholder="Actividad económica principal" class="form-control"
								size="255" title="Actividad económica principal" required />
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-3 col-sm-3 control-label"> <spring:message
								code="page.label.company.actividad.economica.secundaria" />
						</label>
						<div class="col-sm-6">
							<input type="text"
								ng-model="companyModel.actividadComercialSecuandaria.name"
								placeholder="Actividad económica secundaria"
								class="form-control" size="255"
								title="Actividad económica secundaria" required />
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-3 col-sm-3 control-label"> <spring:message
								code="page.label.pais" />
						</label>
						<div class="col-sm-6">
							<ui-select ng-model="companyModel.idGeopoliticalDivisionCountry" on-select="loadProvinces($item.id)"> 
								<ui-select-match placeholder="Escoga...">
									{{$select.selected.name}}
								</ui-select-match>
								<ui-select-choices repeat="country.id as country in countries | filter: $select.search track by country.name">
									<div ng-bind-html="country.name | highlight: $select.search"></div>
								</ui-select-choices> 
							</ui-select>
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-3 col-sm-3 control-label"> <spring:message
								code="page.label.provincia" />
						</label>
						<div class="col-sm-6">
							<ui-select ng-model="companyModel.idGeopoliticalDivisionProvince" on-select="loadCities($item.id)"> 
								<ui-select-match placeholder="Escoga...">
									{{$select.selected.name}}
								</ui-select-match>
								<ui-select-choices repeat="province.id as province in provinces | filter: $select.search track by province.name">
									<div ng-bind-html="province.name | highlight: $select.search"></div>
								</ui-select-choices> 
							</ui-select>
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-3 col-sm-3 control-label"> <spring:message
								code="page.label.cuidad" />
						</label>
						<div class="col-sm-6">
							<ui-select ng-model="companyModel.idGeopoliticalDivisionCity">
								<ui-select-match placeholder="Escoga...">{{$select.selected.name}}</ui-select-match>
								<ui-select-choices repeat="city.id as city in cities | filter: $select.search track by city.name">
									<div ng-bind-html="city.name | highlight: $select.search"></div>
								</ui-select-choices> 
							</ui-select>
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-3 col-sm-3 control-label"> <spring:message
								code="page.label.company.type.company" />
						</label>
						<div class="col-sm-6">
							<ui-select ng-model="companyModel.typesCompanies"> 
								<ui-select-match placeholder="Escoga...">{{$select.selected.name}}</ui-select-match>
								<ui-select-choices repeat="company.id as company in typesCompanies | filter: $select.search track by company.name">
									<div ng-bind-html="company.name | highlight: $select.search"></div>
								</ui-select-choices> 
							</ui-select>
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-3 col-sm-3 control-label"> <spring:message
								code="page.label.company.sector.productor" />
						</label>
						<div class="col-sm-6">
							<ui-select ng-model="companyModel.typeProductiveSector">
							<ui-select-match placeholder="Escoga...">{{$select.selected.name}}</ui-select-match>
								<ui-select-choices repeat="sector.id as sector in productivesSector | filter: $select.search track by sector.id">
								<div ng-bind-html="sector.name | highlight: $select.search"></div>
								</ui-select-choices> 
							</ui-select>
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-3 col-sm-3 control-label"> <spring:message
								code="page.label.company.work.hours" />
						</label>
						<div class="col-sm-6">
							<label ng-repeat="workHour in worksHours"> 
								<input type="checkbox" checklist-model="companyModel.schedulesWork" checklist-value="workHour.id"> {{workHour.name}}
							</label>

						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-3 col-sm-3 control-label"> 
							<spring:message code="page.label.local.phone" />
						</label>

						<div class="col-sm-9">
							<span class="input-icon"> <input type="text"
								ng-model="companyModel.telefono.number" class="input-mask-phone" required/> <i
								class="ace-icon fa fa-phone"></i>
							</span>
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-3 col-sm-3 control-label"> 
							<spring:message code="page.label.mobil.phone" />
						</label>

						<div class="col-sm-9">
							<span class="input-icon"> <input type="text"
								ng-model="companyModel.celular.number" class="input-mask-phone" required/> <i
								class="ace-icon fa fa-phone"></i>
							</span>
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-3 col-sm-3 control-label"> 
							<spring:message code="page.label.direccion" />
						</label>
						<div class="col-sm-6">
							<input type="text" ng-model="companyModel.direccion.nameAddress"
								placeholder="Dirección" class="form-control" size="255"
								title="Dirección" required />
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-3 col-sm-3 control-label"> 
							<spring:message code="page.label.email" />
						</label>

						<div class="col-sm-6">
							<input type="email" ng-model="companyModel.email.emailaddess"
								class="form-control" data-rel="tooltip"
								placeholder="alguien@example.com" title="Email principal"
								data-placement="bottom" maxlength="113" size="35" required /> <span
								class="help-button" data-rel="popover" data-trigger="hover"
								data-placement="left"
								data-content="Este sera el mail al cual se notificaran las novedades"
								title="Email principal">?</span>
						</div>
					</div>

					<div class="clearfix form-actions">
						<div class="col-md-offset-3 col-md-9">
							<button class="btn btn-info" type="submit"
								ng-click="formCreateCompny.$invalid || createCompany()">
								<i class="ace-icon fa fa-check bigger-110"></i>
								<spring:message code="gobal.label.save" />
							</button>

							&nbsp; &nbsp; &nbsp;
							<button class="btn" type="reset">
								<i class="ace-icon fa fa-undo bigger-110"></i>
								<spring:message code="gobal.label.reset" />
							</button>
						</div>
					</div>

					<div class="hr hr-24"></div>

				</form>
			</div>
		</div>

	</div>
</div>