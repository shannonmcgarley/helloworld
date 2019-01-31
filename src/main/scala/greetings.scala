import scala.io.StdIn

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

  val name = StdIn.readLine("what is your name? ")
  val person = new Person(name)
  println(person.speak())

}