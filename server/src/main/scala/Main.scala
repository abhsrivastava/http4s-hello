import cats.effect._
import org.http4s._
import org.http4s.dsl.io._
import org.http4s.implicits._

object Main extends App {
  val service = HttpService[IO] {
    case GET -> Root / "hello" / name => 
      Ok(s"Hello $name")
  }
  
  val getRoot = Request[IO](Method.GET, uri("/foo"))
  val io = service.orNotFound.run(getRoot)
  println(io.runUnsafeSync())
}