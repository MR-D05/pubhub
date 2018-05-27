
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
			PubHub <small>Social home</small>
		</h1>
		<hr class="book-primary">

		<table
			class="table table-striped table-hover table-responsive PubHub-datatable">
			<tbody>
				<tr>
					<td>
						<form action="/subscriptions/manage" method="GET">
							<button class="btn btn-lg btn-primary btn-block" type="submit">Manage
								subscriptions (Users)</button>
						</form>
						<form action="/message/list" method="GET">
							<button class="btn btn-lg btn-primary btn-block" type="submit">Your messages (Users)</button>
						</form>
						<form action="/message/send" method="GET">
							<button class="btn btn-lg btn-primary btn-block" type="submit">Fan
								outreach (Authors)</button>
						</form>
					</td>
				</tr>
			</tbody>


		</table>
	</div>
</header>

<!-- Footer -->
<jsp:include page="footer.jsp" />