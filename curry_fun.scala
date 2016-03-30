#!/bin/bash
exec scala "$0" "$@"
!#

def plainOldSum(x:Int, y:Int) = x+y


def curriedSum(x:Int) (y:Int) = x+y


import scala.io._
import java.io._
def withPrintWrite(file:File) (op :PrintWriter => Unit){
  val writer = new PrintWriter(file)
  try{
    op(writer)
  }finally{
    writer.close()
  }
}


var assertionsEndable=true
def myAssert(predicate : () => Boolean) = 
  if(assertionsEndable && !predicate())
    throw new AssertionError

object Main{
  def main(args:Array[String]){

    println( plainOldSum(1,2))
    println( curriedSum(1)(2))

    val file = new File("date.txt")

    withPrintWrite(file) {
      writer => writer.println(new java.util.Date)
    }

    myAssert(() => 5 > 3)
  }
}


Main.main(args)
