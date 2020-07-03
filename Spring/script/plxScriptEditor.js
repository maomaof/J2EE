var d = bl$( "id_mdiv_plx_script_editor" );
d.tb = blo0.blDiv(d, d.id + "tb", "[v0.0. 31 ]", blGrey[0]);

d.tb.b1 = blo0.blBtn(d.tb, d.tb.id+ "b1", "b1", blGrey[2]); 
d.tb.b2 = blo0.blBtn(d.tb, d.tb.id+ "b2", "b2", blGrey[2]); 

d.tb.b1.onclick = function(){
	if(!d.v0){
		d.v0 = blo0.blDiv(d, d.id + "v0", "v0", blGrey[1]);
		var btnV1 = blo0.blBtn(d.v0, d.v0.id+ "b1", "V1", blGrey[2]);
		var btnM1 = blo0.blBtn(d.v0, d.v0.id+ "b1", "M1", blGrey[2]);
		var v = blo0.blDiv(d.v0, d.v0.id + "v", "", blGrey[1]); 
		var ta = blo0.blTextarea(v, v.id + "ta", "xd", blGrey[2]);  
		ta.style.width = "98%";
		ta.style.height = "300px";
	
		btnV1.onclick = function(){
			var w = {};
			w._2do = function(txt){
				ta.value = txt;
			}
			var urlLrc = "http://localhost:8080/v1.json"
			blo0.blAjx(w,urlLrc);
		}		 
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
