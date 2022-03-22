<h1>Gorillas Assignment - Deliveries</h1>
<h2>Davor Beganovic</h2>
Build application:
`mvn clean install -Dmaven.test.skip=true`

GraphQL schema, queries, mutations ant other types: 

`schema {
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
}`

