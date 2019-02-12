package app.helloWorld

abstract class BankAccount(accountNumber: String, val balance: Double) {

  override def toString: String = s"Account number: $accountNumber, balance: $balance"

  def withdraw(amount: Double): BankAccount

  def deposit(amount: Double): BankAccount
}
