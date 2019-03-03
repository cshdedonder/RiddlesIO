package cshdedonder.riddlesio

import cats.data.OptionT
import cats.effect.{ExitCode, IO, IOApp, Sync}

import scala.io.StdIn

object Main extends IOApp {

  private val initialBot: Bot = TestBot // UPDATE HERE

  override def run(args: List[String]): IO[ExitCode] =
    for {
      _ <- loop[IO](initialBot).value
    } yield ExitCode.Success

  private def readLine[F[_] : Sync]: OptionT[F, String] = OptionT(Sync[F].delay(StdIn.readLine() match {
    case "" => None
    case x => Some(x)
  }))

  private def printLine[F[_] : Sync](string: Option[String]): OptionT[F, Unit] = OptionT.liftF(string match {
    case None => Sync[F].unit
    case Some(x) => Sync[F].delay(println(x))
  })

  private def loop[F[_] : Sync](bot: Bot): OptionT[F, Unit] = for {
    line <- readLine[F]
    (bot2, response) = bot handle line
    _ <- printLine[F](response)
    _ <- loop[F](bot2)
  } yield ()

}
