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
	<title>Ruft Blog</title>

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
	
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<!-- Favicon -->
	<link rel="shortcut icon" href="favicon.ico" />
	
	<!-- jQuery -->
	<!-- <script type="text/javascript" src="/js/jquery.js"></script>
	<script type="text/javascript" src="/js/jquery-ui.min.js"></script>-->
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	
	<script src="/SE2/js/HuskyEZCreator.js"></script>
	<script type="text/javascript">
	var oEditors = []; // 개발되어 있는 소스에 맞추느라, 전역변수로 사용하였지만, 지역변수로 사용해도 전혀 무관 함.
	
	$(document).ready(function() {
		// Editor Setting
		nhn.husky.EZCreator.createInIFrame({
			oAppRef : oEditors, // 전역변수 명과 동일해야 함.
			elPlaceHolder : "smarteditor", // 에디터가 그려질 textarea ID 값과 동일 해야 함.
			sSkinURI : "/SE2/SmartEditor2Skin.html", // Editor HTML
			fCreator : "createSEditor2", // SE2BasicCreator.js 메소드명이니 변경 금지 X
			htParams : {
				// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
				bUseToolbar : true,
				// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
				bUseVerticalResizer : true,
				// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
				bUseModeChanger : true, 
			}
		});
	
		// 전송버튼 클릭이벤트
		$("#savebutton").click(function(){
			if(confirm("게시글을 등록하시겠습니까?")) {
				// id가 smarteditor인 textarea에 에디터에서 대입
				oEditors.getById["smarteditor"].exec("UPDATE_CONTENTS_FIELD", []);
	
				// 이부분에 에디터 validation 검증
				if(validation()) {
					$("#frm").submit();
				}
			}
		})
	});
	
	// 필수값 Check
	function validation(){
		var contents = $.trim(oEditors[0].getContents());
		if(contents === '<p>&nbsp;</p>' || contents === ''){ // 기본적으로 아무것도 입력하지 않아도 <p>&nbsp;</p> 값이 입력되어 있음. 
			alert("내용을 입력하세요.");
			oEditors.getById['smarteditor'].exec('FOCUS');
			return false;
		}
	
		return true;
	}
	
	</script>	
	
	
</head>

