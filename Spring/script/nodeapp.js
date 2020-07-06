var http = require('http');
var formidable = require('formidable');
var fs = require('fs');
var url = require('url');

console.log("__dirname = " + __dirname + Date() );

http.createServer(function (req, res) {
  if (req.url == '/fileupload') {
    var form = new formidable.IncomingForm();
    console.log(form);
    form.parse(req, function (err, fields, files) {
      var oldpath = files.filetoupload.path;
      var newpath = __dirname + '/' + files.filetoupload.name;
      fs.rename(oldpath, newpath, function (err) {
        if (err) 
        {
          console.log(err);
          throw err;
        }
        res.write('File uploaded and moved!');
        res.end();
      });
    });
  }
  else if (req.url == '/1.html'|| req.url == '/plxScriptEditor.js') {
    var q = url.parse(req.url, true);
    var filename = "." + q.pathname;
    fs.readFile(filename, function(err, data) {
      if (err) {
        res.writeHead(404, {'Content-Type': 'text/html'});
        return res.end("404 Not Found");
      } 
      res.writeHead(200, {'Content-Type': 'text/html'});
      res.write(data);
      return res.end();
    });
  } 
  else if ( req.url == '/plxScriptEditor.js') {
    console.log("xd...");
    res.end("xd");
  } 
  else {
    res.writeHead(200, {'Content-Type': 'text/html'});
    res.write('<form action="fileupload" method="post" enctype="multipart/form-data">');
    res.write('<input type="file" name="filetoupload"><br>');
    res.write('<input type="submit">');
    res.write('</form>');
    return res.end();
  }
}).listen(8080);