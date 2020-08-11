const tag = "[plxScriptEditor.js_v0.0.234]";
var d = bl$( "id_mdiv_plx_script_editor" );
d.tb = blo0.blDiv(d, d.id + "tb", tag, blGrey[0]);

d.tb.b1 		= blo0.blBtn(d.tb, d.tb.id+ "b1", "b1", blGrey[2]); 
d.tb.b2 		= blo0.blBtn(d.tb, d.tb.id+ "b2", "b2", blGrey[2]); 
d.tb.b3_upload 		= blo0.blBtn(d.tb, d.tb.id+ "b3", "b3_uploadFile", blGrey[2]); 
d.tb.b4_uploadJson 	= blo0.blBtn(d.tb, d.tb.id+ "b4", "b4_uploadJson", blGrey[2]); 

d.tb.btnTestMyInit 	= blo0.blBtn(d.tb, d.tb.id+ "btnTestMyInit", "btnTestMyInit", blGrey[2]); 
d.tb.btnTestMyInit.onclick = function(){
	if(!this.v)
	{
		this.v = blo0.blMDiv(this.parentElement,this.parentElement.id+"v","blo0.TestMyInit",511,1,222,111,blGrey[0]);
		this.v.tb = blo0.blDiv(this.v, this.v.id+"tb","tb",blGrey[1]);
		this.v.v = blo0.blDiv(this.v, this.v.id+"v","v",blGrey[2]);
		var b1 = blo0.blBtn(this.v.tb,this.v.tb.id+"b1","b1",blGrey[2]);
		b1.onclick = function(){
			blo0.checkMyInit();
		}
		var b2 = blo0.blBtn(this.v.tb,this.v.tb.id+"b2","b2_reg",blGrey[2]);
		b2.onclick = function(_v){
			return function(){
				blo0.regCtxMousedown(_v);
			}
		}(this.v);

		var b3 = blo0.blBtn(this.v.tb,this.v.tb.id+"b3","b3_regTest",blGrey[2]);
		b3.onclick = function(_v){
			return function(){
				blo0.toCtxMousedown();
			}
		}(this.v);

		this.v.toCtxMousedown = function(_v){
			return function(x,y){
				_v.v.innerHTML = "[" + x+ ","+y+"] "+Date();
			} 
		}(this.v);
	}
	_on_off_div(this,this.v);
	var b=this; b.style.background = b.style.background=="red"?blGrey[5]:blColor[4];  
}
d.tb.b1.onclick = function(){
	if(!d.v0){
		d.v0 = blo0.blDiv(d, d.id + "v0", "v0", blGrey[1]);
		var btnV1 = blo0.blBtn(d.v0, d.v0.id+ "b1", "gh.V1", blGrey[2]);
		var btnV2 = blo0.blBtn(d.v0, d.v0.id+ "b2", "gh.V2", blGrey[2]);
		var btnV3 = blo0.blBtn(d.v0, d.v0.id+ "b3", "lh.V1", blGrey[2]);
		var btnV4 = blo0.blBtn(d.v0, d.v0.id+ "b4", "lh.V2", blGrey[2]);
		var btnPlx1 = blo0.blBtn(d.v0, d.v0.id+ "b5", "plx1", blGrey[2]);
		var btnPlx2 = blo0.blBtn(d.v0, d.v0.id+ "b6", "plx2", blGrey[2]);
		var v = blo0.blDiv(d.v0, d.v0.id + "v", "", blGrey[1]); 
		var ta = blo0.blTextarea(v, "id_ta_4_script_editor" , "xd", blGrey[2]);  
		ta.style.width = "98%";
		ta.style.height = "300px";

		var _loadUrl_2_Ta =  function(_ta,_url){
			var w = {};	w._2do = function(txt){				_ta.value = txt;			}
			blo0.blAjx(w, _url );
		}	
		btnV1.onclick = function(){ _loadUrl_2_Ta (ta,"https://littleflute.github.io/J2EE/Spring/script/v1.json");		}
		btnV2.onclick = function(){ _loadUrl_2_Ta (ta,"https://littleflute.github.io/J2EE/Spring/script/v2.json");	}	
		btnV3.onclick = function(){ _loadUrl_2_Ta (ta,"http://localhost:8080/v1.json");		}
		btnV4.onclick = function(){ _loadUrl_2_Ta (ta,"http://localhost:8080/v2.json");	}
		btnPlx1.onclick = function(){
			if(!btnPlx1.v)
			{
				btnPlx1.v = blo0.blMDiv(d.v0,"id_div_4_Plx1","plx1.v0.13",200,100,800,600,blGrey[0]);
				//blo0.blScript( "id_js_plx1_script_editor" ,"plx1.js");
				var w = {};	w._2do = function(txt){		eval(txt);}
				blo0.blAjx(w, "plx1.js" );

			} 
			_on_off_div(this,btnPlx1.v);
			var b=this; b.style.background = b.style.background=="red"?blGrey[5]:blColor[4];   
		}			 
		btnPlx2.onclick = function(){ 
				if(!this.player){
					var sss = '<video id="vPlayer" width="180" height="1" controls>';
					sss+= '<source src="1.mp3" type="video/mp4">';
					sss+='Your browser does not support HTML5 video. '
					sss+='</video>';
					this.vPlayer = blo0.blDiv(this.parentElement,this.parentElement.id+"vPlayer",sss,"lightblue");
				}

				var v = blo0.frameMD();
				var b = this;
				_on_off_div(b,v);
				b.style.background = b.style.background=="red"?blGrey[5]:blColor[4];   
		}
	}
	_on_off_div(this,d.v0);
	var b=this; b.style.background = b.style.background=="red"?blGrey[5]:blColor[4];      
}

