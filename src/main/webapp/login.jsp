

	<!-- Header -->
	<jsp:include page="header.jsp" />
	
	<!-- JSTL includes -->
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
	
<!-- 	Just some stuff you need -->
	<header>
	  <div class="container">
	
	<c:choose>
	<c:when test="${not empty message }">
	  <p class="alert ${messageClass}">${message }</p>
	<%
	  session.setAttribute("message", null);
	  session.setAttribute("messageClass", null);
	%>
	</c:when>
	</c:choose>
	
		<h1>LibraryApp <small>Login</small></h1>
		<hr class="book-primary">
		<form action="/auth/login" method="post" class="form-horizontal">
		  <div class="form-group">
		    <label for="username" class="col-sm-4 control-label">Username</label>
		    <div class="col-sm-5">
		      <input type="text" class="form-control" id="name" name="name" placeholder="Username" required="required" value="" />
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="password" class="col-sm-4 control-label">Password</label>
		    <div class="col-sm-5">
		      <input type="password" class="form-control" id="password" name="password" placeholder="Password" required="required" />
		    </div>
		  </div>
		  <div class="form-group">
		    <div id="popover-login" class="col-sm-offset-4 col-sm-1">
		      <button type="submit" class="btn btn-info">Login</button>
		    </div>
		  </div>
		</form>
	  </div>
	</header>

	
	

	<!-- Footer -->
	<jsp:include page="footer.jsp" />