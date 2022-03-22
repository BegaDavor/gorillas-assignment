<h1>Gorillas Assignment - Deliveries</h1>
<h2>Davor Beganovic</h2>
Build application:
`mvn clean install -Dmaven.test.skip=true`

Service starts on: 8081 port

<h3>GraphQL schema, queries, mutations ant other types: </h3>
<pre>
<code>
schema {
    query: Query,
    mutation: Mutation
}

type Query {
    getDeliveries(isDelivered: Boolean): [Delivery]
}

type Mutation {
    changeDeliveryStatus(deliveryId: String, isDelivered: Boolean): Boolean
}

type Delivery {
    deliveryId: String,
    product: String,
    supplier: String,
    quantity: Int,
    expectedDate: String,
    expectedWarehouse: String,
    isDelivered: Boolean
}
</code>
</pre>

<h3>API</h3>
- endpoint: http://localhost:8081/deliveries
- method: POST

The data from the json file is imported at the start of the application.