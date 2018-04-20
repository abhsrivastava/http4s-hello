import cats.effect._
import org.http4s._, org.http4s.dsl.io._, org.http4s.implicits._
import org.http4s.syntax.kleisli._
import cats.implicits._

object Main extends App {
  val getRoot = Request[IO](Method.GET, uri("/foo"))
  val io = HelloService.service.orNotFound.run(getRoot)
  println(io.runUnsafeSync())
}