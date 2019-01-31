object helloWorld extends App {

  def greeter(name: String, shout : Boolean) = {
   if (shout) {
     println(s"hello $name!")
   } else{
     println(s"hello $name")
   }
  }

//  greeter("pan", true)
//  greeter("pan", false)

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
  personalGreeter("shannon")
  personalGreeter("pan")
  personalGreeter("andrew")
  personalGreeter("dane")
  personalGreeter("dan")
  //////////////////////////////////
}