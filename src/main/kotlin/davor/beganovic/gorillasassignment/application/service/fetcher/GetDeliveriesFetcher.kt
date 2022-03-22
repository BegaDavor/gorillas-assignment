package davor.beganovic.gorillasassignment.application.service.fetcher

import davor.beganovic.gorillasassignment.application.model.Delivery
import davor.beganovic.gorillasassignment.application.service.DeliveryService
import graphql.schema.DataFetcher
import graphql.schema.DataFetchingEnvironment
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class GetDeliveriesFetcher(@Autowired val service: DeliveryService): DataFetcher<List<Delivery>> {

    /**
     * Get deliveries by status fetcher
     */
    override fun get(p0: DataFetchingEnvironment?): List<Delivery> = service.getDeliveries(p0!!.getArgument("isDelivered"))
}