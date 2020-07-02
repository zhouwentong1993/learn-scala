object PatternMatch {
  def main(args: Array[String]): Unit = {
    val VALID_GRADE = Set("A", "B", "C", "D", "E")

    // 模式匹配，能匹配到数据类型，并且能够根据数据类型来做对应的操作。
    // 比如在匹配到 String 时，变量就会当做 String，并做 String 的操作。比 if 语句要灵动
    def letterGrade(value: Any): String = value match {
      case x: Int if (90 to 100).contains(x) => "A"
      case x: Int if (80 to 90).contains(x) => "B"
      case x: Int if (70 to 80).contains(x) => "C"
      case x: Int if (60 to 70).contains(x) => "D"
      case x: Int if (0 to 60).contains(x) => "E"
      case x: String if VALID_GRADE(x.toUpperCase()) => x.toUpperCase()
    }

    printf("Amy的成绩为%d，获得%s等\n", 91, letterGrade(91))
    printf("Bob的成绩为%d，获得%s等\n", 72, letterGrade(72))
    printf("Sam缺席全部课程，成绩%d，获得%s等\n",
      44, letterGrade(44))
    printf("Roy转学前已获%s等，记为%s等\n",
      "B", letterGrade("B"))

    def factorial(n: Int): Int = n match {
      case 0 => 1
      case _ if n > 0 => factorial(n - 1) * n
    }

    println(factorial(5))

    val movies = <movies>
      <movie>The Incredibles</movie>
      <movie>WALL E</movie>
      <short>Jack Jack Attack</short>
      <short>Geri's Game</short>
    </movies>

  }
}
