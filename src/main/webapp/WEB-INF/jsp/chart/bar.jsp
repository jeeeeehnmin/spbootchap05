<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
div{
	margin: 0px auto;
	width: 50%;
	text-align: left;
	border-color: #9dd7b1;
}
</style>
<meta charset="UTF-8">
<title>bar.jsp</title>
<c:if test="${false}">
<link rel="stylesheet" href="../css/bootstrap.css" data-th-remove="all">
<link rel="stylesheet" href="../css/animate.css" data-th-remove="all">
</c:if>
</head>
<body>
<div>
	<h1 class="animated bounce">Bar Chart</h1>
	<p>부서별 직원 급여 차트</p>
	<hr>
	<h3>${depts[0].deptno} ${depts[0].dname}</h3>
	<canvas id="dept01"></canvas>
	<hr>
	<h3>${depts[1].deptno} ${depts[1].dname}</h3>
	<canvas id="dept02"></canvas>
	<hr>
	<h3>${depts[2].deptno} ${depts[2].dname}</h3>
	<canvas id="dept03"></canvas>
	<hr>
	
	${bars[0].toJson()}<br>
	${bars[1].toJson()}<br>
	${bars[2].toJson()}<br>

	<script type="text/javascript">
		var data01 = ${bars[0].toJson()};
		var ctx = document.getElementById("dept01").getContext("2d");
		new Chart(ctx, data01);
		
		var data02 = ${bars[1].toJson()};
		var ctx = document.getElementById("dept02").getContext("2d");
		new Chart(ctx, data02);
		
		var data03 = ${bars[2].toJson()};
		var ctx = document.getElementById("dept03").getContext("2d");
		new Chart(ctx, data03);
	</script>
</div>
</body>
</html>