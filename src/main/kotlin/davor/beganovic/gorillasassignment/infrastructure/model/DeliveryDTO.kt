package davor.beganovic.gorillasassignment.infrastructure.model

import java.time.LocalDate
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Table(name = "delivery")
@Entity
data class DeliveryDTO(
    @Id val deliveryId: String,
    @Column val product: String?,
    @Column val supplier: String?,
    @Column val quantity: Int? = 0,
    @Column val expectedDate: String?,
    @Column val expectedWarehouse: String?,
    @Column val isDelivered: Boolean = false
) {
    constructor() : this("100", null, null, null, null, null, false) {

    }
}
