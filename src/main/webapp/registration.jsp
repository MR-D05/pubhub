
<!-- Header -->
<jsp:include page="header.jsp" />

<!-- JSTL includes -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
			PubHub <small>Register</small>
		</h1>
		<hr class="book-primary">

		<form:form method="POST" modelAttribute="registrationForm"
			class="form-signin">
			<h2 class="form-signin-heading">Create your account</h2>

			<spring:bind path="firstname">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="text" path="firstname" class="form-control"
						placeholder="First Name" autofocus="true"></form:input>
					<form:errors path="firstname"></form:errors>
				</div>
			</spring:bind>

			<spring:bind path="lastname">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="text" path="lastname" class="form-control"
						placeholder="Last Name" autofocus="true"></form:input>
					<form:errors path="lastname"></form:errors>
				</div>
			</spring:bind>

			<spring:bind path="username">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="text" path="username" class="form-control"
						placeholder="Username" autofocus="true"></form:input>
					<form:errors path="username"></form:errors>
				</div>
			</spring:bind>

			<spring:bind path="password">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="password" path="password" class="form-control"
						placeholder="Password"></form:input>
					<form:errors path="password"></form:errors>
				</div>
			</spring:bind>

			<spring:bind path="passwordconfirmation">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="password" path="passwordconfirmation"
						class="form-control" placeholder="Confirm your password"></form:input>
					<form:errors path="passwordconfirmation"></form:errors>
				</div>
			</spring:bind>

			<button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
		</form:form>

		<form action="${contextPath}/login">
			<button class="btn btn-lg btn-primary btn-block" type="submit">Already
				a registered user?</button>
		</form>

	</div>
</header>
<!-- Footer -->
<jsp:include page="footer.jsp" />
