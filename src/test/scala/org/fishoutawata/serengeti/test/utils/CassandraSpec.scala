package org.fishoutawata.serengeti.test.utils

import org.fishoutawata.serengeti.database.{Database, SerengetiDatabase}
import com.outworkers.phantom.database.DatabaseProvider
import org.scalatest._
import org.scalatest.concurrent.ScalaFutures

trait SerengetiDbProvider extends DatabaseProvider[SerengetiDatabase] {
  override def database: SerengetiDatabase = Database
}

trait CassandraSpec extends FlatSpec
  with Matchers
  with Inspectors
  with ScalaFutures
  with OptionValues
  with BeforeAndAfterAll
  with SerengetiDbProvider
