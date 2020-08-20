object FoldLeftDemo {
  def main(args: Array[String]): Unit = {
    // foldLeft 首先是基于 reduceLeft 的，reduceLeft 就是对当前 List 从左向右做 reduce 操作
    // 根据后面自定义的运算，初始值是 0。而 foldLeft 可以看做是初始值为指定数字的特殊的 reduceLeft
    val listA = List(1, 2, 3)
    val b = (10 /: listA) (_ * _)
    val c = listA.foldLeft(10)(_ + _)
    val d = listA.reduceLeft(_ + _)
    println(b)
    println(c)
    println(d)
  }

}
