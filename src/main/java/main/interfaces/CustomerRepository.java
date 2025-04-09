package main.interfaces;
import main.logic.Customer;
import java.io.File;
import java.util.List;

public interface CustomerRepository extends Repository<Customer> {
    void outputList(List<Customer> t, File file);
    void outputList(List<Customer> t, String fileName);

    List<Customer> readList(File file);
    List<Customer> readList(String fileName);
}