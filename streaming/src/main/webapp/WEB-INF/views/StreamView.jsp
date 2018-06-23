<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var = "ROOT" value = "${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="resources/js/control.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>test</title>
</head>
<body>
	<video height="322" width="644" controls autoplay="autoplay" id="video1"
		style="position: absolute; left: 0px; top: 50px; cursor: pointer; cursor: hand; border: 0"
		onmousedown="startDrag(event, this)"
		controls autoplay loop>
	 <source src="${ROOT}/movie/sample.mp4" type="video/mp4">
	</video>
	
	<video  controls autoplay="autoplay" id="video2"
		style="position: absolute; left: 100px; top: 100px; cursor: pointer; cursor: hand; border: 0"
		
		controls autoplay loo>
	 <source src="${ROOT}/movie/sample2.mp4" type="video/mp4">
	</video>
	<p>${ROOT }</p>
</body>
</html>h