<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
 	<link rel="shortcut icon" href="#">
    <title>Booking Form HTML Template</title>

    <!-- Google font -->
    <link
      href="https://fonts.googleapis.com/css?family=Poppins:400"
      rel="stylesheet"
    />
    <link href="https://webfontworld.github.io/goodchoice/Jalnan.css" rel="stylesheet">

    <!-- Bootstrap -->
    <link type="text/css" rel="stylesheet" href="/resources/testMainPage/css/bootstrap.min.css" />

    <!-- Custom stlylesheet -->
    <link type="text/css" rel="stylesheet" href="/resources/testMainPage/css/style.css" />
    <link type="text/css" rel="stylesheet" href="/resources/testMainPage/css/room.css" />
    
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/raty/2.8.0/jquery.raty.min.js"></script>

    <style>
      ul{
        list-style:none;
        padding-left:0px;
       
        }
         
      </style>
      	<style type="text/css">
 		.button-class{
		  border: 0;
		  background-color: transparent;
		  font-size:15px;
		  color:white;
		  font-family: "Jalnan";
		}
 	</style>
 	
<script type="text/javascript">
//Raty 별점
$(document).ready(function() {
	var score = $(".rating").data("score");
    $(".rating").raty({
        readOnly: true,
        half: true,
        score: score,
        size: 25,
        path: 'https://cdnjs.cloudflare.com/ajax/libs/raty/2.8.0/images/'
    });
});
</script>
 	
  </head>

  <body>
    <div id="booking" class="section">
      <div class="header">
        <h1><a href="/">거긴어때</a>
        <div class="cate">호텔</div></h1>
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

      <div class="section-center">
        <div class="container">
          <class class="row">
            <section class="booking-form">
              <form action ="/rel">
                <div class="row no-margin">
                  <div class="col-md-3">
                    <div class="form-group">
                      <span class="form-label">Destination</span>
                      <input
                        class="form-control"
                        type="text"
                        placeholder="Country, ZIP, city..."
                      />
                    </div>
                  </div>
                  <div class="col-md-6">
                    <div class="row no-margin">
                      <div class="col-md-5">
                        <div class="form-group">
                          <span class="form-label">Check In</span>
                          <input class="form-control" value="${Search.checkin}" type="date" required />
                        </div>
                      </div>
                      <div class="col-md-5">
                        <div class="form-group">
                          <span class="form-label">Check out</span>
                          <input class="form-control" value="${Search.checkout}" type="date" required />
                        </div>
                      </div>
                      
                    </div>
                  </div>
                  <div class="col-md-3">
                    <div class="form-btn">
                      <button class="submit-btn">Check availability</button>
                    </div>
                  </div>
                </div>
              </form>
            </section>
           </class>

      <section>
      
       <h1 class="place-title">호텔 리스트</h1>
     	<c:forEach items = "${list}" var= "dto" >
      	
      	
       
        <div class='hotel-list'>
        <a href='/rel?hotel_code=${dto.hotel_code}&checkin=${Search.checkin}&checkout=${Search.checkout}'><img class="hotel-img pointer"src='https:${dto.filepath}' alt="${dto.filename}" style= display:block; onclick="location" >
        <span class='hotel-text'>${dto.name}</span>
        <div class="text1">${dto.type}</div>
        <div class="text2">
        	<div class="rating" data-score="${dto.rating_avg}"></div>
        </div>
        <div class="text3">${dto.address}</div>
        <div class="price">${dto.price}</div>
        </a></div>
        
		</c:forEach>

	<form action="/room" id="searchForm">
	
		
   <div class="check-section">
        <h3 class='check-sub'>상세조건</h3>
        <div class="btn_wrap">
            <button type="button" onclick="window.location.href='https://www.goodchoice.kr/product/search/2/2012?sel_date=2023-03-10&amp;sel_date2=2023-03-11'">초기화</button>
            <button type="submit">적용</button>
        </div>
         <div class="rel1">        
           <ul>
                <li>
                  <input type="checkbox" id="reserve_0" name="reserve[]" class="inp_chk" value="2">
                  <label for="reserve_0" class="label_chk1">예약 가능</label>
                </li>
           </ul>
         </div>

      <section>
         <ul class="hide_type half">
             <strong class='check_star'>Type</strong>
              <li>
                  <input type="checkbox" id="five" name="type" value="5">
                  <input type="hidden" name="checkin" value="${Search.checkin}" />
               <input type="hidden" name="checkout" value="${Search.checkout}" />
               <input type="hidden" name="location" value="${Search.location}" />
               <input type = "hidden" name = "check" value = "2">
                  <label for="five" class="label_chk">5성급</label>
              </li>
              <li>
                  <input type="checkbox" id="four" name="type" value="4">
                  <label for="four" class="label_chk">4성급</label>
              </li>
              <li>
                  <input type="checkbox" id="three" name="type" value="3">
                  <label for="three" class="label_chk">3성급</label>
              </li>
             <strong class='check_star'>Bed Type</strong>
              <li>
                  <input type="checkbox" id="single" name="bedType" value="single">
                  <label for="single" class="label_chk">Single</label>
              </li>
              <li>
                  <input type="checkbox" id="double" name="bedType" value="double">
                  <label for="double" class="label_chk">Double</label>
              </li>
              <li>
                  <input type="checkbox" id="twin" name="bedType" value="twin">
                  <label for="twin" class="label_chk">Twin</label>
              </li>
              <strong class='check_star'>Hotel Condition</strong>
              <li>
                  <input type="checkbox" id="clean" name="filter" value="clean">
                  <label for="clean" class="label_chk">Clean</label>
              </li>
              <li>
                  <input type="checkbox" id="facility" name="filter" value="facility">
                  <label for="amenities" class="label_chk">facility</label>
              </li>
              <li>
                  <input type="checkbox" id="service" name="filter" value="service">
                  <label for="service" class="label_chk">Service</label>
              </li>
              <li>
                  <input type="checkbox" id="disabled" name="filter" value="disabled">
                  <label for="disabled" class="label_chk">For disabled</label>
              </li>
              <li>
                  <input type="checkbox" id="pet" name="filter" value="pet">
                  <label for="pets" class="label_chk">For pets</label>
              </li>
          </ul>
      </section>

			
		
       
            
         </div>
         </form>
      </section>

    </div>
    </div>
  </body>
 <div style="padding-top:20%;">
  <footer>
        <p>
          거기어때컴퍼니는 통신판매중개자로서 통신판매의 당사자가 아니며, 상품의
          예약, 이용 및 환불 등과 관련한 의무와 책임은 각 판매자에게 있습니다.
        </p>
        <address>
          주소:서울특별시 강남구|대표이사:오이들|사업자등록번호:123-45-67894
        </address>
      </footer>
	   </div>
</html>