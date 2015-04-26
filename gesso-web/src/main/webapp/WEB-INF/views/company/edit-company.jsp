<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<t:template>
	<jsp:attribute name="body">
		<form:form class="form-horizontal" role="form">
									<!-- #section:elements.form -->
									
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"><spring:message
						code="page.label.company.razonSocial" /></label>
										<div class="col-sm-9">
											<form:input path="razonSocial" placeholder="Razón Social"
						cssClass="txt-validate-empty" size="35" title="Razón Social"
						required="required" />
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"><spring:message
						code="page.label.ruc" /></label>

										<div class="col-sm-9">
											<form:input path="ruc" placeholder="Ruc"
						cssClass="txt-validate-empty" size="35" title="Ruc"
						required="required" maxlength="13" />
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"><spring:message
						code="page.label.company.nombreComercial" /></label>

										<div class="col-sm-9">
											<form:input path="nombreComercial"
						placeholder="Nombre Comercial" cssClass="txt-validate-empty"
						size="35" title="Nombre Comercial" required="required" />
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"><spring:message
						code="page.label.company.actividad.economica.principal" /></label>
										<div class="col-sm-9">
											<form:textarea path="actividadComercialPrincipal"
						placeholder="Actividad económica principal"
						cssClass="txt-validate-empty" rows="2" cols="50"
						required="required" />
										</div>
									</div>	
									
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"><spring:message
						code="page.label.company.actividad.economica.secundaria" /></label>
										<div class="col-sm-9">
											<form:textarea path="actividadComercialSecuandaria"
						placeholder="Actividad económica secundaria"
						cssClass="txt-validate-empty" rows="2" cols="50" />
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"><spring:message
						code="page.label.pais" /></label>
										<div class="col-sm-5">
											<form:select path="idGeopoliticalDivisionCountry"
						id="selectPais" data-placeholder="Seleccione pais..."
						required="required"
						onchange="loadChildren(this, event,'idGeopoliticalDivisionProvince')"
						style="width: 452px;">
												<form:option value="" label="--- Seleccione---" />
												<form:options items="${geopoliticalCountries}"
							itemLabel="name" itemValue="id" />
											</form:select>
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"><spring:message
						code="page.label.provincia" /></label>
										<div class="col-sm-5">
											<form:select path="idGeopoliticalDivisionProvince"
						data-placeholder="Seleccione provincia..." required="required"
						onchange="loadChildren(this, event, 'idGeopoliticalDivisionCity')"
						style="width: 452px;">
												<form:options items="${geopoliticalProvinces}"
							itemLabel="name" itemValue="id" />
											</form:select>
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"><spring:message
						code="page.label.cuidad" /></label>
										<div class="col-sm-5">
											<form:select path="idGeopoliticalDivisionCity"
						data-placeholder="Seleccione ciudad..." required="required"
						style="width: 452px;">
												<form:options items="${geopoliticalCities}" itemLabel="name"
							itemValue="id" />
											</form:select>
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"><spring:message
						code="page.label.company.type.company" /></label>
										<div class="col-sm-5">
											<form:select path="typesCompanies"
						cssClass="chosen-select form-control"
						data-placeholder="Seleccione tipo compañia..." required="required">
												<form:options items="${typesCompanies}" itemLabel="name"
							itemValue="id" />
											</form:select>
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"><spring:message
						code="page.label.company.sector.productor" /></label>
										<div class="col-sm-5">
											<form:select path="typeProductiveSector"
						cssClass="chosen-select form-control"
						data-placeholder="Seleccione sector productivo..."
						required="required">
												<form:options items="${productivesSector}" itemLabel="name"
							itemValue="id" />
											</form:select>
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"><spring:message
						code="page.label.company.work.hours" /></label>
										<div class="col-sm-5">
											<form:checkboxes items="${worksHours}" path="schedulesWork"
						itemLabel="name" itemValue="id" delimiter=" " />
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"><spring:message
						code="page.label.local.phone" /></label>

										<div class="col-sm-9">
											<span class="input-icon">
												<form:input path="telefono" cssClass="input-mask-phone"
							required="required" />
												<i class="ace-icon fa fa-phone"></i>
											</span>
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"><spring:message
						code="page.label.mobil.phone" /></label>

										<div class="col-sm-9">
											<span class="input-icon">
												<form:input path="celular" cssClass="input-mask-phone" />
												<i class="ace-icon fa fa-phone"></i>
											</span>
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"><spring:message
						code="page.label.direccion" /></label>
										<div class="col-sm-9">
											<form:input path="direccion" placeholder="Dirección"
						cssClass="txt-validate-empty" size="35" required="required" />
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"><spring:message
						code="page.label.email" /></label>

										<div class="col-sm-9">
											<form:input path="email" data-rel="tooltip"
						placeholder="Tooltip on hover" title="Email principal"
						data-placement="bottom" type="email" autocomplete="true"
						maxlength="113" size="35" required="required" />
											<span class="help-button" data-rel="popover"
						data-trigger="hover" data-placement="left"
						data-content="Este sera el email al cual se notificaran las novedades"
						title="Email principal">?</span>
										</div>
									</div>
									
									<div class="clearfix form-actions">
										<div class="col-md-offset-3 col-md-9">
											<button class="btn btn-info" type="submit">
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

								</form:form>
	</jsp:attribute>
</t:template>
