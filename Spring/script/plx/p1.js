
const p1Tag = "[plx/p1.js_v0.151]";
const btn4p1 = bl$("plx_p1_btn");
if(btn4p1){ 
    btn4p1.v = blo0.blMD(btn4p1.id+p1Tag,p1Tag,210,88,155,150,blGrey[0]);
    btn4p1.onclick = function(){
        var b = this;
        _on_off_div(b,b.v);
        b.style.background = b.style.background=="red"?blGrey[5]:blColor[4];   
    } 
    btn4p1.onclick();
}

function CClient(){
    var w = {};
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