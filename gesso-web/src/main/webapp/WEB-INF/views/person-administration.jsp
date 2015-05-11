<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>


			<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/chosen.css" />
			<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/datepicker.css" />
			<div class="row">
				<div class="col-xs-12">
					<!-- PAGE CONTENT BEGINS -->
					<form:form class="form-horizontal" role="form">
						<!-- #section:elements.form -->

						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"><spring:message code="page.label.firstName"/></label>

							<div class="col-sm-9">
								<form:input path="firstName" placeholder="Primer nombre" cssClass="txt-validate-empty" />
								<form:input path="middleName" placeholder="Segundo nombre" />
							</div>
						</div>


						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"><spring:message code="page.label.lastName"/></label>

							<div class="col-sm-9">
								<form:input path="lastName" placeholder="Primer apellido" cssClass="txt-validate-empty"/>
								<form:input path="secondLastName" placeholder="Segundo apellido" />
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right" > <spring:message code="page.label.documentNumber"/> </label>
							<div class="col-sm-9">
								<form:input path="documentNumber" placeholder="17XXXXXXX30" cssClass="txt-validate-empty"/>
							</div>
						</div>

						<div class="space-4"></div>

						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"><spring:message code="page.label.country"/></label>
							<div class="col-sm-5">
								<form:select path="paiscodigo" cssClass="chosen-select form-control" data-placeholder="Seleccionar nacionalidad..." >
									<form:options items="${country}" itemLabel="paisnombrelocal" itemValue="paiscodigo" onclick=""/>
								</form:select>
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"> <spring:message code="page.label.dateofbirth"/> </label>

							<div class="col-sm-2">
								<div class="input-group">
									<form:input path="dateOfBirth" class="form-control date-picker txt-validate-empty"/>

												<span class="input-group-addon">
													<i class="fa fa-calendar bigger-110"></i>
												</span>
								</div>
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"><spring:message code="page.label.sex"/></label>
							<div class="col-sm-2">
								<div class="radio">
									<label>
										<form:radiobutton path="idSexCatalog" value="M" cssClass="ace"/>
										<span class="lbl"><spring:message code="page.label.sex.male"/> </span>
									</label>
								</div>

								<div class="radio">
									<label>
										<form:radiobutton path="idSexCatalog" value="F" cssClass="ace"/>
										<span class="lbl"><spring:message code="page.label.sex.female"/></span>
									</label>
								</div>
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"><spring:message code="page.label.disability"/></label>

							<div class="col-xs-3">
								<label>
									<input name="disability" class="ace ace-switch ace-switch-6" type="checkbox" />
									<span class="lbl"></span>
								</label>
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"><spring:message code="page.label.level.vulnerability"/></label>
							<div class="col-sm-5">
								<form:select path="idCatalogVulnerability" cssClass="chosen-select form-control" data-placeholder="Choose a vulnerability...">
									<form:options items="${levelVulnerability}" itemLabel="name" itemValue="id"/>
								</form:select>
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"><spring:message code="page.label.lactation"/></label>

							<div class="col-xs-3">
								<label>
									<input name="lactationPeriod" class="ace ace-switch ace-switch-6" type="checkbox" />
									<span class="lbl"></span>
								</label>
							</div>
						</div>


						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right">
								<spring:message code="page.label.phone"/>
							</label>

							<div class="col-sm-9">
								<!-- #section:elements.form.input-icon -->
											<span class="input-icon">
												<form:input path="personalLocalPhone" cssClass="input-mask-phone"/>
												<i class="ace-icon fa fa-phone"></i>
											</span>

											<span class="input-icon">
												<form:input path="personalMobilPhone" cssClass="input-mask-phone"/>
												<i class="ace-icon fa fa-phone"></i>
											</span>
							</div>
						</div>


						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right">Email</label>

							<div class="col-sm-9">
								<form:input path="personalEmail" data-rel="tooltip" placeholder="ejemplo@gmail.com" title="Email principal" data-placement="bottom"/>
								<span class="help-button" data-rel="popover" data-trigger="hover" data-placement="left" data-content="Este sera el mail al cual se notificaran las novedades" title="Email principal">?</span>
							</div>
						</div>


						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"><spring:message code="menu.label.process"/></label>
							<div class="col-sm-5">
								<form:select path="idProcess" cssClass="chosen-select form-control" data-placeholder="Seleccionar proceso..." onchange="cargarSubProcesos(this, event)">
									<option >Seleccione</option>
									<form:options items="${lstProcess}" itemLabel="name" itemValue="id" />
								</form:select>
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right">
								Sub proceso
							</label>

							<div class="col-sm-5">
								<select id="idJob" name="idJob" class="form-control person-subprocess-selector" data-placeholder="Seleccionar sub-proceso" onchange="cargarTrabajos(this, event)">

								</select>
							</div>
						</div>


						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right">
								<spring:message code="page.label.job.placement"></spring:message>
							</label>

							<div class="col-sm-5">
								<select id="idSubProcess" name="idSubProcess" class="form-control person-jobs-selector" data-placeholder="Seleccione" >

								</select>
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right">
								<spring:message code="page.label.date.placement.start"></spring:message>
							</label>

							<div class="col-sm-2">
								<div class="input-group">
									<form:input path="dateJobStart" class="form-control date-picker txt-validate-empty"/>

												<span class="input-group-addon">
													<i class="fa fa-calendar bigger-110"></i>
												</span>
								</div>
							</div>
						</div>


						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right">
								<spring:message code="page.label.formacion"/>
							</label>
							<div class="col-sm-2">
								<div class="radio">
									<label>
										<form:radiobutton path="idEducaionLevelCatalog" value="PRI" cssClass="ace"/>
										<span class="lbl">Primaria</span>
									</label>
								</div>

								<div class="radio">
									<label>
										<form:radiobutton path="idEducaionLevelCatalog" value="SEC" cssClass="ace"/>
										<span class="lbl">Secundaria</span>
									</label>
								</div>
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right">
								<spring:message code="page.label.profession.occupation"></spring:message>
							</label>
							<div class="col-sm-5">
								<form:select path="idCodeProfesion" cssClass="chosen-select form-control" data-placeholder="Seleccionar prefesion...">
									<form:options items="${lstProfesion}" itemLabel="name" itemValue="id" onclick=""/>
								</form:select>
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right" >
								<spring:message code="page.label.deatail.work.activities"></spring:message>
							</label>
							<div class="col-sm-9">
								<form:textarea path="workReview" cssClass="form-control limited" maxlength="250"/>
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right" >
								<spring:message code="page.label.last.company"></spring:message>
							</label>
							<div class="col-sm-9">
								<form:input path="lastCompany" cssClass="txt-validate-empty"/>
							</div>
						</div>


						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right">Accidentes laborales</label>

							<div class="col-xs-3">
								<label>
									<input name="occupationalAccident" class="ace ace-switch ace-switch-6" type="checkbox" />
									<span class="lbl"></span>
								</label>
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right" >
								<spring:message code="page.label.brief.description"></spring:message>
							</label>
							<div class="col-sm-9">
								<form:textarea path="occupationalAccidentDetail" cssClass="form-control limited" maxlength="250"/>
							</div>
						</div>


						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right" > Descripcion capacitacion seguridad</label>
							<div class="col-sm-9">
								<form:textarea path="securityTrainingDetail" cssClass="form-control limited" maxlength="250"/>
							</div>
						</div>


						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right">
								<spring:message code="page.label.work.security.unit"></spring:message>
							</label>

							<div class="col-xs-3">
								<label>
									<input name="securityUnitMember" class="ace ace-switch ace-switch-6" type="checkbox" />
									<span class="lbl"></span>
								</label>
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right">
								<spring:message code="page.label.work.security.committee.member"></spring:message>
							</label>

							<div class="col-xs-3">
								<label>
									<input name="securityCommitteeMember" class="ace ace-switch ace-switch-6" type="checkbox" />
									<span class="lbl"></span>
								</label>
							</div>
						</div>


						<div class="clearfix form-actions">
							<div class="col-md-offset-3 col-md-9">
								<button class="btn btn-info" type="submit" onclick="return validateEmptyForm();">
									<i class="ace-icon fa fa-check bigger-110"></i>
									<spring:message code="gobal.label.save"/>
								</button>

								&nbsp; &nbsp; &nbsp;
								<button class="btn" type="reset">
									<i class="ace-icon fa fa-undo bigger-110"></i>
									<spring:message code="gobal.label.reset"/>
								</button>
							</div>
						</div>

						<div class="hr hr-24"></div>

					</form:form>

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
											<div class="form-group">
												<label>Location</label>

												<div>
													<select class="chosen-select" data-placeholder="Choose a Country...">
														<option value="">&nbsp;</option>
														<option value="AL">Alabama</option>
													</select>
												</div>
											</div>

											<div class="space-4"></div>

											<div class="form-group">
												<label for="form-field-username">Username</label>

												<div>
													<input type="text" id="form-field-username" placeholder="Username" value="alexdoe" />
												</div>
											</div>

											<div class="space-4"></div>

											<div class="form-group">
												<label for="form-field-first">Name</label>

												<div>
													<input type="text" id="form-field-first" placeholder="First Name" value="Alex" />
													<input type="text" id="form-field-last" placeholder="Last Name" value="Doe" />
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

									<button class="btn btn-sm btn-primary">
										<i class="ace-icon fa fa-check"></i>
										Save
									</button>
								</div>
							</div>
						</div>
					</div><!-- PAGE CONTENT ENDS -->
				</div><!-- /.col -->
			</div><!-- /.row -->






