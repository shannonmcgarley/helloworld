import scala.io.StdIn

object Prompt {
  def ask(message : String) = StdIn.readLine(message)
}

class Person(name: String) {

  def speak(): String = {
    if (name == "shannon") {
      "you dont get a hello, bye felicia"
    } else {
      s"hello $name"

    }
  }
}

object greetings extends App {

  val name = Prompt.ask("what is your name? ")
  val person = new Person(name)
  println(person.speak())

}