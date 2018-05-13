
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
			PubHub <small>PubHub Home</small>
		</h1>
		<hr class="book-primary">

		<table
			class="table table-striped table-hover table-responsive PubHub-datatable">
			<thead>
				<tr>
					<td>ISBN-13:</td>
					<td>Title:</td>
					<td>Author:</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="book" items="${books}">
					<tr>
						<td><c:out value="${book.isbn13}" /></td>
						<td><c:out value="${book.title}" /></td>
						<td><c:out value="${book.author}" /></td>
						<td><form action="/item/add" method="post">
								<input type="hidden" name="isbn13" value="${book.isbn13}">
								<button class="btn btn-success">Add to Cart</button>
							</form></td>
					</tr>
				</c:forEach>
				<td><a href="/order/cart" class="btn btn-primary">View Cart</a></td>
				<td><a href="/order/list" class="btn btn-primary">Checkout History</a></td>
			</tbody>
		</table>

	</div>
</header>

<!-- Footer -->
<jsp:include page="footer.jsp" />