package davor.beganovic.gorillasassignment.application.service

import com.expediagroup.graphql.generator.annotations.GraphQLIgnore
import com.expediagroup.graphql.server.operations.Query
import davor.beganovic.gorillasassignment.application.model.Delivery
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class DeliveryQuery: Query {
    fun getDeliveries(@GraphQLIgnore @Autowired service: DeliveryService, isDelivered: Boolean): List<Delivery> = service.getDeliveries(isDelivered)
}