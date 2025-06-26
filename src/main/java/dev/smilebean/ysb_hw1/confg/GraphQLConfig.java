package dev.smilebean.ysb_hw1.confg;

import dev.smilebean.ysb_hw1.controller.DataFetcherController;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.TypeRuntimeWiring;
import graphql.schema.idl.RuntimeWiring.Builder;
import graphql.schema.DataFetcher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

@Configuration
public class GraphQLConfig {

    private final DataFetcherController dataFetcherController;

    public GraphQLConfig(DataFetcherController dataFetcherController) {
        this.dataFetcherController = dataFetcherController;
    }

    @Bean
    public RuntimeWiringConfigurer runtimeWiringConfigurer() {
        return wiringBuilder -> wiringBuilder
                .type(TypeRuntimeWiring.newTypeWiring("Query")
                        .dataFetcher("whatIsGqlContext", dataFetcherController.whatIsGqlContext()));
    }
}
