#!/bin/bash
exec scala "$0" "$@"
!#

class Rational (n:Int, d:Int){
    require(d != 0)
    val number = n
    val denom = d
    private val g = gcd(n.abs, d.abs)


    def this(n:Int) = this(n, 1)

    implicit def intToRational(x:Int) = new Rational(x)

    override def toString = n + "/" + d + " g:" + g

    def add(that:Rational):Rational = 
      new Rational(number*that.denom + that.number*denom, denom*that.denom)

    def +(that: Rational) = 
      new Rational(number*that.denom + that.number*denom, denom*that.denom)

    def *(that:Rational) = 
      new Rational(number * that.number, denom * that.denom)

    def lessThan(that:Rational) =
      this.number * that.denom < this.number * that.denom

    def lessThan1(that:Rational) = 
      number * that.denom < number * that.denom


    
    private def gcd (a:Int, b:Int):Int = 
      if (b == 0) a else gcd (b, a%b)
}

object Main{
  def main(args:Array[String]){
      println(new Rational(1,3))
      println(new Rational(1,4))

      val oneHalf = new Rational(1, 2)
      val twoThree = new Rational(2,3)
      println( oneHalf add twoThree)
      println( oneHalf lessThan twoThree)
      println( oneHalf lessThan1 twoThree)

      println( oneHalf + twoThree)

      println (oneHalf * twoThree)

      println ( oneHalf add 3)
  }
}

Main.main(args)
