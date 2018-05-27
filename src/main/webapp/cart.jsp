
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
			PubHub <small>Your Cart</small>
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
				<c:forEach var="item" varStatus="loop"
					items="${MY_CART_ITEMS.items}">
					<tr>
						<td><c:out value="${item.book.isbn13}" /></td>
						<td><c:out value="${item.book.title}" /></td>
						<td><c:out value="${item.book.authorname}" /></td>
						<td><form action="item/remove" method="POST">
								<sec:csrfInput />
								<sec:csrfMetaTags />
								<input type="hidden" name="isbn13" value="${item.book.isbn13}">
								<button class="btn btn-primary">Remove</button>
							</form></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<form action="/order/checkout" method="GET">
			<button class="btn btn-lg btn-primary btn-block" type="submit">Check
				out</button>
		</form>
	</div>
</header>

<!-- Footer -->
<jsp:include page="footer.jsp" />