package async

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import io.vavr._
import io.vavr.control.Option

class AsyncTestSpec extends AnyFlatSpec with Matchers {

  "The Async test" should "compute ceo and enterprise" in {

    Tuple.of(None, None) shouldEqual Tuple.of(None, None)

    val result1 = AsyncTest.getCEOAndEnterprise("12").get()
    result1.toString() shouldEqual "(None, None)"

    val result2 = AsyncTest.getCEOAndEnterprise("ceo_1").get()
    result2.toString() shouldEqual "(Some(Ceo_Mark), Some(Enterprise_Facebook))"

    val result3 = AsyncTest.getCEOAndEnterprise("ceo_3").get()
    result3.toString() shouldEqual "(Some(Ceo_Bill), None)"
  }
}
