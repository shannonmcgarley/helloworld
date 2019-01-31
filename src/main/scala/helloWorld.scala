object helloWorld extends App {

  val name = "shannon"
  val pan = "pan"

  def greeter(name: String, shout : Boolean) = {
   if (shout) {
     println(s"hello $name!")
   } else{
     println(s"hello $name")
   }
  }

  greeter(pan, true)
  greeter(pan, false)
}