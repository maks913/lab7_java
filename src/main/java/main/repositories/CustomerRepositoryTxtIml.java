package main.repositories;
import main.interfaces.CustomerRepository;
import main.logic.Customer;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;


public class CustomerRepositoryTxtIml implements CustomerRepository {
    public void outputList(List<Customer> customers, File file) {
        try (PrintWriter out = new PrintWriter(Files.newBufferedWriter(file.toPath(), StandardCharsets.UTF_8))) {
            if (customers != null) {
                for (Customer customer : customers) {
                    out.println(customer.getId() + ";" +
                            customer.getCity() + ";" +
                            customer.getCustomerName() + ";" +
                            customer.getCardNumber() + ";" +
                            customer.getAccBalance() + ";" +
                            customer.getNumberOfPurchases() + ";" +
                            customer.getTotalPurchases() + ";");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void outputList(List<Customer> customers, String fileName) {
        File file = new File(fileName);
        outputList(customers, file);
    }

    @Override
    public List<Customer> readList(File file) {
        int size = 7;
        List<Customer> customers = new ArrayList<>();
        try (BufferedReader in = Files.newBufferedReader(file.toPath(), StandardCharsets.UTF_8)) {
            String line;
            while ((line = in.readLine()) != null) {
                String[] tokens = line.split(";");
                if (tokens.length == size) {
                    customers.add(new Customer(
                            Integer.parseInt(tokens[0]),
                            tokens[1],
                            tokens[2],
                            Integer.parseInt(tokens[3]),
                            Integer.parseInt(tokens[4]),
                            Integer.parseInt(tokens[5]),
                            Integer.parseInt(tokens[6])
                    ));
                }
            }
            return customers;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Customer> readList(String fileName) {
        File file = new File(fileName);
        return readList(file);
    }
}