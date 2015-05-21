<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<t:template>
	<jsp:attribute name="body">
		<form:form class="form-horizontal" role="form">
					<div class="row mt">
						<div class="col-lg-12">
							<div class="form-panel">
									<h4 class="mb"><i class="fa fa-angle-right"></i>Nueva Compa�ia</h4>
									<!-- #section:elements.form -->
	
									<div class="form-group">
										<label class="col-sm-3 col-sm-3 control-label">
											<spring:message code="page.label.company.razonSocial" />
										</label>
										<div class="col-sm-6">
											<form:input path="razonSocial" placeholder="Raz�n Social" cssClass="form-control" size="35" title="Raz�n Social" required="required" />
										</div>
									</div>
	
									<div class="form-group">
										<label class="col-sm-3 col-sm-3 control-label">
											<spring:message code="page.label.ruc" />
										</label>
	
										<div class="col-sm-6">
											<form:input path="ruc" placeholder="Ruc" cssClass="form-control" size="35" title="Ruc" required="required" maxlength="13" />
										</div>
									</div>
	
									<div class="form-group">
										<label class="col-sm-3 col-sm-3 control-label">
											<spring:message code="page.label.company.nombreComercial" />
										</label>
	
										<div class="col-sm-6">
											<form:input path="nombreComercial" placeholder="Nombre Comercial" cssClass="form-control" size="35" title="Nombre Comercial" required="required" />
										</div>
									</div>
	
									<div class="form-group">
										<label class="col-sm-3 col-sm-3 control-label">
											<spring:message code="page.label.company.actividad.economica.principal" />
										</label>
										<div class="col-sm-6">
											<form:input path="actividadComercialPrincipal" placeholder="Actividad econ�mica principal" cssClass="form-control" size="255" title="Actividad econ�mica principal" required="required" />
										</div>
									</div>
	
									<div class="form-group">
										<label class="col-sm-3 col-sm-3 control-label">
											<spring:message code="page.label.company.actividad.economica.secundaria" />
										</label>
										<div class="col-sm-6">
											<form:input path="actividadComercialSecuandaria" placeholder="Actividad econ�mica secundaria" cssClass="form-control" size="255" title="Actividad econ�mica secundaria" required="required" />
										</div>
									</div>
	
									<div class="form-group">
										<label class="col-sm-3 col-sm-3 control-label">
											<spring:message code="page.label.pais" />
										</label>
										<div class="col-sm-6">
											<form:select path="idGeopoliticalDivisionCountry"
												id="selectPais" data-placeholder="Seleccione pais..."
												required="required"
												onchange="loadChildren(this, event,'idGeopoliticalDivisionProvince')"
												style="width: 452px;">
												<form:option value="" label="--- Seleccione---" />
												<form:options items="${geopoliticalDivisions}"
													itemLabel="name" itemValue="id" />
											</form:select>
										</div>
									</div>
	
									<div class="form-group">
										<label class="col-sm-3 col-sm-3 control-label">
											<spring:message code="page.label.provincia" />
										</label>
										<div class="col-sm-6">
											<form:select path="idGeopoliticalDivisionProvince"
												data-placeholder="Seleccione provincia..."
												required="required"
												onchange="loadChildren(this, event, 'idGeopoliticalDivisionCity')"
												style="width: 452px;">
												<form:option value="" label="--- Seleccine un pais---" />
											</form:select>
										</div>
									</div>
	
									<div class="form-group">
										<label class="col-sm-3 col-sm-3 control-label">
											<spring:message code="page.label.cuidad" />
										</label>
										<div class="col-sm-6">
											<form:select path="idGeopoliticalDivisionCity"
												data-placeholder="Seleccione ciudad..." required="required"
												style="width: 452px;">
												<form:option value="" label="--- Select una provincia---" />
											</form:select>
										</div>
									</div>
	
									<div class="form-group">
										<label class="col-sm-3 col-sm-3 control-label">
											<spring:message code="page.label.company.type.company" />
										</label>
										<div class="col-sm-6">
											<form:select path="typesCompanies"
												cssClass="chosen-select form-control"
												data-placeholder="Seleccione tipo compa�ia..."
												required="required">
												<form:options items="${typesCompanies}" itemLabel="name"
													itemValue="id" />
											</form:select>
										</div>
									</div>
	
									<div class="form-group">
										<label class="col-sm-3 col-sm-3 control-label">
											<spring:message code="page.label.company.sector.productor" />
										</label>
										<div class="col-sm-6">
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
										<label class="col-sm-3 col-sm-3 control-label">
											<spring:message code="page.label.company.work.hours" />
										</label>
										<div class="col-sm-6">
											<form:checkboxes items="${worksHours}" path="schedulesWork"
												itemLabel="name" itemValue="id" delimiter=" " />
										</div>
									</div>
	
									<div class="form-group">
										<label class="col-sm-3 col-sm-3 control-label">
											<spring:message code="page.label.local.phone" />
										</label>
	
										<div class="col-sm-6">
											<span class="input-icon"> <form:input path="telefono"
													cssClass="input-mask-phone" required="required" /> <i
												class="ace-icon fa fa-phone"></i>
											</span>
										</div>
									</div>
	
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right">
											<spring:message code="page.label.mobil.phone" />
										</label>
	
										<div class="col-sm-6">
											<span class="input-icon"> <form:input path="celular"
													cssClass="input-mask-phone" /> <i
												class="ace-icon fa fa-phone"></i>
											</span>
										</div>
									</div>
	
									<div class="form-group">
										<label class="col-sm-3 col-sm-3 control-label">
											<spring:message code="page.label.direccion" />
										</label>
										<div class="col-sm-6">
											<form:input path="direccion" placeholder="Direcci�n" cssClass="form-control" size="255" title="Actividad econ�mica secundaria" required="required" />
										</div>
									</div>
	
									<div class="form-group">
										<label class="col-sm-3 col-sm-3 control-label">
											<spring:message code="page.label.email" />
										</label>
	
										<div class="col-sm-6">
											<form:input path="email" type="email"
												placeholder="Email" title="Email"
												class="form-control" autocomplete="true"
												maxlength="113" size="35" required="required" />
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
							</div>
						</div>
					</div>
				</form:form>
	</jsp:attribute>
</t:template>