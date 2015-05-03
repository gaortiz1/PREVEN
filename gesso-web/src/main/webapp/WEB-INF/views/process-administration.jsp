<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/font-awesome.css" />

<!-- ace styles -->
<style type="text/css">

</style>

<t:template>
	<jsp:attribute name="body">
		<form:form class="form-horizontal" role="form" >

            <div class="row">
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


                                    <button class="btn btn-white btn-info btn-round" onclick="$('#modal-form-process').modal('show')">
                                        <i class="ace-icon fa fa-cogs bigger-120 blue"></i>
                                        <spring:message code="page.label.new.process"/>
                                    </button>

                                    <button class="btn btn-white btn-warning btn-round" onclick="$('#modal-form-subprocess').modal('show')">
                                        <i class="ace-icon fa fa-cogs bigger-120 orange"></i>
                                        <spring:message code="page.label.new.subprocess"/>
                                    </button>

                                    <button class="btn btn-white btn-default btn-round" onclick="$('#modal-form-job').modal('show')">
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

                                <form:form action="new-process" method="POST">
                                    <div class="modal-body">
                                        <div class="row">
                                            <div class="col-xs-12 col-sm-7">

                                                <div class="form-group">
                                                    <label for="form-field-first">
                                                        <spring:message code="page.label.name"/>
                                                    </label>

                                                    <div>
                                                        <form:input path="process.name" placeholder ="Nombre proceso" required="required"/>

                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <label for="form-field-first">
                                                        <spring:message code="page.label.description"/>
                                                    </label>

                                                    <div>
                                                        <form:input path="process.description" required="required"/>
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

                                        <button class="btn btn-sm btn-primary" type="submit">
                                            <i class="ace-icon fa fa-check"></i>
                                            Save
                                        </button>
                                    </div>
                                </form:form>

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

                                <form:form action="new-subprocess" method="POST">
                                    <div class="modal-body">
                                        <div class="row">
                                            <div class="col-xs-12 col-sm-7">

                                                <div class="form-group">
                                                    <label for="form-field-first">
                                                        <spring:message code="menu.label.process"/>
                                                    </label>

                                                    <div>
                                                        <form:select path="subProcess.idProcess" cssClass="chosen-select form-control" data-placeholder="Seleccionar proceso" >
                                                            <form:options items="${lstProcess}" itemLabel="name" itemValue="id" />
                                                        </form:select>
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <label for="form-field-first">
                                                        <spring:message code="page.label.name"/>
                                                    </label>

                                                    <div>
                                                        <form:input path="subProcess.name" placeholder ="Nombre proceso" required="required"/>

                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <label for="form-field-first">
                                                        <spring:message code="page.label.description" />
                                                    </label>

                                                    <div>
                                                        <form:input path="subProcess.description" required="required"/>
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

                                        <button class="btn btn-sm btn-primary" type="submit">
                                            <i class="ace-icon fa fa-check"></i>
                                            Save
                                        </button>
                                    </div>
                                </form:form>

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

                                <form:form action="new-job" method="POST">
                                    <div class="modal-body">
                                        <div class="row">
                                            <div class="col-xs-12 col-sm-7">




                                                <div class="form-group">
                                                    <label for="form-field-first">
                                                        <spring:message code="menu.label.process"/>
                                                    </label>

                                                    <div>
                                                        <form:select path="idProcesFormJob" cssClass="chosen-select form-control" data-placeholder="Seleccionar proceso" onchange="cargarSubProcesos(this, event)">
                                                            <form:options items="${lstProcess}" itemLabel="name" itemValue="id" />
                                                        </form:select>
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <label>
                                                        <spring:message code="menu.label.process"/>
                                                    </label>

                                                    <div>
                                                        <select id="job.idSubProcess" name="job.idSubProcess" class="chosen-select form-control job-subprocess-selector" data-placeholder="Seleccionar sub-proceso" required="required">

                                                        </select>
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <label for="form-field-first">
                                                        <spring:message code="page.label.name"/>
                                                    </label>

                                                    <div>
                                                        <form:input path="job.name" placeholder ="Nombre proceso" required="required"/>

                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <label for="form-field-first">
                                                        <spring:message code="page.label.description" />
                                                    </label>

                                                    <div>
                                                        <form:input path="job.description" required="required"/>
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

                                        <button class="btn btn-sm btn-primary" type="submit">
                                            <i class="ace-icon fa fa-check"></i>
                                            Save
                                        </button>
                                    </div>
                                </form:form>

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

        </form:form>
	</jsp:attribute>





</t:template>

<!-- basic scripts -->

<!--[if !IE]> -->
<script type="text/javascript">
    window.jQuery || document.write("<script src='${pageContext.request.contextPath}/resources/assets/js/jquery.js'>"+"<"+"/script>");
</script>

<!-- <![endif]-->

