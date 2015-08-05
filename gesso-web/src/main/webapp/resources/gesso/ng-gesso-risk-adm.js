/**
 * 
 */
app.controller("gesso-register-risk", ['$http', '$scope', 'SweetAlert', '$routeParams', '$location', function($http, $scope, SweetAlert, $routeParams, $location){
	
	$scope.risks = [];
	$scope.probabilities = [];
	$scope.consequences = [];
	
	$http({
		method : 'GET',
		url : 'factor',
		}).success(function(result) {
		$scope.factors = result;
	});	
	
	function loadCatalogProbabilities(){
		$http.get('catalog/group/PROBA')
			.success(function(data) {
			$scope.probabilities = data;
        });
	};
	
	function loadCatalogConsequences(){
		$http.get('catalog/group/CONSE')
			.success(function(data) {
			$scope.consequences = data;
        });
	};
	
	loadCatalogProbabilities();
	loadCatalogConsequences();
}]);