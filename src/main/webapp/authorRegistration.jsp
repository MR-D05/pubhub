
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

		<h1>
			PubHub <small>Author Registration</small>
		</h1>
		<hr class="book-primary">

		<form action="/user/register/author" method="post"
			class="form-horizontal" enctype="multipart/form-data">
			<div class="form-group">
				<label for="name" class="col-sm-4 control-label">Name</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="name" name="name"
						placeholder="Name" required="required" value="${param.name }" />
				</div>
			</div>
			<div class="form-group">
				<label for="username" class="col-sm-4 control-label">Username</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="username" name="username"
						placeholder="Username" required="required" value="${param.username }" />
				</div>
			</div>
			<div class="form-group">
				<label for="email" class="col-sm-4 control-label">Email</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="email" name="email"
						placeholder="Email" required="required" value="${param.email }" />
				</div>
			</div>
			<div class="form-group">
				<label for="password" class="col-sm-4 control-label">Password</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="password"
						name="password" placeholder="Password" required="required"
						value="${param.password }" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-4 col-sm-1">
					<button type="submit" class="btn btn-info">Register</button>
				</div>
			</div>
		</form>
	</div>
</header>



<!-- Footer -->
<jsp:include page="footer.jsp" />
