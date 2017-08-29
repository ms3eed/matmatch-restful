##MatMatch Restful

MatMatch Restful endpoint is a solution to the coding test sent by MatMatch

## Technologies
##### Spring Boot:
Spring Boot was chosen because of the ease of use and the ease of
bootstrapping an application with minimal effort.

##### Postgres:
Postgresql was chosen because it is the most advanced, SQL-compliant
and open-source objective-RDBMS since it tries to adopt the ANSI/ISO SQL
standards together with the revisions.

Also it's support for concurrency is achieved without read locks thanks
to the implementation of Multiversion Concurrency Control (MVCC),
which also ensures the ACID compliance.

It is highly programmable, and therefore extendable.

##### Elasticsearch:
At the beginning I was gonna build the Restful app without full text
search support but since it became really easy for a full text search
engine to be integrated with spring through their library
`spring-boot-starter-data` it was really appealing to use elastic search.

Although ElasticSearch and Solar has Apache Lucene in their core, ElasticSearch
Has a really easy to use HTTP API. Plus TransportClient, Thrift (through a plugin)
support. it has a huge set of official client libraries and structured query DSL.


## Development

To start your application in the dev profile, simply run:

    ./gradlew


> Don't forget to set the following env vars:
> * SPRING_DATASOURCE_URL
> * SPRING_DATA_ELASTICSEARCH_CLUSTER_NODES
> * SPRING_DATASOURCE_USERNAME (Optional based on postgres setup)
> * SPRING_DATASOURCE_PASSWORD (Optional based on postgres setup)

## Building for production

To optimize the restful application for production, run:

    ./gradlew -Pprod clean bootRepackage

To ensure everything worked, run:

    java -jar build/libs/*.war

## Using Docker for publishing the code
You can also fully dockerize the application and all the services that it depends on.
To achieve this, first build a docker image of your app by running:

    ./gradlew publish

Then run:

    docker-compose -f docker/app.yml up -d

or simply run
    ./publish.sh

## Accessing the app
You can access the app using any of the JSON client using the url `/api/people`

For the search please use the url `/api/people/search?query=:query&gender:=[Male|Female]`
via `GET` request

## Final Notes on development:

It took me a very long time to build this test since there were too many aspects that
needs to be cleared and a lot of questions needed to be answered.

In this section I'll share with you some of the questions that I had in mind but due to
the time limit I had to make a lot of assumptions and cut back the test to the barebones
of the requirements:
* Do we need to build an ETL pipeline for consumption of the CSV or just load it in the DB?
* Do we need to have authentication and authorization over the api calls and over the data?
* Do we want to use Oauth Mechanism or JWT if we decided to implement authentication?
* What is the API versioning strategy? using sub-domains or include the api version in the URI?
* what are the content types that are accepted to be served by the app
* Can we use ETag for caching?
* what kind of protocols our app supports?