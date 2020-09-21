<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp" %>

<style>
	.msg {
		color: red;
	}
</style>

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
                                            	회원가입
                                        </h3>
                                        <p>
                                            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur leo est, feugiat nec elementum id, suscipit id nulla. Nulla sit amet luctus dolor. Etiam finibus consequat ante ac congue.
                                        </p>
										<form action="join" method="post">
	                                        <div class="mt75 row justify-content-center">
	                                        	<div class="col-lg-12 col-12">
	                                        		<h5>아이디</h5>
	                                        	</div>
	                                            <div class="col-lg-7 col-12">
	                                                <input type="text" name="id" placeholder="ID" class="form-control">
	                                            </div>
	                                            <div class="col-lg-5 col-12">
	                                                <button type="button" class="btn btn-primary-outline" onclick="checkId()">중복확인</button>
	                                            </div>
	                                            <p class="msg"></p>
	                                            <div class="col-lg-12 col-12">
	                                        		<h5>비밀번호</h5>
	                                        	</div>
	                                            <div class="col-lg-7 col-12">
	                                                <input type="password" name="password" placeholder="Password" class="form-control">
	                                            </div>
	                                            <div class="col-lg-5 col-12">
	                                            </div>
	                                            <div class="col-lg-12 col-12">
	                                        		<h5>비밀번호 확인</h5>
	                                        	</div>
	                                            <div class="col-lg-7 col-12">
	                                                <input type="password" name="password2" placeholder="Check Password" class="form-control">
	                                            </div>
	                                            <div class="col-lg-5 col-12">
	                                            </div>
	                                            <div class="col-lg-12 col-12">
	                                        		<h5>이름</h5>
	                                        	</div>
	                                            <div class="col-lg-7 col-12">
	                                                <input type="text" name="name" placeholder="Name" class="form-control">
	                                            </div>
	                                            <div class="col-lg-5 col-12">
	                                            </div>
	                                            <div class="col-lg-12 col-12">
	                                        		<h5>성별</h5>
	                                        	</div>
	                                            <div class="col-lg-7 col-12">
	                                                <input type="radio" name="gender" value="male" class="">male<br>
	                                                <input type="radio" name="gender" value="female" class="">female
	                                            </div>
	                                            <div class="col-lg-5 col-12">
	                                            </div>
	                                            <!-- <div class="col-12">
	                                                <input type="text" placeholder="Subject" class="form-control">
	                                            </div> -->
	                                            <div class="col-12">
	                                                <button type="submit" class="btn btn-primary">Join</button>
	                                            </div>
	                                        </div>
	                                	</form>
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
	function checkId() {
		$.ajax({
			type:"post",
			url:"checkId",
			async:false,
			data:{"id":$("input[name='id']").val()},
			dataType:"text",
			success:function(data,textStatus){
				if(data==1){
					$('.msg').html("사용 가능");
				}else{
					$('.msg').html("사용 불가능");
				}
			},error:function(data,textStatus){
				alert("서버 에러.")
			}
		});
	}
</script>

<%@ include file="../include/footer.jsp" %>    