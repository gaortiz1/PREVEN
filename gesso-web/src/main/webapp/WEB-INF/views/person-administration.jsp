<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<div class="row" ng-controller="gesso-person-adm as crtlPerAdm">
	<div class="col-xs-12">
		<!-- PAGE CONTENT BEGINS -->
		<form class="form-horizontal" role="form">
			<!-- #section:elements.form -->

			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right"><spring:message code="page.label.firstName"/></label>

				<div class="col-sm-9">
					<input type="text" ng-model="crtlPerAdm.personAdministrationModel.person.firstName" placeholder="Primer nombre" class="txt-validate-empty" />
					<input type="text" ng-model="crtlPerAdm.personAdministrationModel.person.middleName" placeholder="Segundo nombre" />
				</div>
			</div>


			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right"><spring:message code="page.label.lastName"/></label>

				<div class="col-sm-9">
					<input type="text" ng-model="crtlPerAdm.personAdministrationModel.person.lastName" placeholder="Primer apellido" class="txt-validate-empty"/>
					<input type="text" ng-model="crtlPerAdm.personAdministrationModel.person.secondLastName" placeholder="Segundo apellido" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" > <spring:message code="page.label.documentNumber"/> </label>
				<div class="col-sm-9">
					<input  type="text" ng-model="crtlPerAdm.personAdministrationModel.person.documentNumber" placeholder="17XXXXXXX30" class="txt-validate-empty"/>
				</div>
			</div>

			<div class="space-4"></div>

			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right"><spring:message code="page.label.country"/></label>
				<div class="col-sm-5">
                    <ui-select ng-model="crtlPerAdm.selectedCountry">
                        <ui-select-match placeholder="Pick one...">{{$select.selected.paisnombre}}</ui-select-match>
                        <ui-select-choices repeat="pais in crtlPerAdm.personAdministrationModel.country | filter: $select.search track by pais.paisnombre">
                            <div ng-bind-html="pais.paisnombre | highlight: $select.search"></div>
                        </ui-select-choices>
                    </ui-select>
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right"> <spring:message code="page.label.dateofbirth"/> </label>

				<div class="col-sm-2">
					<div class="input-group">
						<input type="text" ng-model="crtlPerAdm.personAdministrationModel.person.dateOfBirth" class="form-control date-picker txt-validate-empty"/>
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
							<input type="radio" ng-model="crtlPerAdm.personAdministrationModel.person.idSexCatalog" value="M" class="ace"/>
							<span class="lbl"><spring:message code="page.label.sex.male"/> </span>
						</label>
					</div>

					<div class="radio">
						<label>
							<input type="radio" ng-model="crtlPerAdm.personAdministrationModel.person.idSexCatalog" value="F" class="ace"/>
							<span class="lbl">
								<spring:message code="page.label.sex.female"/>
							</span>
						</label>
					</div>
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right"><spring:message code="page.label.disability"/></label>

				<div class="col-xs-3">
					<label>
						<input ng-model="crtlPerAdm.personAdministrationModel.person.disability" class="ace ace-switch ace-switch-6" type="checkbox" />
						<span class="lbl"></span>
					</label>
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right"><spring:message code="page.label.level.vulnerability"/></label>
				<div class="col-sm-5">
                    <ui-select ng-model="crtlPerAdm.selectedCatVul">
                        <ui-select-match placeholder="Pick one...">{{$select.selected.name}}</ui-select-match>
                        <ui-select-choices repeat="catvul in crtlPerAdm.personAdministrationModel.levelVulnerability | filter: $select.search track by catvul.name">
                            <div ng-bind-html="catvul.name | highlight: $select.search"></div>
                        </ui-select-choices>
                    </ui-select>
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right"><spring:message code="page.label.lactation"/></label>

				<div class="col-xs-3">
					<label>
						<input ng-model="crtlPerAdm.personAdministrationModel.person.lactationPeriod" class="ace ace-switch ace-switch-6" type="checkbox" />
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
						<input type="text"  ng-model="crtlPerAdm.personAdministrationModel.person.personalLocalPhone" class="input-mask-phone"/>
						<i class="ace-icon fa fa-phone"></i>
					</span>

					<span class="input-icon">
						<input type="text" ng-model="crtlPerAdm.personAdministrationModel.person.personalMobilPhone" class="input-mask-phone"/>
						<i class="ace-icon fa fa-phone"></i>
					</span>
				</div>
			</div>


			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right">Email</label>

				<div class="col-sm-9">
					<input type="text" ng-model="crtlPerAdm.personAdministrationModel.person.personalEmail" data-rel="tooltip" placeholder="ejemplo@gmail.com" title="Email principal" data-placement="bottom"/>
					<span class="help-button" data-rel="popover" data-trigger="hover" data-placement="left" data-content="Este sera el mail al cual se notificaran las novedades" title="Email principal">?</span>
				</div>
			</div>


			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right"><spring:message code="menu.label.process"/></label>
				<div class="col-sm-5">

                    <ui-select ng-model="crtlPerAdm.selectedProcess" on-select="crtlPerAdm.loadSubProcess($item, $model)">
                        <ui-select-match placeholder="Pick one...">{{$select.selected.name}}</ui-select-match>
                        <ui-select-choices repeat="process in crtlPerAdm.personAdministrationModel.lstProcess | filter: $select.search track by process.id">
                            <div ng-bind-html="process.name | highlight: $select.search"></div>
                        </ui-select-choices>
                    </ui-select>

				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right">
					Sub proceso
				</label>

                <div class="col-sm-5">
                    <ui-select ng-model="crtlPerAdm.selectedSubProcess" on-select="crtlPerAdm.loadJob($item, $model)">
                        <ui-select-match placeholder="Pick one...">{{$select.selected.name}}</ui-select-match>
                        <ui-select-choices repeat="subProcess in crtlPerAdm.lstSubProcess | filter: $select.search track by subProcess.name">
                            <div ng-bind-html="subProcess.name | highlight: $select.search"></div>
                        </ui-select-choices>
                    </ui-select>
                </div>
