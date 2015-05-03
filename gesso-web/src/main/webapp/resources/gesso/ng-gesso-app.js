/**
 * Created by Roberto on 29/04/2015.
 */
var app = angular.module('app-gesso',['ngRoute', 'ngResource']);
app.config(function($routeProvider) {
    $routeProvider.when('/login', {
        templateUrl: 'todo/layout'

    });
    $routeProvider.when('/login', {
        templateUrl: 'address/layout'
    });

    $routeProvider.otherwise({
        redirectTo: '/'
    });
});