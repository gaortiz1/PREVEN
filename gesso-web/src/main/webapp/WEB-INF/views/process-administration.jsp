<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<div class="row" ng-controller="gesso-process-adm as crtlPro">
    <div class="col-xs-12">
        <!-- PAGE CONTENT BEGINS -->

        <!-- #section:plugins/fuelux.treeview -->
        <div class="row">
            <div class="col-sm-4">
                <div class="widget-box widget-color-blue2">
                    <div class="widget-header">
                        <h4 class="widget-title lighter smaller">
                            <spring:message code="menu.label.process"/>
                        </h4>
                    </div>

                    <div class="widget-body">
                        <div class="widget-main padding-8">
                            <ul id="tree1"></ul>
                        </div>
                    </div>
                </div>
            </div>

            <div class="col-sm-8">
                <div class="widget-box widget-color-green2">
                    <div class="widget-header">
                        <h4 class="widget-title lighter smaller">Administrar procesos</h4>
                    </div>

                    <div class="widget-body">
                        <div class="widget-main padding-8">
                            <ul id="tree2"></ul>
                        </div>

                        <button type="button" class="btn btn-white btn-info btn-round" ng-click="crtlPro.callModalProcess()">
                            <i class="ace-icon fa fa-cogs bigger-120 blue"></i>
                            <spring:message code="page.label.new.process"/>
                        </button>

                        <button type="button" class="btn btn-white btn-warning btn-round" ng-click="crtlPro.callModalSubProcess()">
                            <i class="ace-icon fa fa-cogs bigger-120 orange"></i>
                            <spring:message code="page.label.new.subprocess"/>
                        </button>

                        <button type="button" class="btn btn-white btn-default btn-round" ng-click="crtlPro.callModalJob()">
                            <i class="ace-icon fa fa-cogs red2"></i>
                            <spring:message code="page.label.new.job"/>
                        </button>
                    </div>
                </div>
            </div>
        </div>


        <div id="modal-form-process" class="modal" tabindex="-1">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="blue bigger">
                            <spring:message code="page.label.new.process"/>
                        </h4>
                    </div>

                    
                        <div class="modal-body">
                            <div class="row">
                                <div class="col-xs-12 col-sm-7">
                                
                                	<div class="form-group">
                                        <label>
                                            Compania
                                        </label>

                                        <div>
                                            <input type="text" ng-model="crtlPro.process.idCompany" placeholder ="Compania" />
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <label>
                                            <spring:message code="page.label.name"/>
                                        </label>

                                        <div>
                                            <input type="text" ng-model="crtlPro.process.name" placeholder ="Nombre proceso" />
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label>
                                            <spring:message code="page.label.description"/>
                                        </label>

                                        <div>
                                            <input type="text" ng-model="crtlPro.process.description"/>
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

                            <button class="btn btn-sm btn-primary" type="submit" ng-click="crtlPro.createProcess();">
                                <i class="ace-icon fa fa-check"></i>
                                Save
                            </button>
                        </div>
                    

                </div>
            </div>
        </div>


        <div id="modal-form-subprocess" class="modal" tabindex="-1">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="blue bigger">
                            <spring:message code="page.label.new.subprocess"/>
                        </h4>
                    </div>

                    
                        <div class="modal-body">
                            <div class="row">
                                <div class="col-xs-12 col-sm-7">

                                    <div class="form-group">
                                        <label>
                                            <spring:message code="menu.label.process"/>
                                        </label>

                                        <div>

                                            <select ng-options="process.name for process in crtlPro.lstProcessModal" ng-model="crtlPro.subProcess.processRoot" 
                                            	class="chosen-select form-control chosenSubprocess" data-placeholder="Seleccionar proceso">
                                            </select>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label>
                                            <spring:message code="page.label.name"/>
                                        </label>

                                        <div>
                                            <input type="text" ng-model="crtlPro.subProcess.name" placeholder ="Nombre sub-proceso" required="required"/>

                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label>
                                            <spring:message code="page.label.description" />
                                        </label>

                                        <div>
                                            <input type="text" ng-model="crtlPro.subProcess.description" required="required"/>
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

                            <button class="btn btn-sm btn-primary" type="submit" ng-click="crtlPro.createSubProcess();">
                                <i class="ace-icon fa fa-check"></i>
                                Save
                            </button>
                        </div>
                    

                </div>
            </div>
        </div>


        <div id="modal-form-job" class="modal" tabindex="-1">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="blue bigger">
                            <spring:message code="page.label.new.job"/>
                        </h4>
                    </div>

                    
                        <div class="modal-body">
                            <div class="row">
                                <div class="col-xs-12 col-sm-7">
                                    <div class="form-group">
                                        <label>
                                            <spring:message code="menu.label.process"/>
                                        </label>

                                        <div>
                                            
                                            <select ng-options="process.name for process in crtlPro.lstProcessModal" ng-model="crtlPro.selectedProcess" ng-change="crtlPro.cargarSubProcesos()"
                                            	class="chosen-select form-control chosenJobProcess" data-placeholder="Seleccionar proceso">
                                            </select>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label>
                                            Sub proceso
                                        </label>

                                        <div>
                                            <select ng-options="subProcess.name for subProcess in crtlPro.lstSubProcessModal" ng-model="crtlPro.job.subProcessRoot" 
                                            	class="chosen-select form-control job-subprocess-selector" data-placeholder="Seleccionar sub-proceso" required="required">
                                            </select>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label>
                                            <spring:message code="page.label.name"/>
                                        </label>

                                        <div>
                                            <input type="text" ng-model="crtlPro.job.name" placeholder ="Nombre proceso" required="required"/>

                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label>
                                            <spring:message code="page.label.description" />
                                        </label>

                                        <div>
                                            <input type="text" ng-model="crtlPro.job.description" required="required"/>
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

                            <button class="btn btn-sm btn-primary" type="submit" ng-click="crtlPro.createJob();">
                                <i class="ace-icon fa fa-check"></i>
                                Save
                            </button>
                        </div>
                    

                </div>
            </div>
        </div>
        <!-- /section:plugins/fuelux.treeview -->
        <script type="text/javascript">
            var $assets = "${pageContext.request.contextPath}/resources/assets";//this will be used in fuelux.tree-sampledata.js
        </script>

        <!-- PAGE CONTENT ENDS -->
    </div><!-- /.col -->
</div><!-- /.row -->
