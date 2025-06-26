package dev.smilebean.ysb_hw1.controller;

import dev.smilebean.ysb_hw1.annotation.Gql;
import dev.smilebean.ysb_hw1.annotation.GqlDataFetcher;
import dev.smilebean.ysb_hw1.annotation.GqlType;
import graphql.GraphQLContext;
import graphql.schema.DataFetcher;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Supplier;

@Gql
@Controller
public class DataFetcherController {

    @GqlDataFetcher(type = GqlType.QUERY)
    public DataFetcher<?> whatIsGqlContext() {
        return environment -> {
            ArrayList<Integer> list = new ArrayList<>();
            Integer date = environment.getArgument("date");
            Integer countSize = environment.getArgument("countSize");

            // masking ?
            String maskFlag = "N";
            Optional<GraphQLContext> optGqlContext = Optional.ofNullable(environment.getContext());
            System.out.println(optGqlContext);
            GraphQLContext gqlContext = Optional.ofNullable(environment.getContext())
                    .filter(GraphQLContext.class::isInstance)
                    .map(GraphQLContext.class::cast)
                    .orElseGet(() -> GraphQLContext.newContext().build());
            System.out.println(gqlContext);
            return "hello";
        };
    }
}
