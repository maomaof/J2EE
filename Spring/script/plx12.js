﻿const tag = "[plx12.js_v0.143]";
var v1 = bl$("id_div_4_Plx1_v1");
v1.innerHTML = tag+new Date;
//*
v1.g = null; 
v1.g = new classFrame( );
v1.g.initGame();
v1.g.startGame();
//*/

function classFrame(){   
  var spList = []; 
  var myGameArea = {
    canvas : document.createElement("canvas"),
    start : function() {
        this.canvas.width = 480;
        this.canvas.height = 270;
        this.canvas.style.backgroundColor = "grey";
        this.context = this.canvas.getContext("2d");

        v1.appendChild(this.canvas);
        this.interval = setInterval(updateGameArea, 20);

        window.addEventListener('mousedown', function (e) {
          myGameArea.x = e.offsetX;//e.pageX;
          myGameArea.y = e.offsetY;// e.pageY; 
          for(i in spList){
           var b = spList[i].clicked(myGameArea,bl$("id_4_debug"));
          }

        })

        window.addEventListener('mouseup', function (e) { 
          myGameArea.x = e.offsetX;//e.pageX;
          myGameArea.y = e.offsetY;// e.pageY;
        })
    },
    clear : function() {
        this.context.clearRect(0, 0, this.canvas.width, this.canvas.height);
    }
  } 
  function sprite(width, height, color, x, y) {
    this.text = "spriteText.";
    this.x = x;
    this.y = y;    
    this.size = 50;
    this.color= color; 

    var _x = x;
    var _y = y;
    var _width = width;
    var _height = height;
    this.update = function(){ 
        ctx = myGameArea.context;
        ctx.fillStyle = this.color;
        ctx.fillRect(_x, _y, _width, _height);
    }
    this.clicked = function(a,dbgDiv) {
      var myleft = _x;
      var myright = _x + _width;
      var mytop = _y;
      var mybottom = _y + _height;
      var rClick = true;
      if ((mybottom < a.y) || (mytop > a.y) ||
          (myright < a.x) || (myleft > a.x)) {
            rClick = false;
        if(this.color == "yellow"){
          _x = a.x;
          _y = a.y;          
        }
        this.color = "red";
      }
      else{
        rClick = true;
        this.color = "yellow";
      }
      var ds = this.text;
      ds += "[" + _x + "," + _y + "]";
      ds += "[" + this.x + "," + this.y + "] ";
      ds += rClick;
      dbgDiv.innerHTML = ds;
      return rClick;
    } 
  }
  function updateGameArea() {
    myGameArea.clear();    
    
    for(i in spList){
      spList[i].update();
    }
  }

  this.initGame = function () { 
    var w = 1280;
    var h = 1024;
    var tb = blo0.blDiv(v1, v1.id + "tb","tb",blGrey[1]);
    var b1 = blo0.blBtn(tb,tb.id + "b1","b1",blGrey[2]);
    var btn_760x480 = blo0.blBtn(tb,tb.id + "btn_760x480","760x480",blGrey[2]);
    var btn_1280x1024 = blo0.blBtn(tb,tb.id + "btn_1280x1024","1280x1024",blGrey[2]);
    var btn_createJSON = blo0.blBtn(tb,tb.id + "btn_createJSON","createJSON",blGrey[2]);
    
   
    var d1 = blo0.blDiv(v1, "id_4_debug","d1",blGrey[3]);
    b1.onclick = function(){
      var d = new Date;
      d1.innerHTML = d.getMilliseconds();
      var x = d.getMilliseconds()/3;
      var y = d.getMilliseconds()%100;
      var sp = new sprite(20, 20, "green", x, y);
      spList.push(sp);
    }
    btn_760x480.onclick = function(){     w = 760;       h = 480;    }
    btn_1280x1024.onclick = function(){     w = 1280;      h = 1024;    }
    btn_createJSON.onclick = function(){
      var s = "2";
      var o = {};
      var r = {};
      var fs = [];
      o.request = r;
      r.version = "v0. 21";
      r.width   = w;
      r.height  = h;
      r.music   = "1.mp3";
      r.rate    = "1";
      r.frames  = fs; 

      var f={};
      f.number = 1;
      f.time = 60;
      f.objects = spList;
      fs.push(f);

      f.backgroundColor = "123,45,200";
      
      s =   JSON.stringify(o);
      bl$("id_ta_4_script_editor").value = s;
    }
  };

  this.startGame = function () {   
      myGameArea.start();  
  };  
}

