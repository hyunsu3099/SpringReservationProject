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
    <link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR:wght@400;600&display=swap" rel="stylesheet">
    <!--부트스트랩 import-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    
    <!--jquery, underscore import ()-->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/underscore@1.13.6/underscore-umd-min.js"></script>
    <!--로컬 css 파일-->
    <link rel="stylesheet" href="/css/inc/main.css">
    <link rel="stylesheet" href='<tiles:getAsString name="includeCSS" />'>
    <!--로컬 js 파일-->
    <script type="text/javascript" src="/js/inc/main.js"></script>
    <script type="module" src='<tiles:getAsString name="includeJS" />'></script>
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