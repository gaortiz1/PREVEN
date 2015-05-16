/**
 * 
 */

app.controller("gesso-person-adm", ['$http', '$scope', 'SweetAlert', function($http, $scope, SweetAlert){
	controller = this;
	controller.selectedCountry = [];
	controller.selectedCatVul = [];
	controller.selectedProcess = [];
    controller.selectedSubProcess = [];
    controller.selectedJob = [];

	controller.selectedProfesion = [];
    controller.lstSubProcess = [];
    controller.lstJob = [];
	
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
        	format:'yyyy/MM/dd',
			autoclose: true,
			todayHighlight: true
		}).next().on(ace.click_event, function(){
			$(this).prev().focus();
		});
        
        $.mask.definitions['~']='[+-]';
        $('.input-mask-date').mask('99/99/9999');
        $('.input-mask-phone').mask('(999) 999-9999');
	}


    controller.loadSubProcess = function (item, model){
        controller.selectedSubProcess = [];
        controller.selectedJob = [];
        controller.lstSubProcess = [];
        controller.lstJob = [];


        var response = $http.get('person-load-sub-process/'+item.id);
        response.success(function (data, status, headers, config) {
            controller.lstSubProcess = data;
        });

        response.error(function (data, status, headers, config) {
            alert("Error.");
        });
    };


    controller.loadJob = function(item, model){
        controller.selectedJob = [];
        var response = $http.get('person-load-jobs/'+item.id);
        response.success(function (data, status, headers, config) {
            controller.lstJob = data;
        });

        response.error(function (data, status, headers, config) {
            alert("Error.");
        });
    }

    controller.createPerson = function(){
    	if(controller.selectedJob){
            controller.personAdministrationModel.person.idJob = controller.selectedJob.id;
        }
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