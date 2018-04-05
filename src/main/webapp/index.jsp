<jsp:include page="header.jsp" />
<!-- Header -->
<header>
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<!--                     <img class="img-responsive" src="resources/libraries/img/profile.png" alt=""> -->
				<div class="intro-text">
					<span class="name">LibraryApp</span>
					<hr class="book-primary">
					<span class="skills">Open Your Mind</span>
				</div>
			</div>
		</div>
	</div>
</header>
<section id="myCarousel" class="carousel slide">
	<!-- Indicators -->
	<ol class="carousel-indicators">
		<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
		<li data-target="#myCarousel" data-slide-to="1" class=""></li>
		<li data-target="#myCarousel" data-slide-to="2" class=""></li>
	</ol>

	<!-- Wrapper for Slides -->
	<div class="carousel-inner">
		<div class="item active">
			<!-- Set the first background image using inline CSS below. -->
			<div class="fill"
				style="background-image:url('${request.contextPath}resources/imgs/ebook1.jpg');"></div>
			<div class="carousel-caption">
				<h2>Read.</h2>
			</div>
		</div>
		<div class="item">
			<!-- Set the second background image using inline CSS below. -->
			<div class="fill"
				style="background-image:url('${request.contextPath}resources/imgs/ebook2.jpg');"></div>
			<div class="carousel-caption">
				<h2>Understand</h2>
			</div>
		</div>
		<div class="item">
			<!-- Set the third background image using inline CSS below. -->
			<div class="fill"
				style="background-image:url('${request.contextPath}resources/imgs/ebook3.jpg');"></div>
			<div class="carousel-caption">
				<h2>Love</h2>
			</div>
		</div>
	</div>

	<!-- Controls -->
	<a class="left carousel-control" href="#myCarousel" data-slide="prev">
		<span class="icon-prev"></span>
	</a> <a class="right carousel-control" href="#myCarousel" data-slide="next">
		<span class="icon-next"></span>
	</a>
	<!--     </div> -->
</section>
<jsp:include page="footer.jsp" />
