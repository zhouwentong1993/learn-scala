

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
    // 当求的值过于小时，就会出现误差。当求的值过于大时，程序就会卡死。
    // 原因：值过小，开根号的值就更小了，很容易就会小于我们设定的 0.001 这个标准
    // 当值过大时，我们需要经过很多次的比较才会使得开根号之后的值小于 0.001
    println(sqrt(1e-6))

    // 柯里化
    def sum(x: Int)(y: Int)(z: Int): Int = x + y + z

    def test = sum(1) _

    println(test)

    val sumResult = sum(1)(2)(19)
    println(sumResult)

    def first(x: Int) = (y: Int) => (z: Int) => x + y + z

    //    def first = sum(1)
    //    def second = first(2)
    //    def third = second(3)
    //    println(third)

    Array("a", "b", "c").map((x: String) => x * 2)


  }

  // 函数内部定义函数，这样太好了
  def filter(xs: List[Int], threshold: Int) = {
    def process(ys: List[Int]): List[Int] =
      if (ys.isEmpty) ys
      else if (ys.head < threshold) ys.head :: process(ys.tail)
      else process(ys.tail)

    process(xs)
  }

  def sqrt(x: Double): Double = {

    def abs(x: Double): Double = if (x >= 0) x else -x

    def square(x: Double): Double = x * x

    def average(x: Double, y: Double): Double = (x + y) / 2

    def goodEnough(guess: Double, x: Double): Boolean = abs(square(guess) - x) < guess / 10000

    def improve(guess: Double, x: Double): Double = average(guess, x / guess)

    @scala.annotation.tailrec
    def sqrtIter(guess: Double, x: Double): Double = {
      if (goodEnough(guess, x)) guess
      else
        sqrtIter(improve(guess, x), x)
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
