<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <!-- ========== Meta Tags ========== -->
    <meta charset="UTF-8">
    <meta name="description" content="Cocoon -Portfolio">
    <meta name="keywords" content="Cocoon , Portfolio">
    <meta name="author" content="Pharaohlab">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <!-- ========== Title ========== -->
    <title>Medol`s mom Storage</title>
    <!-- ========== Favicon Ico ========== -->
    <!--<link rel="icon" href="fav.ico">-->
    <!-- ========== STYLESHEETS ========== -->
    <!-- Bootstrap CSS -->
    <link href="../resources/assets/css/bootstrap.min.css" rel="stylesheet">
    <!-- Fonts Icon CSS -->
    <link href="../resources/assets/css/font-awesome.min.css" rel="stylesheet">
    <link href="../resources/assets/css/et-line.css" rel="stylesheet">
    <link href="../resources/assets/css/ionicons.min.css" rel="stylesheet">
    <!-- Carousel CSS -->
    <link href="../resources/assets/css/slick.css" rel="stylesheet">
    <!-- Magnific-popup -->
    <link rel="stylesheet" href="../resources/assets/css/magnific-popup.css">
    <!-- Animate CSS -->
    <link rel="stylesheet" href="../resources/assets/css/animate.min.css">
    <!-- Custom styles for this template -->
    <link href="../resources/assets/css/main.css" rel="stylesheet">
    <script
  src="https://code.jquery.com/jquery-3.5.1.min.js"
  integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
  crossorigin="anonymous"></script>
</head>
<body>
<div class="loader">
    <div class="loader-outter"></div>
    <div class="loader-inner"></div>
</div>

<div class="body-container container-fluid">
    <a class="menu-btn" href="javascript:void(0)">
        <i class="ion ion-grid"></i>
    </a>
    <div class="row justify-content-center">
        <!--=================== side menu ====================-->
        <div class="col-lg-2 col-md-3 col-12 menu_block">

            <!--logo -->
            <div class="logo_box">
                <a href="index">
                    <img src="../resources/assets/img/logo.png" alt="cocoon">
                </a>
            </div>
            <!--logo end-->

            <!--main menu -->
            <div class="side_menu_section">
                <ul class="menu_nav">
                    <li class="${nav eq 'Home'?'active':''} }">
                        <a href="index">
                            Home
                        </a>
                    </li>
                    <c:choose>
                   		<c:when test="${empty session_id }">
                       		<li class="${nav eq 'Login'?'active':''} }">
                        		<a href="login">
                            		Login
                        		</a>
                   			</li>
                   			<li class="${nav eq 'Join'?'active':''} }">
                        		<a href="join">
                            		Join
                        		</a>
                    		</li>
                       	</c:when>
                       	<c:otherwise>
                       		<li>
                        		<a href="logout">
                            		Logout
                        		</a>
                   			</li>
                   			<li class="${nav eq 'Register'?'active':''} }">
                        		<a href="register">
                            		Register
                        		</a>
                   			</li>
                       	</c:otherwise>	
                    </c:choose>	
                    <li class="${nav eq 'Drawing'?'active':''} }">
                        <a href="listDrawing">
                            Drawing
                        </a>
                    </li>
                    <li class="${nav eq 'Essay'?'active':''} }">
                        <a href="listEssay">
                            Essay
                        </a>
                    </li>
                    <li class="${nav eq 'Picture'?'active':''} }">
                        <a href="listPicture">
                            Picture
                        </a>
                    </li>
                </ul>
            </div>
            <!--main menu end -->

            <!--filter menu -->
            <div class="side_menu_section">
                <h4 class="side_title">filter by:</h4>
                <ul  id="filtr-container"  class="filter_nav">
                    <li  data-filter="*" class="active"><a href="javascript:void(0)" >all</a></li>
                    <li data-filter=".branding"> <a href="javascript:void(0)">Drawing</a></li>
                    <li data-filter=".photography"><a href="javascript:void(0)">Essay</a></li>
                    <li data-filter=".design"><a href="javascript:void(0)">Picture</a></li>
                    <!-- <li data-filter=".architecture"><a href="javascript:void(0)">architecture</a></li> -->
                </ul>
            </div>
            <!--filter menu end -->

            <!--social and copyright -->
            <div class="side_menu_bottom">
                <div class="side_menu_bottom_inner">
                    <ul class="social_menu">
                        <li>
                            <a href="#"> <i class="ion ion-social-pinterest"></i> </a>
                        </li>
                        <li>
                            <a href="#"> <i class="ion ion-social-facebook"></i> </a>
                        </li>
                        <li>
                            <a href="#"> <i class="ion ion-social-twitter"></i> </a>
                        </li>
                        <li>
                            <a href="#"> <i class="ion ion-social-dribbble"></i> </a>
                        </li>
                    </ul>
                    <div class="copy_right">
                        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                        <p class="copyright">Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a></p>
                        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                    </div>
                </div>
            </div>
            <!--social and copyright end -->

        </div>
        <!--=================== side menu end====================-->
        
<script>
	/* $('menu_nav ul li').on('click', function() {
		$('menu_nav ul li').attr("class", "");
		$(this).attr("class", "active")
	}); */
</script>