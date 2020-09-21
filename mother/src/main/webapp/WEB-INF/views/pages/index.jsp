<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

        <!--=================== content body ====================-->
        <div class="col-lg-10 col-md-9 col-12 body_block  align-content-center">
        	<div class="widget widget_search">
				<div class="search-form">
					<input type="text" class="search-field" placeholder="Search">
				</div>
			</div>
            <div class="portfolio">
                <div class="container-fluid">
                    <!--=================== masaonry portfolio start====================-->
                    <div class="grid img-container justify-content-center no-gutters">
                        <div class="grid-sizer col-sm-12 col-md-6 col-lg-3"></div>
                        <div class="grid-item branding col-sm-12 col-md-6 col-lg-3">
                            <a href="../resources/images/drawing1.jpg" title="${list[0].title }">
                                <div class="project_box_one">
                                    <img src="../resources/images/drawing1.jpg" alt="pro1" />
                                    <div class="product_info">
                                        <div class="product_info_text">
                                            <div class="product_info_text_inner">
                                                <i class="ion ion-plus"></i>
                                                <h4>${list[0].title }</h4>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </div>
                        <div class="grid-item  branding architecture col-sm-12 col-md-6 ">
                            <a href="../resources/images/drawing2.jpg" title="${list[1].title }">
                                <div class="project_box_one">
                                    <img src="../resources/images/drawing2.jpg" alt="pro1" />
                                    <div class="product_info">
                                        <div class="product_info_text">
                                            <div class="product_info_text_inner">
                                                <i class="ion ion-plus"></i>
                                                <h4>${list[1].title }</h4>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </div>
                        <div class="grid-item  design col-sm-12 col-md-6 col-lg-3">
                            <a href="../resources/images/drawing3.jpg" title="${list[2].title }">
                                <div class="project_box_one">
                                    <img src="../resources/images/drawing3.jpg" alt="pro1" />
                                    <div class="product_info">
                                        <div class="product_info_text">
                                            <div class="product_info_text_inner">
                                                <i class="ion ion-plus"></i>
                                                <h4>${list[2].title }</h4>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </div>
                        <div class="grid-item  photography design col-sm-12 col-md-6 col-lg-3">
                            <a href="../resources/images/drawing4.jpg" title="${list[3].title }">
                                <div class="project_box_one">
                                    <img src="../resources/images/drawing4.jpg" alt="pro1" />
                                    <div class="product_info">
                                        <div class="product_info_text">
                                            <div class="product_info_text_inner">
                                                <i class="ion ion-plus"></i>
                                                <h4>${list[3].title }</h4>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </div>
                        <div class="grid-item  branding photography col-sm-12 col-md-6 col-lg-3">
                            <a href="../resources/images/drawing5.jpg" title="${list[4].title }">
                                <div class="project_box_one">
                                    <img src="../resources/images/drawing5.jpg" alt="pro1" />
                                    <div class="product_info">
                                        <div class="product_info_text">
                                            <div class="product_info_text_inner">
                                                <i class="ion ion-plus"></i>
                                                <h4>${list[4].title }</h4>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </div>
                        <div class="grid-item   architecture design col-sm-12 col-md-6 col-lg-3">
                            <a href="../resources/images/drawing6.jpg" title="project name 5">
                                <div class="project_box_one">
                                    <img src="../resources/images/drawing6.jpg" alt="pro1" />
                                    <div class="product_info">
                                        <div class="product_info_text">
                                            <div class="product_info_text_inner">
                                                <i class="ion ion-plus"></i>
                                                <h4>6</h4>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </div>
                        <div class="grid-item  photography architecture col-sm-12 col-md-6 col-lg-3">
                            <a href="../resources/images/drawing7.jpg" title="project name 5">
                                <div class="project_box_one">
                                    <img src="../resources/images/drawing7.jpg" alt="pro1" />
                                    <div class="product_info">
                                        <div class="product_info_text">
                                            <div class="product_info_text_inner">
                                                <i class="ion ion-plus"></i>
                                                <h4>7</h4>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </div>
                        <div class="grid-item  branding design  col-sm-12 col-md-6 col-lg-3">
                            <a href="../resources/images/drawing8.jpg" title="project name 5">
                                <div class="project_box_one">
                                    <img src="../resources/images/drawing8.jpg" alt="pro1" />
                                    <div class="product_info">
                                        <div class="product_info_text">
                                            <div class="product_info_text_inner">
                                                <i class="ion ion-plus"></i>
                                                <h4>8</h4>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </div>
                        <div class="grid-item architecture  col-sm-12 col-md-6 col-lg-6">
                            <a href="../resources/images/drawing9.jpg" title="project name 4">
                                <div class="project_box_one">
                                    <img src="../resources/images/drawing9.jpg" alt="pro1" />
                                    <div class="product_info">
                                        <div class="product_info_text">
                                            <div class="product_info_text_inner">
                                                <i class="ion ion-plus"></i>
                                                <h4>9</h4>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </div>
                    </div>
                    <!--=================== masaonry portfolio end====================-->
                </div>
            </div>
        </div>
        <!--=================== content body end ====================-->
    </div>
</div>

<%@ include file="../include/footer.jsp" %>    