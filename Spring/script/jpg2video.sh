#!/bin/bash

readonly MY_NAME=$(basename "$0")
readonly MY_WIDTH=$(basename "$1")
readonly RATE=$(basename "$2")
readonly THISDIR=$(cd "$(dirname "$0")" ; pwd)
readonly FFMPEGDIR=/usr/bin

echo "------------------------------jpg2video.sh v0.0.3------------------------------"
if [ -z $RATE ] ; then
 RATE=1
 echo "The rate is:" $RATE
fi

if [ -z $MY_WIDTH ] ; then
    echo "The usage is:" $MY_NAME "360" "1"
else
    echo "Call ffmpeg to generate video"
    if [ ! -f $FFMPEGDIR/ffmpeg ];then
       FFMPEGDIR=/usr/local/bin
     fi
    $FFMPEGDIR/ffmpeg -framerate $RATE -i $THISDIR/%d.jpg -r $RATE -s $MY_WIDTH"x"$MY_WIDTH -y vSubtitle.mp4
fi
echo "-------------------------------end----------------------------------------"
