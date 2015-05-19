/**
 * Created by Roberto on 29/04/2015.
 */

app.controller('gesso-user-adm', ['$rootScope', '$scope', '$http','SweetAlert', function($rootScope, $scope, $http, SweetAlert){

    controller = this;
    controller.lstUsers = [];
    controller.lstUsersDisplayed = [];

    controller.userSelected = [];

    controller.findUsers = function (){
        var response = $http.get('find_users_json.json');
        response.success(function (data, status, headers, config) {
            controller.lstUsers = data;
            controller.lstUsersDisplayed = [].concat(data);
        });

        response.error(function (data, status, headers, config) {
            alert("Error.");
        });
    }

    controller.selectUser = function(userSelected){
        controller.userSelected = userSelected;
        $('#modal-form').modal('show');
    }
    
    
    controller.saveChangesUser = function(){
        var response = $http.post('user-administration-edit.json', controller.userSelected);
        response.success(function (data, status, headers, config) {
        	SweetAlert.swal("Ok","Registro actualizado", "success");

        	$('#modal-form').modal('hide');
        });

        response.error(function (data, status, headers, config) {
        	SweetAlert.swal('Heres a message');        	
        });
    }
   
    
    controller.findUsers();
}]);