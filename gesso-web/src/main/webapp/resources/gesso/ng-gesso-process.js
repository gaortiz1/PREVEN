/**
 * Created by Roberto on 03/05/2015.
 */

app.controller('gesso-process-adm', ['$scope', '$http','SweetAlert',  function($scope, $http, SweetAlert){

    controller = this;
    controller.process = {
    		idRoot:null,
    		name:null,
    		description:null,
    		status:null,
    		idCompany:null
    };
    
    controller.subProcess = {
    		idProcess:null,
    		name:null,
    		description:null,
    		state:null, 
    		processRoot : {
    			idRoot:null,
        		name:null,
        		description:null,
        		status:null,
        		idCompany:null
    		}
    };
    
    controller.job ={
    		id:null,
    		idRoot:null,
    		idSubProcess:null,
    		name:null,
    		description:null,
    		subProcessRoot:{
    			idProcess:null,
        		name:null,
        		description:null,
        		state:null, 
    		}
    };
    
    controller.selectedProcess = [];
    
    controller.lstProcessModal = [];
    controller.lstSubProcessModal = [];
    
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


    controller.cargarSubProcesos = function(){
    	
    	var response = $http.post('load-sub_processByPro_json.json', controller.selectedProcess);
        response.success(function (data, status, headers, config) {
        	controller.lstSubProcessModal = data;
        });
        response.error(function (data, status, headers, config) {
            alert("Error.");
        });
        
    };



    controller.loadSubProcess = function (item, model){
        var response = $http.post('load-sub_processByPro_json.json', model);
        response.success(function (data, status, headers, config) {
            controller.lstSubProcessModal = data;
        });
        response.error(function (data, status, headers, config) {
            alert("Error.");
        });
    };


    controller.loadProcessToModal = function(){
    	var response = $http.get('process_json.json');
        response.success(function (data, status, headers, config) {
            controller.lstProcessModal = data;
        });

        response.error(function (data, status, headers, config) {
            alert("Error.");
        });
    	
    }
    controller.callModalProcess = function(){
        $('#modal-form-process').modal('show');
    };

    controller.callModalSubProcess = function(){
    	
    	var response = $http.get('load-process_json.json');
        response.success(function (data, status, headers, config) {
            controller.lstProcessModal = data;
            $('#modal-form-subprocess').modal('show');
        });
        
        response.error(function (data, status, headers, config) {
            alert("Error.");
        });
        
    };

    controller.callModalJob = function(){
    	
    	
    	var response = $http.get('load-process_json.json');
        response.success(function (data, status, headers, config) {
            controller.lstProcessModal = data;
            $('#modal-form-job').modal('show');
        });
        
        response.error(function (data, status, headers, config) {
            alert("Error.");
        });
        
        

    };

    controller.createProcess = function(){

        var res = $http.post('saveProcess_json.json', controller.process);
        res.success(function(data, status, headers, config) {
            controller.message = data;
            SweetAlert.swal("Ok!", "Proceso creado!", "success");
            $('#modal-form-process').modal('hide');
        });
        res.error(function(data, status, headers, config) {
        	SweetAlert.swal("Error!", "No se pudo crear el proceso!", "error");
        });
    }
    
    
    controller.createSubProcess = function(){

        var res = $http.post('saveSubProcess_json.json', controller.subProcess);
        res.success(function(data, status, headers, config) {
            controller.message = data;
            SweetAlert.swal("Ok!", "Sub Proceso creado!", "success");
            $('#modal-form-subprocess').modal('hide');
        });
        res.error(function(data, status, headers, config) {
        	SweetAlert.swal("Error!", "No se pudo crear el sub proceso!", "error");
        });
    }
    
    
    controller.createJob = function(){

        var res = $http.post('saveJob_json.json', controller.job);
        res.success(function(data, status, headers, config) {
            controller.message = data;
            SweetAlert.swal("Ok!", "Puesto de trabajo creado!", "success");
            $('#modal-form-job').modal('hide');
        });
        res.error(function(data, status, headers, config) {
        	SweetAlert.swal("Error!", "No se pudo crear el Puesto de trabajo!", "error");
        });
    }

    controller.cargarProcesos();
}]);