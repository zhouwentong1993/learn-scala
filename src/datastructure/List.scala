package datastructure

/**
 * 自定义的单向链表
 * 想象一下，单向链表是由一个头结点和剩下的所有节点（在这里称其为尾结点）组成
 * 这其实就是一个递归的描述，当前的尾结点也是由头结点和剩下的所有节点组成
 * @tparam A
 */
sealed trait List[+A] {

  case object Nil extends List[Nothing]

  case class Cons[+A](head: A, tail: List[A]) extends List[A]

  object List {

    val x = List(1, 2, 3, 4, 5) match {
      case Cons(x, Cons(2, Cons(4, _))) => x
      case Nil => 42
      case Cons(x, Cons(y, Cons(3, Cons(4,_)))) => x + y
      case _ => 101
    }
    println(x)

    def sum(ints: List[Int]): Int = ints match {
      case Nil => 0
      case Cons(x, xs) => x + sum(xs)
    }

    def product(ds:List[Double]): Double = ds match {
      case Nil => 1.0
      case Cons(0.0,_) => 0.0
      case Cons(x,xs) => x * product(xs)
    }

    def apply[A] (as: A*) : List[A] =
      if (as.isEmpty) Nil
      else Cons(as.head, apply(as.tail: _*))


    def main(args: Array[String]): Unit = {

    }
  }
}
