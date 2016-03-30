#!/bin/bash
exec scala "$0" "$@"
!#


def gcdLoop (x:Long, y:Long): Long = {
  
  var a = x
  var b = y
  while( a!= 0){
    var temp = a
    a = b % a
    b = temp
  }
  b
}


def do_while(){ 
  var line = ""
  do{
    line = readLine()
    println("Read : " + line)
  }while(line != "")
}

def greet() {
  println("hi")
}

def gcd_no_while (x:Long, y:Long) : Long = {
  if(y == 0) x else gcd_no_while (y, x%y)
}


def for_test(){
  val fileHere = (new java.io.File(".")).listFiles
  for (file <- fileHere)
    println(file)

  println("for filter test")

  for(file <- fileHere if file.isFile if file.getName.endsWith(".scala"))
    println(file)

}


def fileLines (file :java.io.File) = 
  scala.io.Source.fromFile(file).getLines().toList

def grep( pattern :String) = { 

  val fileHere = (new java.io.File(".")).listFiles
  for (
       file <- fileHere if file.getName.endsWith(".scala");
       line <- fileLines(file) if line.trim.matches(pattern)
     ){
       println(file + ":" + line.trim)     
     }
}

def grep2( pattern :String) = { 

  val fileHere = (new java.io.File(".")).listFiles
  for {
       file <- fileHere if file.getName.endsWith(".scala")
       line <- fileLines(file) if line.trim.matches(pattern)
       }{
       println(file + ":" + line.trim)     
     }
}


def grep3( pattern :String) = { 

  val fileHere = (new java.io.File(".")).listFiles
  for {
       file <- fileHere if file.getName.endsWith(".scala")
       line <- fileLines(file) 
       trimmed = line.trim
       if trimmed.matches(pattern)

       }{
       println(file + ":" + trimmed)     
     }
}

def scalaFile() = {
  var fileHere = (new java.io.File(".")).listFiles
  var xx = for { file <- fileHere if file.getName.endsWith(".scala") } yield file 
  println("foreach test")
  xx.foreach(println)
} 

object Main{

  def main(args : Array[String]) {

    var filename = if (!args.isEmpty) args(0) else  "date.txt"

    println("filename == " + filename)
    println("hello world")

    println(gcd_no_while(4,10))

    for_test()
    //do_while()
    grep(".*gcd.*")
    grep2(".*gcd.*")
    grep3(".*gcd.*")

    scalaFile()
  }
}


Main.main(args)
