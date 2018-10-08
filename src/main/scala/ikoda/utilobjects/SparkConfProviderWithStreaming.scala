package ikoda.utilobjects

import com.typesafe.config.ConfigFactory
import grizzled.slf4j.Logging
import ikoda.IKodaMLException
import org.apache.spark.sql.SparkSession
import org.apache.spark.streaming.{Seconds, StreamingContext}

import scala.collection.mutable
import scala.util.Try


object SparkConfProviderWithStreaming extends Serializable {
  val sparkVariables: mutable.HashMap[String, Any] = new mutable.HashMap
}

trait SparkConfProviderWithStreaming extends Logging with Serializable
{

  private val keySSC = "SSC"
  private val keyStartedConf = "keyStartedConf"
  private val keySparkSession = "spark"

  lazy val sparkcassandraconnectionhost = ConfigFactory.load("streaming").getString("streaming.cassandraconfig.sparkcassandraconnectionhost")
  lazy val sparkdrivermaxResultSize = ConfigFactory.load("streaming").getString("streaming.sparkconfig.sparkdrivermaxResultSize")
  lazy val sparknetworktimeout = Try(ConfigFactory.load("streaming").getString("streaming.sparkconfig.sparknetworktimeout")).getOrElse("350s")
  lazy val sparkmaster = Try(ConfigFactory.load("streaming").getString("streaming.sparkconfig.sparkmaster")).getOrElse("127.0.0.1")
  lazy val datastaxpackageversion = ConfigFactory.load("streaming").getString("streaming.cassandraconfig.datastaxpackageversion")
  lazy val sparkcoresmax = Try(ConfigFactory.load("streaming").getString("streaming.sparkconfig.sparkcoresmax")).getOrElse("4g")
  lazy val sparkdrivermemory = Try(ConfigFactory.load("streaming").getString("streaming.sparkconfig.sparkdrivermemory")).getOrElse("6g")
  lazy val sparkexecutormemory = Try(ConfigFactory.load("streaming").getString("streaming.sparkconfig.sparkexecutormemory")).getOrElse("6g")
  lazy val appname = Try(ConfigFactory.load("streaming").getString("streaming.sparkconfig.appname")).getOrElse("ikoda-"+System.currentTimeMillis())
  lazy val localo = Try(ConfigFactory.load("streaming").getBoolean("streaming.root.local"))
  lazy val streamingo = Try(ConfigFactory.load("streaming").getBoolean("streaming.root.streaming"))


  @throws(classOf[IKodaMLException])
  def intitializeSpark(): Unit = {
    synchronized {
      getSparkSession()
      getSparkStreamingContext()
    }
  }

  def clearSession: Unit =
  {
    SparkSession.clearActiveSession()
    SparkSession.clearDefaultSession()
  }

  @throws(classOf[IKodaMLException])
  def killSparkStreamingContext {
    try {
      if (SparkConfProviderWithStreaming.sparkVariables.get(keySSC).isDefined) {
        SparkConfProviderWithStreaming.sparkVariables -= keySSC
        SparkConfProviderWithStreaming.sparkVariables -= keyStartedConf
        SparkConfProviderWithStreaming.sparkVariables -= keySparkSession
      }
      clearSession
    }
    catch {
      case e: Exception =>
        logger.error(e.getMessage, e)
        throw new IKodaMLException(e.getMessage)
    }
  }

  @throws(classOf[IKodaMLException])
  def getSparkStreamingContext(): StreamingContext = {
    try {
      if (!SparkConfProviderWithStreaming.sparkVariables.get(keySSC).isDefined) {
        logger.info("\n\nLoading new streaming\n\n")
        val ssc: StreamingContext = new StreamingContext(spark.sparkContext, Seconds(6))
        SparkConfProviderWithStreaming.sparkVariables.put(keySSC, ssc)
        logger.info("Loaded streaming")
        ssc
      }
      else {
        SparkConfProviderWithStreaming.sparkVariables.get(keySSC).get.asInstanceOf[StreamingContext]
      }
    }
    catch {
      case e: Exception =>
        logger.error(e.getMessage, e)
        throw new IKodaMLException(e.getMessage)
    }
  }

  def preExistingSession(): Option[SparkSession] = {
    SparkConfProviderWithStreaming.sparkVariables.get(keyStartedConf).isDefined match {
      case true =>
        SparkConfProviderWithStreaming.sparkVariables.get(keySparkSession).isDefined match {
          case true => SparkConfProviderWithStreaming.sparkVariables.get(keySparkSession).asInstanceOf[Option[SparkSession]]
          case false => None
        }
      case false => None
    }
  }

  private def dirRoot(): String = {
    localo.getOrElse(false) match {
      case true => "local[2]"
      case false => s"spark://$sparkmaster:7077"
    }
  }

  def getSparkSession(): SparkSession = {
        val sso=preExistingSession()
        sso.isDefined match
        {
          case true => sso.get
          case false =>
            logger.info("\n\n*********\nLoading new conf: " + dirRoot() + "\n*********\n\n")
            SparkConfProviderWithStreaming.sparkVariables.put(keyStartedConf, "true")

            val sparksession: SparkSession = SparkSession.builder
              .appName(appname)
              .master(dirRoot())
              .config("spark.sql.warehouse.dir", "target/spark-warehouse")
              .config("spark.streaming.stopGracefullyOnShutdown", "true")
              .config("spark.cassandra.connection.host", sparkcassandraconnectionhost)
              .config("spark.driver.maxResultSize", sparkdrivermaxResultSize)
              .config("spark.network.timeout", sparknetworktimeout)
              .config("spark.driver.memory", sparkdrivermemory)
              .config("spark.executor.memory", sparkexecutormemory)
              .config("spark.jars.packages", "datastax:spark-cassandra-connector:" + datastaxpackageversion)
              .config("spark.cores.max", sparkcoresmax)
              .config("spark.hive.mapred.supports.subdirectories", "true")
              .config("spark.hadoop.mapreduce.input.fileinputformat.input.dir.recursive", "true")
              .getOrCreate
            SparkConfProviderWithStreaming.sparkVariables.put(keySparkSession, sparksession)
            sparksession
        }
  }

  def spark(): SparkSession = {
    getSparkSession
  }
}
