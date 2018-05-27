<!-- Header -->
<jsp:include page="header.jsp" />

<!-- JSTL includes -->
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
			PubHub <small>Manage Your Subscriptions</small>
		</h1>
		<hr class="book-primary">
		<form:form method="POST" modelAttribute="messageForm"
			class="form-signin">
			<table
				class="table table-striped table-hover table-responsive PubHub-datatable">
				<thead>
					<tr>
						<td>Channel:</td>
						<td>Message:</td>
						<td>Action:</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><spring:bind path="channelid">
								<div class="form-group ${status.error ? 'has-error' : ''}">
									<select>
										<c:forEach var="channel" items="${channels}">
											<option value="${channel.id}">
												<c:out value="${channel.id}" /></option>
										</c:forEach>
									</select>
									<form:errors path="channelid"></form:errors>
								</div>
							</spring:bind></td>
						<td><spring:bind path="content">
								<div class="form-group ${status.error ? 'has-error' : ''}">
									<form:input type="textarea" path="content" class="form-control"
										placeholder="Content"></form:input>
									<form:errors path="content"></form:errors>
								</div>
							</spring:bind></td>
						<td>
							<button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
						</td>
					</tr>
				</tbody>
			</table>
		</form:form>
		<form action="/channel/home" method="GET">
			<button class="btn btn-lg btn-primary btn-block" type="submit">Back
				to your homepage</button>
		</form>
	</div>
</header>

<!-- Footer -->
<jsp:include page="footer.jsp" /></html>