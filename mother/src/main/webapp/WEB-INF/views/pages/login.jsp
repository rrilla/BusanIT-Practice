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
                                            	로그인
                                        </h3>
                                        <p>
                                            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur leo est, feugiat nec elementum id, suscipit id nulla. Nulla sit amet luctus dolor. Etiam finibus consequat ante ac congue.
                                        </p>
                                        <div class="mt75 row justify-content-center">
                                            <div class="col-lg-8 col-12">
                                                <input type="text" id="id" placeholder="Id" class="form-control">
                                            </div>
                                            <div class="col-lg-8 col-12">
                                                <input type="password" id="pw" placeholder="Password" class="form-control">
                                            </div>
                                            <!-- <div class="col-12">
                                                <input type="text" placeholder="Subject" class="form-control">
                                            </div> -->
                                            <div class="col-12">
                                                <button type="button" id="btnLogin" class="btn btn-primary">Login</button>
                                                <a href="join"><button type="button" class="btn btn-primary">Join</button></a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!--=================== contact info and form end====================-->
                        </div>
                        <div class="col-md-6 col-5 img_section" style="background-color:#000;">
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--=================== content body end ====================-->
    </div>
</div>

<script type="text/javascript">
$("#btnLogin").on('click',function(){
	if(validate()){
		$.ajax({
			type:"post",
			url:"login",
			async:false,
			data:{"id":$("#id").val(), "password":$("#pw").val()},
			dataType:"text",
			success:function(data,textStatus){
				if(data==1){
					alert("로그인 성공.");
					location.href=document.referrer;
				}else if(data==2){
					alert("password를 확인해주세요.");
				}else{
					alert("id를 확인해주세요.");
				}
			},error:function(data,textStatus){
				alert("서버 에러.")
			}
		});
	}
});

function validate() {
	if($("#id").val()=="") {
		alert("아이디를 입력해 주세요.");
		$("#id").focus();
		return false;
	}
	if($("#pw").val()=="") {
		alert("비밀번호를 입력해 주세요.");
		$("#pw").focus();
		return false;
	}
	return true;
}
</script>

<%@ include file="../include/footer.jsp" %>    