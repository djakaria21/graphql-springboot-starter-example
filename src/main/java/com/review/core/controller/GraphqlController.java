package com.review.core.controller;

import com.review.core.service.GraphQLUserService;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.GraphQLException;
import graphql.schema.GraphQLSchema;
import io.leangen.graphql.GraphQLSchemaGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class GraphqlController {

    private final GraphQL graphQL;

    @Autowired
    public GraphqlController(GraphQLUserService userService) {
        GraphQLSchema schema = new GraphQLSchemaGenerator()
                .withBasePackages("com.review.core")
                .withOperationsFromSingleton(userService)
                .generate();
        this.graphQL = new GraphQL.Builder(schema)
                .build();
    }

    @PostMapping(value = "/graphql")
    public Map<String, Object> execute(@RequestBody Map<String, String> request, HttpServletRequest raw)
            throws GraphQLException {
        ExecutionResult result = graphQL.execute(request.get("query"));
        return result.getData();
    }
}
