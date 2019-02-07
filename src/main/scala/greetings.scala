import scala.io.StdIn

object Prompt {
  def ask(message : String) = StdIn.readLine(message)
}

class Person(name: String, age : Int) {

  private val years : String = if(age > 1) "years" else "year"

  def speak(): String = {
    if (name == "shannon") {
      "you dont get a hello, bye felicia"
    } else {
      s"hello $name, you are $age $years old"

    }
  }
}

object greetings extends App {

  val name = Prompt.ask("what is your name? ")
  val age = Prompt.ask("what is your age?")
  val person = new Person(name, age.toInt)
  println(person.speak())

}