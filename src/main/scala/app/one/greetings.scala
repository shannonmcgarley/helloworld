package app.one

import scala.io.StdIn


object Prompt {
  def ask(message: String) = StdIn.readLine(message)
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

abstract class BankAccount(accountNumber: String, val balance: Double) {

  override def toString: String = s"Account number: $accountNumber, balance: $balance"

  def withdraw(amount: Double): BankAccount

  def deposit(amount: Double): BankAccount
}

final class SavingsAccount(accountNumber: String, balance: Double) extends BankAccount(accountNumber, balance) {
  override def withdraw(amount: Double): BankAccount = {
    if ((balance - amount) < 0) {
      println(s"you have insufficient funds")
      this
    } else {
      val deducted = balance - amount
      println(s"balance after deductions $deducted")

      new SavingsAccount(accountNumber, deducted)
    }
  }

  override def deposit(amount: Double): BankAccount = {
    new SavingsAccount(accountNumber, balance + amount)
  }
}

final class CashISASavingsAccount(accountNumber: String, balance: Double) extends BankAccount(accountNumber, balance) {

  private val depositThreshold: Double = 200.00

  override def withdraw(amount: Double): BankAccount = {
    println(s"You cannot withdraw money yet. \n Try again in 3 years boo")
    this
  }

  override def deposit(amount: Double): BankAccount = {
    if (amount > depositThreshold) {
      val difference = amount - depositThreshold
      println(s"You cannot deposit more than £$depositThreshold. \n Excess : £$difference")
      new CashISASavingsAccount(accountNumber, balance + depositThreshold)
    } else {
      new CashISASavingsAccount(accountNumber, balance + amount)
    }
  }
}
