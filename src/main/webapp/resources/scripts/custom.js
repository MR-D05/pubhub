/**
 * 
 */
$(document).ready(function(){
	setTimeout(function(){
		$(".alert").fadeOut("slow");
	} ,3000);
	
	$(".pubhub-datatable").DataTable({
		stateSave: true,
		lengthChange: false,
		info:false,
		language: {
			zeroRecords: "No items matched your search"
		}
	});
  
    $('.carousel').carousel({

    });
});