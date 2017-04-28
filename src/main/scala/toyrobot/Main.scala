package toyrobot

import scala.io.StdIn.readLine
import scala.util.Try

import Controller._
import Surface._

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

      val nextRobot = (x, currentRobot) match {
        case ("PLACE", _) => {
          val args = xs flatMap (_.split(","))
          Try(place(args(0).toInt, args(1).toInt, directionMap(args(2)))).toOption
        }
        case (_, None) => None
        case ("MOVE", _) => currentRobot map move
        case ("LEFT", _) => currentRobot map left
        case ("RIGHT", _) => currentRobot map right
        case ("REPORT", _) => {
          println(report(currentRobot.get))
          currentRobot
        }
        case _ => currentRobot
      }

      loop(nextRobot filter (r => table(r.x, r.y)) orElse currentRobot)
    }

    loop(None)
  }

  println(welcomeMessage)
  start()
}
