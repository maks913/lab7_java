package main.controller;

import main.io.View;
import main.logic.Customer;
import main.service.CustomerService;

import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Controller {
    private final CustomerService customerService = new CustomerService();
    private final Scanner scanner = new Scanner(System.in);
    private final View view = new View();

    public void controller(List<Customer> customers) {
        int choice;
        while (true) {
            view.menu();
            choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 0) {break;}
            switch (choice) {
                case 1 -> {
                    view.showMessage("Enter customers first letters:");
                    String n = scanner.nextLine();
                    view.showCustomers(customerService.findCustomersByLetters(customers, n));
                }
                case 2 ->{
                    view.showMessage("Enter specified credit card range:");
                    int a = scanner.nextInt();
                    int b = scanner.nextInt();
                    view.showCustomers(customerService.findCustomersByCreditCardRange(customers, a, b));
                }

                case 3 ->{
                    view.showMessage("List customers who have debt:");
                    view.showCustomers(customerService.findCustomerByArrears(customers));
                }
                case 4->{
                    view.showMessage("List customers:");
                    view.showCustomers(customerService.customersByTotalPurchases(customers));
                }
                case 5->{
                    view.showMessage("Enter customer ID:");
                    int customerId = scanner.nextInt();
                    int avgPurchase = customerService.findCustomerById(customers,customerId);
                    if(avgPurchase == -1) {
                        view.showMessage("Customer not found");
                    }else{
                        view.showMessage("Average purchase:" + avgPurchase);
                    }
                }
                case 6 ->{
                    view.showMessage("Enter file name:");
                    String filename = scanner.nextLine();
                    customerService.outputListTxt(customers, filename);
                }
                case 7 ->{
                    view.showMessage("Enter file name:");
                    String filename = scanner.nextLine();
                    customerService.outputListBinary(customers, filename);
                }
                case 8->{
                    view.showMessage("Enter file name:");
                    String file = scanner.nextLine();
                    customers =  customerService.readListTxt(file);
                }
                case 9 ->{
                    view.showMessage("Enter file name:");
                    String file = scanner.nextLine();
                    customers = customerService.readListBinary(file);
                }
                case 10 ->{
                    view.showMessage("All customers:");
                    view.showCustomers(customers);
                }
                case 11 ->{
                    view.showMessage("Enter ID of customer:");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    view.showMessage("Enter customer name:");
                    String name = scanner.nextLine();
                    view.showMessage("Enter customer city:");
                    String city = scanner.nextLine();
                    view.showMessage("Enter customer card number:");
                    int cardNumber = scanner.nextInt();
                    scanner.nextLine();
                    view.showMessage("Enter customer account balance:");
                    int accountBalance = scanner.nextInt();
                    view.showMessage("Enter customer number of purchase:");
                    int numberOfPurchase = scanner.nextInt();
                    view.showMessage("Enter customer total spend:");
                    int totalSpend = scanner.nextInt();

                    Customer newCustomer = new Customer(id,name,city,cardNumber,accountBalance,numberOfPurchase,totalSpend);
                    customerService.addCustomer(customers,newCustomer);
                    view.showMessage("Customer added");
                }
                case 12 -> {
                    view.showMessage("Enter ID of customer:");
                    int id = scanner.nextInt();
                    boolean removed = customerService.removeCustomerById(customers, id);
                    if (removed) {
                        view.showMessage("Customer removed successfully.");
                    } else {
                        view.showMessage("Customer with ID " + id + " not found.");
                    }
                }
                case 13 -> {
                    Map<String, List<Customer>> grouped = customerService.groupCustomersByCityAndName(customers);
                    grouped.forEach((city, customersList) -> {
                        view.showMessage("-------------------------------");
                        view.showMessage("City: " + city);
                        customersList.forEach(customer -> {
                            view.showMessage("-" + customer.getCustomerName());
                        });
                        view.showMessage("-------------------------------");
                    });
                }
                case 14 -> {
                    Map<String, Integer> totalSpendByCity = customerService.calcByTotalPurchase(customers);
                    totalSpendByCity.forEach((city, totalSpend) -> {
                        view.showMessage("====================================");
                        view.showMessage("City: " + city);
                        view.showMessage("Total spend: " + totalSpend);
                        view.showMessage("====================================");
                    });
                }
                default ->{
                    view.showMessage("Invalid choice");
                }
            }
        }
    }

}