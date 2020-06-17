

// https://twitter.github.io/scala_school/zh_cn/basics.html
object Demo1 {
  def main(args: Array[String]): Unit = {
    println("hello world")
    //    val add10 = addOne(10)
    val nums = Array(1, 2, 3, 5)
    nums.map(_ * 2)
    println(max(1, 2))
    println(incr(123))

    // 高阶函数
    //    1. 接受一个或多个函数作为输入
    //      2. 输出一个函数
    val convert2Str = (x: Int) => "==[" + x + "]=="

    def apply(f: Int => String, x: Int) = f(x)

    println(apply(convert2Str, 123))

    val list: List[Int] = List(1, 2, 3, 4, 5, 7)
    val ints = filter(list, 4)
    println(ints)
    println()
    println(sqrt(10))
  }

  // 函数内部定义函数，这样太好了
  def filter(xs: List[Int], threshold: Int) = {
    def process(ys: List[Int]): List[Int] =
      if (ys.isEmpty) ys
      else if (ys.head < threshold) ys.head :: process(ys.tail)
      else process(ys.tail)

    process(xs)
  }

  def sqrt(x: Int): Double = {

    def abs(x: Double): Double = if (x >= 0) x else -x

    def square(x: Double): Double = x * x

    def average(x: Double, y: Double): Double = (x + y) / 2

    def goodEnough(guess: Double, x: Double): Boolean = abs(square(guess) - x) < 0.001

    def improve(guess: Double, x: Double): Double = average(guess, x / guess)

        @scala.annotation.tailrec
    def sqrtIter(guess: Double, x: Double): Double = {
      if (goodEnough(guess, x)) {
        guess
      } else {
        sqrtIter(improve(guess, x), x)
      }
    }

    sqrtIter(1, x)
  }

  def max(x: Int, y: Int): Int = Math.max(x, y)


  def annoy: Int => Int = (x: Int) => x + 1

  println(annoy(10))

  def addOne(value: Int): Int = {
    def addTow(value1: Int): Int = {
      value1 + value
    }

    addTow(value)
  }

  def adder(m: Int, n: Int): Int = m + n

  var adder1 = adder(2, _: Int)

  println(adder1(19))

  val incr = new (Int => Int) {
    def apply(x: Int): Int = x + 1
  }


}
