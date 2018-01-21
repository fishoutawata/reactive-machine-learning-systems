package org.fishoutawata.serengeti.entity

import java.util.UUID

case class PreyReading(id: UUID,
                       sensorId: Int,
                       locationId: Int,
                       timestamp: Long,
                       animalsLowerBound: Double,
                       animalsUpperBound: Double,
                       percentZebras: Double)
