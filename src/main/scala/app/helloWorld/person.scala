package app.helloWorld

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