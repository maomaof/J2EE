const tag = "[nodelib/CPlay.js_v0.54]";

function CPlay (){
    var f = 2;
    var x = 50;
    var y = 50;
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
        ctx.fillRect(50,50,x,y);
        ctx.fillText( tag, x,y);
    };
    this.toCtxMousedown = function(_x,_y){
        x = _x;
        y = _y;
    }
    blo0.regCtxMousedown(this);
}

blo0.p = new CPlay();   
 