<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zxx" class="no-js">

<head>
	<!-- Mobile Specific Meta -->
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<!-- Favicon-->
	<link rel="shortcut icon" href="img/fav.png">
	<!-- Author Meta -->
	<meta name="author" content="codepixer">
	<!-- Meta Description -->
	<meta name="description" content="">
	<!-- Meta Keyword -->
	<meta name="keywords" content="">
	<!-- meta character set -->
	<meta charset="UTF-8">
	<!-- Site Title -->
	<title>Ruft Blog1</title>

	<link href="https://fonts.googleapis.com/css?family=Roboto:400,500|Rubik:500" rel="stylesheet">
	<!--
			CSS
			============================================= -->
	<link rel="stylesheet" href="css/linearicons.css">
	<link rel="stylesheet" href="css/font-awesome.min.css">
	<link rel="stylesheet" href="css/bootstrap.css">
	<link rel="stylesheet" href="css/magnific-popup.css">
	<link rel="stylesheet" href="css/nice-select.css">
	<link rel="stylesheet" href="css/animate.min.css">
	<link rel="stylesheet" href="css/owl.carousel.css">
	<link rel="stylesheet" href="css/main.css">
</head>

<body>
	<%@include file="/header.jsp" %>

	<!-- Start banner Area -->
	<form action="${pageContext.request.contextPath }/post" id="frm" method="post">
		<section class="banner-area relative">
			<div class="overlay overlay-bg"></div>
			<div class="container box_1170">
				<div class="row d-flex align-items-center justify-content-center">
					<div class="about-content col-lg-12">
						<h1 class="text-white">
							<c:choose>
								<c:when test="${use_flag == 't' }">
									${board_nm }
								</c:when>
								<c:otherwise>
									게시판이 닫혀있습니다.
								</c:otherwise>
							</c:choose>
							<input type="hidden" id="board_nm" name="board_nm">
						</h1>
	
					</div>
				</div>
			</div>
		</section>
	<!-- End banner Area -->


	<!-- Start Align Area -->
		<c:choose>
			<c:when test="${use_flag == 't' }">
				<div class="whole-wrap">
					<div class="container box_1170">
						<%-- 테이블 --%>
						<div class="section-top-border">
							<h3 class="mb-30">게시글 목록</h3>
							<div class="progress-table-wrap">
								<div class="progress-table">
									<div class="table-head">
										<div class="serial">#</div>
										<div class="country">제목</div>
										<div class="visit">작성자</div>
										<div class="visit">작성일시</div>
									</div>
									
									<c:forEach var="i" begin="0" end="${postList.size() - 1 }" >
										<div class="table-row" data-post_no="${postList.get(i).post_no }">
											<div class="serial">${postList.get(i).post_no }</div>
											<div class="country">${postList.get(i).title }</div>
											<div class="visit">${postList.get(i).userid }</div>
											<div class="visit">${postList.get(i).reg_dt }</div>
										</div>							
									</c:forEach>
									<input type="hidden" id="post_no" name="post_no">						
			
								</div>
							</div>
						</div>
					</div>
				</div>			
			</c:when>
			<c:otherwise>
				<div class="whole-wrap">
					<div class="container box_1170">
						<%-- 테이블 --%>
						<div class="section-top-border">
							<h3 class="mb-30">게시글 목록</h3>
							<div class="progress-table-wrap">
								<div class="progress-table">
									<div class="table-head">
										<div class="serial">#</div>
										<div class="country">제목</div>
										<div class="visit">작성자</div>
										<div class="visit">작성일시</div>
									</div>
									
									<c:forEach var="i" begin="0" end="${postList.size() - 1 }" >
										<div class="table-row" data-post_no="${postList.get(i).post_no }"
												style="cursor: not-allowed;">
											<div class="serial">${postList.get(i).post_no }</div>
											<div class="country">${postList.get(i).title }</div>
											<div class="visit">${postList.get(i).userid }</div>
											<div class="visit">${postList.get(i).reg_dt }</div>
										</div>							
									</c:forEach>
									<input type="hidden" id="post_no" name="post_no">						
			
								</div>
							</div>
						</div>
					</div>
				</div>	
			</c:otherwise>
		</c:choose>	
		
	</form>
	
	
	
	<c:choose>
		<c:when test="${use_flag == 't' }">
			<a href="${pageContext.request.contextPath }/posting?board_nm=${board_nm }" class="genric-btn primary radius" 
					style="margin-bottom: 100px; margin-left: 1300px; margin-top: -60px;">글쓰기</a>
		</c:when>
		<c:otherwise>
			<a href="" class="genric-btn primary radius" 
					style="margin-bottom: 100px; margin-left: 1300px; margin-top: -60px;
					cursor: not-allowed;">글쓰기</a>
		</c:otherwise>
	</c:choose>
	
	
	<!-- End Align Area -->

	<!-- start footer Area -->
	<footer class="footer-area section-gap">
		<div class="container box_1170">
			<div class="row">
				<div class="col-lg-3 col-md-6 col-sm-6">
					<div class="single-footer-widget">
						<h6 class="footer_title">About Us</h6>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore dolore
							magna aliqua.</p>
					</div>
				</div>
				<div class="col-lg-3 col-md-6 col-sm-6">
					<div class="single-footer-widget">
						<h6 class="footer_title">Newsletter</h6>
						<p>Stay updated with our latest trends</p>
						<div id="mc_embed_signup">
							<form target="_blank" action="https://spondonit.us12.list-manage.com/subscribe/post?u=1462626880ade1ac87bd9c93a&amp;id=92a4423d01"
							 method="get" class="subscribe_form relative">
								<div class="input-group d-flex flex-row">
									<input name="EMAIL" placeholder="Email Address" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Email Address '"
									 required="" type="email">
									<button class="btn sub-btn"><span class="lnr lnr-arrow-right"></span></button>
								</div>
								<div class="mt-10 info"></div>
							</form>
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-md-6 col-sm-6">
					<div class="single-footer-widget instafeed">
						<h6 class="footer_title">Instagram Feed</h6>
						<ul class="list instafeed d-flex flex-wrap">
							<li><img src="img/i1.jpg" alt=""></li>
							<li><img src="img/i2.jpg" alt=""></li>
							<li><img src="img/i3.jpg" alt=""></li>
							<li><img src="img/i4.jpg" alt=""></li>
							<li><img src="img/i5.jpg" alt=""></li>
							<li><img src="img/i6.jpg" alt=""></li>
							<li><img src="img/i7.jpg" alt=""></li>
							<li><img src="img/i8.jpg" alt=""></li>
						</ul>
					</div>
				</div>
				<div class="col-lg-2 col-md-6 col-sm-6">
					<div class="single-footer-widget f_social_wd">
						<h6 class="footer_title">Follow Us</h6>
						<p>Let us be social</p>
						<div class="f_social">
							<a href="#"><i class="fa fa-facebook"></i></a>
							<a href="#"><i class="fa fa-twitter"></i></a>
							<a href="#"><i class="fa fa-dribbble"></i></a>
							<a href="#"><i class="fa fa-behance"></i></a>
						</div>
					</div>
				</div>
			</div>
			<div class="row footer-bottom d-flex justify-content-between align-items-center">
				<p class="col-lg-12 footer-text text-center"><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>
			</div>
		</div>
	</footer>
	<!-- End footer Area -->

	<script src="js/vendor/jquery-2.2.4.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	 crossorigin="anonymous"></script>
	<script src="js/vendor/bootstrap.min.js"></script>
	<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBhOdIF3Y9382fqJYt5I_sswSrEw5eihAA"></script>
	<script src="js/easing.min.js"></script>
	<script src="js/hoverIntent.js"></script>
	<script src="js/superfish.min.js"></script>
	<script src="js/jquery.ajaxchimp.min.js"></script>
	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/jquery.tabs.min.js"></script>
	<script src="js/jquery.nice-select.min.js"></script>
	<script src="js/waypoints.min.js"></script>
	<script src="js/mail-script.js"></script>
	<script src="js/main.js"></script>
	
	<script type="text/javascript">
		$(document).ready(function(){
			<c:if test="${use_flag == 't'}">
				$(".table-row").on("click", function(){
					console.log("click row");
					console.log($(this).data("post_no"));
					$("#post_no").val($(this).data("post_no"));
					$("#board_nm").val("${board_nm}");
					
					$("#frm").submit();				
				});
			</c:if>	
		});
	</script>
	
</body>

</html>