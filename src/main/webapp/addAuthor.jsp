
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
			<tbody>
				<tr>
					<td><form action="/subscriber/add" method="post">
							<select name="selection">
								<c:forEach var="author" items="${authors}">
									<option>"${author.name}"</option>
								</c:forEach>
							</select> <input type="submit" value="Submit">
						</form>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</header>

<!-- Footer -->
<jsp:include page="footer.jsp" />

<form action="some.jsp">
	<select name="item">
		<option value="1">1</option>
		<option value="2">2</option>
		<option value="3">3</option>
	</select> <input type="submit" value="Submit">
</form>