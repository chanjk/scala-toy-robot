package toyrobot

object Surface {
  val table = (x: Int, y: Int) => (x >= 0 && x < 5) && (y >= 0 && y < 5)
}
