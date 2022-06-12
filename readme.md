## **GraphQL** implementation with Spring Boot

  Create a project from [Spring Initializr](start.spring.io)
  <img width="1286" alt="Screen Shot 2022-06-11 at 7 59 43 PM" src="https://user-images.githubusercontent.com/20631927/173241657-bec97dde-d824-4476-9518-3b14bb72feb6.png">

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