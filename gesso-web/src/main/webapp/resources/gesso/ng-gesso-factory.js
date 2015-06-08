/**
 * 
 */
app.factory('companyModelFactory', function($http) {
	
	return{
		getCompanyModel : function(id) {
			return $http({
				url: 'company/edit-company/' + id,
				method: 'GET'
			});
		}
	 }
});