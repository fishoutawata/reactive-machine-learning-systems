package org.fishoutawata.serengeti.database

import org.fishoutawata.serengeti.connector.Connector._
import com.outworkers.phantom.connectors.CassandraConnection
import com.outworkers.phantom.dsl._
import org.fishoutawata.serengeti.entity.PreyReading
import org.fishoutawata.serengeti.models.PreyReadingModel

import scala.concurrent.Future

/**
  * This is our Database object that wraps our existing tables,
  * giving the ability to receive different connectors
  * for example: One for production and other for testing
  */
class SerengetiDatabase(override val connector: CassandraConnection) extends Database[SerengetiDatabase](connector) {
  object PreyReadingModel extends PreyReadingModel with connector.Connector

  /**
    * Save a prey reading
    *
    * @param PreyReading
    * @return
    */
  def savePreyReading(preyReading: PreyReading): Future[ResultSet] = {
    PreyReadingModel.store(preyReading).future()
  }
}

/**
  * This is the database, it connects to a cluster with multiple contact points
  */
object Database extends SerengetiDatabase(connector)