<!-- 					<select chosen class="cssSelPais" ng-options="process.name for process in crtlPerAdm.personAdministrationModel.lstProcess" data-placeholder="Seleccionar nacionalidad..." ng-model="crtlPerAdm.selectedProcess"></select> -->

			</div>


			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right">
					<spring:message code="page.label.job.placement"></spring:message>
				</label>

				<div class="col-sm-5">
                    <ui-select ng-model="crtlPerAdm.selectedJob">
                        <ui-select-match placeholder="Pick one...">{{$select.selected.name}}</ui-select-match>
                        <ui-select-choices repeat="job in crtlPerAdm.lstJob | filter: $select.search track by subProcess.job">
                            <div ng-bind-html="job.name | highlight: $select.search"></div>
                        </ui-select-choices>
                    </ui-select>
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right">
					<spring:message code="page.label.date.placement.start"></spring:message>
				</label>

				<div class="col-sm-2">
					<div class="input-group">
						<input type="text" ng-model="crtlPerAdm.personAdministrationModel.person.dateJobStart | date:'yyyy-MM-dd'" ng-value="crtlPerAdm.personAdministrationModel.person.dateJobStart| date:'yyyy/dd/MM'" class="form-control date-picker txt-validate-empty"/>
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
							<input type="radio" ng-model="crtlPerAdm.personAdministrationModel.person.idEducaionLevelCatalog" value="PRI" class="ace"/>
							<span class="lbl">Primaria</span>
						</label>
					</div>

					<div class="radio">
						<label>
							<input type="radio" ng-model="crtlPerAdm.personAdministrationModel.person.idEducaionLevelCatalog" value="SEC" class="ace"/>
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
                    <ui-select ng-model="crtlPerAdm.selectedProfesion">
                        <ui-select-match placeholder="Pick one...">{{$select.selected.name}}</ui-select-match>
                        <ui-select-choices repeat="catprof in crtlPerAdm.personAdministrationModel.lstProfesion | filter: $select.search track by catprof.name">
                            <div ng-bind-html="catprof.name | highlight: $select.search"></div>
                        </ui-select-choices>
                    </ui-select>
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" >
					<spring:message code="page.label.deatail.work.activities"></spring:message>
				</label>
				<div class="col-sm-9">
					<textarea ng-model="crtlPerAdm.personAdministrationModel.person.workReview" class="form-control limited" maxlength="250"></textarea>
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" >
					<spring:message code="page.label.last.company"></spring:message>
				</label>
				<div class="col-sm-9">
					<input type="text" ng-model="crtlPerAdm.personAdministrationModel.person.lastCompany" cssClass="txt-validate-empty"/>
				</div>
			</div>


			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right">Accidentes laborales</label>

				<div class="col-xs-3">
					<label>
						<input ng-model="crtlPerAdm.personAdministrationModel.person.occupationalAccident" class="ace ace-switch ace-switch-6" type="checkbox" />
						<span class="lbl"></span>
					</label>
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" >
					<spring:message code="page.label.brief.description"></spring:message>
				</label>
				<div class="col-sm-9">
					<textarea ng-model="crtlPerAdm.personAdministrationModel.person.occupationalAccidentDetail" class="form-control limited" maxlength="250"></textarea>
				</div>
			</div>


			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" > Descripcion capacitacion seguridad</label>
				<div class="col-sm-9">
					<textarea  ng-model="crtlPerAdm.personAdministrationModel.person.securityTrainingDetail" class="form-control limited" maxlength="250"></textarea>
				</div>
			</div>


			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right">
					<spring:message code="page.label.work.security.unit"></spring:message>
				</label>

				<div class="col-xs-3">
					<label>
						<input ng-model="crtlPerAdm.personAdministrationModel.person.securityUnitMember" class="ace ace-switch ace-switch-6" type="checkbox" />
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
						<input ng-model="crtlPerAdm.personAdministrationModel.person.securityCommitteeMember" class="ace ace-switch ace-switch-6" type="checkbox" />
						<span class="lbl"></span>
					</label>
				</div>
			</div>


			<div class="clearfix form-actions">
				<div class="col-md-offset-3 col-md-9">
					<button class="btn btn-info" type="submit" ng-click="crtlPerAdm.createPerson()">
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

		</form>
		
	</div><!-- /.col -->
	


<script type="text/javascript">
	
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
	
</div><!-- /.row -->



