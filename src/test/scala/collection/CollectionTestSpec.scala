package collection

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
//import java.util.List
import scala.collection.JavaConverters._

class CollectionTestSpec extends AnyFlatSpec with Matchers {

  "The Collection test" should "compute some value for first method" in {
    CollectionTest.compute1(List().asJava) shouldEqual List().asJava
    CollectionTest.compute1(List(0, 1, 2, 5, 10).map(Integer.valueOf).asJava) shouldEqual List(243.0, 3125.0, 16807.0, 371293.0, 6436343.0).asJava
  }

  "The Collection test" should "compute some value for second method" in {
    CollectionTest.compute2(List().asJava) shouldEqual List().asJava
    CollectionTest.compute2(List("abc").asJava) shouldEqual List("AbcAbc").asJava
    CollectionTest.compute2(List("Abc").asJava) shouldEqual List("AbcAbc").asJava
    CollectionTest.compute2(List("").asJava) shouldEqual List("").asJava
    CollectionTest.compute2(List("sldkfj sdflkjs sdf").asJava) shouldEqual List("Sldkfj sdflkjs sdfSldkfj sdflkjs sdf").asJava
  }
}
