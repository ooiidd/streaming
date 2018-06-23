<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var = "ROOT" value = "${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>test</title>
</head>
<body>
	<video width="640" height="344" controls autoplay="autoplay">
	 <source src="${ROOT}/movie/sample.mp4" type="video/mp4">
	
	Your
	</video>
	<p>${ROOT }</p>
</body>
</html>