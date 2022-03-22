package davor.beganovic.gorillasassignment.application.service

import davor.beganovic.gorillasassignment.application.factory.DeliveryFactory
import davor.beganovic.gorillasassignment.application.model.Delivery
import davor.beganovic.gorillasassignment.application.service.abs.DeliveryAbstractService
import davor.beganovic.gorillasassignment.domain.service.DeliveryDomainService
import davor.beganovic.gorillasassignment.infrastructure.repository.IDeliveryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DeliveryService(@Autowired val repository: IDeliveryRepository, @Autowired val factory: DeliveryFactory, @Autowired val domainService: DeliveryDomainService): DeliveryAbstractService(repository, factory, domainService) {

    override fun getDeliveries(isDelivered: Boolean): List<Delivery> {
        logger.info("Fetching deliveries with status delivered - $isDelivered")
        return factory.createDeliveries(repository.findAllByIsDelivered(isDelivered))
    }

    @Transactional
    override fun changeDeliveryStatus(deliveryId: String, isDelivered: Boolean): Int {
        logger.info("Update delivery status for delivery with id: $deliveryId to status: delivered - $isDelivered")
        domainService.validateDeliveryStatus(repository.getDeliveryStatus(deliveryId), isDelivered)
        return repository.changeDeliveryStatus(deliveryId, isDelivered)
    }
}