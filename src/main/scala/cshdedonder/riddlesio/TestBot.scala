package cshdedonder.riddlesio

object TestBot extends Bot {
  override def handle(string: String): (Bot, Option[String]) = (this, Some(string))
}
