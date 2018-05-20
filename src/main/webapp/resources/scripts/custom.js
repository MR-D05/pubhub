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

function getCookie(name) {
    return document.cookie.split('; ').reduce((r, v) => {
        const parts = v.split('=')
        return parts[0] === name ? decodeURIComponent(parts[1]) : r
    }, '')
}
     
function display_username() {
    var username = getCookie('welcome');
    if (username) {
        document.getElementById("welcometext").innerHTML = "Welcome " + username + "!";
    }
}