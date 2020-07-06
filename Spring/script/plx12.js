const tag = "[plx12.js_v0.31]";
var v1 = bl$("id_div_4_Plx1_v1");
v1.innerHTML = tag+new Date;
//*
v1.g = null; 
v1.g = new classGame();
v1.g.initGame();
v1.g.startGame();
//*/

function classGame(){   

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
  function component(width, height, color, x, y) {
    this.width = width;
    this.height = height;
    this.x = x;
    this.y = y;    
    this.update = function(){
    	  this.x += 1;
        if(this.x>400) this.x = 0;
        ctx = myGameArea.context;
        ctx.fillStyle = color;
        ctx.fillRect(this.x, this.y, this.width, this.height);
    }
  }
  function updateGameArea() {
    myGameArea.clear();
    myGamePiece.update();
  }

  this.initGame = function () { 
    var tb = blo0.blDiv(v1, v1.id + "tb","tb",blGrey[1]);
    var b1 = blo0.blBtn(tb,tb.id + "b1","b1",blGrey[2]);
  };

  this.startGame = function () { 
    myGamePiece = new component(30, 30, "red", 10, 120);
    myGameArea.start();  
  };

  
}

