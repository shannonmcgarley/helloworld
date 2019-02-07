import scala.io.StdIn

object Prompt {
  def ask(message: String) = StdIn.readLine(message)
}

class Person(name: String, age: Int) {

  private val years: String = if (age > 1) "years" else "year"

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

abstract class BankAccount(accountNumber : String, balance : Double) {
  def withdraw(amount: Double): BankAccount

  def deposit(amount: Double): BankAccount
}

final class SavingsAccount(accountNumber : String, balance : Double) extends BankAccount(accountNumber, balance){
  override def withdraw(amount : Double) : BankAccount = {
    if ((balance - amount) < 0) {
      println(s"you have insufficient funds")
      this
    } else {
      val deducted = balance - amount
      println(s"balance after deductions $deducted")

      new SavingsAccount(accountNumber, deducted)
    }
  }
  override def deposit(amount : Double) : BankAccount = {
    new SavingsAccount(accountNumber, balance + amount)
  }
}

final class CashISASavingsAccount (accountNumber : String, balance : Double) extends BankAccount(accountNumber, balance){
  override def withdraw(amount: Double) : BankAccount = {
    println(s"try again in 3 years boo")
    this
  }
  override def deposit(amount : Double) : BankAccount = {
    new CashISASavingsAccount(accountNumber, balance + amount)
  }
}