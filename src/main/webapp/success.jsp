
<!-- Header -->
<jsp:include page="header.jsp" />

<!-- JSTL includes -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<header>
	<div class="container">
		<h1>
			PubHub <small>Item successfully added to you cart</small>
		</h1>
			<form action="pubHubHome.jsp" method="GET">
			<button class="btn btn-lg btn-primary btn-block" type="submit">Back to browsing</button>
		</form>
			<form action="/order/cart" method="GET">
			<button class="btn btn-lg btn-primary btn-block" type="submit">View cart</button>
		</form>
	</div>
</header>

<!-- Footer -->
<jsp:include page="footer.jsp" />