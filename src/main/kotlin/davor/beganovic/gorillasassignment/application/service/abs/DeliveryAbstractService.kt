package davor.beganovic.gorillasassignment.application.service.abs

import davor.beganovic.gorillasassignment.application.factory.IDeliveryFactory
import davor.beganovic.gorillasassignment.application.model.Delivery
import davor.beganovic.gorillasassignment.domain.service.IDeliveryDomainService
import davor.beganovic.gorillasassignment.infrastructure.repository.IDeliveryRepository
import mu.KotlinLogging

abstract class DeliveryAbstractService(repository: IDeliveryRepository, factory: IDeliveryFactory, deliveryDomainService: IDeliveryDomainService) {
    val logger = KotlinLogging.logger {}

    abstract fun getDeliveries(isDelivered: Boolean): List<Delivery>
    abstract fun changeDeliveryStatus(deliveryId: String, isDelivered: Boolean): Int
}