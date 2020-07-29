const tag = "[nodelib/CPlay.js_v0.55]";

function CPlay (){
    var f = 2;
    var x = 10;
    var y = 10;
    var w = 50;
    var h = 50;
    this.getCurFameNO = function(){
        return f;
    };
    this.toPlay = function(){
        //alert("play...");
    };
    this.toStop = function(){
        //alert("stop...");
    };
    
    this.toShowCurFrame = function(ctx){    
        ctx.fillStyle = "red";
        ctx.font = "20px Arial";
        ctx.fillRect(x,y,w,h);
        ctx.fillText( tag, x,y);
    };
    this.toCtxMousedown = function(_x,_y){
        x = _x;
        y = _y;
    }
    blo0.regCtxMousedown(this);
}

blo0.p = new CPlay();   
 