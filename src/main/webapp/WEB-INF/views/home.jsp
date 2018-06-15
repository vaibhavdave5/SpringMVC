<!doctype html>
<%@page import="org.springframework.data.domain.PageImpl"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page
	import="org.springframework.context.annotation.AnnotationConfigApplicationContext"%>
<%@page
	import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="co.edureka.config.*"%>
<%@page import="co.edureka.model.*"%>
<%@page import="co.edureka.dao.*"%>
<%@page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Album example for Bootstrap</title>

<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"
	integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
	crossorigin="anonymous"></script>

<!-- Custom styles for this template -->
<link href="<c:url value="/resources/main.css" />" rel="stylesheet">
<script src="<c:url value="/resources/main.js" />"
	type="text/javascript"></script>
</head>

<body>


	<header>
		<div class="collapse bg-dark" id="navbarHeader">
			<div class="container">
				<div class="row">
					<div class="col-sm-8 col-md-7 py-4">
						<h4 class="text-white">About</h4>
						<p class="text-muted">Add some information about the album
							below, the author, or any other background context. Make it a few
							sentences long so folks can pick up some informative tidbits.
							Then, link them off to some social networking sites or contact
							information.</p>
					</div>
					<div class="col-sm-4 offset-md-1 py-4">
						<h4 class="text-white">Contact</h4>
						<ul class="list-unstyled">
							<li><a href="#" class="text-white">Follow on Twitter</a></li>
							<li><a href="#" class="text-white">Like on Facebook</a></li>
							<li><a href="#" class="text-white">Email me</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<!-- Main header -->
		<div class="navbar navbar-dark bg-dark box-shadow">
			<div class="container d-flex justify-content-between">
				<!-- Enter code here -->
			</div>
		</div>
	</header>

	<main role="main">

	<div class="jumbotron jumbotron-billboard">
		<div class="img"></div>
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<h1>
						<a href="" class="typewrite" data-period="2000"
							data-type='[ "Hi, I am Vaibhav.", "Please Appreciate my work", "It takes time and effort to do such things", "I Love to Develop." ]'>
							<span class="wrap"></span>
						</a></h1><br/>
					<a href="${pageContext.request.contextPath}/signup" class="btn btn-success btn-lg">Sign Up</a>
					<a href="${pageContext.request.contextPath}/login" class="btn btn-info btn-lg">Login</a>
				</div>
			</div>
		</div>
	</div>
	<div class="album py-5 bg-light">

		<nav aria-label="...">
			<ul class="pagination justify-content-center">
				<li class="page-item"><a class="page-link"
					href="${pageContext.request.contextPath}/nav?id=${currentPage-5}"
					tabindex="-1">Previous</a></li>
				<li class="page-item active"><a class="page-link"
					href="${pageContext.request.contextPath}/nav?id=${currentPage}">${currentPage}</a></li>
				<c:forEach begin="${currentPage+1}" end="${currentPage+5}"
					varStatus="loop">
					<li class="page-item"><a class="page-link"
						href="${pageContext.request.contextPath}/nav?id=${loop.index}">${loop.index}</a></li>
				</c:forEach>
				<li class="page-item"><a class="page-link"
					href="${pageContext.request.contextPath}/nav?id=${currentPage+5}">Next</a></li>
			</ul>
		</nav>

		<div class="container">
			<div class="row">

				<c:forEach items="${listOfMovies}" var="movie">
					<div class="col-md-4">
						<div class="card mb-4 box-shadow">
							<img class="card-img-top" height="260.5vw"
								src="<c:choose>
    															<c:when test="${empty movie.poster}">
        																https://thumb7.shutterstock.com/display_pic_with_logo/457558/549465907/stock-vector-not-available-grunge-rubber-stamp-on-white-background-vector-illustration-549465907.jpg
    															</c:when>
    														 <c:otherwise>
        																	<c:url value="${movie.poster}"/>
    														 </c:otherwise>
																</c:choose>">
							<div class="card-body">
								<div style="display: inline">
									<p>
									<h5 class="card-title">${movie.title}</h5>
									<h6>
										<span class="badge badge-warning"><strong>IMDB:
												${movie.imdb.rating}</strong>
									</h6>
									</p>
								</div>
								<div class="d-flex justify-content-between align-items-center">
									<div class="btn-group">
										<a class="btn btn-sm btn-outline-secondary"
											href="${pageContext.request.contextPath}/view?id=${movie.id}">View</a>
									</div>
									<small class="text-muted"> <!-- Something can be added -->
									</small>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>

	</main>

	<footer class="text-muted">
		<div class="container">
			<p class="float-right">
				<a href="#">Back to top</a>
			</p>
			<p>Album example is &copy; Bootstrap, but please download and
				customize it for yourself!</p>
			<p>
				New to Bootstrap? <a href="../../">Visit the homepage</a> or read
				our <a href="../../getting-started/">getting started guide</a>.
			</p>
		</div>
	</footer>

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="../../assets/js/vendor/jquery-slim.min.js"><\/script>')
	</script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/holder/2.9.4/holder.js"></script>
</body>
</html>
