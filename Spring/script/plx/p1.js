
const p1Tag = "[plx/p1.js_v0.221]";

const btn4p1 = bl$("plx_p1_btn");

if(btn4p1){ 
    btn4p1.v = blo0.blMD(btn4p1.id+p1Tag,p1Tag,210,11,555,150,blGrey[0]);
    var tb = blo0.blDiv(btn4p1.v,btn4p1.v.id+"tb","tb0",blGrey[1]);
    tb.btnStoryBoard = blo0.blBtn(tb,"btnStoryBoard","storyBoard",blGrey[2]);
    tb.btnStoryBoard.style.float = "left";
    
    tb.btnStoryBoard.onclick = function(){
       if(!this.sb)  this.sb = new CStoryBoard(btn4p1.v);
       this.sb.show(this);
    }
    
    tb.btnPlayground = blo0.blBtn(tb,"btnPlayground","Playground",blGrey[2]);
    tb.btnPlayground.style.float = "left";
    
    tb.btnPlayground.onclick = function(){
        if(!this.pg)  this.pg = new CPlayground(btn4p1.v);
        this.pg.show(this);
    }
    
    tb.btnServer = blo0.blBtn(tb,"btnServer","Server",blGrey[2]);
    tb.btnServer.style.float = "left";
    
    tb.btnServer.onclick = function(){
        if(!this.pg)  this.pg = new CServer(btn4p1.v);
        this.pg.show(this);
    }
    
    btn4p1.onclick = function(){
        var b = this;
        _on_off_div(b,b.v);
        b.style.background = b.style.background=="red"?blGrey[5]:blColor[4];   
    } 
    btn4p1.onclick();
}
 
