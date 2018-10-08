package ikoda.utilobjects

import grizzled.slf4j.Logging

import scala.collection.mutable

object DebugObjectTracker extends Logging{

  private val debugMap:mutable.HashMap[String, String]  = new mutable.HashMap[String,String]

  def put(key:String, value:String): Unit =
  {
    if(debugMap.get(key).isEmpty) {
      logger.debug("\n\nDebugObjectTracker: New Object storing " + key + " -> " + value+"\n\n")
      debugMap.put(key, value)
    }
  }

  def remove(key:String): Option[String] =
  {
    logger.debug("Removing "+key)
    debugMap.remove(key)
  }

  def get(key:String): Option[String] =
  {
    logger.debug("Retrieving "+key)
    debugMap.get(key)
  }

  private def seqContains(target:String, seqIn:Seq[String]) = seqIn.contains(target)

  def seqContainsObject(key:String, objSeq:Seq[String]): Boolean =
  {
    val storedObjo:Option[String] =debugMap.get(key)
    storedObjo.isDefined match
    {
      case true =>
        logger.debug("Stored object is "+storedObjo.get)
        seqContains(storedObjo.get,objSeq)
      case false => logger.warn(key+" not found in DebugObjectTracker")
        false
    }
  }





}

