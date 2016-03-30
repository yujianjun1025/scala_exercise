#!/bin/bash
exec scala "$0" "$@"
!#



def boom(x:Int):Int = 
  if ( x== 0) throw new Exception("boom!") else boom(x-1) +1


def bang(x:Int):Int = 
  if (x == 0) throw new Exception("boom") else bang(x-1)


def isEven(x:Int) :Boolean = 
  if (x == 0) true else isOdd(x-1)

def isOdd(x:Int) : Boolean = 
  if (x == 0) false else isEven(x-1)


object FileMatcher{

  private def filesHere = (new java.io.File(".")).listFiles
  def filesEnding(query:String) = 
    for(file <- filesHere ; if file.getName.endsWith(query))
      yield file

  def filesContaining(query:String) = 
    for(file <- filesHere; if file.getName.contains(query))
      yield file

  filesMatching(query:String, matcher:(String, String) => Boolean) = {
    for( file <- filesHere; if matcher(file.getName, query))
      yield file
  }

  def filesEnding(query:String) =
    filesMatching(query, _.endsWith(_))

  def filesContaining(query:String) = 
    filesMatching(query, _.contains(_))

  def filesRegex(query:String) = 
    filesMatching(query, _.matches(_))

  def filesEnding1(query:String) = 
    filesMatching(_.endsWith(query))

  def filesContaining1(query:String) = 
    filesMatching(_.contains(query))

  def filesRegex(query:String) = 
    filesMatching(_.matches(query))



}

object Main{
  def main(args:Array[String]){
    println("hello world")

    //boom(5)
    //bang(5)
  }
}

Main.main(args)
