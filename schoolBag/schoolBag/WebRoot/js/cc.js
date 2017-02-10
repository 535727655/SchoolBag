window.onscroll=function(){
 if ($(document).scrollTop() > 250)
 {
  //$("#pf_nav").show();
  $("#alt").addClass('float');
 }else{
  //$("#pf_nav").hide();
  $("#alt").removeClass('float');
 }
}
  function addEventLoad(func){
    var oldonload = window.onload;
    if(typeof(window.onload) != 'funciton'){
     window.onload = func;
    }
    else {
     window.onload = function(){
      oldonload();
      func();
     }
    }
   }
  //初始化小图片及图片标题样式
  function classNormal(picbtn,pictxt){
   var picbtns = document.getElementById(picbtn).getElementsByTagName("li");
   var pictxts = document.getElementById(pictxt).getElementsByTagName("li");
   for(var i = 0; i < picbtns.length; i++){
    picbtns[i].className = "normal";
    pictxts[i].className = "normal";
   } 
  }
  //当前显示的小图片及图片标题样式
  function classCurrent(picbtn,pictxt,n){
   var picbtns = document.getElementById("picbtn").getElementsByTagName("li");
   var pictxts = document.getElementById("pictxt").getElementsByTagName("li");
   picbtns[n].className = "current";
   pictxts[n].className = "current";
  }
  //移动图片
  function movePic(pic,final_x,final_y,interval){
   var elem = document.getElementById("pic");
   var xpos = parseInt(elem.style.left);
   var ypos = parseInt(elem.style.top);
   if(elem.movement){
    clearTimeout(elem.movement);
   }
   if (!elem.style.left) {
       elem.style.left = "0px";
   }
   if (!elem.style.top) {
       elem.style.top = "0px";
   }
   if (xpos == final_x && ypos == final_y) {
       return true;
   }
  
   //直接将目标位置赋值给图片当前位置。也可以采用以下代码产生动画

  
   //以下代码：按间隔时间、平均移动的距离，缓慢移动图片到目标位置，产生动画效果
   var dist;
      if(xpos < final_x){
    dist = Math.ceil((final_x - xpos)/10);
    xpos += dist;
   }
   if(xpos > final_x){
    dist = Math.ceil((xpos - final_x)/10);
    xpos -= dist;
   }
   if(ypos < final_y){
    dist = Math.ceil((final_y - ypos)/10);
    ypos += dist;
   }
   if(ypos > final_y){
    dist = Math.ceil((ypos - final_y)/10);
    ypos -= dist;
   }
   elem.style.left = xpos + "px";
   elem.style.top = ypos + "px";
   var repeat = "movePic('" + pic + "'," + final_x + "," + final_y + "," + interval + ")";
   elem.movement = setTimeout(repeat,interval);          
  }
  //当鼠标移动到小图片上时切换图片
  function changePic(){
   if(!document.getElementById('picfocus')) return false;
   document.getElementById('picfocus').onmouseover = function(){autokey = true};
   document.getElementById('picfocus').onmouseout = function(){autokey = false};
   var picbtns = document.getElementById("picbtn").getElementsByTagName("li");  
   var picnums = picbtns.length;
   picbtns[0].onmouseover = function(){
    movePic('pic',0,0,5);
    classNormal('picbtn','pictxt');
    classCurrent('picbtn','pictxt',0);   
   }
   if(picnums >= 2){
    picbtns[1].onmouseover = function(){
    movePic('pic',0,-225,5);
    classNormal('picbtn','pictxt');
    classCurrent('picbtn','pictxt',1);   
       } 
   }
   if(picnums >= 3){
    picbtns[2].onmouseover = function(){
    movePic('pic',0,-450,5);
    classNormal('picbtn','pictxt');
    classCurrent('picbtn','pictxt',2);   
       } 
   }
   if(picnums >= 4){
    picbtns[3].onmouseover = function(){
    movePic('pic',0,-675,5);
    classNormal('picbtn','pictxt');
    classCurrent('picbtn','pictxt',3);   
       } 
   }
  }
  //自动切换图片
  var autokey = false;
  setInterval('autoChange()',5000);
  function autoChange(){
   if(autokey) return false;
   var picbtns = document.getElementById("picbtn").getElementsByTagName("li");
   var len = picbtns.length;
   for(var i = 0; i < len; i++){
   if(picbtns[i].className == "current"){
     var currentNum = i;
    }
   }
   if(currentNum == 0 && len >= 1){
    movePic('pic',0,-225,5);
    classNormal('picbtn','pictxt');
    classCurrent('picbtn','pictxt',1); 
   }
   if(currentNum == 1 && len >= 2){
    movePic('pic',0,-450,5);
    classNormal('picbtn','pictxt');
    classCurrent('picbtn','pictxt',2); 
   }
   if(currentNum == 2 && len >= 3){
    movePic('pic',0,-675,5);
    classNormal('picbtn','pictxt');
    classCurrent('picbtn','pictxt',3); 
   }
   if(currentNum == 3 && len >= 4){
    movePic('pic',0,0,5);
    classNormal('picbtn','pictxt');
    classCurrent('picbtn','pictxt',0); 
   }
  }
  addEventLoad(changePic);
  

window.onload=function(){  
backtime();  
}  
function backtime(){  
var str = '2016-08-20';   
str = str.replace(/-/g,'/');   
var d=new Date(str);  
var today=new Date();  
var time=d.getTime()-today.getTime();  

var 小时=Math.floor(time/(1000*60*60))%24;  
var 分=Math.floor(time/(1000*60))%60;  
var 秒=Math.floor(time/1000)%60;  
//var abcInner=document.createTextNode(天+'天'+小时+'小时'+分+'分'+秒+'秒');  
var 时间=document.getElementById('a');  
时间.innerHTML=小时+'小时'+分+'分'+秒+'秒';  

时间.style.fontSize='35px';  
时间.style.color='red';  

时间.style.borderColor='red';  
时间.style.padding='5px';  
时间.style.width='240px';  
时间.style.textAlign='center';  
时间.style.backgroundColor='#F6F6F6';  

  
}  
setInterval('backtime()',1000);  


var i=0;
	function blink(){
		document.getElementById("remaincolor").className="changecolor"+i%6;
		i++;
	}
	setInterval(blink, 500);
	

var j=0;
	function blin(){
		document.getElementById("remaincolor-first").className="changecolor"+j%6;
		j++;
	}
	setInterval(blin, 500);
	var k=0;
	function blint(){
		document.getElementById("remaincolor-two").className="changecolor"+k%6;
		k++;
	}
	setInterval(blint, 500);
	
	var t=0;
	function blind(){
		document.getElementById("remaincolor-third").className="changecolor"+t%6;
		t++;
	}
	setInterval(blind, 500);
	

