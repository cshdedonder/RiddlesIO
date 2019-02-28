package cshdedonder.riddlesio

import scala.io.StdIn

object Main {

  val bot: Bot = _

  def readLine(): Option[String] = Option(StdIn.readLine())

  def main(args: Array[String]): Unit = {
    Stream.iterate("init")(_ => StdIn.readLine())
      .takeWhile(_ != null)
      .foreach(bot.handleString _ andThen println)
  }

}
