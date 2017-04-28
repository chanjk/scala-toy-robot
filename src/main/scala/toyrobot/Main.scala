package toyrobot

import scala.io.StdIn.readLine
import scala.util.Try

import Controller._

object Main extends App {
  private val welcomeMessage = """
    |Welcome to Toy Robot Simulator!
    |
    |Commands: PLACE X,Y,DIRECTION | MOVE | LEFT | RIGHT | REPORT
    |Directions: NORTH | EAST | SOUTH | WEST
    |
    |Refer to the README for more information.
    """.stripMargin

  private val directionMap = Map[String, Direction](
    "NORTH" -> North,
    "EAST" -> East,
    "SOUTH" -> South,
    "WEST" -> West
  )

  def start(): Unit = {
    def loop(currentRobot: Option[Robot]): Unit = {
      val x :: xs = Try(readLine("> ").trim.toUpperCase.split("\\s+").toList) getOrElse { return }

      (x, currentRobot) match {
        case ("PLACE", _) => {
          val args = xs flatMap (_.split(","))
          val newRobot = Try(place(args(0).toInt, args(1).toInt, directionMap(args(2)))).toOption
          loop(newRobot orElse currentRobot)
        }
        case (_, None) => loop(None)
        case ("MOVE", _) => loop(currentRobot map move)
        case ("LEFT", _) => loop(currentRobot map left)
        case ("RIGHT", _) => loop(currentRobot map right)
        case ("REPORT", _) => {
          println(report(currentRobot.get))
          loop(currentRobot)
        }
        case _ => loop(currentRobot)
      }
    }

    loop(None)
  }

  println(welcomeMessage)
  start()
}
