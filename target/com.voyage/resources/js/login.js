//获取元素距离页面边缘的距离
function getOffset(box,direction){
	
	var setDirection =  (direction == 'top') ? 'offsetTop' : 'offsetLeft' ;
	
	var offset =  box[setDirection];
	
	var parentBox = box.offsetParent;
	while(parentBox){
		
		offset+=parentBox[setDirection];
		parentBox = parentBox.offsetParent;
	}
	parentBox = null;
	
	return parseInt(offset);
}

function moveCode(code){

	var fn = {codeVluae : code};

	var box = document.querySelector("#code-box"),
			progress = box.querySelector("p"),
			codeInput = box.querySelector('.code-input'),
			evenBox = box.querySelector("span");

	//默认事件
	var boxEven = ['mousedown','mousemove','mouseup'];
	//改变手机端与pc事件类型
	if(typeof document.ontouchstart == 'object'){

		boxEven = ['touchstart','touchmove','touchend'];
	}

	var goX,offsetLeft,deviation,evenWidth,endX;

	function moveFn(e){

		e.preventDefault();
		e = (boxEven['0'] == 'touchstart') ? e.touches[0] : e || window.event;
		
		
		endX = e.clientX - goX;
		endX = (endX > 0) ? (endX > evenWidth) ? evenWidth : endX : 0;
	
		if(endX > evenWidth * 0.7){
			
			progress.innerText = '松开验证';
			progress.style.backgroundColor = "#66CC66";
		}else{
			
			progress.innerText = '';
			progress.style.backgroundColor = "#FFFF99";
		}

		progress.style.width = endX+deviation+'px';
		evenBox.style.left = endX+'px';
	}

	function removeFn() {

		document.removeEventListener(boxEven['2'],removeFn,false);
		document.removeEventListener(boxEven['1'],moveFn,false);

		if(endX > evenWidth * 0.7){
			
			progress.innerText = '验证成功';
			progress.style.width = evenWidth+deviation+'px';
			evenBox.style.left = evenWidth+'px'
			
			codeInput.value = fn.codeVluae;
			evenBox.onmousedown = null;
		}else{

			progress.style.width = '0px';
			evenBox.style.left = '0px';
		}
	}

	evenBox.addEventListener(boxEven['0'], function(e) {

		e = (boxEven['0'] == 'touchstart') ? e.touches[0] : e || window.event;

			goX = e.clientX,
				offsetLeft = getOffset(box,'left'),
				deviation = this.clientWidth,
				evenWidth = box.clientWidth - deviation,
				endX;

		document.addEventListener(boxEven['1'],moveFn,false);

		document.addEventListener(boxEven['2'],removeFn,false);
	},false);
	
	fn.setCode = function(code){

		if(code)
			fn.codeVluae = code;
	}

	fn.getCode = function(){

		return fn.codeVluae;
	}

	fn.resetCode = function(){

		evenBox.removeAttribute('style');
		progress.removeAttribute('style');
		codeInput.value = '';
	};

	return fn;
}