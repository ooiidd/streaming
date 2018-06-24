

var load_cnt = 0;


function play(){
	console.log($('.all').length);
	console.log("play");
	if(load_cnt>1){
		for(var i=0;i<$('.all').length;i++){
			console.log($('.all')[i]);
			console.log("tq");
			$('.all')[i].play();
		}
	}
}
function loaddata(){
	var num = Number(event.target.id);
	load_cnt++;
	console.log("loaddata");
	if(load_cnt > 1){
		play();
	}
}
var video = document.getElementById('video2');
console.log(video);
video.addEventListener('click',play());