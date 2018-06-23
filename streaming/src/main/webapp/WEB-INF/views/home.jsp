<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
<script type="text/javascript" src="resources/jquery-3.2.0.min.js"></script>
<script type="text/javascript">
function changeImageSize(size) {

	alert("asdfasdf");
	var v1 = document.getElementById("video1");
	var v2 = document.getElementById("video2");
	var w = 2;
	var h = 2;
	
	if (size == 'L') {

		v1.style.width += w * 2;
		v1.style.height += h * 2;
		v2.style.width += w * 2;
		v2.style.height += h * 2;
	}
	else if (size == 'S') {

		v1.style.width -= w * 2;
		v1.style.height -= h * 2;
		v2.style.width -= w * 2;
		v2.style.height -= h * 2;
	}
	
	else{
		
		v1.style.width = 100px;
		v1.style.height = 100px;
		v2.style.width = 100px;
		v2.style.height = 100px;
		
	}
}

</script>
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

	<script type='text/javascript'>
		var img_L = 10;
		var img_T = 20;
		var targetObj;

		function getLeft(o) {
			return parseInt(o.style.left.replace('px', ''));
		}
		function getTop(o) {
			return parseInt(o.style.top.replace('px', ''));
		}

		function moveDrag(e) {
			var e_obj = window.event ? window.event : e;
			var dmvx = parseInt(e_obj.clientX + img_L);
			var dmvy = parseInt(e_obj.clientY + img_T);
			targetObj.style.left = dmvx + "px";
			targetObj.style.top = dmvy + "px";
			return false;
		}

		function startDrag(e, obj) {
			targetObj = obj;
			var e_obj = window.event ? window.event : e;
			img_L = getLeft(obj) - e_obj.clientX;
			img_T = getTop(obj) - e_obj.clientY;

			document.onmousemove = moveDrag;
			document.onmouseup = stopDrag;
			if (e_obj.preventDefault)
				e_obj.preventDefault();
		}

		function stopDrag() {
			document.onmousemove = null;
			document.onmouseup = null;
		}
		
	</script>

</body>
</html>
