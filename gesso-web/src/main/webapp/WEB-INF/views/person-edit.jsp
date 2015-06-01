<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>

<h3><i class="fa fa-angle-right"></i> Personas</h3>

<hr>

<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 id="panel-title" class="panel-title">
            Listado de usuarios
        </h3>
    </div>

    <div class="panel-body">
        <div class="row" ng-controller="app-gesso-person-edt as ctrlPerEdt">
            <div class="col-xs-12">
                <!-- PAGE CONTENT BEGINS -->

                <div ng-hide="ctrlPerEdt.personSelected !== undefined ">
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
            </div>












            <div class="col-xs-12" ng-show="ctrlPerEdt.personSelected !== undefined ">
                <!-- PAGE CONTENT BEGINS -->
                <form class="form-horizontal" role="form">
                    <!-- #section:elements.form -->

                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right"><spring:message code="page.label.firstName"/></label>

                        <div class="col-sm-9">
                            <input type="text" ng-model="ctrlPerEdt.personAdministrationModel.person.firstName" placeholder="Primer nombre" class="txt-validate-empty" />
                            <input type="text" ng-model="ctrlPerEdt.personAdministrationModel.person.middleName" placeholder="Segundo nombre" />
                        </div>
                    </div>


                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right"><spring:message code="page.label.lastName"/></label>

                        <div class="col-sm-9">
                            <input type="text" ng-model="ctrlPerEdt.personAdministrationModel.person.lastName" placeholder="Primer apellido" class="txt-validate-empty"/>
                            <input type="text" ng-model="ctrlPerEdt.personAdministrationModel.person.secondLastName" placeholder="Segundo apellido" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" > <spring:message code="page.label.documentNumber"/> </label>
                        <div class="col-sm-9">
                            <input  type="text" ng-model="ctrlPerEdt.personAdministrationModel.person.documentNumber" placeholder="17XXXXXXX30" class="txt-validate-empty"/>
                        </div>
                    </div>

                    <div class="space-4"></div>

                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right"><spring:message code="page.label.country"/></label>
                        <div class="col-sm-5">
                            <ui-select ng-model="ctrlPerEdt.selectedCountry">
                                <ui-select-match placeholder="Pick one...">{{$select.selected.paisnombre}}</ui-select-match>
                                <ui-select-choices repeat="pais in ctrlPerEdt.personAdministrationModel.country | filter: $select.search track by pais.paisnombre">
                                    <div ng-bind-html="pais.paisnombre | highlight: $select.search"></div>
                                </ui-select-choices>
                            </ui-select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right"> <spring:message code="page.label.dateofbirth"/> </label>

                        <div class="col-sm-2">
                            <div class="input-group">
                                <input type="text" ng-model="ctrlPerEdt.personAdministrationModel.person.dateOfBirth" class="form-control date-picker txt-validate-empty"/>
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
                                    <input type="radio" ng-model="ctrlPerEdt.personAdministrationModel.person.idSexCatalog" value="M" class="ace"/>
                                    <span class="lbl"><spring:message code="page.label.sex.male"/> </span>
                                </label>
                            </div>

                            <div class="radio">
                                <label>
                                    <input type="radio" ng-model="ctrlPerEdt.personAdministrationModel.person.idSexCatalog" value="F" class="ace"/>
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
                                <input ng-model="ctrlPerEdt.personAdministrationModel.person.disability" class="ace ace-switch ace-switch-6" type="checkbox" />
                                <span class="lbl"></span>
                            </label>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right"><spring:message code="page.label.level.vulnerability"/></label>
                        <div class="col-sm-5">
                            <ui-select ng-model="ctrlPerEdt.selectedCatVul">
                                <ui-select-match placeholder="Pick one...">{{$select.selected.name}}</ui-select-match>
                                <ui-select-choices repeat="catvul in ctrlPerEdt.personAdministrationModel.levelVulnerability | filter: $select.search track by catvul.name">
                                    <div ng-bind-html="catvul.name | highlight: $select.search"></div>
                                </ui-select-choices>
                            </ui-select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right"><spring:message code="page.label.lactation"/></label>

                        <div class="col-xs-3">
                            <label>
                                <input ng-model="ctrlPerEdt.personAdministrationModel.person.lactationPeriod" class="ace ace-switch ace-switch-6" type="checkbox" />
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
						<input type="text"  ng-model="ctrlPerEdt.personAdministrationModel.person.personalLocalPhone" class="input-mask-phone"/>
						<i class="ace-icon fa fa-phone"></i>
					</span>

					<span class="input-icon">
						<input type="text" ng-model="ctrlPerEdt.personAdministrationModel.person.personalMobilPhone" class="input-mask-phone"/>
						<i class="ace-icon fa fa-phone"></i>
					</span>
                        </div>
                    </div>


                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right">Email</label>

                        <div class="col-sm-9">
                            <input type="text" ng-model="ctrlPerEdt.personAdministrationModel.person.personalEmail" data-rel="tooltip" placeholder="ejemplo@gmail.com" title="Email principal" data-placement="bottom"/>
                            <span class="help-button" data-rel="popover" data-trigger="hover" data-placement="left" data-content="Este sera el mail al cual se notificaran las novedades" title="Email principal">?</span>
                        </div>
                    </div>


                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right"><spring:message code="menu.label.process"/></label>
                        <div class="col-sm-5">

                            <ui-select ng-model="ctrlPerEdt.selectedProcess" on-select="ctrlPerEdt.loadSubProcess($item, $model)">
                                <ui-select-match placeholder="Pick one...">{{$select.selected.name}}</ui-select-match>
                                <ui-select-choices repeat="process in ctrlPerEdt.personAdministrationModel.lstProcess | filter: $select.search track by process.id">
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
                            <ui-select ng-model="ctrlPerEdt.selectedSubProcess" on-select="ctrlPerEdt.loadJob($item, $model)">
                                <ui-select-match placeholder="Pick one...">{{$select.selected.name}}</ui-select-match>
                                <ui-select-choices repeat="subProcess in ctrlPerEdt.lstSubProcess | filter: $select.search track by subProcess.name">
                                    <div ng-bind-html="subProcess.name | highlight: $select.search"></div>
                                </ui-select-choices>
                            </ui-select>
                        </div>
                    </div>


                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right">
                            <spring:message code="page.label.job.placement"></spring:message>
                        </label>

                        <div class="col-sm-5">
                            <ui-select ng-model="ctrlPerEdt.selectedJob">
                                <ui-select-match placeholder="Pick one...">{{$select.selected.name}}</ui-select-match>
                                <ui-select-choices repeat="job in ctrlPerEdt.lstJob | filter: $select.search track by subProcess.job">
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
                                <input type="text" ng-model="ctrlPerEdt.personAdministrationModel.person.dateJobStart | date:'yyyy-MM-dd'" ng-value="ctrlPerEdt.personAdministrationModel.person.dateJobStart| date:'yyyy/dd/MM'" class="form-control date-picker txt-validate-empty"/>
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
                                    <input type="radio" ng-model="ctrlPerEdt.personAdministrationModel.person.idEducaionLevelCatalog" value="PRI" class="ace"/>
                                    <span class="lbl">Primaria</span>
                                </label>
                            </div>

                            <div class="radio">
                                <label>
                                    <input type="radio" ng-model="ctrlPerEdt.personAdministrationModel.person.idEducaionLevelCatalog" value="SEC" class="ace"/>
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
                            <ui-select ng-model="ctrlPerEdt.selectedProfesion">
                                <ui-select-match placeholder="Pick one...">{{$select.selected.name}}</ui-select-match>
                                <ui-select-choices repeat="catprof in ctrlPerEdt.personAdministrationModel.lstProfesion | filter: $select.search track by catprof.name">
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
                            <textarea ng-model="ctrlPerEdt.personAdministrationModel.person.workReview" class="form-control limited" maxlength="250"></textarea>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" >
                            <spring:message code="page.label.last.company"></spring:message>
                        </label>
                        <div class="col-sm-9">
                            <input type="text" ng-model="ctrlPerEdt.personAdministrationModel.person.lastCompany" cssClass="txt-validate-empty"/>
                        </div>
                    </div>


                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right">Accidentes laborales</label>

                        <div class="col-xs-3">
                            <label>
                                <input ng-model="ctrlPerEdt.personAdministrationModel.person.occupationalAccident" class="ace ace-switch ace-switch-6" type="checkbox" />
                                <span class="lbl"></span>
                            </label>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" >
                            <spring:message code="page.label.brief.description"></spring:message>
                        </label>
                        <div class="col-sm-9">
                            <textarea ng-model="ctrlPerEdt.personAdministrationModel.person.occupationalAccidentDetail" class="form-control limited" maxlength="250"></textarea>
                        </div>
                    </div>


                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" > Descripcion capacitacion seguridad</label>
                        <div class="col-sm-9">
                            <textarea  ng-model="ctrlPerEdt.personAdministrationModel.person.securityTrainingDetail" class="form-control limited" maxlength="250"></textarea>
                        </div>
                    </div>


                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right">
                            <spring:message code="page.label.work.security.unit"></spring:message>
                        </label>

                        <div class="col-xs-3">
                            <label>
                                <input ng-model="ctrlPerEdt.personAdministrationModel.person.securityUnitMember" class="ace ace-switch ace-switch-6" type="checkbox" />
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
                                <input ng-model="ctrlPerEdt.personAdministrationModel.person.securityCommitteeMember" class="ace ace-switch ace-switch-6" type="checkbox" />
                                <span class="lbl"></span>
                            </label>
                        </div>
                    </div>


                    <div class="clearfix form-actions">
                        <div class="col-md-offset-3 col-md-9">
                            <button class="btn btn-info" type="submit" ng-click="ctrlPerEdt.updatePerson()">
                                <i class="ace-icon fa fa-check bigger-110"></i>
                                <spring:message code="gobal.label.save"/>
                            </button>


                            <button class="btn" type="button" ng-click="ctrlPerEdt.cancelUpdatePerson()">
                                <i class="ace-icon fa fa-undo bigger-110"></i>
                                <spring:message code="gobal.label.cancel"/>
                            </button>
                        </div>
                    </div>

                    <div class="hr hr-24"></div>

                </form>

            </div>
        </div>
    </div>
</div>