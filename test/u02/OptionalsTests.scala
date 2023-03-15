package u02

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import Optionals.Option.*

class OptionalsTests:

  val opt = Some(5)
  println(opt)
  @Test def testFilter() =
    assertEquals(None(), filter(opt, _ > 6))
    assertEquals(Some(5), filter(opt, _ < 6))
