/**
 * 
 */

var clickCount_L = 0;
var clickCount_S = 0;

function changePlayerSize(size) {

	var v1 = document.getElementById("video1");
	
	if (size == 'L') {
		clickCount_L = clickCount_L + 1;
		v1.style.width = 200 + (clickCount_L * 2) + 'px';
		v1.style.height = 260 + (clickCount_L * 2) + 'px';

	} else if (size == 'S') {

		clickCount_S = clickCount_S + 1;
		v1.style.width = 200 - (clickCount_S * 2) + 'px';
		v1.style.height = 260 - (clickCount_S * 2) + 'px';
	}

	else {

		clickCount_L = 0;
		clickCount_S = 0;
		
		v1.style.width = "200px";
		v1.style.height = "260px";
		
	}
}
