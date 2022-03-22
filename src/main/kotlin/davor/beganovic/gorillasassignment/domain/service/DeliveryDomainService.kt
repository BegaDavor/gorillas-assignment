package davor.beganovic.gorillasassignment.domain.service

import org.springframework.stereotype.Service

@Service
class DeliveryDomainService: IDeliveryDomainService {
    override fun validateDeliveryStatus(oldDeliveryStatus: Boolean, newDeliveryStatus: Boolean) {
        if(oldDeliveryStatus == newDeliveryStatus)
            throw Exception("Delivery is already in status $oldDeliveryStatus")
    }

}