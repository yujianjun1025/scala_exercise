#!/bin/bash
exec scala "$0" "$@"
!#

import scala.io.Source
object LongLines {

  def processFile(filename :String, width:Int){
    val source = Source.fromFile(filename)
    for(line <- source.getLines()){
      processLine(filename, width, line)
    }
  }

  def processLine(filename: String, width : Int, line:String){
    if(line.length > width){
      println(filename + "\t:" + line.trim)
    }
  }

  def processFile2(filename:String, width:Int){
    def processLine2(line:String){
      if(line.length > width){
        println(filename + ":" + line.trim)
      }
    }

    val source = Source.fromFile(filename)
    for( line <- source.getLines()){
      processLine2(line)
    }
  }
}

LongLines.processFile(args(0), args(1).toInt)
println("局部函数测试")
LongLines.processFile2(args(0), args(1).toInt)
