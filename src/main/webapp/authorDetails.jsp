
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
			PubHub <small>Messages</small>
		</h1>
		<hr class="book-primary">

		<table
			class="table table-striped table-hover table-responsive PubHub-datatable">
			<thead>
				<tr>
					<td>Author's first name:</td>
					<td>Author's last name:</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><c:out value="${author.firstname}" /></td>
					<td><c:out value="${author.lastname}" /></td>
				</tr>
			</tbody>

		</table>
		<form action="${contextPath}/subscriptions/manage">
			<button class="btn btn-lg btn-primary btn-block" type="submit">Back
				to managing your subscriptions</button>
		</form>
	</div>
</header>

<!-- Footer -->
<jsp:include page="footer.jsp" />