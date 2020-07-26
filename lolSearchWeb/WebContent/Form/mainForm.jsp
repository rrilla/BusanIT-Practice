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
		padding: 30px;
		background-color: #8BBCFF;
	}

	div.list-container table {
		width: 900px;
		background-color: white;
	}
	
	div.controls {
		margin-bottom: 10px;
		margin-top: 30px;
	}
	#idInput {
		height: 50px;
		width: 500px;
		margin-left: 150px;
		font-size: 30px;
	}
	
	#btnList, #test {
		background-color: #D5D5D5;
	}
	
</style>
</head>
<body>
	<div class="container">
		<form id="search">
		<input type="text" name="search" id="idInput" placeholder="검색할 소환사명 입력!"/>
		<input type="submit" id="test" value="ㄱㄱ" />
		</form>
		
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
					<!-- 여기에 데이터 받아올거임 -->
				</tbody>
				</table>
				
			</div>
			
	</div>
	
<script src="../js/jquery-3.5.1.min.js"></script>
<script>
	function getList() {
		$.ajax({
			url: '../api/winBan',
			method: 'GET',
			success: function (result) {
				console.log(result);
				
				processList(result);
			}
		});
	}
	
	function processList(list) {
		var str = '';
		
		for (let winRatio of list) {
			str += '<tr>';
			str += '<td>' + winRatio.no + '</td>';
			str += '<td>' + winRatio.name + '</td>';
			str += '<td>' + winRatio.line + '</td>';
			str += '<td>' + winRatio.winRatio + '</td>';
			str += '<td>' + winRatio.pickRatio + '</td>';
			str += '<td>' + winRatio.banRatio + '</td>';
			str += '</tr>';
		}
		
	$('#tblList > tbody').html(str);
	} // processList()

	$('#btnList').click(function () {
		$.ajax({
			url: '../api/winBan',
			method: 'DELETE',
			success: function (result) {
				alert(result);
				
			},
			error: function () {
				alert('갱신 에러 발생!')
			}
		});
		getList();
		/* alert('갱신됬따!') */
	});
</script>
<script>
	getList();
</script>
</body>
</html>