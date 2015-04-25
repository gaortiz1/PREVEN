var app = angular.module("app-gesso-adm",[]);
app.controller("app-gesso-ctrl-adm", ['$http', function($http){
	this.loadprocess = function(){
		var response = $http.get('person-edit2.json');
        response.success(function (data, status, headers, config) {
           alert(data);
        });

        response.error(function (data, status, headers, config) {
            alert("Error.");
        });


	};

    this.loadprocess();
}]);