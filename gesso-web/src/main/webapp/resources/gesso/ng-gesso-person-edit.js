app.controller("app-gesso-person-edt", ['$http', '$scope', function($http, $scope){

    controller = this;

    controller.nombre = 'prueba';
    controller.lstPerson = [];
    controller.personSelected = [];

	this.loadPersonList = function(){
		var response = $http.get('load-person-list.json');
        response.success(function (data, status, headers, config) {
            controller.lstPerson = data;
            controller.nombre = 'cambio';
        });

        response.error(function (data, status, headers, config) {
            alert("Error.");
        });
	};


    controller.selectPerson = function (dataObj){
        controller.personSelected = dataObj;
        $('#modal-form').modal('show')
    }


    controller.updatePerson = function(){
        var res = $http.post('saveperson_json', $scope.personSelected);
        res.success(function(data, status, headers, config) {
            controller.message = data;

            alert('dato guardado');
        });
        res.error(function(data, status, headers, config) {
            alert( "failure message: " + JSON.stringify({data: data}));
        });
    }

    controller.loadPersonList();
}]);