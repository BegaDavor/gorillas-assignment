package davor.beganovic.gorillasassignment.domain.service

interface IDeliveryDomainService {
    fun validateDeliveryStatus(oldDeliveryStatus: Boolean, newDeliveryStatus: Boolean)
}