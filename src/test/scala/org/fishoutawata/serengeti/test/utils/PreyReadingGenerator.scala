package org.fishoutawata.serengeti.test.utils

import org.fishoutawata.serengeti.entity.PreyReading

import com.datastax.driver.core.utils.UUIDs
import com.outworkers.util.samplers.Sample

import java.time.Instant

trait PreyReadingGenerator {
  implicit object PreyReadingGenerator extends Sample[PreyReading] {
    override def sample: PreyReading = {
      PreyReading(UUIDs.timeBased(), 36, 16, Instant.now().toEpochMilli, 12.0, 18, 0.60)

    }
  }
}
