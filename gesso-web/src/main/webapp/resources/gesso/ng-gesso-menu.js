/**
 * Created by Roberto on 04/05/2015.
 */

app.controller('gesso-menu', ['$scope', '$http', function($scope, $http){

    controller = this;
    controller.lstMenu = [];

    controller.message = "pruebas";

    controller.builMenu = function (){
        var response = $http.get('build-user-menu.json');
        response.success(function (data, status, headers, config) {
            controller.lstUsers = data;
        });

        response.error(function (data, status, headers, config) {
            alert("Error.");
        });
    }

    controller.builMenu();
}]);