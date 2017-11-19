function changeFrameHeight(){ 
　　var ifm= document.getElementById("iframe_a"); 
　　ifm.height=document.documentElement.clientHeight; 
} 
window.onresize=function(){  
　　changeFrameHeight(); 
} 