function CServer(parentDiv){
    var p = parentDiv;
    var ui = null;
    var x = 0;
    var y = 220;
    var w = 500;
    var h = 50;
    
    this.show = function(b){ 
        if(!ui){
            ui=blo0.blMDiv(p,"id_mdiv_4_server","server",x,y,w,h,blGrey[0]);
            var tb = blo0.blDiv(ui, "id_4_tb_server","tb",blGrey[1]);
        }
        _on_off_div(b,ui);
        b.style.background = b.style.background=="red"?blGrey[5]:blColor[4];    
    }
}
function CPlayground(parentDiv){
    var p = parentDiv;
    var ui = null;
    var w = 360;
    var h = 240;
    var xDbg = 20;
    var yDbg = 111;
    var wDbg = 20;
    var hDbg = 20;
    var cDbg = "brown";


    this.show = function(b){
        if(!ui){
            ui=blo0.blMDiv(p,"id_mdiv_4_playground","playground",555,5,w,111,blGrey[0]);
            ui.inf = {};
            ui.inf.x = 0;
            ui.inf.y = 0;
                        
            ui.inf.text = "playground.text";     

            var tb = blo0.blDiv(ui, "id_4_tb_playground","tb",blGrey[1]);
            tb.btnPlay = blo0.blBtn(tb,"id_4_btnPlay","play",blGrey[2]);
            tb.btnPlay.style.float = "left";
            tb.btnPlay.onclick = function(){
                o.play(this);
            }
            tb.b1 = o.dbgBtn(tb,"id_btn_4_dbgPlayground","dbg");

            var vStatus = blo0.blDiv(ui,"id_4_vStatus","status::",blGrey[3]);   
            var v1 = blo0.blDiv(ui,ui.id+"v1","",blGrey[1]);          
                

            var cvs = document.createElement("canvas");
            cvs.width = w;
            cvs.height = h;
            cvs.style.backgroundColor = "grey";
            cvs.style.float = "left";

            v1.appendChild(cvs);
            
            cvs.addEventListener('mousedown', function (e) {
                var x = e.offsetX;
                var y = e.offsetY;
                o.mousedown(cvs.getContext("2d"),x,y);                
            });
            
            ui.mousedown = function(x,y){   
                if(!tb.b1.b) return;

                if(cDbg=="brown"){
                    if(o.inRect(x,y,xDbg,yDbg,wDbg,hDbg)){
                        cDbg = "yellow";
                        o.status(ui);
                    }
                }
                else if(cDbg=="yellow"){
                    cDbg = "brown";
                    xDbg =x;
                    yDbg = y;                    
                }
            }
            ui.draw = function(ctx){
                if(tb.b1.b)  {
                    o.rect(ctx,xDbg,yDbg,wDbg,hDbg,cDbg);    
                    o.text(ctx,ui.id,xDbg,yDbg);
                }   
            }
            o.reg2draw(ui);
            o.regMousedown(ui);

            var itv = setInterval(o.ftnTimer, 20,cvs.getContext("2d"),w,h);
        }
        _on_off_div(b,ui);
        b.style.background = b.style.background=="red"?blGrey[5]:blColor[4];   
    }; 
}
function CStoryBoard(parentDiv){

    var v = "CStoryBoard v0.12";
    var ui = null;
    var p = parentDiv; 
       
     
    this.show = function(b){
        if(!ui){           

            var xDbg = 11;
            var yDbg = 222;
            var wDbg = 20;
            var hDbg = 20;
            var cDbg = "lightgreen";
            
            ui=blo0.blDiv(p,p.id+"_StoryBoard",v,blGrey[1]);   
            ui.inf = {};
            ui.inf.x = 17809;
            ui.inf.y = 17809;
            ui.inf.text = "storyBoard.text";   

            var tb =blo0.blDiv(ui,"tb4StoryBoard","tb2",blGrey[1]);
            tb.b1 = o.dbgBtn(tb,"id_btn_4_StoryBoardDbg","dbg");
            tb.btnAddCard = blo0.blBtn(tb,"id_4_btnAddCard","+Card",blGrey[2]);
            tb.btnAddCard.style.float="left";
            tb.btnAddCard.onclick = function(){
                o.addCard(this);
            }
            

            o.addClass(ui,"w3-row");  
            o.addClass(ui,"w3-red");

            o.uiColum(ui);   

            ui.draw = function(ctx){
                if(tb.b1.b)       
                {
                    o.rect(ctx,xDbg,yDbg,wDbg,hDbg,cDbg);
                    o.text(ctx,ui.id,xDbg,yDbg);

                }  
            }
            ui.mousedown = function(x,y){   
                if(!tb.b1.b) return;

                if(cDbg=="lightgreen"){
                    if(o.inRect(x,y,xDbg,yDbg,wDbg,hDbg)){
                        cDbg = "yellow";
                        o.status(ui);
                    }
                }
                else if(cDbg=="yellow"){
                    cDbg = "lightgreen";
                    xDbg =x;
                    yDbg = y;
                }
            }
            o.regMousedown(ui);
            o.reg2draw(ui);
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

var o = {};
o.x = 50;
o.y = 30;
o.s = "o.s";
o.list2draw = [];
o.listMousedown = [];
o.listCards = [];
o.curCard = 0;

o.bPlay = false;
o.status = function(me){
    var d = bl$("id_4_vStatus");
    d.innerHTML = "";
    var vs = blo0.blMDiv(d,d.id+"vs","vs::",3,340,555,100,blGrey[0]); 
    var n = 0;
    //*
    for(i in me.inf){
        n++;
        var b = blo0.blBtn(vs,vs.id+"b" + n, i ,blGrey[1]);
        var bv = blo0.blBtn(vs,vs.id+"bv"+ n, me.inf[i] ,"lightgreen");
        b.style.float="left";
        bv.style.float="left";
        if(i=="text"){
            b.style.backgroundColor = "lightblue";
            b.onclick = function(_bv,_me,_i){
                var vta = blo0.blDiv(vs,vs.id+"vta","vta" ,"green");
                vta.innerHTML = "";
                return function(){
                   if(b.style.backgroundColor=="lightblue"){
                       b.style.backgroundColor="grey";
                       _bv.ta = blo0.blTextarea(vta,vta.id+"ta",_me.inf[_i],"grey");
                       _bv.ta.style.width= "100%";
                       ta.value = _bv.innerHTML;
                   }
                   else if(b.style.backgroundColor=="grey"){
                       b.style.backgroundColor="lightblue";
                       _bv.innerHTML = _bv.ta.value;
                       _me.inf[_i] = _bv.ta.value; 
                       vta.innerHTML = "";
                   }
                }
            }(bv,me,i);
        }
    }
    //*/
}
o.addCard= function(_ls){
    return function(btn){
        var n = _ls.length;
        var v=bl$("id_4_cardV");
        s = btn.id + ":" + n;
        var b = blo0.blBtn(v,v.id+"_"+n,n+1,"grey");
        b.style.float="left";
        b.No = n+1;
        b.onclick = function(_o,_this){
            return function(){
                _o.curCard = _this.No;
                for(i in _o.listCards){
                    if((_this.No-1)==i){
                        _o.listCards[i].style.backgroundColor = "yellow";
                    }
                    else{
                        _o.listCards[i].style.backgroundColor = "grey";
                    }
                }
            }
        }(o,b);
        _ls.push(b);
    }
}(o.listCards);

o.play = function(btn){
    if(o.bPlay){
        o.bPlay = false;
        btn.innerHTML = "play";
    }
    else{
        o.bPlay = true;
        btn.innerHTML = "stop";
    }
}
o.inRect = function(x,y,x0,y0,w,h){
    var b = false;
    if(x<x0 || x>(x0+w) || y<y0 || y>(y0+h)){
        b = false;
    }
    else{
        b = true;
    }
    return b;
}
o.draw = function(ctx){
    var s = "o.draw: " + o.bPlay ;
    s += " o.list2draw.length=" + o.list2draw.length;
    s += ": " + o.curCard + "/" + o.listCards.length;
    o.text(ctx,s,100,100);

    for(i in o.list2draw){
        o.list2draw[i].draw(ctx);
    }

}
o.reg2draw  = function(user){
    o.list2draw.push(user);
}
o.regMousedown = function(user){
    o.listMousedown.push(user);
}
o.dbgBtn = function(tb,id,html){
    var btn = blo0.blBtn(tb,id,html,"grey"); 
           
    btn.style.float = "left";
       
    btn.onclick = function(_tb){ 
        return function(){
                if("grey"==this.style.backgroundColor){
                    this.style.backgroundColor = "green";
                    this.b = true;
                }
                else{
                    this.style.backgroundColor = "grey";
                    this.b = false;
                }
            }
    }(tb); 
    return btn;            
}
o.mousedown = function(ctx,x,y){
    o.s = x + ":" + y;
    o.x = x;
    o.y = y;    
    for(i in o.listMousedown){
        o.listMousedown[i].mousedown(x,y);
    }
};
o.ftnTimer = function(ctx,w,h){ 
    ctx.clearRect(0, 0, w, h);
    
    ctx.fillStyle = "grey";
    ctx.fillRect(0,0,w,h);
 
    o.text(ctx,"xd--" + Date(),15,20);   

    o.draw(ctx);
};
o.text = function(ctx,txt,x,y){ 
    ctx.font= 12 + "px Comic Sans MS";
    ctx.fillStyle = "white";
    ctx.fillText(txt, x,y); 
};
o.rect = function(ctx,x,y,w,h,c){ 
    ctx.fillStyle = c;
    ctx.fillRect(x,y,w,h); 
};
    o.uiCards = function(_p,_c){  
        _p.style.overflow = "auto";        
        var cardV = blo0.blDiv(_p,"id_4_cardV","cardV",blGrey[2]);
        cardV.style.width = 20*111 +"px";
        cardV.style.height = "50px";
        cardV.style.backgroundColor = "lightblue";
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
      

    var b = bl$("btnStoryBoard");    
    o.addClass(b,"w3-button"); 
    o.addClass(b,"w3-blue"); 
 

    var b = bl$("btnPlayground");    
    o.addClass(b,"w3-button"); 
    o.addClass(b,"w3-green"); 

    var b = bl$("btnServer");    
    o.addClass(b,"w3-button"); 
    o.addClass(b,"w3-brown"); 