package org.fishoutawata.serengeti.test

import org.fishoutawata.serengeti.database.Database
import org.fishoutawata.serengeti.entity.PreyReading
import org.fishoutawata.serengeti.test.utils.{CassandraSpec, PreyReadingGenerator}

import com.outworkers.phantom.dsl._
import com.outworkers.util.testing._

import scala.concurrent.Future

/**
  * Tests PreyReading methods against an embedded cassandra
  *
  * Before executing it will create all necessary tables in cassandra
  */
class PreyReadingTest extends CassandraSpec with PreyReadingGenerator {

  override def beforeAll(): Unit = {
    super.beforeAll()
    database.create()
  }

  "A PreyReading" should "be inserted into cassandra" in {
    val sample = gen[PreyReading]
    val future = this.store(sample)

    whenReady(future) { result =>
      result isExhausted() shouldBe true
      result wasApplied() shouldBe true
    }
  }

  it should "find a PreyReading by id" in {
    val sample = gen[PreyReading]

    val chain = for {
      _ <- this.store(sample)
      get <- database.PreyReadingModel.getById(sample.id)
    } yield get

    whenReady(chain) { res =>
      res shouldBe defined
      res.get shouldEqual sample
    }
  }


  /**
    * Utility method to store prey readings
    *
    * @param preyReading the prey reading to be inserted
    * @return a [[Future]] of [[ResultSet]]
    */
  private def store(preyReading: PreyReading): Future[ResultSet] = Database.savePreyReading(preyReading)
}
