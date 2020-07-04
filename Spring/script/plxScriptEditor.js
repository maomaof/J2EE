var d = bl$( "id_mdiv_plx_script_editor" );
d.tb = blo0.blDiv(d, d.id + "tb", "[v0.0. 52 ]", blGrey[0]);

d.tb.b1 		= blo0.blBtn(d.tb, d.tb.id+ "b1", "b1", blGrey[2]); 
d.tb.b2 		= blo0.blBtn(d.tb, d.tb.id+ "b2", "b2", blGrey[2]); 
d.tb.b3_upload 		= blo0.blBtn(d.tb, d.tb.id+ "b3", "b3_uploadFile", blGrey[2]); 
d.tb.b4_uploadJson 	= blo0.blBtn(d.tb, d.tb.id+ "b4", "b4_uploadJson", blGrey[2]); 

d.tb.b1.onclick = function(){
	if(!d.v0){
		d.v0 = blo0.blDiv(d, d.id + "v0", "v0", blGrey[1]);
		var btnV1 = blo0.blBtn(d.v0, d.v0.id+ "b1", "gh.V1", blGrey[2]);
		var btnV2 = blo0.blBtn(d.v0, d.v0.id+ "b2", "gh.V2", blGrey[2]);
		var btnV3 = blo0.blBtn(d.v0, d.v0.id+ "b3", "lh.V1", blGrey[2]);
		var btnV4 = blo0.blBtn(d.v0, d.v0.id+ "b4", "lh.V2", blGrey[2]);
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
	}
	_on_off_div(this,d.v0);
	var b=this; b.style.background = b.style.background=="red"?blGrey[5]:blColor[4];      
}

d.tb.b2.onclick = function(){
	if(!d.v2){
		d.v2 = blo0.blDiv(d, d.id + "v2", "v2", blGrey[1]); 
		var b1 = blo0.blBtn(d.v2, d.v2.id+ "b1", "b1", blGrey[2]);
		var v = blo0.blDiv(d.v2, d.v2.id + "v", "v", blGrey[1]); 		 
	
		b1.onclick = function(){ 
			var w = {};
			w._2do = function(txt){ v.innerHTML = txt;}
			blo0.blAjx(w, "http://localhost:8080/image/video?script=v1.json" );
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
			    alert(this.responseText);
			  }	
			});
			xhr.open("POST", "http://localhost:8080/json?filename=v3.json");
			xhr.setRequestHeader("Content-Type", "text/plain");
			xhr.send(data);
		}
	}
	_on_off_div(this,d.v4);
	var b=this; b.style.background = b.style.background=="red"?blGrey[5]:blColor[4];      
}