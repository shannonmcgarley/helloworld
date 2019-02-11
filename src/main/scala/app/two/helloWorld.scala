package app.two

object helloWorld extends App {

  def greeter(name: String, shout : Boolean = false) = {
   if (shout) {
     println(s"hello $name!")
   } else{
     println(s"hello $name")
   }
  }

  greeter("pan", true)
  greeter("pan")
  greeter("pan", false)

  def personalGreeterold(names : String): Unit = {
    if (names == "andrew") {
      println("good morning andrew")
    } else if (names == "dane") {
      println("alright dave")
    } else if (names == "dan"){
      println("yo wazzup")
    } else {
      println(s"hello $names")
    }
  }

  def personalGreeternewold(names : String): Unit = {
      names match {
        case "andrew" => println("good morning andrew")
        case "dane"   => println("alright dave")
        case "dan"    => println("yo wazzup")
        case _        => println(s"hello $names")
      }
  }

  def personalGreeter(names : String) = {
    val message = names match {
      case "andrew" => "good morning andrew"
      case "dane"   => "alright dave"
      case "dan"    => "yo wazzup"
      case _        => s"hello $names"
    }
    println(message)
  }

  ///////////////////////////////
 /* personalGreeter("shannon")
  personalGreeter("pan")
  personalGreeter("andrew")
  personalGreeter("dane")
  personalGreeter("dan")*/
  //////////////////////////////////
}



import scala.io.StdIn

object Prompt {
  def ask(message: String): String = StdIn.readLine(message)
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

abstract class BankAccount(accountNumber: String,balance: Double) {
  def withdraw(amount: Double): BankAccount

  def deposit(amount: Double): BankAccount
}

final case class SavingsAccount(accountNumber: String, balance: Double) extends BankAccount(accountNumber, balance) {

  override def withdraw(amount: Double): BankAccount = {
    if ((balance - amount) < 0) {
      println(s"you have insufficient funds")
      this
    } else {
      val newBalance = balance - amount
      println(s"balance after deductions $newBalance")

      this.copy(balance = newBalance)
    }
  }

  override def deposit(amount: Double): BankAccount = {
    this.copy(balance = balance + amount)
  }
}

final case class CashISASavingsAccount(accountNumber: String, balance: Double) extends BankAccount(accountNumber, balance) {
  override def withdraw(amount: Double): BankAccount = {
    println(s"try again in 3 years boo")
    this
  }

  override def deposit(amount: Double): BankAccount = {
    if ((amount) <= 200) {
      println(s"you have successfully added $amount to your account")
      this.copy(balance = balance + amount)
    } else {
      println("too much money richie rich")
      this
    }

  }
}
