<!-- Header -->
<jsp:include page="header.jsp" />

<!-- JSTL includes -->
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
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
			PubHub <small>Send a message</small>
		</h1>
		<hr class="book-primary">
		<form action="/message/send" method="POST" class="form-signin">
		<sec:csrfInput />
			<table
				class="table table-striped table-hover table-responsive PubHub-datatable">
				<thead>
					<tr>
						<td>To:</td>
						<td>Message:</td>
						<td>Action:</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>
							<div class="form-group ${status.error ? 'has-error' : ''}">
								<select name="userid">
									<c:forEach var="user" items="${users}">
										<option>
											<c:out value="${user.id}" /></option>
									</c:forEach>
								</select>
							</div>
						</td>
						<td>
							<div class="form-group ${status.error ? 'has-error' : ''}">
								<input type="text" class="form-control" id="content"
									name="content" placeholder="Content" required="required"
									value="${param.content }" />
							</div>
						</td>
						<td>
							<button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
						</td>
					</tr>
				</tbody>
			</table>
		</form>
		<form action="/social/home" method="GET">
			<button class="btn btn-lg btn-primary btn-block" type="submit">Back</button>
		</form>
	</div>
</header>

<!-- Footer -->
<jsp:include page="footer.jsp" /></html>