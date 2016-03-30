#!/bin/bash
exec scala "$0" "$@"
!#

object HelloWorld extend App{
  println("Hello World")
}
