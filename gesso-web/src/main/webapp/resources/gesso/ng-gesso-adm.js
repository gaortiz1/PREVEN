var app = angular.module("app-gesso-adm",[]);
app.controller("app-gesso-ctrl-adm", ['$http', '$scope', function($http, $scope){

    this.controller = $scope;

    $scope.nombre = 'prueba';
    $scope.lstPerson = [];

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

    this.loadprocess();
}]);