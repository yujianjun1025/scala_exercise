#!/bin/bash
exec scala "$0" "$@"
!#

import java.io.FileReader
import java.io.FileNotFoundException
import java.io.IOException

def try_test(){

  try{
    val f = new FileReader("input.txt")
  }catch{
    case ex : FileNotFoundException => 
      println("handle missing file")
  }
}

def match_test(args:Array[String]){

  (if (args.length > 0) args(0) else "")  match {
    case "salt" => println("papper")
    case "chips" => println("salsa")
    case "eggs" => println("bacon")
    case _ => println("huh?")
  }

}

def match_test_2(args:Array[String]):String = {

  (if (args.length > 0) args(0) else "") match {
    case "salt" => "papper"
    case "chips" => "salsa"
    case "eggs" => "bacon"
    case _ => "huh?"
  }

}
object Main{

  def main(args:Array[String]){

    try_test()
    println("hello world")

    match_test(args)
    println(match_test_2(args))

  }
}

Main.main(args)
