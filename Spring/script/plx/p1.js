 
   var _blShowObj2Div = function (oBoss,obj)
    {                 
        oBoss.innerHTML = "";
        for(i in obj)
		{ 
            if (typeof obj[i] == "function"){
                if("test"==i){
                    var b = document.createElement("button");
                      b.id = b.innerHTML = i;
                      b.style.backgroundColor = "gray";              
                      oBoss.appendChild(b); 
                      b.onclick = function(_go,_o,_oBass){
                          return function(){
                            _go(_o,_oBass);
                          }
                      }(obj[i],obj,oBoss);
                } 
            } 
            else{
                var b = document.createElement("button");
                  b.id = b.innerHTML = i;
                  b.style.backgroundColor = "gray";              
                  oBoss.appendChild(b); 
    
                var d = document.createElement("button");
                  d.innerHTML = obj[i];
                  d.style.border = "blue 1px solid";
                  d.style.backgroundColor = "green";
                  d.style.color = "yellow";
                  oBoss.appendChild(d);         
            }    
		}
    }    

const tag = "[plx/p1.js_v0.53]";
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
        _blShowObj2Div(b.v.v2,b.v.o);
    }
}
 

_on_off_div(b,b.v);
b.style.background = b.style.background=="red"?blGrey[5]:blColor[4];   