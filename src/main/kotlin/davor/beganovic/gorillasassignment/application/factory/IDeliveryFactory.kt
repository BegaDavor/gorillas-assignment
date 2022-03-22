package davor.beganovic.gorillasassignment.application.factory

import davor.beganovic.gorillasassignment.application.model.Delivery
import davor.beganovic.gorillasassignment.infrastructure.model.DeliveryDTO

interface IDeliveryFactory {
    fun createDelivery(dto: DeliveryDTO): Delivery
    fun createDeliveries(dtos: List<DeliveryDTO>): List<Delivery>
}