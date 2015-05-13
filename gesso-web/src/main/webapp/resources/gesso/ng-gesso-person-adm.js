/**
 * 
 */

app.controller("gesso-person-adm", ['$http', '$scope', 'SweetAlert', function($http, $scope, SweetAlert){
	controller = this;
	controller.selectedCountry = [];
	controller.selectedCatVul = [];
	controller.selectedProcess = [];
	controller.selectedProfesion = [];
	
	controller.personAdministrationModel = {
		country : [],	
		levelVulnerability: [],
		lstProfesion : [],
		lstProcess: [],
		person:{
			idPerson:null,
		    userDto:null,
		    personalEmail:null,
		    firstName:null,
		    lastName:null,
		    documentNumber:null,
			idDivgeoPol:null,
		    idSexCatalog:null,
		    idCatalogVulnerability:null,
		    lactationPeriod:null,
		    personalLocalPhone:null,
		    personalMobilPhone:null,
		    idCodeProfesion:null,
		    middleName:null,
		    secondLastName:null,
		    dateOfBirth:null,
		    statusPerson:null,
		    disability:null,
		    percentageDisability:null,
		    occupationalAccident:null,
		    occupationalAccidentDetail:null,
		    userId:null,
		    securityTrainingDetail:null,
		    paiscodigo:null,
		    dateJobStart:null,
		    idEducaionLevelCatalog:null,
		    workReview:null,
		    lastCompany:null,
		    securityUnitMember:null,
		    securityCommitteeMember:null,
		    idProcess:null,
		    idSubProcess:null,
		    idJob:null,
		}
	}
	
	controller.loadInitParameters = function(){
		var response = $http.get('person-administration_json.json');
        response.success(function (data, status, headers, config) {
        	controller.personAdministrationModel = data;
        });
    
        response.error(function (data, status, headers, config) {
            alert("Error.");
        });
        
        $('.date-picker').datepicker({
			autoclose: true,
			todayHighlight: true
		}).next().on(ace.click_event, function(){
			$(this).prev().focus();
		});
        
        $.mask.definitions['~']='[+-]';
        $('.input-mask-date').mask('99/99/9999');
        $('.input-mask-phone').mask('(999) 999-9999');
	}
	
    controller.createPerson = function(){
    	
        var res = $http.post('create-person_json', controller.personAdministrationModel.person);
        res.success(function(data, status, headers, config) {
            controller.message = data;
            
            SweetAlert.swal("Error", "Usuario o clave incorrecto", "succes");
            
        });
        res.error(function(data, status, headers, config) {
            alert( "failure message: " + JSON.stringify({data: data}));
        });
    }
    
  
    
    controller.loadInitParameters();
    
}]);