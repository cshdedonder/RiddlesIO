package cshdedonder.riddlesio

trait Bot {

  def handle(string: String): (Bot, Option[String])
}
