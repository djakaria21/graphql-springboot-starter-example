# Spring boot with SPQR GraphQL example with in mem MongoDB

This is a simple example of how to use the spqr library to create a GraphQL endpoint in a Spring Boot application.

## Reason for this example

I found that the existing examples of using a framework to create graphql endpoints in java/spring boot usually ended up just using a blank hashmap to serve as the database so I thought I would create an example that used the mongodb repository class.

## Running the application

To run the application, simply run the following commands:

```bash 
mvn clean install
mvn spring-boot:run 
``` 

The application should be available at http://localhost:8080/gui

## Using the application

The application has a single endpoint, which is the graphql endpoint.  The endpoint is available at http://localhost:8080/graphql

In the project I have included a postman colleciton that has the queries that can be used to test the application.

I found that the examples online for graphql queries/mutations in general and how to use parameters with those graphql queries weren't very clear.  Hopefully playing around with this example will help you understand how to use graphql queries/mutations with parameters.