<body>
	<%@include file="/header.jsp" %>

	<!-- Start banner Area -->
	<form action="${pageContext.request.contextPath }/editPost" id="frm" method="post">
		<section class="banner-area relative">
			<div class="overlay overlay-bg"></div>
			<div class="container box_1170">
				<div class="row d-flex align-items-center justify-content-center">
					<div class="about-content col-lg-12">
						<h1 class="text-white">
							${board_nm }
							<input type="hidden" id="board_nm" name="board_nm">
						</h1>
	
					</div>
				</div>
			</div>
		</section>
		<!-- End banner Area -->
	
	
		<!-- Start Align Area -->
		<div class="whole-wrap">
			<div class="container box_1170">
				<%-- 테이블. 여기에 에디터 넣기. --%>
				<div class="section-top-border">
					<div class="progress-table-wrap">
						<div class="progress-table" style="color: black;">			
							<div>
								<label>게시글 번호 : </label>
								<label>${post_no }</label>
							</div>
							<div>
								<label>제목 : </label>
								<label>${title }</label>
							</div>
							<div>
								<label>글쓴이 : </label>
								<label>${userid }</label>
							</div>
							<div>
								<label>내용 : </label>
								<label>${content }</label>
							</div>
							<input type="hidden" id="post_no" name="post_no">	
							<input type="hidden" id="title" name="title">	
							<input type="hidden" id="userid" name="userid">	
							<input type="hidden" id="content" name="content">	
	
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<!-- 댓글 -->
	    <section class="blog_area section-gap single-post-area" style="padding: 0px;">
	        <div class="container box_1170">
	            <div class="row">
	                <div class="col-lg-8">
	                    <div class="comments-area" style="padding-top: 0px;">
	                        <h4>3개의 댓글이 있습니다.</h4>
	                        <div class="comment-list">
	                            <div class="single-comment justify-content-between d-flex">
	                                <div class="user justify-content-between d-flex">
	                                    <div class="thumb">
	                                        <img src="img/blog/c1.jpg" alt="">
	                                    </div>
	                                    <div class="desc">
	                                        <h5><a href="#">Emilly Blunt</a></h5>
	                                        <p class="date">December 4, 2017 at 3:12 pm </p>
	                                        <p class="comment">
	                                            Never say goodbye till the end comes!
	                                        </p>
	                                    </div>
	                                </div>
	                                <div class="reply-btn">
	                                    <a href="" class="btn-reply text-uppercase">reply</a>
	                                </div>
	                            </div>
	                        </div>
	                        <div class="comment-list">
	                            <div class="single-comment justify-content-between d-flex">
	                                <div class="user justify-content-between d-flex">
	                                    <div class="thumb">
	                                        <img src="img/blog/c4.jpg" alt="">
	                                    </div>
	                                    <div class="desc">
	                                        <h5><a href="#">Maria Luna</a></h5>
	                                        <p class="date">December 4, 2017 at 3:12 pm </p>
	                                        <p class="comment">
	                                            Never say goodbye till the end comes!
	                                        </p>
	                                    </div>
	                                </div>
	                                <div class="reply-btn">
	                                    <a href="" class="btn-reply text-uppercase">reply</a>
	                                </div>
	                            </div>
	                        </div>
	                        <div class="comment-list">
	                            <div class="single-comment justify-content-between d-flex">
	                                <div class="user justify-content-between d-flex">
	                                    <div class="thumb">
	                                        <img src="img/blog/c5.jpg" alt="">
	                                    </div>
	                                    <div class="desc">
	                                        <h5><a href="#">Ina Hayes</a></h5>
	                                        <p class="date">December 4, 2017 at 3:12 pm </p>
	                                        <p class="comment">
	                                            Never say goodbye till the end comes!
	                                        </p>
	                                    </div>
	                                </div>
	                                <div class="reply-btn">
	                                    <a href="" class="btn-reply text-uppercase">reply</a>
	                                </div>
	                            </div>
	                            <!-- 댓글작성 -->
			                    <div class="comment-form">
			                        <form>
			                            <div class="form-group form-inline">
			                                <div class="form-group col-lg-6 col-md-6 name">
			                                    <input type="text" class="form-control" id="name" placeholder="Enter Name" onfocus="this.placeholder = ''"
			                                        onblur="this.placeholder = 'Enter Name'">
			                                </div>
			                                <div class="form-group col-lg-6 col-md-6 email">
			                                    <input type="email" class="form-control" id="email" placeholder="Enter email address"
			                                        onfocus="this.placeholder = ''" onblur="this.placeholder = 'Enter email address'">
			                                </div>
			                            </div>
			                            <div class="form-group">
			                                <input type="text" class="form-control" id="subject" placeholder="Subject" onfocus="this.placeholder = ''"
			                                    onblur="this.placeholder = 'Subject'">
			                            </div>
			                            <div class="form-group">
			                                <textarea class="form-control mb-10" rows="5" name="message" placeholder="Messege"
			                                    onfocus="this.placeholder = ''" onblur="this.placeholder = 'Messege'" required=""></textarea>
			                            </div>
			                            <a href="#" class="primary-btn submit_btn text-uppercase">Send Message</a>
			                        </form>
			                    </div>
	                        </div>
	                    </div>		
					</div>
	            </div>
	        </div>
	    </section>		
		
		
		<!-- 댓글 -->
		
		<a class="genric-btn primary radius" 
				style="margin-left: 1075px; margin-top: -50px; margin-bottom: 40px; margin-right: 10px;" 
				id="btn_list" href="${pageContext.request.contextPath }
				/board?board_nm=${board_nm }">목록으로</a>
		<a class="genric-btn primary radius" style="margin-right: 10px;" id="btn_repost" 
				href="${pageContext.request.contextPath }/repost?board_nm=${board_nm }
				&post_no=${post_no }
				">답글 쓰기</a>
		<input type="button" class="genric-btn primary radius" style="" id="btn_edit" value="수정">
	</form>
	
	
	
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
			$(".table-row").on("click", function(){
				console.log("click row");
				console.log($(this).data("post_no"));
			});
			
			$("#btn_edit").on("click", function(){
				// 여기서 값을 세팅안했군.
				$("#post_no").val("${post_no }");
				$("#userid").val("${userid }");
				$("#title").val("${title }");
				$("#content").val("${content }");
				$("#board_nm").val("${board_nm }");
				
				$("#frm").submit();
			});
		});
	</script>
	
</body>

</html>