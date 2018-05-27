document.querySelectorAll('.unsubscribe-author-form').forEach(function (form) {
	form.addEventListener('submit', function (event) {
		event.preventDefault();
		var user = event.target.dataset.user;
	  	var author = event.target.dataset.author;
	  	var body = JSON.stringify({user:user, author, author});
	  	var csrfToken = document.getElementsByName("_csrf")[0].value;
	  	var csrfParmeter = document.getElementsByName("_csrf_parameter")[0].content;
	  	var csrfHeader = document.getElementsByName("_csrf_header")[0].content;
	  	var ajax = new XMLHttpRequest();
	  	ajax.open("DELETE", "/subscription/delete/" +author, true);
	  	ajax.setRequestHeader(csrfHeader, csrfToken);
	  	ajax.send(body);
	  	ajax.onreadystatechange=function() {
	  		if (ajax.readyState==4 && ajax.status==200) {
	  			window.location.href = "http://localhost:8080/subscriptionSuccessfullyDeleted.jsp";
	  		}
	  	}
	 });
});


document.querySelectorAll('.subscribe-author-form').forEach(function (form) {
	form.addEventListener('submit', function (event) {
		event.preventDefault();
		var user = event.target.dataset.user;
	  	var author = event.target.dataset.author;
	  	var body = JSON.stringify({user:user, author, author});
	  	var csrfToken = document.getElementsByName("_csrf")[0].value;
	  	var csrfParmeter = document.getElementsByName("_csrf_parameter")[0].content;
	  	var csrfHeader = document.getElementsByName("_csrf_header")[0].content;
	  	var ajax = new XMLHttpRequest();
	  	ajax.open("PUT", '/subscription/add/' +author, true);
	  	ajax.setRequestHeader(csrfHeader, csrfToken);
	  	ajax.send(body);
	  	ajax.onreadystatechange=function() {
	  		if (ajax.readyState==4 && ajax.status==200) {
	  			window.location.href = "http://localhost:8080/subscriptionSuccessfullyAdded.jsp";
	  		}
	  	}
	 });
});

document.querySelectorAll('.delete-message-form').forEach(function (form) {
	form.addEventListener('submit', function (event) {
		event.preventDefault();
		var user = event.target.dataset.user;
	  	var messageId = event.target.dataset.message;
	  	var body = JSON.stringify({user:user, message:messageId});
	  	var csrfToken = document.getElementsByName("_csrf")[0].value;
	  	var csrfParmeter = document.getElementsByName("_csrf_parameter")[0].content;
	  	var csrfHeader = document.getElementsByName("_csrf_header")[0].content;
	  	var ajax = new XMLHttpRequest();
	  	ajax.open("DELETE", '/message/delete/' +messageId, true);
	  	ajax.setRequestHeader(csrfHeader, csrfToken);
	  	ajax.send(body);
	  	ajax.onreadystatechange=function() {
	  		if (ajax.readyState==4 && ajax.status==200) {
	  			window.location.href = "http://localhost:8080/messageSuccessfullyDeleted.jsp";
	  		}
	  	}
	 });
});