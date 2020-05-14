<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <div class="container d-flex">

      <div class="logo mr-auto">
<!--         <h1 class="text-light"><a href="index.html">Flattern</a></h1> -->
        <!-- Uncomment below if you prefer to use an image logo -->
        <a href=""><img src="${cp }/Flattern/assets/img/logo.png" alt="" class="img-fluid"></a>
      </div>

      <nav class="nav-menu d-none d-lg-block">
        <ul>
          <!-- 아래 active~~가 없으니 첫번째 회사소개 드롭다운이 오른쪽으로 쏠림 그래서 가로0px 유지 -->
          <li class="active"><a href=""></a></li>
          <li><a href="${cp }/board?board_seq=1">공지사항</a>
          <li><a href="${cp }/board?board_seq=2">자유게시판</a>
          </li>
<!--           <li class="drop-down"><a href="">Drop Down</a> -->
<!--             <ul> -->
<!--               <li><a href="#">Drop Down 1</a></li> -->
<!--               <li class="drop-down"><a href="#">Drop Down 2</a> -->
<!--                 <ul> -->
<!--                   <li><a href="#">Deep Drop Down 1</a></li> -->
<!--                   <li><a href="#">Deep Drop Down 2</a></li> -->
<!--                   <li><a href="#">Deep Drop Down 3</a></li> -->
<!--                   <li><a href="#">Deep Drop Down 4</a></li> -->
<!--                   <li><a href="#">Deep Drop Down 5</a></li> -->
<!--                 </ul> -->
<!--               </li> -->
<!--               <li><a href="#">Drop Down 3</a></li> -->
<!--               <li><a href="#">Drop Down 4</a></li> -->
<!--               <li><a href="#">Drop Down 5</a></li> -->
<!--             </ul> -->
<!--           </li> -->
          <li id="login"><a data-toggle="modal" href="#loginModal">로그인</a></li>
        </ul>
      </nav><!-- .nav-menu -->

    </div>