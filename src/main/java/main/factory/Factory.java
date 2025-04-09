package main.factory;

import main.logic.Customer;

import java.util.ArrayList;
import java.util.List;

public class Factory {
    public static List<Customer> createCustomers() {
        return new ArrayList<>(List.of(
                new Customer(1, "Alice Brown", "Kiev", 5055, 1434, 23, 4321),
                new Customer(2, "Bob Smith", "New York", 2004, 3432, 21, 1323),
                new Customer(3, "Charlie Johnson", "Paris", 1505, -3434, 43, 4321),
                new Customer(4, "Avid Wilson", "Tokyo", 5034, 43434, 432, 43343),
                new Customer(5, "Bon Pick", "Tokyo", 5032, 43434, 432, 43343)
        ));
    }
}