package davor.beganovic.gorillasassignment.ui.resource

import davor.beganovic.gorillasassignment.application.service.GraphQLService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping( "/deliveries")
@RestController
class DeliveryResource(@Autowired val graphQLService: GraphQLService) {

    @PostMapping
    fun getDeliveries(@RequestBody query: String): ResponseEntity<Any> {
       val executionResult = graphQLService.graphQL!!.execute(query)
        return ResponseEntity(executionResult, HttpStatus.OK)
    }
}