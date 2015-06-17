/**
 * 
 */
app.controller("gesso-register-company", ['$http', '$scope', 'SweetAlert', 'companyModelFactory', '$routeParams', '$location', function($http, $scope, SweetAlert, companyModelFactory, $routeParams, $location){
	controller = this;
	$scope.datacompany = {};
	companyModelFactory.getCompanyModel($routeParams.id).success(function(data){
		$scope.companyModel.id = data.id != null ? data.id : null;
		$scope.companyModel.razonSocial = data.razonSocial != null ? data.razonSocial : null;
		$scope.companyModel.ruc = data.ruc != null ? data.ruc : null;
		$scope.companyModel.nombreComercial = data.nombreComercial != null ? data.nombreComercial : null;
		$scope.companyModel.actividadComercialPrincipal = data.actividadComercialPrincipal != null ? data.actividadComercialPrincipal : null;
		$scope.companyModel.actividadComercialSecuandaria = data.actividadComercialSecuandaria != null ? data.actividadComercialSecuandaria : null;
		$scope.companyModel.typesCompanies = data.typesCompanies != null ? data.typesCompanies : null;
		$scope.companyModel.typeProductiveSector = data.typeProductiveSector != null ? data.typeProductiveSector : null;
		$scope.companyModel.telefono = data.telefono != null ? data.telefono : null;
		$scope.companyModel.celular = data.celular != null ? data.celular : null;
		$scope.companyModel.direccion = data.direccion != null ? data.direccion : null;
		$scope.companyModel.email = data.email != null ? data.email : null;
		$scope.companyModel.idGeopoliticalDivisionCountry = data.idGeopoliticalDivisionCountry != null ? data.idGeopoliticalDivisionCountry : null;
		$scope.companyModel.idGeopoliticalDivisionProvince = data.idGeopoliticalDivisionProvince != null ? data.idGeopoliticalDivisionProvince : null;
		$scope.companyModel.idGeopoliticalDivisionCity = data.idGeopoliticalDivisionCity != null ? data.idGeopoliticalDivisionCity : null;
		$scope.companyModel.schedulesWork = data.schedulesWork != null ? data.schedulesWork : null;
	});
	
	$scope.companyModel = {
			id : null,	
			razonSocial : null,
			ruc : null,
			nombreComercial : null,
			actividadComercialPrincipal:{id : null, name : null},
			actividadComercialSecuandaria: {id : null, name : null},
			typesCompanies : null,
			typeProductiveSector : null,
			telefono: { id : null, number : null },
			celular:{ id : null, number : null },
			direccion: {id: null, nameAddress: null},
			email: {id: null, emailaddess: null},
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
			$location.path('/company-administration');
        });
        res.error(function(data, status, headers, config) {
            alert( "failure message: " + JSON.stringify({data: data}));
        });
    }
	
	
	$scope.loadProvinces = function(id){
		if (id != null) {
			$scope.provinces = [];
			$scope.cities = [];
			
			var response = $http.get('geopoliticaldivision/children/'+id);
			response.success(function (data, status, headers, config) {
				$scope.provinces = data;
			});

			response.error(function (data, status, headers, config) {
				alert("Error.");
			});
		}
    }
	
	$scope.loadCities = function(id){
		if (id != null) {
			$scope.cities = [];
			var response = $http.get('geopoliticaldivision/children/'+id);
			response.success(function (data, status, headers, config) {
				$scope.cities = data;
			});

			response.error(function (data, status, headers, config) {
				alert("Error.");
			});
		}
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
	
	loadCatalogTypesCompanies();
	loadCatalogWorksHours();
	loadCatalogProductivesSector();
	
}]);