#!/bin/bash

readonly MY_NAME=$(basename "$0")
readonly MY_WIDTH=$(basename "$1")
readonly THISDIR=$(cd "$(dirname "$0")" ; pwd)
export FFMPEGDIR=/usr/bin
echo "------------------------------jpg2video.sh v0.0.2------------------------------"
if [ -z $MY_WIDTH ] ; then
    echo "The usage is:" $MY_NAME "360"
else
    echo "Call ffmpeg to generate video"
    if [ ! -f $FFMPEGDIR/ffmpeg ];then
      FFMPEGDIR=/usr/local/bin
    fi
    $FFMPEGDIR/ffmpeg -framerate 1 -i $THISDIR/%d.jpg -r 1 -s $MY_WIDTH"x"$MY_WIDTH -y vSubtitle.mp4
fi
echo "-------------------------------end----------------------------------------"
