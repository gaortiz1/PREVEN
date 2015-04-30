/**
 * Created by Roberto on 29/04/2015.
 */

app.controller('gesso-user-adm', ['$scope', '$http', function($scope, $http){

    controller = this;
    controller.lstUsers = [];

    controller.message = "pruebas";
    controller.userSelected = [];

    controller.findUsers = function (){
        var response = $http.get('find_users_json.json');
        response.success(function (data, status, headers, config) {
            controller.lstUsers = data;
        });

        response.error(function (data, status, headers, config) {
            alert("Error.");
        });
    }

    controller.selectUser = function(userSelected){
        controller.userSelected = userSelected;
        $('#modal-form').modal('show');
    }

    controller.findUsers();
}]);