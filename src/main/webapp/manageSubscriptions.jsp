
<!-- Header -->
<jsp:include page="header.jsp" />

<!-- JSTL includes -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ page isErrorPage="true"%>

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
			PubHub <small>Manage Your Subscriptions</small>
		</h1>
		<hr class="book-primary">

		<table
			class="table table-striped table-hover table-responsive PubHub-datatable">
			<thead>
				<tr>
					<td>Author:</td>
					<td>Action:</td>
					<td>Action:</td>
					<td>Action:</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="author" items="${authors}">
					<tr>
						<td><c:out value="${author.username}" /></td>
						<td>
							<form action="/author/details" method="GET">
								<input type="hidden" name="username" value="${author.username}">
								<button class="btn btn-lg btn-primary btn-block" type="submit">Author
									details</button>
							</form>
						</td>
						<td>
							<form class="subscribe-author-form"
								data-author="${author.username}">
								<button class="btn btn-lg btn-primary btn-block" type="submit">Subscribe</button>
							</form>
						</td>
						<td>
							<form class="unsubscribe-author-form"
								data-author="${author.username}" data-user="${user}">
								<sec:csrfInput />
								<sec:csrfMetaTags />
								<button class="btn btn-lg btn-primary btn-block" type="submit">Unsubscribe</button>
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>

		</table>
		<form action="/social/home" method="GET">
			<button class="btn btn-lg btn-primary btn-block" type="submit">Back</button>
		</form>
	</div>
</header>

<!-- Footer -->
<jsp:include page="footer.jsp" />