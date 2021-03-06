import scala.reflect.macros.{Context => Ctx}

object Impls {
  def foo(c: Ctx)(x: c.Expr[Int]) = {
    import c.universe._
    val body = Apply(Select(x.tree, TermName("$plus")), List(Literal(Constant(1))))
    c.Expr[Int](body)
  }
}

object Macros {
  def foo(x: Int) = macro Impls.foo
}