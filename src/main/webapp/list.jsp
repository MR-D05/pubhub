
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
			PubHub <small>Checkout History</small>
		</h1>
		<hr class="book-primary">
		<table
			class="table table-striped table-hover table-responsive PubHub-datatable">
			<thead>
				<tr>
					<td>ISBN-13:</td>
					<td>Title:</td>
					<td>Author:</td>
					<td>Action:</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="book" items="${books}">
					<tr>
						<td><c:out value="${book.isbn13}" /></td>
						<td><c:out value="${book.title}" /></td>
						<td><c:out value="${book.authorname}" /></td>
						<td><form action="/book/download/${book.isbn13}" method="GET">
								<button class="btn btn-primary">Download</button>
							</form></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<form action="${contextPath}/pubHub/home" method="GET">
			<button class="btn btn-lg btn-primary btn-block" type="submit">Back</button>
		</form>
	</div>
</header>

<!-- Footer -->
<jsp:include page="footer.jsp" />