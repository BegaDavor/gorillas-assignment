package davor.beganovic.gorillasassignment.application.service.fetcher

import davor.beganovic.gorillasassignment.application.service.DeliveryService
import graphql.schema.DataFetcher
import graphql.schema.DataFetchingEnvironment
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ChangeDeliveryStatusFetcher(@Autowired val service: DeliveryService): DataFetcher<Int> {
    /**
     * Update delivery status fetcher
     */
    override fun get(p0: DataFetchingEnvironment?): Int = service.changeDeliveryStatus(p0!!.getArgument("deliveryId"), p0.getArgument("isDelivered"))
}