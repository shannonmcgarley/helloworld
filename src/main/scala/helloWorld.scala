object helloWorld extends App {

  val name = "shannon"
  val name2 = "pan"

  def greeter(name: String) = {
    println(s"hello $name")
  }

  greeter(name)
  greeter(name2)
}