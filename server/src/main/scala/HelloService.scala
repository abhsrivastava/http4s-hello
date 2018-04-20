import cats.effect._
import org.http4s._, org.http4s.dsl.io._, org.http4s.implicits._

object HelloService {
  val service = HttpService[IO] {
    case GET -> Root / name => 
      Ok(s"Hello $name")
  }
}