<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String siteURL = (String)request.getAttribute("siteURL");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset='utf-8' />
		<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
		<link rel="stylesheet" type="text/css" href="<%=siteURL%>/resources/css/style.css" />
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
		<script type="text/javascript" src="<%=siteURL%>/resources/js/ckeditor/ckeditor.js"></script>
		<script src="<%=siteURL%>/resources/js/layer.js"></script>
		<script src="<%=siteURL%>/resources/js/common.js"></script>
		<title>네트워크 프로그래밍 평가</title>
	</head>
	<body>