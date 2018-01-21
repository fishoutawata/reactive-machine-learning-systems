package org.fishoutawata.serengeti.test.utils

import org.fishoutawata.serengeti.entity.PreyReading

import com.datastax.driver.core.utils.UUIDs
import com.outworkers.util.samplers.Sample

import java.time.Instant

import scala.util.Random

trait PreyReadingGenerator {
  implicit object PreyReadingGenerator extends Sample[PreyReading] {
    override def sample: PreyReading = {
      val r: Random = new Random

      val bounds = (1 to 2)
        .map(_ => r.nextInt(100).toDouble + 1L)
        .sortWith(_ > _)

      PreyReading(
        UUIDs.timeBased(),
        1 + r.nextInt(40) ,
        1 + r.nextInt(16),
        Instant.now().toEpochMilli,
        bounds(1),
        bounds(0),
        r.nextDouble())
    }
  }
}
