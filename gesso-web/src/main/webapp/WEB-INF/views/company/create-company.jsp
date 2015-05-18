<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>

<div class="row" ng-controller="gesso-create-company">

	<form:form class="form-horizontal" role="form">
		<div class="row mt">
			<div class="col-lg-12">
				<div class="form-panel">
					<h4 class="mb">
						<i class="fa fa-angle-right"></i>Nueva Compañia
					</h4>

					<div class="form-group">
						<label class="col-sm-3 col-sm-3 control-label"> 
							<spring:message code="page.label.company.razonSocial" />
						</label>
						<div class="col-sm-6">
							<input type="text" ng-model="companyModel.razonSocial" placeholder="Razón Social" class="form-control" size="35" title="Razón Social" required/>
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-3 col-sm-3 control-label"> 
							<spring:message code="page.label.ruc" />
						</label>

						<div class="col-sm-6">
							<input type="text" ng-model="companyModel.ruc" placeholder="Ruc" class="form-control" size="35" title="Ruc" maxlength="13" required/>
						</div>
					</div>


					<div class="form-group">
						<label class="col-sm-3 col-sm-3 control-label"> 
							<spring:message code="page.label.company.nombreComercial" />
						</label>

						<div class="col-sm-6">
							<input type="text" ng-model="companyModel.nombreComercial" placeholder="Nombre Comercial" class="form-control" size="35" title="Nombre Comercial" required/>
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-3 col-sm-3 control-label"> 
							<spring:message code="page.label.company.actividad.economica.principal" />
						</label>
						<div class="col-sm-6">
							<input type="text" ng-model="companyModel.actividadComercialPrincipal" placeholder="Actividad económica principal" class="form-control" size="255" title="Actividad económica principal" required/>
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-3 col-sm-3 control-label"> 
							<spring:message code="page.label.company.actividad.economica.secundaria" />
						</label>
						<div class="col-sm-6">
							<input type="text" ng-model="companyModel.actividadComercialSecuandaria" placeholder="Actividad económica secundaria" class="form-control" size="255" title="Actividad económica secundaria" required/>
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-3 col-sm-3 control-label"> 
							<spring:message code="page.label.pais" />
						</label>
						<div class="col-sm-6">
							<select ng-model="companyModel.idGeopoliticalDivisionCountry" class="chosen-select form-control" data-placeholder="Seleccione pais..." required>
							</select>
						</div>
					</div>

				</div>
			</div>
		</div>
	</form:form>

</div>