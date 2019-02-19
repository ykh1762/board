<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<title>Ruft Blog11</title>

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
	<section class="banner-area relative">
		<div class="overlay overlay-bg"></div>
		<div class="container box_1170">
			<div class="row d-flex align-items-center justify-content-center">
				<div class="about-content col-lg-12">
					<h1 class="text-white">
						게시판 관리
					</h1>
				</div>
			</div>
		</div>
	</section>
	<!-- End banner Area -->
	<form action="${pageContext.request.contextPath }/boardSetting" id="frm" method="post">
		<div class="whole-wrap">
			<div class="container box_1170">
				<div class="section-top-border">
					<h3 class="mb-30">게시판 목록</h3>
					<div class="progress-table-wrap">
						<div class="progress-table">
							<div class="table-head">
								<div class="serial">#</div>
								<div class="country">게시판 이름</div>
								<div class="visit">게시글 수</div>
								<div class="serial">사용여부</div>
								<div class="serial"> </div>
							</div>
							
							<!-- 게시판 목록 출력. -->
							<c:forEach items="${boardList }" var="board" varStatus="i">
								<div class="table-row">
									<div class="serial">${board.board_no }</div>
									<div class="country">
	<%-- 									<input type="text" id="new_name" name="first_name" placeholder="${board.board_nm }"  --%>
										<input type="text" id="editName${board.board_no }" name="editName${board.board_no }" placeholder="${board.board_nm }" 
												onfocus="this.placeholder = ''" onblur="this.placeholder = '${board.board_nm }'" 
												required class="single-input" style="width: 310px; background-color: #cfb3ff;
												margin-left: -20px;" value="${board.board_nm }">
												<!-- 수정. 연한 보라색 : #cfb3ff. 생성. 연한 파랑색 : #b3ddff. -->									
									</div>
									<div class="visit">645032?</div>
									<div class="serial">
										<div class="primary-switch">
											<c:choose>
												<c:when test="${board.use_flag == 't'  }">
													<input type="checkbox" id="switch${board.board_no }" checked
															name="editFlag${board.board_no }">
												</c:when>
												<c:otherwise>
													<input type="checkbox" id="switch${board.board_no }"
															name="editFlag${board.board_no }">
												</c:otherwise>
											</c:choose>
											<label for="switch${board.board_no }"></label>
										</div>								
									</div>
									
									<div id="change_btn">
<!-- 											<a id="btn_edit" href="" -->
<!-- 													class="genric-btn primary radius">수정</a> -->
										<input type="button" id="btn_edit${board.board_no }" class="genric-btn primary radius" value="수정">
										<!-- 수정 버튼 클릭시 form 전송 editName, editFlag -->
									</div>
									
								</div>
									
							</c:forEach>	
							<input type="hidden" id="editName" name="editName"/>
							<input type="hidden" id="editFlag" name="editFlag"/>
							<input type="hidden" id="editIndex" name="editIndex"/>
	
							<div class="table-row">
								<div class="serial">${boardList.size() + 1 }</div>
								<div class="country">
									<input type="text" id="new_name" name="first_name" placeholder="새로운 게시판" 
											onfocus="this.placeholder = ''" onblur="this.placeholder = '새로운 게시판'" 
											required class="single-input" style="width: 310px; background-color: #b3ddff;
											margin-left: -20px;">
											<!-- 수정. 연한 보라색 : #cfb3ff. 생성. 연한 파랑색 : #b3ddff. -->
								</div>
								<div class="visit"> </div>
								<div class="serial">
									<div class="confirm-switch">
										<input type="checkbox" id="switch_new" checked>
										<label for="switch_new"></label>
									</div>								
								</div>
								<a href="#" id="btn_new" class="genric-btn info radius">생성</a>
							</div>
							
							
	
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
			

						

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
			console.log("docu ready");
		
			// 여기서 board. 은 못쓰지.
			<c:forEach var="i" begin="0" end="${boardList.size() - 1 }">
				$("#btn_edit${i+1 }").on("click", function(){
					<c:set var="editIndex" value="${i+1 }" scope="session"></c:set>
					
					// 첫번째 파라미터에 정보를 다 넣자. 는 아니고 수정 버튼을 하나씩 다 만들어야겠네.
					// editName, editFlag에 저장하자.
					$("#editName").val($("#editName${i+1 }").val());
					$("#editFlag").val($("#editFlag${i+1 }").val());
					// index도 파라미터에 넣기.
					$("#editIndex").val("${i+1 }");
					alert("???");
					$("#frm").submit();
				});
				
			
			</c:forEach>
			
			
			$("#btn_new").on("click", function(){
				console.log($("#new_name").val());
			});
		});
	</script>
	
</body>

</html>