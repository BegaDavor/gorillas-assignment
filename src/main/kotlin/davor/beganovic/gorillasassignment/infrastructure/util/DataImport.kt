package davor.beganovic.gorillasassignment.infrastructure.util

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import davor.beganovic.gorillasassignment.infrastructure.model.DeliveryDTO
import davor.beganovic.gorillasassignment.infrastructure.repository.IDeliveryRepository
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.core.io.Resource
import org.springframework.stereotype.Component
import java.io.File
import java.io.IOException

@Component
class DataImport(@Autowired val repository: IDeliveryRepository) {
    private val logger = KotlinLogging.logger {}

    @Value("classpath:deliveries.json")
    var resource: Resource? = null

    @Bean
    fun insertDataIntoDB() {
        logger.info("Import data into DB")
        lateinit var json: String
        val jsonFile: File = resource!!.file
        try {
            if(resource!!.isReadable) {
                json = jsonFile
                    .bufferedReader()
                    .use { it.readText() }
            }
        } catch (ioException: IOException) {
           logger.error(ioException.message)
        }
        val deliveryType = object : TypeToken<List<DeliveryDTO?>?>() {}.type
        val gson: Gson = GsonBuilder().create()
        val deliveries: List<DeliveryDTO> = gson.fromJson(json, deliveryType)
        repository.saveAllAndFlush(deliveries)
    }
}

