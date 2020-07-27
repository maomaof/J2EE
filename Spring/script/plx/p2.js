 
const tag = "[plx/p2.js_v0.54]";
const b = bl$("plx_p2_btn"); 
b.v = blo0.blMDiv(b.parentElement,tag,tag,234,88,55,55,blGrey[0]);
if(!b.v.parent){
    b.v.parent = bl$("id_mdiv_load_plxMng");
    b.v.parent.list.push(b.v);
    
    b.v.tellMe = function(_o){
        b.v.o = _o;
        //b.v.tb.b1.onclick();
    }
    b.v.parent.listDivFrameMsg.push(b.v);
    b.v.showFrame = function(_f){ 
        var dd = bl$("id_4_plx2_dbg2"); 
        dd.innerHTML = _f;
    }
}
b.v.style.width = "300px";
b.v.tb = blo0.blDiv(b.v,b.v.id+"tb","tb",blGrey[0]);

//*
var s = '<video id="myVideo" width="180" height="120" controls>';
s+= '<source src="1.mp3" type="video/mp4">';
s+='Your browser does not support HTML5 video. '
s+='</video>';
//*/

b.v.v1 = blo0.blDiv(b.v,b.v.id+"v1",s,blGrey[1]);
b.v.v2 = blo0.blDiv(b.v,"id_4_plx2_dbg2","v2",blGrey[2]);
 

b.v.tb.b1 = blo0.blBtn(b.v.tb,b.v.tb.id+"b1","b1",blGrey[2]);
b.v.tb.b1.onclick = function(){
    _on_off_div(null,b.v.v2);
}  


_on_off_div(b,b.v);
b.style.background = b.style.background=="red"?blGrey[5]:blColor[4];   