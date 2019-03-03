package cshdedonder.riddlesio.tictactoe

import cshdedonder.riddlesio.Bot

import scala.util.Random

object RandomTicTacToeBot extends Bot {

  override def handle(string: String): (Bot, Option[String]) = string match {
    case s if s.startsWith("settings") => (this, None)
    case s if s.startsWith("update game field") => (new Bot {

      val validPlaces: Array[(Int, Int)] = ???

      override def handle(string: String): (Bot, Option[String]) = string match {
        case t if t.startsWith("action move") => (RandomTicTacToeBot, Some("%1$d %2$d" format validPlaces(Random.nextInt(validPlaces.length))))
        case t => RandomTicTacToeBot.handle(t)
      }
    }, None)
  }
}
