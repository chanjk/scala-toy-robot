package toyrobot

object Controller {
  def place(x: Int, y: Int, direction: Direction): Robot = Robot(x, y, direction)

  def move(robot: Robot): Robot = robot.direction match {
    case North => robot.copy(y = robot.y + 1)
    case East => robot.copy(x = robot.x + 1)
    case South => robot.copy(y = robot.y - 1)
    case West => robot.copy(x = robot.x - 1)
  }

  def left(robot: Robot): Robot = robot.direction match {
    case North => robot.copy(direction = West)
    case East => robot.copy(direction = North)
    case South => robot.copy(direction = East)
    case West => robot.copy(direction = South)
  }

  def right(robot: Robot): Robot = (left _ andThen left _ andThen left _)(robot)

  def report(robot: Robot): String = s"${robot.x},${robot.y},${robot.direction}".toUpperCase
}