<!--[if IE]>
<script type="text/javascript">
window.jQuery || document.write("<script src='${pageContext.request.contextPath}/resources/assets/js/jquery1x.js'>"+"<"+"/script>");
</script>
<![endif]-->
<script type="text/javascript">
    if('ontouchstart' in document.documentElement) document.write("<script src='${pageContext.request.contextPath}/resources/assets/js/jquery.mobile.custom.js'>"+"<"+"/script>");
</script>
<script src="${pageContext.request.contextPath}/resources/assets/js/bootstrap.js"></script>

<!-- page specific plugin scripts -->
<script src="${pageContext.request.contextPath}/resources/assets/js/fuelux/fuelux.tree.js"></script>

<!-- ace scripts -->
<script src="${pageContext.request.contextPath}/resources/assets/js/ace/elements.scroller.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/ace/elements.colorpicker.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/ace/elements.fileinput.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/ace/elements.typeahead.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/ace/elements.wysiwyg.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/ace/elements.spinner.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/ace/elements.treeview.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/ace/elements.wizard.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/ace/elements.aside.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/ace/ace.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/ace/ace.ajax-content.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/ace/ace.touch-drag.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/ace/ace.sidebar.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/ace/ace.sidebar-scroll-1.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/ace/ace.submenu-hover.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/ace/ace.widget-box.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/ace/ace.settings.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/ace/ace.settings-rtl.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/ace/ace.settings-skin.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/ace/ace.widget-on-reload.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/ace/ace.searchbox-autocomplete.js"></script>

<!-- inline scripts related to this page -->
<script type="text/javascript">


    function cargarProcesos(){
        $.ajax({
            method: "GET",
            url: "load-process",
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: loadProcessDataAjax,
            error: function( jqXhr, textStatus, errorThrown ){
                console.log( errorThrown );
            }
        });
    }

    function loadProcessDataAjax(data, textStatus, jQxhr){
        var tree_data = data;




        var dataSource1 = function(options, callback){
            var $data = null
            if(!("text" in options) && !("type" in options)){
                $data = tree_data;//the root tree
                callback({ data: $data });
                return;
            }
            else if("type" in options && options.type == "folder") {
                if("additionalParameters" in options && "children" in options.additionalParameters)
                    $data = options.additionalParameters.children || {};
                else $data = {}//no data
            }

            if($data != null){
                setTimeout(function(){callback({ data: $data });} , parseInt(Math.random() * 500) + 200);
            }
        }


        $('#tree1').ace_tree({
            dataSource: dataSource1,
            multiSelect: true,
            cacheItems: true,
            'open-icon' : 'ace-icon tree-minus',
            'close-icon' : 'ace-icon tree-plus',
            'selectable' : true,
            'selected-icon' : 'ace-icon fa fa-check',
            'unselected-icon' : 'ace-icon fa fa-times',
            loadingHTML : '<div class="tree-loading"><i class="ace-icon fa fa-refresh fa-spin blue"></i></div>'
        });
    }


    function cargarSubProcesos(element, event){

        var selectResult=0;
        $(element).find("option:selected").each(function(indice, elemento) {
            selectResult= $(elemento).val();
        });

        $.ajax({
            method: "GET",
            url: "load-sub-process/"+selectResult,
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success:function( data, textStatus, errorThrown ){
                $(".job-subprocess-selector").find('option').remove();
                $.each( data, function( i, item ) {
                    $(".job-subprocess-selector").append($("<option></option>").attr("value",item.id).text(item.text));
                });

            },
            error: function( jqXhr, textStatus, errorThrown ){
                alert( errorThrown );
            }
        });
    }
    jQuery(function($){
        //see below

        //please refer to docs for more info
        $('#tree1')
                .on('loaded.fu.tree', function(e) {

                })
                .on('updated.fu.tree', function(e, result) {
                })
                .on('selected.fu.tree', function(e, result) {
                })
                .on('deselected.fu.tree', function(e) {
                })
                .on('opened.fu.tree', function(e, result) {

                })
                .on('closed.fu.tree', function(e) {
                });
        cargarProcesos();

    });
</script>



<!-- the following scripts are used in demo only for onpage help and you don't need them -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/ace.onpage-help.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/docs/assets/js/themes/sunburst.css" />

<script type="text/javascript"> ace.vars['base'] = '..'; </script>
<script src="${pageContext.request.contextPath}/resources/assets/js/ace/elements.onpage-help.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/ace/ace.onpage-help.js"></script>
<script src="${pageContext.request.contextPath}/resources/docs/assets/js/rainbow.js"></script>
<script src="${pageContext.request.contextPath}/resources/docs/assets/js/language/generic.js"></script>
<script src="${pageContext.request.contextPath}/resources/docs/assets/js/language/html.js"></script>
<script src="${pageContext.request.contextPath}/resources/docs/assets/js/language/css.js"></script>
<script src="${pageContext.request.contextPath}/resources/docs/assets/js/language/javascript.js"></script>