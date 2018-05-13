
<!-- Header -->
<jsp:include page="header.jsp" />

<!-- JSTL includes -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<header>
	<div class="container">
		<h1>
			PubHub <small>Item Successfully Added to Cart</small>
		</h1>
		<h2><a href="pubHubHome.jsp" class="btn btn-primary">Back to Browsing</a></h2>
		<h2><a href="/order/cart" class="btn btn-primary">View Cart</a></h2>
	</div>
</header>

<!-- Footer -->
<jsp:include page="footer.jsp" />