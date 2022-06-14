package com.diyan.GraphQLDemo;

import com.diyan.GraphQLDemo.services.CrmService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

@SpringBootApplication
public class GraphQlDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphQlDemoApplication.class, args);
	}

	@Bean
	RuntimeWiringConfigurer runtimeWiringConfigurer(CrmService crm){
		return builder -> builder.type("Query", wiring -> wiring
				.dataFetcher("customerById", env -> crm.getCustomerById(Integer.parseInt(env.getArgument("id"))))
				.dataFetcher("customers", env -> crm.getCustomers()));
	}
}
