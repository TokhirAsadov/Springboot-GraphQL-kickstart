package uz.tohir.springgraphqlkickstart;

import graphql.analysis.MaxQueryComplexityInstrumentation;
import graphql.analysis.MaxQueryDepthInstrumentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringGraphqlKickstartApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringGraphqlKickstartApplication.class, args);
    }


    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "spring.graphql.instrumentation", name = "max-query-complexity")
    public MaxQueryComplexityInstrumentation maxQueryComplexityInstrumentation(@Value("${spring.graphql.instrumentation.max-query-complexity}") int maxComplexity) {
        return new MaxQueryComplexityInstrumentation(maxComplexity);
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "spring.graphql.instrumentation", name = "max-query-depth")
    public MaxQueryDepthInstrumentation maxQueryDepthInstrumentation(@Value("${spring.graphql.instrumentation.max-query-depth}") int maxDepth) {
        return new MaxQueryDepthInstrumentation(maxDepth);
    }

}
