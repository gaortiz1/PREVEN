/**
 * 
 */
app.controller("gesso-create-company", ['$http', '$scope', 'SweetAlert', function($http, $scope, SweetAlert){
	$scope.companyModel = {
			id : null,	
			razonSocial: null,
			ruc: null,
			nombreComercial: null,
			actividadComercialPrincipal: null,
			actividadComercialSecuandaria : null,
			idGeopoliticalDivisionCountry: null
		}
	$scope.countries = [];
	
	$http({
		method : 'GET',
		url : '/Admin/GetTestAccounts',
		data : {
			applicationId : 3
			}
		}).success(function(result) {
		$scope.countries = result;
	});
}]);