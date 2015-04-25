var app = angular.module("app-gesso-adm",[]);
app.controller("app-gesso-ctrl-adm", ['$http', '$scope', function($http, $scope){

    this.controller = $scope;

    this.lstPerson = [];

	this.loadprocess = function(){
		var response = $http.get('person-edit2.json');
        response.success(function (data, status, headers, config) {
            controller.lstPerson = data;
        });

        response.error(function (data, status, headers, config) {
            alert("Error.");
        });
	};

    this.loadprocess();
}]);