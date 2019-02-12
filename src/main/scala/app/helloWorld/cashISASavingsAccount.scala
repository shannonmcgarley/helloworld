package app.helloWorld

final class CashISASavingsAccount(accountNumber: String, balance: Double,
                                  private val depositThreshold: Double = 200.00) extends BankAccount(accountNumber, balance) {

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
