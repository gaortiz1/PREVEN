/**
 * Created by Roberto on 03/05/2015.
 */

app.controller('gesso-process-adm', ['$scope', '$http', function($scope, $http){

    controller = this;

    controller.cargarProcesos = function (){
        var response = $http.get('load-process');
        response.success(function (data, status, headers, config) {
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
        });

        response.error(function (data, status, headers, config) {
            alert("Error.");
        });



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
    };


    controller.cargarSubProcesos = function(element){
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

                $(".job-subprocess-selector").trigger("chosen:updated");
                $(".job-subprocess-selector").chosen();

            },
            error: function( jqXhr, textStatus, errorThrown ){
                alert( errorThrown );
            }
        });
    };


    controller.callModalProcess = function(){
        $('#modal-form-process').modal('show');
    };

    controller.callModalSubProcess = function(){
        $('#modal-form-subprocess').modal('show');
        $(".chosenSubprocess").trigger("chosen:updated");
        $(".chosenSubprocess").chosen();
    };

    controller.callModalJob = function(){
        $('#modal-form-job').modal('show');

        $(".chosenJobProcess").trigger("chosen:updated");
        $(".chosenJobProcess").chosen();


        $(".job-subprocess-selector").trigger("chosen:updated");
        $(".job-subprocess-selector").chosen();

    };

    controller.cargarProcesos();
}]);