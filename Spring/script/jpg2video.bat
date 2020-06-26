echo jpg2v.bat V0.0. 15 ;

IF %1.==. GOTO No1 

ffmpeg -framerate %2 -i %%d.jpg -r %2 -s %1x%1 -y vSubtitle.mp4  

GOTO End1

:No1
  ECHO No param 1 :  usage:   jpg2v 480 1
GOTO End1 

:End1
 
echo ffmpeg -framerate 10 -i Path/To/File/filename%3d.jpg -r 10 -y Path/To/File/test.mp4

echo debug:  ...