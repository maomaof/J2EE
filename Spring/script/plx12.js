const tag = "[plx12.js_v0.52]";
var v1 = bl$("id_div_4_Plx1_v1");
v1.innerHTML = tag+new Date;
//*
v1.g = null; 
v1.g = new classFrame();
v1.g.initGame();
v1.g.startGame();
//*/

function classFrame(){   
  var spList = [];
  var myGamePiece = null;
  var myGameArea = {
    canvas : document.createElement("canvas"),
    start : function() {
        this.canvas.width = 480;
        this.canvas.height = 270;
        this.canvas.style.backgroundColor = "grey";
        this.context = this.canvas.getContext("2d");

        v1.appendChild(this.canvas);
        this.interval = setInterval(updateGameArea, 20);
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
    this.color= "222,123,50";

    var _width = width;
    var _height = height;
    this.update = function(){ 
        ctx = myGameArea.context;
        ctx.fillStyle = color;
        ctx.fillRect(this.x, this.y, _width, _height);
    }
  }
  function updateGameArea() {
    myGameArea.clear();
    myGamePiece.update();
    for(i in spList){
      spList[i].update();
    }
  }

  this.initGame = function () { 
    var tb = blo0.blDiv(v1, v1.id + "tb","tb",blGrey[1]);
    var b1 = blo0.blBtn(tb,tb.id + "b1","b1",blGrey[2]);
    var b2 = blo0.blBtn(tb,tb.id + "b2","b2",blGrey[2]);
    var d1 = blo0.blDiv(v1, v1.id + "d1","d1",blGrey[3]);
    b1.onclick = function(){
      var d = new Date;
      d1.innerHTML = d.getMilliseconds();
      var x = d.getMilliseconds()/3;
      var y = d.getMilliseconds()%100;
      var sp = new sprite(20, 20, "green", x, y);
      spList.push(sp);
    }
    b2.onclick = function(){
      var s = "2";
      var o = {};
      var r = {};
      var fs = [];
      o.request = r;
      r.version = "v0. 14";
      r.width   = 480;
      r.height  = 270;
      r.music   = "1.mp3";
      r.rate    = 1;
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
    myGamePiece = new sprite(30, 30, "red", 10, 120);
    var s = new sprite(11, 30, "blue", 110, 120);
    spList.push(s);
    myGameArea.start();  
  };  
}

