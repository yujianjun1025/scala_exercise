#!/bin/bash
exec scala "$0" "$@"
!#


abstract class Element{
  def contens: Array[String]
  def height:Int =  contens.length
  def width:Int = if (height == 0) 0 else contens(0).length
}

class ArrayElement(conts:Array[String]) extends Element{
  def contens1: Array[String] = conts
}

object Main{
  def main(args:Array[String]){
    println("hello world")

    val ae = ArrayElement(Array("hello", "world"))
    println(ae.length)
  }
}

Main.main(args)
