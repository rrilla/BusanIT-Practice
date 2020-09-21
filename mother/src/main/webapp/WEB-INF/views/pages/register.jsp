<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp" %>

<!--=================== content body ====================-->
        <div class="col-lg-10 col-md-9 col-12 body_block  align-content-center">
            <div>
                <div class="img_card">
                    <div class="row justify-content-center">
                        <div class="col-md-6 col-7 content_section">
                            <!--=================== contact info and form start====================-->
                            <div class="content_box">
                                <div class="content_box_inner">
                                    <div>
                                        <h3>
                                            	글쓰기
                                        </h3>
                                        <p>
                                            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur leo est, feugiat nec elementum id, suscipit id nulla. Nulla sit amet luctus dolor. Etiam finibus consequat ante ac congue.
                                        </p>

                                        <!-- <ul class="nosyely_list pt50">
                                            <li>
                                                <div class="img_box_two">
                                                    <img src="../resources/assets/img/icons/satelite.png" alt="info list">
                                                    <div class="content align-items-center">
                                                        <p>
                                                            Rosia Road , No234/56<br/>
                                                            Gibraltar , UK
                                                        </p>
                                                    </div>
                                                </div>
                                            </li>
                                            <li>
                                                <div class="img_box_two">
                                                    <img src="../resources/assets/img/icons/scheme.png" alt="info list">
                                                    <div class="content align-items-center">
                                                        <p>
                                                            contact@cocoontemplate.com
                                                        </p>
                                                    </div>
                                                </div>
                                            </li>
                                            <li>
                                                <div class="img_box_two">
                                                    <img src="../resources/assets/img/icons/smartphone.png" alt="info list">
                                                    <div class="content align-items-center">
                                                        <p>
                                                            +5463 834 53 2245
                                                        </p>
                                                    </div>
                                                </div>
                                            </li>
                                        </ul> -->

                                        <div class="mt75 row justify-content-center">
                                        <form action="register" method="post">
                                        	<input type="hidden" name="writer" value="${session_id }" />
                                        	
                                        	<div class="col-lg-12 col-12">
                                            	<hr style="border:solid 2px grey;"/>
                                            </div>
                                        	<div class="col-lg-12 col-12">
	                                        	<h4 style="font-style: italic;">카테고리</h4>
	                                        </div>
                                            <div class="col-lg-4 col-4">
                                                <label><input type="radio" name="type" value="Essay" class="form-control">Essay</label>
                                            </div>
                                            <div class="col-lg-4 col-4">
                                                <label><input type="radio" name="type" value="Picture" class="form-control">Picture</label>
                                            </div>
                                            <div class="col-lg-4 col-4">
                                                <label><input type="radio" name="type" value="Drawing" class="form-control">Drawing</label>
                                            </div>
	                                        <div class="col-lg-12 col-12">
                                            	<hr style="border:solid 2px grey;"/>
                                            </div>
                                            <div class="col-lg-12 col-12">
	                                        	<h4 style="font-style: italic;">제목</h4>
	                                        </div>
                                            <div class="col-lg-6 col-12">
                                                <input type="text" name="title" placeholder="title" class="form-control">
                                            </div>
                                            <div class="col-lg-6 col-12">
                                            </div>
                                             <div class="col-lg-12 col-12">
                                            	<hr style="border:solid 2px grey;"/>
                                            </div>
                                            <div class="col-lg-12 col-12">
	                                        	<h4 style="font-style: italic;">내용</h4>
	                                        </div>
                                            <div class="col-12">
                                                <textarea name="content" placeholder="content" class="form-control" cols="4" rows="4"></textarea>
                                            </div>
                                            <div class="col-lg-12 col-12">
                                            	<hr style="border:solid 2px grey;"/>
                                            </div>
                                            <div class="col-lg-12 col-12">
	                                        	<h4 style="font-style: italic;">첨부파일</h4>
	                                        </div>
	                                        <div class="col-lg-12 col-12">
	                                        	<input type="file" name="img_name" multiple/>
	                                        </div>
                                            <div class="col-12">
                                            <br /><br />
                                                <button type="submit" class="btn btn-primary">Send</button>
                                            </div>
                                        </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!--=================== contact info and form end====================-->
                        </div>
                        <div class="col-md-6 col-5 img_section" style="background-color:#000;">
                            <!--map -->
                            <div id="map" data-lon="24.036176" data-lat=" 57.039986" class="map"></div>
                            <!--map end-->
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--=================== content body end ====================-->
    </div>
</div>

<script>
	
</script>

<%@ include file="../include/footer.jsp" %>
