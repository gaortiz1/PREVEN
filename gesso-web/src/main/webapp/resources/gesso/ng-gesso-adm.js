app.controller("app-gesso-ctrl-adm", ['$http', '$scope', function($http, $scope){

    this.controller = $scope;

    $scope.nombre = 'prueba';
    $scope.lstPerson = [];
    $scope.personSelected = [];

	this.loadprocess = function(){
		var response = $http.get('load-person-list.json');
        response.success(function (data, status, headers, config) {
            $scope.lstPerson = data;
            $scope.nombre = 'cambio';
        });

        response.error(function (data, status, headers, config) {
            alert("Error.");
        });
	};


    $scope.selectPerson = function (dataObj){
        $scope.personSelected = dataObj;
        $('#modal-form').modal('show')
    }


    $scope.updatePerson = function(){
        var res = $http.post('saveperson_json', $scope.personSelected);
        res.success(function(data, status, headers, config) {
            $scope.message = data;

            alert('dato guardado');
        });
        res.error(function(data, status, headers, config) {
            alert( "failure message: " + JSON.stringify({data: data}));
        });
    }

    this.loadprocess();
}]);