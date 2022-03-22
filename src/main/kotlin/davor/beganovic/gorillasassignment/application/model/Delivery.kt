package davor.beganovic.gorillasassignment.application.model

import com.expedia.graphql.annotations.GraphQLID
import com.expediagroup.graphql.generator.annotations.GraphQLDescription

@GraphQLDescription("Delivery")
data class Delivery(
    @GraphQLID
    val deliveryId: String?,
    val product: String?,
    val supplier: String?,
    val quantity: Int?,
    val expectedDate: String?,
    val expectedWarehouse: String?,
    val isDelivered: Boolean
)
