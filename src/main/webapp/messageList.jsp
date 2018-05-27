
<!-- Header -->
<jsp:include page="header.jsp" />

<!-- JSTL includes -->
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
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
			PubHub <small>Messages</small>
		</h1>
		<hr class="book-primary">

		<table
			class="table table-striped table-hover table-responsive PubHub-datatable">
			<thead>
				<tr>
					<td>Id:</td>
					<td>From:</td>
					<td>Content:</td>
					<td>Action:</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="message" items="${messages}">
					<tr>
						<td><c:out value="${message.id}" /></td>
						<td><c:out value="${message.user}" /></td>
						<td><c:out value="${message.content}" /></td>
						<td>
							<form class="delete-message-form"
								data-message="${message.id}" data-user="${user}">
								<sec:csrfInput />
								<sec:csrfMetaTags />
								<button class="btn btn-lg btn-primary btn-block" type="submit">Delete</button>
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>

		</table>
		<form action="${contextPath}/social/home" method="GET">
			<button class="btn btn-lg btn-primary btn-block" type="submit">Back</button>
		</form>
	</div>
</header>

<!-- Footer -->
<jsp:include page="footer.jsp" />