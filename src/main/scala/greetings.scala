import scala.io.StdIn

object greetings extends App {

  def greet(name : String) = println(s"hello $name")

  val name = StdIn.readLine("what is your name? ")

  greet(name)
}