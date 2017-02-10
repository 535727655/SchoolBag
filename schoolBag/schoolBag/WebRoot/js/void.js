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


