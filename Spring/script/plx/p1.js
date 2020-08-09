
const tag = "[plx/p1.js_v0.121]";
const b = bl$("plx_p1_btn");
if(b){
    b.v = blo0.blMD(b.id+tag,tag,210,88,155,150,blGrey[0]);
    b.onclick = function(){
        _on_off_div(b,b.v);
        b.style.background = b.style.background=="red"?blGrey[5]:blColor[4];   
    } 
    b.onclick();
}