d.tb.b2.onclick = function(){
	if(!d.v2){
		d.v2 = blo0.blDiv(d, d.id + "v2", "jsonFiles", blGrey[1]); 
		var b1 = blo0.blBtn(d.v2, d.v2.id+ "b1", "getAllJsonFiles", blGrey[2]);
		var v = blo0.blDiv(d.v2, d.v2.id + "v", "v", blGrey[5]); 	
		var v0 = blo0.blDiv(v, v.id + "v0", "v0", blGrey[0]);  
		var v1 = blo0.blDiv(v, v.id + "v1", "v1", blGrey[1]);	
		var v2 = blo0.blDiv(v, v.id + "v2", "v2", blGrey[2]);  
	
		b1.onclick = function(){ 
			var w = {};
			w._2do = function(txt){ 
				v0.innerHTML = "";
				//*
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
				} //*/
			}
			blo0.blAjx(w, "http://localhost:8080/getResourceOnServer?filetype=json" ); 
		}
	}
	_on_off_div(this,d.v2);
	var b=this; b.style.background = b.style.background=="red"?blGrey[5]:blColor[4];      
}

d.tb.b3_upload.onclick = function(){
	if(!d.v3){
		d.v3 = blo0.blDiv(d, d.id + "v3", "v3", blGrey[1]); 
		var b1 = blo0.blBtn(d.v3, d.v3.id+ "b1", "b1", blGrey[2]);
		var v = blo0.blDiv(d.v3, d.v3.id + "v", "v", blGrey[1]); 		 
	
		b1.onclick = function(){ 
			var w = {};
			w._2do = function(txt){ v.innerHTML = txt;}
			blo0.blAjx(w, "http://localhost:8080/uploadpage" );
		}
	}
	_on_off_div(this,d.v3);
	var b=this; b.style.background = b.style.background=="red"?blGrey[5]:blColor[4];      
}
d.tb.b4_uploadJson.onclick = function(){
	if(!d.v4){
		d.v4 = blo0.blDiv(d, d.id + "v4", "v4", blGrey[1]); 
		var b1 = blo0.blBtn(d.v4, d.v4.id+ "b1", "b1", blGrey[2]);
		var v = blo0.blDiv(d.v4, d.v4.id + "v", "v", blGrey[1]); 		 
	
		b1.onclick = function(){ 
			var data = bl$("id_ta_4_script_editor" ).value;
			var xhr = new XMLHttpRequest();
			xhr.withCredentials = true;
			xhr.addEventListener("readystatechange", function() {
			  if(this.readyState === 4) {
			    v.innerHTML = this.responseText;
			  }	
			});
			xhr.open("POST", "http://localhost:8080/json?fileName=v3.json");
			xhr.setRequestHeader("Content-Type", "text/plain");
			xhr.send(data);
		}
	}
	_on_off_div(this,d.v4);
	var b=this; b.style.background = b.style.background=="red"?blGrey[5]:blColor[4];      
}
