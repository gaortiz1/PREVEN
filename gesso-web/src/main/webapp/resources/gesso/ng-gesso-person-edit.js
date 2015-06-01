app.controller("app-gesso-person-edt", ['$http', '$scope', 'SweetAlert', function($http, $scope, SweetAlert){

    controller = this;

    controller.lstPerson = [];
    controller.personSelected = undefined;
    controller.personAdministrationModel = {
        person: undefined
    };

	this.loadPersonList = function(){
		var response = $http.get('load-person-list.json');
        response.success(function (data, status, headers, config) {
            controller.lstPerson = data;
        });

        response.error(function (data, status, headers, config) {
            alert("Error.");
        });
	};


    controller.selectPerson = function (dataObj){
        controller.personSelected = dataObj;
        controller.personAdministrationModel.person = controller.personSelected;
        $('#modal-form').modal('show');
    }


    controller.updatePerson = function(){
        var res = $http.post('saveperson_json', controller.personSelected);
        res.success(function(data, status, headers, config) {
            controller.personSelected = undefined;
            $('#modal-form').modal('hide');
            SweetAlert.swal("Ok!", "Persona actualizada!", "success");
        });
        res.error(function(data, status, headers, config) {
            alert( "failure message: " + JSON.stringify({data: data}));
        });
    }

    controller.cancelUpdatePerson = function(){
        controller.personSelected = undefined;
        $('#modal-form').modal('hide');
    }

    controller.loadPersonList();
}]);