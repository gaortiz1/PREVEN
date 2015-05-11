/**
 * 
 */

app.controller('gesso-user-login', ['$rootScope', '$scope', '$http', '$location', 'SweetAlert', function($rootScope, $scope, $http, $location, SweetAlert){

    controller = this;
    controller.userDto = {
    		nickName:null,
    	    password:null,
    }
    
    controller.personDto = {
    		idPerson:null,
    	    userDto:{
    	    	nickName:null,
        	    password:null,
    	    },
    	    personalEmail:null,
    	    firstName:null,
    	    lastName:null,
    	    documentNumber:null,
    }
    
    controller.message = '';

    controller.loginUser = function (){
        var response = $http.post('loginUser_json.json', controller.userDto);
        response.success(function (data, status, headers, config) {
        	$location.path('/dashboard');
        });

        response.error(function (data, status, headers, config) {
        	SweetAlert.swal("Error", "Usuario o clave incorrecto", "error");
        	
        });
    }
    
    controller.recordUser = function (){
    	var response = $http.post('recordUser_json.json', controller.personDto);
        response.success(function (data, status, headers, config) {
        	$('#loginbox').show(); $('#signupbox').hide();
        });

        response.error(function (data, status, headers, config) {
        	
        });
    }
    
    
    controller.openRecordUserModal = function (){
    	$('#loginbox').hide(); $('#signupbox').show();
    }
}]);