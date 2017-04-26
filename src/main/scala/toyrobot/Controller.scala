package toyrobot

object Controller {
  def place(x: Int, y: Int, direction: Direction): Robot = Robot(x, y, direction)

  def move(robot: Robot): Robot = robot.direction match {
    case North => robot.copy(y = robot.y + 1)
    case East => robot.copy(x = robot.x + 1)
    case South => robot.copy(y = robot.y - 1)
    case West => robot.copy(x = robot.x - 1)
  }
}
