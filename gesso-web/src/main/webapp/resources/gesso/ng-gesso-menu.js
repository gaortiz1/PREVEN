/**
 * Created by Roberto on 04/05/2015.
 */

app.controller('gesso-menu', ['$rootScope', '$scope', '$http', 'SweetAlert', function($rootScope, $scope, $http, SweetAlert){
    controller = this;

    controller.builMenu = function (){
        var response = $http.get('build-user-menu.json');
        response.success(function (data, status, headers, config) {
            $rootScope.lstUserProfileDto = data;
        }).then(function(response){
            $rootScope.lstUserProfileDto = response.data;
        });

        response.error(function (data, status, headers, config) {
            SweetAlert.swal("Error", "Usuario o clave incorrecto", "error");
        });
    }
}]);