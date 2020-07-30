const tag = "[nodelib/CPlay.js_v0.124]";

function CPlay (){
    var c = "lightgreen";
    var fps = 30;
    var x = 10;
    var y = 10;
    var w = 50;
    var h = 50;
    var ms0 = 0;
    var dms = 0; 
    var o = {};
    o.getFrameNo = function(){
        var dt = 1000/fps;
        return dms/dt;
    }
    o.getMsg = function(){
        var s = tag +"_getMsg():";
        s+="["+x+","+y+"]";
        s+= " dms="+dms;
        s+= " fps=" + fps;
        s+= " FrameNo=" + o.getFrameNo();
        return s;
    }
    this.getCurFameNO = function(){
        return f;
    };
    this.toPlay = function(){
        var d = new Date();
        ms0 = d.getTime();
    };
    this.toStop = function(){
        //alert("stop...");
    };
    
    this.toShowCurFrame = function(ctx){    
        var dNow = new Date();
        dms = dNow.getTime() - ms0;
        ctx.fillStyle = c;
        ctx.font = "20px Arial";
        ctx.fillRect(x,y,w,h);
        ctx.fillText( o.getMsg(), x,y);
    };
    this.toCtxMousedown = function(_x,_y){
        x = _x;
        y = _y;
    }
    blo0.regCtxMousedown(this);
}

blo0.p = new CPlay();   
 