var check_load=[2];
for(i in check_load){
	i = false;
}
//음성3개 게임소리 내소리 같이하는사람소리 비디오2개 게임화면 채팅화면
function test(){
	console.log("test");
}
function video_playing(){
	var all=document.getElementsByClassName('all');
	console.log("video_playing");
	for(var i=0;i<$('.all').length;i++){
		var d = new Date();
		//$('.all')[i].prop('currentTime',d.getSeconds()%30);
		console.log(all[i].currentTime);
		all[i].currentTime = d.getSeconds()%30;
		//console.log(($('.all')[i]).attr("id"));
		//$('.all')[i].play();
	}
}
function bufferring(){
	console.log("bufferring");
	for(var i=0;i<$('.all').length;i++){
		console.log($('.all')[i]);
		console.log("tq");
		$('.all')[i].pause();
	}
}
function change_range(value){
	console.log(value);
	console.log(event.target.id);
	switch(event.target.id){
	case "v1":
		var volume = Number(value)/100;
		console.log(volume);
		$('#voice1').prop("volume",volume);
		$('#p1').text(value);
		break;
	case "v2":
		var volume = Number(value)/100;
		console.log(volume);
		$('#voice2').prop("volume",volume);
		$('#p2').text(value);
		break;
	case "v3":
		var volume = Number(value)/100;
		console.log(volume);
		$('#audio').prop("volume",volume);
		$('#p3').text(value);
		break;
	}
}
