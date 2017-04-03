package com.agrias.crimson.app

import com.agrias.crimson.function.BaseFunctions

case class Config(mode: String = "")

/**
  * Created by Andrew Gao on 4/3/17.
  */
object Crimson extends App{
  val parser = new scopt.OptionParser[Config]("crimson") {
    head("crimson", "0.1")

    //help("help").text("")

    cmd("sayHello")
      .action((_, c) => c.copy(mode = "sayHello"))
  }

  parser.parse(args, Config()) match {
    case Some(config) =>
      config.mode match {
        case "sayHello" =>
          BaseFunctions.HelloWorld()
      }
  }
}
