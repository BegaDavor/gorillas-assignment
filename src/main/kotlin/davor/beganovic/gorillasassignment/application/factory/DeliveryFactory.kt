package davor.beganovic.gorillasassignment.application.factory

import davor.beganovic.gorillasassignment.application.model.Delivery
import davor.beganovic.gorillasassignment.infrastructure.model.DeliveryDTO
import org.springframework.stereotype.Component

@Component
class DeliveryFactory: IDeliveryFactory {

    /**
     * Method for creating list of Delivery objects from list of DeliveryDTO
     * @author Davor
     * @param dtos List<DeliveryDTO>
     * @return List<Delivery>
     */
    override fun createDeliveries(dtos: List<DeliveryDTO>): List<Delivery> {
        return dtos.map(this::createDelivery)
    }

    /**
     * Method for creating Delivery object from DeliveryDTO
     * @author Davor
     * @return Delivery
     */
    override fun createDelivery(dto: DeliveryDTO): Delivery {
        return Delivery(
          dto.deliveryId,
          dto.product,
          dto.supplier,
          dto.quantity,
          dto.expectedDate,
          dto.expectedWarehouse,
          dto.isDelivered
        );
    }
}