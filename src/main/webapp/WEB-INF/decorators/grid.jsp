<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>default.jsp<sitemesh:write property="title" /></title>
<link rel="stylesheet" href="/webjars/bootstrap/3.3.7/css/bootstrap.css">
<link rel="stylesheet" href="/webjars/animate.css/3.5.2/animate.css">
<!-- css style library를 포함시키려면 'head' 추가  | 단 타이틀은 제외-->
<sitemesh:write property="head"/>
</head>
<body>
<h1>Decorator default.jsp START</h1>
<sitemesh:write property="body"/>
<h1>Decorator default.jsp END</h1>
</body>
</html>