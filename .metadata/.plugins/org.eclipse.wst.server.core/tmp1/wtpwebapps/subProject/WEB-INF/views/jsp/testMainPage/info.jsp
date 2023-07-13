<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<link rel="shortcut icon" href="#">
<title>공지사항</title>

<!-- Google font -->
<link href="https://fonts.googleapis.com/css?family=Poppins:400"
	rel="stylesheet" />
<link href="https://webfontworld.github.io/goodchoice/Jalnan.css"
	rel="stylesheet">
<!-- Bootstrap -->
<link type="text/css" rel="stylesheet"
	href="/resources/testMainPage/css/bootstrap.min.css" />

<!-- Custom stlylesheet -->
<link type="text/css" rel="stylesheet"
	href="/resources/testMainPage/css/style.css" />


<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<link rel="stylesheet"
	href="resources/testMainPage/css/announcement.css" type="text/css">

	<style type="text/css">
 		.button-class{
		  border: 0;
		  background-color: transparent;
		  font-size:15px;
		  color:white;
		  font-family: "Jalnan";
		}
 	</style>


</head>

<body>
	<div id="booking" class="section">
		<div class="header">
			<h1>
				<a href="/">거긴어때</a>
			</h1>
			<div class="nav">
				<ul>
					<li><a href="/inform?currentPage=1">공지사항</a></li>
					<li><a href="/room">호텔정보</a></li>
					<li><a href="/check">예약내역</a></li>
					<li><a href="/board?currentPage=1">게시판</a></li>
					<c:choose>
            	<c:when test="${sessionScope.loginMember == null && sessionScope.loginKakao == null && sessionScope.loginAdmin==null}">
            		 <li><a href='/login'><span>로그인</span></a></li>
            		  <li><a href='/login'><span>회원가입</span></a></li>
            	</c:when>
            	<c:when test="${sessionScope.loginKakao != null}">
            		<li><a href="https://kauth.kakao.com/oauth/logout?client_id=fdb3ded4b5d753c2e685b7bb4ffbaa8d&logout_redirect_uri=http://localhost:8090/auth/kakao/logout">
            		<span>${sessionScope.loginKakao.mem_Id}님 로그아웃</span>
            		</a></li>
            		<li><a href='/'><span>내 정보</span></a></li>
            		<li><a href='/'><span>회원수정</span></a></li>
            	</c:when>
            	<c:when test="${sessionScope.loginAdmin != null}">
            	<li><span><button type="submit" class = "button-class">${sessionScope.loginAdmin.mem_Id}(관리자)님 로그아웃</button></span></li>
            	<li><a href='/management'><span>관리자 페이지</span></a></li>
            	</c:when>
            	<c:otherwise>
            		<li><span><button type="submit" class = "button-class">${sessionScope.loginMember.mem_Id}님 로그아웃</button></span></li>
            		<li><a href='/'><span>내 정보</span></a></li>
            		<li><a href='/'><span>회원수정</span></a></li>
            	</c:otherwise>
            	
            	
            </c:choose>
				</ul>
			</div>
		</div>


		<section class="notice">

			<div class="page-title">
				<div class="container">
					<h3>공지사항</h3>
				</div>
			</div>

			<!-- board seach area -->
			<div id="board-search">
				<div class="container">
					<div class="search-window">
						<form action="">
							<div class="search-wrap">
								<label for="search" class="blind">공지사항 내용 검색</label> <input
									id="search" type="search" name="" placeholder="검색어를 입력해주세요."
									value="">
								<button type="submit" class="btn btn-dark">검색</button>
								<!-- <button class="btn btn-secondary">Secondary</button> -->
							</div>

						</form>
					</div>
				</div>
			</div>

			<!-- board list area -->
			<div id="board-list">
				<div class="container">
					<table class="board-table">
						<thead>
							<tr>
								<th scope="col" class="th-num">번호</th>
								<th scope="col" class="th-title">제목</th>
								<th scope="col" class="th-date">등록일</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>3</td>
								<th><a href="#!">[공지사항] 개인정보 처리방침 변경안내처리방침</a>
									<p>테스트</p></th>
								<td>2017.07.13</td>
							</tr>

							<tr>
								<td>2</td>
								<th><a href="#!">공지사항 안내입니다. 이용해주셔서 감사합니다</a></th>
								<td>2017.06.15</td>
							</tr>

							<tr>
								<td>1</td>
								<th><a href="#!">공지사항 안내입니다. 이용해주셔서 감사합니다</a></th>
								<td>2017.06.15</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>

		</section>
	</div>
</body>
<div style="padding-top: 5%">
	<footer>
		<p>거기어때컴퍼니는 통신판매중개자로서 통신판매의 당사자가 아니며, 상품의 예약, 이용 및 환불 등과 관련한 의무와
			책임은 각 판매자에게 있습니다.</p>
		<address>주소:서울특별시 강남구|대표이사:오이들|사업자등록번호:123-45-67894</address>
	</footer>
</div>
</html>