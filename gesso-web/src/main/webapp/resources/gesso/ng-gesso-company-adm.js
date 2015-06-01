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
			idGeopoliticalDivisionCity : null,
			schedulesWork : []
		}
	
	$scope.countries = [];
	$scope.provinces = [];
	$scope.cities = [];
	
	$scope.typesCompanies = [];
	$scope.worksHours = [];
	$scope.productivesSector = [];
	
	$http({
		method : 'GET',
		url : 'geopoliticaldivision/root',
		}).success(function(result) {
		$scope.countries = result;
	});	
	
	$scope.createCompany = function(){
    	var res = $http.post('register-company', JSON.stringify($scope.companyModel));
        res.success(function(data, status, headers, config) {
            SweetAlert.swal("Ok","Registro creado", "success");
        });
        res.error(function(data, status, headers, config) {
            alert( "failure message: " + JSON.stringify({data: data}));
        });
    }
	
	function loadCatalogTypesCompanies(){
		$http.get('catalog/group/TP')
			.success(function(data) {
			$scope.typesCompanies = data;
        });
	};
	
	function loadCatalogWorksHours(){
		$http.get('catalog/group/HT')
			.success(function(data) {
			$scope.worksHours = data;
        });
	};

	
	function loadCatalogProductivesSector(){
		$http.get('catalog/group/SP')
			.success(function(data) {
			$scope.productivesSector = data;
        });
	};
	
	
	$scope.loadProvinces = function(item){
		
		$scope.provinces = [];
		$scope.cities = [];
        
		var response = $http.get('geopoliticaldivision/children/'+item.id);
        response.success(function (data, status, headers, config) {
        	$scope.provinces = data;
        });

        response.error(function (data, status, headers, config) {
            alert("Error.");
        });
    }
	
	$scope.loadCities = function(item){
		$scope.cities = [];
        
		var response = $http.get('geopoliticaldivision/children/'+item.id);
        response.success(function (data, status, headers, config) {
        	$scope.cities = data;
        });

        response.error(function (data, status, headers, config) {
            alert("Error.");
        });
    }
	
	loadCatalogTypesCompanies();
	loadCatalogWorksHours();
	loadCatalogProductivesSector();
	
}]);