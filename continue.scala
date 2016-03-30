#!/bin/bash
exec scala "$0" "$@"
!#

import  scala.util.control.Breaks._
import java.io._

def break_test(){
  var in = new BufferedReader (new InputStreamReader(System.in))
  while(true){
    println("? ")
    if(in.readLine() == "") break
  }
}
def continue1(){
    var i = 0
    var foundIt = false
    while( i < args.length && !foundIt){
      if(!args(i).startsWith("-")){
        if(args(i).endsWith(".scala")){
          foundIt = true
        }
      }
      i = i+1
    }

}

def searchFrom(i:Int, args:Array[String]):Int = {
  if (i >= args.length) -1
  else if (args(i).startsWith("-")) searchFrom( i+1, args)
  else if (args(i).endsWith(".scala")) i
  else searchFrom(i+1, args)
}


def args_test(){
  args.foreach(println)
}
object Main{
  def main(args:Array[String]){
    continue1()
    println("hello world")

    println(searchFrom(0, args))

    args_test()
    break_test()
  }
}

Main.main(args)
