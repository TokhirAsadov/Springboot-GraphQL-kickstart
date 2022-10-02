package uz.tohir.springgraphqlkickstart.domain;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Builder
@Value
public class BankAccount {

    UUID id;
    Client client;
    Currency currency;
}
