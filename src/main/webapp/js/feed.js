function send(action){
	document.forms[0].action = action;
	document.forms[0].submit();
}
function nowTime(){
	now = new Date();
	document.all.clock.value = now.toLocaleString();
	window.setTimeout("nowTime()", 1000);
}