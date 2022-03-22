package davor.beganovic.gorillasassignment.infrastructure.repository

import davor.beganovic.gorillasassignment.infrastructure.model.DeliveryDTO
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface IDeliveryRepository: JpaRepository<DeliveryDTO, Long> {
    fun findAllByIsDelivered(isDelivered: Boolean): List<DeliveryDTO>

    @Query("SELECT d.isDelivered FROM DeliveryDTO d WHERE d.deliveryId = :id")
    fun getDeliveryStatus(id: String): Boolean

    @Modifying
    @Query("UPDATE DeliveryDTO d SET d.isDelivered = :delivered WHERE d.deliveryId = :deliveryId")
    fun changeDeliveryStatus(deliveryId: String, delivered: Boolean): Int
}