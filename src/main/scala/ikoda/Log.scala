package ikoda

import grizzled.slf4j.Logger

trait Log
{
  lazy val logger = Logger[this.type]
  val loggerName = this.getClass.getName
}
