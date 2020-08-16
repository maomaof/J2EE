
const p1Tag = "[plx/p1.js_v0.154]";
const btn4p1 = bl$("plx_p1_btn");
if(btn4p1){ 
    btn4p1.v = blo0.blMD(btn4p1.id+p1Tag,p1Tag,210,88,555,150,blGrey[0]);
    var tb = blo0.blDiv(btn4p1.v,btn4p1.v.id+"tb","tb",blGrey[1]);
    tb.btnStoryBoard = blo0.blBtn(tb,tb.id+"btnStoryBoard","storyBoard",blGrey[2]);
    tb.btnStoryBoard.style.float = "left";
    tb.btnStoryBoard.onclick = function(){
       if(!this.sb)  this.sb = new CStoryBoard(btn4p1.v);
       this.sb.show(this);
    }
    
    btn4p1.onclick = function(){
        var b = this;
        _on_off_div(b,b.v);
        b.style.background = b.style.background=="red"?blGrey[5]:blColor[4];   
    } 
    btn4p1.onclick();
}
 
function CStoryBoard(parentDiv){

    var v = "CStoryBoard v0.12";
    var ui = null;
    var p = parentDiv; 
    var o = {};
    o.uiCards = function(_p,_c){  
        _p.style.overflow = "auto";        
        var cardV = blo0.blDiv(_p,_p.id+"cardV","cardV",blGrey[2]);
        cardV.style.width = 20*111 +"px";
        cardV.style.height = "50px";
        cardV.style.backgroundColor = "coral";
        cardV.style.float = "left";
    };
    o.uiColum = function(ui){           
        var s = '<div class="w3-col s3 w3-green w3-center"><p>s6</p></div>';
        s+='<div class="w3-col s9 w3-dark-grey w3-center" id="uiRight">   </div>';
        var v1 = blo0.blDiv(ui,ui.id+"v1",s,blGrey[2]);
       
        o.addClass(v1,"w3-row"); 
        var r = bl$("uiRight");  
        o.uiCards(r,"red");  
    };
    o.addClass = function (d,cn) {        d.classList.add(cn);    };
      
     
    this.show = function(b){
        if(!ui){
            ui=blo0.blDiv(p,p.id+"_StoryBoard",v,blGrey[1]);   
            o.addClass(ui,"w3-row");  
            o.addClass(ui,"w3-red");

            o.uiColum(ui);   
        }
        _on_off_div(b,ui);
        b.style.background = b.style.background=="red"?blGrey[5]:blColor[4];   
    }; 
} 

function CClient(){
    var w = {};
    this.exeCmd = function(v0,v1,v2){
        var ta = bl$("id_ta_4_script_editor");
        if(!ta) v0.innerHTML = "No ta.";
        else{
            ta.value = "exeCmd" + Date();
            var btnRun = blo0.blBtn(v1, v1.id+ "btnRun", "run", "green");
            btnRun.onclick = function(){                    
                w._2do = function(txt){ 
                    v0.innerHTML = txt;        
                } 
                blo0.blAjx(w, "http://localhost:8080/command?cmd="+ta.value ); 
            }
        }
    };
    this.getJSFiles = function(v0,v1,v2){
			w._2do = function(txt){ 
				v0.innerHTML = ""; 
				eval("var o=" + txt);
				for(i in o.resource){
					var b = blo0.blBtn(v0,v0.id+i,i,blGrey[2]);
					b.onclick = function(_this,_jsf){						
						return function(){
							 v1.innerHTML = _this.id;
							 var btnMP4 = blo0.blBtn(v1, v1.id+ "b1", "createMP4", blGrey[2]);
							 v2.innerHTML = _jsf;
							 var vMP4 = blo0.blDiv(v2, v2.id + "vMP4", "vMP4", blGrey[2]);  

							 btnMP4.onclick = function(){
								var url = "http://localhost:8080/image/video?script="+_jsf; 
								var w1 = {};
								w1._2do = function(txt){ 
									vMP4.innerHTML = txt;	
								}
								blo0.blAjx(w1,url);							
							}
						}
					}(b,o.resource[i]);					
				}  
			}
			blo0.blAjx(w, "http://localhost:8080/getResourceOnServer?filetype=json" ); 
    };
    
    this.getMp3Files = function(v0){
        w._2do = function(txt){ 
            eval("var o=" + txt);
            v0.innerHTML = "";
            for(i in o.resource){
                var b = blo0.blBtn(v0,v0.id+i,i,blGrey[2]);
                b.onclick = function(_this,_r){						
                    return function(){
                         alert(_r);                          
                    }
                }(b,o.resource[i]);	                		
            }  
        }
        blo0.blAjx(w, "http://localhost:8080/getResourceOnServer?filetype=mp3" ); 
    };
}
