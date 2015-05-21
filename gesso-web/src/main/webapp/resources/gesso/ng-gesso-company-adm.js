/**
 * 
 */
app.controller("gesso-create-company", ['$http', '$scope', 'SweetAlert', function($http, $scope, SweetAlert){
	controller = this;
	$scope.companyModel = {
			id : null,	
			nombreGrupoEmpresarial : null,
			razonSocial : null,
			ruc : null,
			nombreComercial : null,
			actividadComercialPrincipal : null,
			actividadComercialSecuandaria : null,
			typesCompanies : null,
			typeProductiveSector : null,
			telefono : null,
			celular : null,
			direccion : null,
			email : null,
			idGeopoliticalDivisionCountry : null,
			idGeopoliticalDivisionProvince : null,
			idGeopoliticalDivisionCity : null
		}
	
	$scope.countries = [];
	$scope.provinces = [];
	$scope.cities = [];
	
	$scope.typesCompanies = loadCatalog('TP');
	$scope.worksHours = loadCatalog('HT');
	$scope.productivesSector = loadCatalog('SP');
	
	$http({
		method : 'GET',
		url : '/gesso/geopoliticaldivision/root',
		}).success(function(result) {
		$scope.countries = result;
	});	
	
	function loadCatalog(idGroupCatalog){
		var result = $http.get('/gesso/catalog/group/' + idGroupCatalog);
		alert(result);
		return result;
    }
	
	
	$scope.loadProvinces = function(item){
		
		$scope.provinces = [];
		$scope.cities = [];
        
		var response = $http.get('/gesso/geopoliticaldivision/children/'+item.id);
        response.success(function (data, status, headers, config) {
        	$scope.provinces = data;
        });

        response.error(function (data, status, headers, config) {
            alert("Error.");
        });
    }
	
	$scope.loadCities = function(item){
		$scope.cities = [];
        
		var response = $http.get('/gesso/geopoliticaldivision/children/'+item.id);
        response.success(function (data, status, headers, config) {
        	$scope.cities = data;
        });

        response.error(function (data, status, headers, config) {
            alert("Error.");
        });
    }
	
	
}]);