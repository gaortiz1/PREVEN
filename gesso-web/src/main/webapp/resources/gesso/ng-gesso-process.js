/**
 * Created by Roberto on 03/05/2015.
 */

app.controller('gesso-process-adm', ['$scope', '$http', function($scope, $http){

    controller = this;

    controller.cargarProcesos = function (){
        var response = $http.get('load-process');
        response.success(function (data, status, headers, config) {
            controller.lstUsers = data;
        });

        response.error(function (data, status, headers, config) {
            alert("Error.");
        });
        $.ajax({
            method: "GET",
            url: "load-process",
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: loadProcessDataAjax,
            error: function( jqXhr, textStatus, errorThrown ){
                console.log( errorThrown );
            }
        });
    };


    controller.callModalProcess = function(){
        $('#modal-form-process').modal('show');
    };

    controller.callModalSubProcess = function(){
        $('#modal-form-subprocess').modal('show');
        $(".chosenSubprocess").trigger("chosen:updated");
        $(".chosenSubprocess").chosen();
    };

    controller.callModalJob = function(){
        $('#modal-form-job').modal('show');

        $(".chosenJobProcess").trigger("chosen:updated");
        $(".chosenJobProcess").chosen();


        $(".job-subprocess-selector").trigger("chosen:updated");
        $(".job-subprocess-selector").chosen();

    };

    //controller.cargarProcesos();
}]);