<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var = "ROOT" value = "${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src="resources/js/control.js"></script>
<script type="text/javascript" src="resources/js/control2.js"></script>
<script type="text/javascript" src="resources/js/control3.js"></script>

<link rel="stylesheet" href="resources/css/volume.css">
<link rel="stylesheet" href="resources/css/contents.css">

<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>test</title>
</head>
<body>

	<input style="position: relavive; left: 0px; top: 0px;" type="button" value="Bigger" onclick="changePlayerSize('L')">
	<input style="position: relative; left: 0px; top: 0px;" type="button" value="Smaller" onclick="changePlayerSize('S')">
	<input style="position: relative; left: 0px; top: 0px;" type="button" value="Back" onclick="changePlayerSize('M')">

	<video id="video2" controls class="all" autoplay="false" height="400" width="800"
		style="position: absolute; left: 0px; top: 30px; cursor: pointer; cursor: hand; border: 0; z-index:1;"
		 onloadeddata="loaddata()"
		onplay="video_playing()" loop
		controls>
	 <source src="${ROOT}/movie/gamevideo.mp4" type="video/mp4">
	</video>
	
	<video id="video1" height="260" width="200" autoplay="false" controls class="all"
		style="position: absolute; left: 0px; top: 50px; cursor: pointer; cursor: hand; border: 0; z-index:2;"
		onmousedown="startDrag(event, this)" onloadeddata="loaddata()" loop
		controls oncanplay="test()" >
	 <source src="${ROOT}/movie/chat.mp4" type="video/mp4">
	</video>
	
	<input style="position: absolute; left: 0px; top: 500px;" type="range" id="v1" value="100" max="100" onchange="change_range(this.value)"/><p style="position: absolute; left: 0px; top: 500px;" id="p1">100</p>
	<input style="position: absolute; left: 210px; top: 500px;" type="range" id="v2" value="100" max="100" onchange="change_range(this.value)"/><p style="position: absolute; left: 210px; top: 500px;" id="p2">100</p>
	<input style="position: absolute; left: 420px; top: 500px;" type="range" id="v3" value="100" max="100" onchange="change_range(this.value)"/><p style="position: absolute; left: 420px; top: 500px;" id="p3">100</p>
	<audio id="voice1" class="all" autoplay="false" loop>
		<source src="${ROOT }/audio/voice1.mp3" type="audio/mpeg">
	</audio>
	<audio id="voice2" class="all" autoplay="false" loop>
		<source src="${ROOT }/audio/voice2.mp3" type="audio/mpeg">
	</audio>
	<audio id="audio" class="all" autoplay="false" loop>
		<source src="${ROOT }/audio/audio.mp3" type="audio/mpeg">
	</audio>
	<p>${ROOT }</p>
	
<script type="text/javascript" src="resources/js/listener.js"></script>
</body>
</html>