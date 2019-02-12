package app.helloWorld

import scala.io.StdIn

class Person(name: String, age: Int, private val bankAccount: BankAccount) {

  def this(name: String, age: Int) = this(name, age, new SavingsAccount("12345", 0.00))

  private def years: String = if (age > 1) "years" else "year"

  def speak(): String = {
    if (name == "shannon") {
      "you dont get a hello, bye felicia"
    } else {
      s"hello $name, you are $age $years old. \n Your account details are: $bankAccount"

    }
  }
}

object greetings extends App {

  val cashISA = new CashISASavingsAccount("10101", 0.00)

  val deposited = cashISA.deposit(1000.00)

  val withdrawn = deposited.withdraw(200.00)

  val name = Prompt.ask("what is your name? ")

  val age = Prompt.ask("what is your age?")

  val person = new Person(name, age.toInt, withdrawn)

  println(person.speak())

}

object Prompt {
  def ask(message: String) = StdIn.readLine(message)
}