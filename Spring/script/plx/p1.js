
const tag = "[plx/p1.js_v0.54]";
const b = bl$("plx_p1_btn");
b.v = blo0.blMDiv(b.parentElement,b.id+tag,tag,10,88,55,150,blGrey[0]);
if(!b.v.parent){
    b.v.parent = bl$("id_mdiv_load_plxMng");
    b.v.parent.list.push(b.v);
    b.v.tellMe = function(_o){
        b.v.o = _o;
        b.v.tb.b1.onclick();
    }
}
b.v.style.width = "300px";
b.v.tb = blo0.blDiv(b.v,b.v.id+"tb","tb",blGrey[0]);
b.v.v1 = blo0.blDiv(b.v,b.v.id+"v1","v1",blGrey[1]);
b.v.v2 = blo0.blDiv(b.v,b.v.id+"v2","v2",blGrey[2]);
 

b.v.tb.b1 = blo0.blBtn(b.v.tb,b.v.tb.id+"b1","b1",blGrey[2]);
b.v.tb.b1.onclick = function(){
    if(b.v.o){ 
        blo0.ShowSprite2Div(b.v.v2,b.v.o);
    }
}
 

_on_off_div(b,b.v);
b.style.background = b.style.background=="red"?blGrey[5]:blColor[4];   