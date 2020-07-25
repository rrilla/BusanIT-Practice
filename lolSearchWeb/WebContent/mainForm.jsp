<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	div.container {
	width: 900px;
	margin: 0 auto;
	background-color: white;
	}

	div.list-container table {
		width: 800px;
	}
	
	div.container {
		padding: 30px;
	}
	
	div.controls {
		margin-bottom: 30px;
	}
</style>
</head>
<body>
	<div class="container">
		
		<div class="list-container">
		
			<div class="controls">
				<button type="button" id="btnList">리스트 갱신</button>
			</div>
			<table id="tblList" border="1">
			<thead>
				<tr>
					<th>번호</th>
					<th>챔프이름</th>
					<th>포지션</th>
					<th>승률</th>
					<th>픽률</th>
					<th>밴률</th>
				</tr>
			</thead>
			<tbody>
				<!-- 데이터 받아올거임 -->
			</tbody>
			</table>
			
		</div>
			
	</div>
	
<script src="../js/jquery-3.5.1.min.js"></script>
<script>

</script>
</body>
</html>