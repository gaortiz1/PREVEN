function cargarCiudades(elemento){
	$.ajax( "person-fill-ciudad/uno" )
		.done(function(data) {
			$.each( data, function( i, item ) {
				alert( item.catalog_name);
		   	});
		})
		.fail(function() {
			alert( "error" );
	  	})
	  	.always(function() {
	    	alert( "complete" );
	  	});
}


function validateEmptyForm(){
	var validForm = true;
	$('.txt-validate-empty').each(function(inidice, elemento){
		if($(elemento).val() == ''){
			$(elemento).addClass('required-element');
			if(validForm){
				validForm = false;
			}
		}else{
			$(elemento).removeClass('required-element');
		}
		
	});
	return validForm;
}