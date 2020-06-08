// https://twitter.github.io/scala_school/zh_cn/basics.html
object Demo1 {
  def main(args: Array[String]): Unit = {
    println("hello world")
//    val add10 = addOne(10)
  }
  def annoy = (x: Int) => x + 1
  println(annoy(10))

  def addOne(value: Int) = {
    def addTow(value1: Int): Int = {
      value1 + value
    }

    addTow(value)
  }

  def adder(m:Int,n:Int):Int = m + n

  var adder1 = adder(2,_:Int)

  println(adder1(19))



}
