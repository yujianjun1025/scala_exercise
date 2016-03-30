#!/bin/bash
exec scala "$0" "$@"
!#

val str2 = "{\"et\":\"kanqiu_client_join\",\"vtm\":1435898329434,\"body\":{\"client\":\"866963024862254\",\"client_type\":\"android\",\"room\":\"NBA_HOME\",\"gid\":\"\",\"type\":\"\",\"roomid\":\"\"},\"time\":1435898329}"  

import scala.util.parsing.json.JSON

object Main{
  def main(args:Array[String]){
      
      val b = JSON.parseFull(args[1])
      b.foreach(println)
      println("hello world")
  }
}

Main.main(args)
