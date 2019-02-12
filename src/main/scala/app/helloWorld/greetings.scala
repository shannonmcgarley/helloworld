package app.helloWorld

import scala.io.StdIn

object greetings extends App {

  val cashISA = new CashISASavingsAccount("10101", 0.00, 1000.00)

  val deposited = cashISA.deposit(1000.00)

  val withdrawn = deposited.withdraw(200.00)

  val normalAccount = new CashISASavingsAccount("12121", 100.00)

  val loyalAccountDeposited = normalAccount.deposit(300.00)

  val name = Prompt.ask("what is your name? ")

  val age = Prompt.ask("what is your age?").toInt

  val person = new Person(name, age, withdrawn)

  val loyal = new Person("Loyal customer", age, loyalAccountDeposited)

  Prompt.reply(loyal.speak())

  println(person.speak())

}

object Prompt {
  def ask(message: String) = StdIn.readLine(message)

  def reply(message : String) = println(message)
}