<script type="text/javascript">
	jQuery(function($) {
		$("#paiscodigo").chosen();
		$("#idCatalogVulnerability").chosen();
		$("#idProcess").chosen();
		$("#idSubProcess").chosen();
		$("#idJob").chosen();
		$("#idCodeProfesion").chosen();



		$('.date-picker').datepicker({
			autoclose: true,
			todayHighlight: true
		}).next().on(ace.click_event, function(){
			$(this).prev().focus();
		});


		$('.fechauno').datepicker({
			autoclose: true
		}).next().on(ace.click_event, function(){
			$(this).prev().focus();
		});

		$.mask.definitions['~']='[+-]';
		$('.input-mask-date').mask('99/99/9999');
		$('.input-mask-phone').mask('(999) 999-9999');
		$('.input-mask-eyescript').mask('~9.99 ~9.99 999');
		$(".input-mask-product").mask("a*-999-a999",{placeholder:" ",completed:function(){alert("You typed the following: "+this.val());}});



	});
	function cargarSubProcesos(element, callJob){

		var selectResult=0;
		$(element).find("option:selected").each(function(indice, elemento) {
			selectResult= $(elemento).val();
		});

		$.ajax({
			method: "GET",
			url: "person-load-sub-process/"+selectResult,
			contentType: "application/json; charset=utf-8",
			dataType: "json",
			success:function( data, textStatus, errorThrown ){
				$(".person-subprocess-selector").find('option').remove();
				$(".person-subprocess-selector").append($("<option></option>").text("Seleccione"));
				$.each( data, function( i, item ) {
					$(".person-subprocess-selector").append($("<option></option>").attr("value",item.id).text(item.text));
				});
				$(".person-subprocess-selector").trigger("chosen:updated");
				$(".person-subprocess-selector").chosen();

				$(".person-jobs-selector").find('option').remove();
				$(".person-jobs-selector").trigger("chosen:updated");
				$(".person-jobs-selector").chosen();
			},
			error: function( jqXhr, textStatus, errorThrown ){
				alert( errorThrown );
			}
		});
	}

	function cargarTrabajos(element, event){
		var selectResult=0;
		$(element).find("option:selected").each(function(indice, elemento) {
			selectResult= $(elemento).val();
		});

		$.ajax({
			method: "GET",
			url: "person-load-jobs/"+selectResult,
			contentType: "application/json; charset=utf-8",
			dataType: "json",
			success:function( data, textStatus, errorThrown ){
				$(".person-jobs-selector").find('option').remove();
				$.each( data, function( i, item ) {
					$(".person-jobs-selector").append($("<option></option>").attr("value",item.id).text(item.text));
				});

			},
			error: function( jqXhr, textStatus, errorThrown ){
				alert( errorThrown );
			}
		});

		$(".person-jobs-selector").trigger("chosen:updated");
		$(".person-jobs-selector").chosen();
	}
</script>


<script src="${pageContext.request.contextPath}/resources/assets/js/jquery-ui.custom.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/jquery.ui.touch-punch.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/chosen.jquery.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/fuelux/fuelux.spinner.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/date-time/bootstrap-datepicker.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/date-time/bootstrap-timepicker.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/date-time/moment.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/date-time/daterangepicker.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/date-time/bootstrap-datetimepicker.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/bootstrap-colorpicker.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/jquery.knob.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/jquery.autosize.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/jquery.inputlimiter.1.3.1.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/jquery.maskedinput.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/bootstrap-tag.js"></script>

<script src="${pageContext.request.contextPath}/resources/assets/js/chosen.jquery.js"></script>