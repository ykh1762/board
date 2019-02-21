<%@page import="kr.or.ddit.board.model.BoardVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--================ Start header Top Area =================-->
<%
	// ${sessionScope.userVo }
%>

<section class="header-top">
	<div class="container box_1170">
		<div class="row align-items-center justify-content-between">
			<div class="col-lg-6 col-md-6 col-sm-6">
				<a href="${pageContext.request.contextPath }/main.jsp" class="logo">
					<img src="img/logo.png" alt="">
				</a>
			</div>
			
			<input type="hidden" id="userId" value="${sessionScope.userVo.userId }">
			<!-- el로 Cookie값 가져오기 : cookie.[저장한 이름].value -->
			<h3 class="mb-20" style="margin-top: 25px; margin-left: 200px;">Welcome, 
					${cookie.boardUser.value }</h3>
			
			<!--  -->
			<c:choose>
				<%-- el로 session 가져오기. 'sessionScope' --%>
				<c:when test="${sessionScope.userVo != null}">
					<a href="${pageContext.request.contextPath }/login" class="genric-btn primary radius">로그아웃</a>
				</c:when>
				<c:otherwise>
					<a href="${pageContext.request.contextPath }/login" class="genric-btn primary radius">로그인</a>
				</c:otherwise>
			</c:choose>
			
		</div>
	</div>
</section>
<!--================ End header top Area =================-->

<!-- Start header Area -->
<header id="header">
	<div class="container box_1170 main-menu">
		<div class="row align-items-center justify-content-center d-flex">
			<nav id="nav-menu-container">
				<ul class="nav-menu">
					<li class="menu-active"><a href="${pageContext.request.contextPath }/main.jsp">홈</a></li>
					<li><a href="elements.jsp">Elements</a></li>
					<li><a href="details.jsp">222</a></li>
					<li class="menu-has-children"><a href="">게시판</a>
						<ul>
							<%-- 게시판 리스트 불러서 출력하기 --%>
							<%-- 게시판을 board.jsp 하나로 통합해야되나 --%>
							<c:forEach items="${boardList }" var="board">
								<li><a href="${pageContext.request.contextPath }
										/board?board_nm=${board.board_nm }">${board.board_nm }</a></li>
							</c:forEach>
						</ul>
					</li>
					<li class="menu-has-children"><a href="">페이징 게시판</a>
						<ul>
							<%-- 게시판 리스트 불러서 출력하기 --%>
							<%-- 게시판을 board.jsp 하나로 통합해야되나 --%>
							<c:forEach items="${boardList }" var="board">
								<li><a href="${pageContext.request.contextPath }
										/boardPaging?board_nm=${board.board_nm }">${board.board_nm }</a></li>
							</c:forEach>
						</ul>
					</li>
					<li><a href="${pageContext.request.contextPath }/boardSetting">게시판 관리</a></li>
					<li><a href="contact.html">Contact</a></li>
				</ul>
			</nav>
		</div>
	</div>
	
	<div class="search_input" id="search_input_box">
		<div class="container box_1170">
			<form class="d-flex justify-content-between">
				<input type="text" class="form-control" id="search_input" placeholder="Search Here">
				<button type="submit" class="btn"></button>
				<span class="lnr lnr-cross" id="close_search" title="Close Search"></span>
			</form>
		</div>
	</div>
</header>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${pageContext.request.contextPath }/js/js.cookie.js"></script> 
<script>
	$(document).ready(function(){
		console.log("header document");
		
		Cookies.remove("userId");
		Cookies.set("boardUser", $("#userId").val(), {expires : 1});	
	});
</script>

