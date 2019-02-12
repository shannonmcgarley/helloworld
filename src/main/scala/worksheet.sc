

def x = "i am the def"

val y = "i am the val"

x


val names = List("shan", "shannon")

names

val namesConcat = "shan" :: "shannon" :: Nil

namesConcat

namesConcat.indexOf("shan")

val nameList = names


val nums = List.range(0, 11)


val even = (x : Int) => (x % 2 == 0)


def ifEven(number : Int) = number % 2 == 0

def odd(number : Int) = !ifEven(number)

for (n <- nums){
  print(n)
  if (ifEven(n)){
    println(" -> even")
  }
  if (odd(n)){
    println(" -> odd")
  }
}

