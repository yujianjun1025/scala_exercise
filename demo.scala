#!/bin/bash
exec scala "$0" "$@"
!#

def max(x:Int, y:Int):Int = {
    if ( x > y) 
      x
    else
      y
}

def greet () = println("greet")

def printArgs(args:Array[String] ):Unit = {
    var i = 0
    while(i < args.length){
      println(args(i))
      i += 1
    }

}

def printArgs2(args:Array[String]) : Unit = {
   for (arg <- args){
      println(arg)
   }
}

def printArgs3(args:Array[String]) :Unit = {
  args.foreach(println)
}

import scala.io.Source

def readFile(fileName:String):Unit = {
  for (line  <- Source.fromFile(fileName).getLines()){
      println(line.length + " " + line )
  }


}

class ChecksumAccumulator{
  private var sum = 0
  def add (b:Byte) :Unit = sum +=b
  def checksum() : Int = ~(sum & 0XFF) + 1
}
object HelloWorld{
    def main(args: Array[String]){
        println("hello world")

        println(max(3,4))
        greet()

        var i =0;
        while (i < args.length){
          println (args(i))
          i+=1
        }

        args.foreach( arg => println(arg))

        args.foreach(println)

        for(arg <- args){
          println(arg)
          println(arg)
        }

        println("数组测试")
        val greeString = new Array[String](3)
        greeString(0) = "Hello"
        greeString(1) = ","
        greeString(2) = "world! \n"
        for (i <- 0 to 2)
          println(greeString(i))

        val greeString1 = Array("hello", "," , "World\n")
        greeString1.foreach(println)

        val greeString2 = Array.apply("hello", ",", "World\n")
        greeString2.foreach(println)

        println("list 测试")

        val oneTwo = List(1,2)
        val threeFour = List(3,4)
        val oneTwoThreeFour = oneTwo ::: threeFour
        println( oneTwo + " and " +  threeFour + " was not mutated.")
        println("thus ," + oneTwoThreeFour + "is new List" )

        val oneTwo2Three = 1::2::3::Nil
        println (oneTwo2Three)

        val oneTwoThree2 = Nil.::(3).::(2).::(1)
        println(oneTwoThree2)

        println("tuple 测试")

        val pair = (99, "leftballos")
        println(pair._1)
        println(pair._2)

        val pair2  = ('u','r', "the", 1,4)
        println(pair2)

        println("set 测试")
        var jetSet = Set("beijing", "chongqing")
        jetSet += "shandong"

        println(jetSet)
        println(jetSet.contains("shandong"))

        println("map 测试")
        val romanNumberal = Map( 1 -> "I", 2 -> "II", 3 -> "III", 4->"IV", 5-> "V")
        println(romanNumberal(4))
        //println(romanNumberal(10))
        //

        println("函数测试")
        printArgs(args)
        printArgs2(args)
        printArgs3(args)

        println("读取文件测试")
        readFile("date.txt")
    }
}


HelloWorld.main(args)
