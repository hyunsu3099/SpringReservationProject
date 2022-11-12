<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <!--메인 글씨체 import ()-->
    <link rel="preconnect" href="https://fonts.googleapis.com"> 
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin> 
    <link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR&display=swap" rel="stylesheet">

    <!--로컬 css 파일-->
    <link rel="stylesheet" href="/css/inc/main.css">
    <link rel="stylesheet" href="<tiles:getAsString name="includeCSS" />">
    <!--로컬 js 파일-->
    <script src="/js/inc/main.js"></script>
    <script src="<tiles:getAsString name="includeJS" />"></script>
</head>
<body>

    <!-- header -->
    <tiles:insertAttribute name="header" />
	<!-- maintb -->
	<tiles:insertAttribute name="main" />
	<!-- footer -->
	<tiles:insertAttribute name="footer" />
    
</body>
</html>