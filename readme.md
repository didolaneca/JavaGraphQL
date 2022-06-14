## **GraphQL** implementation with Spring Boot

  Create a project from [Spring Initializr](start.spring.io)

  <img width="1259" alt="Screen Shot 2022-06-14 at 5 00 06 PM" src="https://user-images.githubusercontent.com/20631927/173697522-70a12717-f345-4c59-af75-1a3de9417ddd.png">

1. Create a `graphql` folder under the `resources` folder. The Spring Boot
    starter looks for ".GRAPHQLS" or ".GQLS" files in the folder.
   - Add the following code to the graphql schema file
     ```
     type Query {
      customers: [Customer]
      customerById(id: ID): Customer
     }
     
     type Customer {
       id: ID
       name: String
     }
     ```
