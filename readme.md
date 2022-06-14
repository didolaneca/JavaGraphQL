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
2. Create a `@Service` CrmService to handle the Database logic as the following
    ```
    @Service
    public class CrmService {
    record Customer(Integer id, String name){}

    public Customer getCustomerById(Integer id){
        return new Customer(id, Math.random() > .5 ? "Name1" : "Name2");
    }

    public Collection<Customer> getCustomers(){
        return List.of(new Customer(1, "Name1"), new Customer(2, "Name2"));
    }
    }
    ```
3. Add a `@Bean` of type `RuntimeWiringConfigurer` with the following configuration
    ```
     builder -> builder.type("Query", wiring -> wiring
                .dataFetcher("customerById", env -> crm.getCustomerById(Integer.parseInt(env.getArgument("id"))))
                .dataFetcher("customers", env -> crm.getCustomers()));
    ```
   Note: the CrmService must be injected into the `RuntimeWiringConfigurer` bean so we can use it
4. Add `spring.graphql.graphiql.enabled=true` to the `application.properties` to enable the GraphQL client
5. After we run the application and hit `localhost:8080/graphiql` , we should be able to query our API. 
   Try the following query:
   ```
   query {
    customers{
      id
    }
   }
   ```