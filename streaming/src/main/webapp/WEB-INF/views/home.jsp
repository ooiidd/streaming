<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
<script type="text/javascript" src="resources/jquery-3.2.0.min.js"></script>

</head>
<body>


	<video src="resources/video/1234.mp4" id="video1"
		style="position: absolute; left: 0px; top: 50px; cursor: pointer; cursor: hand; border: 0"
		width="100px" height="100px" onmousedown="startDrag(event, this)"
		controls autoplay loop></video>

	<video src="resources/video/1234.mp4" id="video2"
		style="position: absolute; left: 100px; top: 100px; cursor: pointer; cursor: hand; border: 0"
		width="100px" height="100px" onmousedown="startDrag(event, this)"
		controls autoplay loop></video>

	<input type="button" value="Bigger" onclick="changeImageSize('L')">
	<input type="button" value="Smaller" onclick="changeImageSize('S')">
	<input type="button" value="Back" onclick="changeImageSize('M')">

	
</body>
</html>
