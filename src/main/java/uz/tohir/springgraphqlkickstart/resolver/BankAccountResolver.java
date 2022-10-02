package uz.tohir.springgraphqlkickstart.resolver;

import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import uz.tohir.springgraphqlkickstart.domain.BankAccount;
import uz.tohir.springgraphqlkickstart.domain.Client;
import uz.tohir.springgraphqlkickstart.domain.Currency;

import java.util.UUID;

@Slf4j
@Component
public class BankAccountResolver implements GraphQLQueryResolver {

    public BankAccount bankAccount(UUID id) {
        log.info("Retrieving bank account id: {}",id);

        Client clientB = Client.builder()
                .id(UUID.randomUUID())
                .firstName("Bahodir")
                .lastName("Abdullayev")
                .build();

        Client clientA = Client.builder()
                .id(UUID.randomUUID())
                .firstName("Tohir")
                .lastName("Asadov")
                .build();

        clientA.setClient(clientB);
        clientB.setClient(clientA);

        return BankAccount.builder().id(id).currency(Currency.USD).client(clientA).build();
    }

}
