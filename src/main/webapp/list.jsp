
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
			LibraryApp <small>Your Previously Checkout Out Books</small>
		</h1>
		<h2><a href="libraryHome.jsp" class="btn btn-primary">Back to Browsing</a></h2>
		<hr class="book-primary">
		<table
			class="table table-striped table-hover table-responsive LibraryApp-datatable">
			<thead>
				<tr>
					<td>ISBN-13:</td>
					<td>Title:</td>
					<td>Author:</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" varStatus="loop" items="${MY_CHECKEDOUT_BOOKS.items}">
					<tr>
						<td><c:out value="${item.book.isbn13}" /></td>
						<td><c:out value="${item.book.title}" /></td>
						<td><c:out value="${item.book.author}" /></td>
						<td><form action="/book/download" method="get">
								<input type="hidden" name="isbn13" value="${item.book.isbn13}">
								<button class="btn btn-primary">Download</button>
							</form></td>
						<%-- <td><form action="/item/add" method="post">
								<input type="hidden" name="isbn13" value="${book.isbn13}">
								<button class="btn btn-success">Add to Cart</button>
							</form></td>
						<td><form action="ViewBookDetails?isbn=${book.isbn13}"
								method="get">
								<input type="hidden" name="isbn13" value="${book.isbn13}">
								<button class="btn btn-primary">Details</button>
							</form></td>
						<td><form action="/order/view" method="get">
								<input type="hidden" name="isbn13" value="${book.isbn13}">
								<button class="btn btn-primary">View Cart</button>
							</form></td> --%>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</header>

<!-- Footer -->
<jsp:include page="footer.jsp" />