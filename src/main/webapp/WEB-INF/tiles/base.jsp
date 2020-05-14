<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>꺽순시스템</title>
  <meta content="" name="descriptison">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="${cp }/Flattern/assets/img/favicon.png" rel="icon">
  <link href="${cp }/Flattern/assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Muli:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="${cp }/Flattern/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="${cp }/Flattern/assets/vendor/icofont/icofont.min.css" rel="stylesheet">
  <link href="${cp }/Flattern/assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="${cp }/Flattern/assets/vendor/animate.css/animate.min.css" rel="stylesheet">
  <link href="${cp }/Flattern/assets/vendor/venobox/venobox.css" rel="stylesheet">
  <link href="${cp }/Flattern/assets/vendor/owl.carousel/assets/owl.carousel.min.css" rel="stylesheet">
  <link href="${cp }/Flattern/assets/vendor/aos/aos.css" rel="stylesheet">
  
  <!-- Board CSS -->
  <link href="${cp }/css/board.css" rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="${cp }/Flattern/assets/css/style.css" rel="stylesheet">

  <!-- =======================================================
  * Template Name: Flattern - v2.0.0
  * Template URL: https://bootstrapmade.com/flattern-multipurpose-bootstrap-template/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
</head>

<body>

  <!-- ======= Top Bar ======= -->
<section id="topbar" class="d-none d-lg-block">
	<tiles:insertAttribute name="topbar"/>
</section>

  <!-- ======= Header ======= -->
  <header id="header">
	<tiles:insertAttribute name="header"/>
  </header><!-- End Header -->
  
  <!-- ======= Hero ======= -->
  <section id="hero">
    <tiles:insertAttribute name="hero"/>
  </section>
  
  <!-- ======= Content ======= -->
  <tiles:insertAttribute name="content"/>
	
  <!-- ======= Footer ======= -->
  <footer id="footer">
	<tiles:insertAttribute name="footer"/>
  </footer><!-- End Footer -->

<!-- Login Modal -->
<div class="bootstrap-modal">
    <div class="modal fade" id="loginModal">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h3 class="modal-title" id="calendarModalTitle">로그인</h3>
                </div>
                <div class="modal-body basic-form">
                	<form id="calendarForm">
                		<input type="hidden" name="cal_id" id="cal_id"/>
                		<input type="hidden" name="depart_id" value="${S_EMPLOYEE.depart_id }"/>
                		<input type="hidden" name="emp_id" value="${S_EMPLOYEE.emp_id }"/>
                		
                		<div class="form-group row">
		                    <label class="col-sm-3 col-form-label">아이디</label>
		                    <div class="col-sm-9">
		                    	<input type="text" class="form-control" id="cal_title" name="cal_title">
		                    </div>
	                    </div>
	                    <div class="form-group row">
		                    <label class="col-sm-3 col-form-label">비밀번호</label>
		                    <div class="col-sm-9">
		                    	<input type="text" class="form-control" id="cal_title" name="cal_title">
		                    </div>
	                    </div>
	                    
	                    <div class="form-group row">
		                    <label class="col-sm-3 col-form-label">하루 종일</label>
		                    <div class="col-sm-9">
	                    		<input id="allDay" name="allDay" type="checkbox" style="margin-top: 10px;">
		                    </div>
	                    </div>
                    </form>
                </div>
                    <button type="button" class="btn mb-1 btn-dark" data-dismiss="modal" style="float: right;">취소</button>
                    <button type="button" class="btn mb-1 btn-dark" id="btnUpdateCalendar" style="float: right;">수정</button>
                    <button type="button" class="btn mb-1 btn-dark" id="btnInsertCalendar" style="float: right;">생성</button>
                    <button type="button" class="btn mb-1 btn-danger" id="btnDeleteCalendar" style="float: left;">삭제</button>
            </div>
        </div>
    </div>
</div> <!-- End Login Modal -->

  <a href="#" class="back-to-top"><i class="icofont-simple-up"></i></a>

  <!-- Vendor JS Files -->
  <script src="${cp }/Flattern/assets/vendor/jquery/jquery.min.js"></script>
  <script src="${cp }/Flattern/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="${cp }/Flattern/assets/vendor/jquery.easing/jquery.easing.min.js"></script>
  <script src="${cp }/Flattern/assets/vendor/php-email-form/validate.js"></script>
  <script src="${cp }/Flattern/assets/vendor/jquery-sticky/jquery.sticky.js"></script>
  <script src="${cp }/Flattern/assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
  <script src="${cp }/Flattern/assets/vendor/venobox/venobox.min.js"></script>
  <script src="${cp }/Flattern/assets/vendor/waypoints/jquery.waypoints.min.js"></script>
  <script src="${cp }/Flattern/assets/vendor/owl.carousel/owl.carousel.min.js"></script>
  <script src="${cp }/Flattern/assets/vendor/aos/aos.js"></script>

  <!-- Template Main JS File -->
  <script src="${cp }/Flattern/assets/js/main.js"></script>

</body>

</html>