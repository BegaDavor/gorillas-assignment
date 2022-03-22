package davor.beganovic.gorillasassignment.application.service

import davor.beganovic.gorillasassignment.application.service.fetcher.ChangeDeliveryStatusFetcher
import davor.beganovic.gorillasassignment.application.service.fetcher.GetDeliveriesFetcher
import graphql.GraphQL
import graphql.schema.GraphQLSchema
import graphql.schema.idl.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.io.Resource
import org.springframework.stereotype.Service
import java.io.File
import java.io.IOException
import javax.annotation.PostConstruct

@Service
class GraphQLService(@Autowired val getDeliveriesFetcher: GetDeliveriesFetcher, @Autowired val changeDeliveryStatusFetcher: ChangeDeliveryStatusFetcher) {

    @Value("classpath:delivery.graphql")
    var resource: Resource? = null
    var graphQL: GraphQL? = null

    @PostConstruct
    @Throws(IOException::class)
    private fun loadSchema() {

        //Load Books into the Book Repository
        //loadDataIntoHSQL()

        // get the schema
        val schemaFile: File = resource!!.file
        // parse schema
        val typeRegistry: TypeDefinitionRegistry = SchemaParser().parse(schemaFile)
        val wiring: RuntimeWiring = buildRuntimeWiring()!!
        val schema: GraphQLSchema = SchemaGenerator().makeExecutableSchema(typeRegistry, wiring)
        graphQL = GraphQL.newGraphQL(schema).build()
    }

    private fun buildRuntimeWiring(): RuntimeWiring? {
        return RuntimeWiring.newRuntimeWiring()
            .type("Query") { typeWiring: TypeRuntimeWiring.Builder ->
                typeWiring
                    .dataFetcher("getDeliveries", getDeliveriesFetcher)
            }
            .type("Mutation") { typeWiring: TypeRuntimeWiring.Builder ->
                typeWiring
                    .dataFetcher("changeDeliveryStatus", changeDeliveryStatusFetcher)
            }
            .build()
    }
}