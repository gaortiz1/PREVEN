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