package org.fishoutawata.serengeti.models

import org.fishoutawata.serengeti.entity.PreyReading
import com.outworkers.phantom.dsl._

import scala.concurrent.Future

/**
  * Create the Cassandra representation of the PreyReading table
  */
abstract class PreyReadingModel extends Table[PreyReadingModel, PreyReading] {

  override def tableName: String = "prey_readings"

  object id extends TimeUUIDColumn with PartitionKey {
    override lazy val name = "id"
  }

  object sensorId extends IntColumn
  object locationId extends IntColumn
  object timestamp extends LongColumn
  object animalsLowerBound extends DoubleColumn
  object animalsUpperBound extends DoubleColumn
  object percentZebras extends DoubleColumn

  def getById(id: UUID): Future[Option[PreyReading]] = {
    select
      .where(_.id eqs id)
      .consistencyLevel_=(ConsistencyLevel.ONE)
      .one()
  }

}
