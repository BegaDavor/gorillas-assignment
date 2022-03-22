package davor.beganovic.gorillasassignment.application.service

import com.expediagroup.graphql.generator.annotations.GraphQLIgnore
import com.expediagroup.graphql.server.operations.Mutation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class DeliveryMutation: Mutation {
    fun changeDeliveryStatus(@GraphQLIgnore @Autowired service: DeliveryService, deliveryId: String, isDelivered: Boolean): Int = service.changeDeliveryStatus(deliveryId, isDelivered)
}