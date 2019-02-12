package app.helloWorld

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

final class CashISASavingsAccount(accountNumber: String, balance: Double, private val depositThreshold: Double = 200.00) extends BankAccount(accountNumber, balance) {

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
