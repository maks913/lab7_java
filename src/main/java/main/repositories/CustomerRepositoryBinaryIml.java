package main.repositories;

import main.interfaces.CustomerRepository;
import main.logic.Customer;

import java.io.*;
import java.nio.file.Files;
import java.util.List;

public class CustomerRepositoryBinaryIml implements CustomerRepository {
    @Override
    public void outputList(List<Customer> customers, File file) {
        try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(file.toPath()))) {
            out.writeObject(customers);
        }catch (IOException e){
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
        try(ObjectInputStream in = new ObjectInputStream(Files.newInputStream(file.toPath()))){
            return (List<Customer>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Customer> readList(String fileName) {
        File file = new File(fileName);
        return readList(file);
    }
}