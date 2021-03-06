/**
 * Created by Roberto on 29/04/2015.
 */

var app = angular.module('app-gesso', [ 'ngSanitize', 'ui.select', 'ngRoute',
		'ngResource', 'oitozero.ngSweetAlert', 'smart-table' ]);

app.config([ '$routeProvider', '$locationProvider', '$compileProvider',
		function($routeProvider, $locationProvider, $compileProvider) {

			$routeProvider.when('/dashboard', {
				templateUrl : 'user-administration'

			});

			$routeProvider.when('/login', {
				templateUrl : 'login'
			});

			$routeProvider.when('/user-administration', {
				templateUrl : 'user-administration'

			});

			$routeProvider.when('/company-administration', {
				templateUrl : 'company-administration',

			});

			$routeProvider.when('/create-company', {
				templateUrl : 'company/register-company'
			});

			$routeProvider.when('/edit-company/:id', {
				templateUrl : function(params) {
					return 'company/register-company';
				}
			});

			$routeProvider.when('/person-administration', {
				templateUrl : 'person-administration',

			});
			$routeProvider.when('/person-edit', {
				templateUrl : 'person-edit',

			});
			$routeProvider.when('/process-administration', {
				templateUrl : 'process-administration',

			});
			
			$routeProvider.when('/create-risk', {
				templateUrl : 'risk/register-risk'

			});

			$routeProvider.otherwise({
				redirectTo : 'login'
			});

		} ]);