package main.logic;

import java.io.Serializable;

public class Customer implements Serializable {
    private int id;
    private String customerName;
    private String city;
    private int cardNumber;
    private int accBalance;
    private int numberOfPurchases;
    private int totalPurchases;

    public Customer(int id, String customerName,String city, int cardNumber, int accBalance, int numberOfPurchases,int totalPurchases) {
        this.id = id;
        this.customerName = customerName;
        this.city = city;
        this.cardNumber = cardNumber;
        this.accBalance = accBalance;
        this.numberOfPurchases = numberOfPurchases;
        this.totalPurchases = totalPurchases;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getAccBalance() {
        return accBalance;
    }

    public void setAccBalance(int accBalance) {
        this.accBalance = accBalance;
    }

    public int getNumberOfPurchases() {
        return numberOfPurchases;
    }

    public void setNumberOfPurchases(int numberOfPurchases) {
        this.numberOfPurchases = numberOfPurchases;
    }

    public int getTotalPurchases() {
        return totalPurchases;
    }

    public void setTotalPurchases(int totalPurchases) {
        this.totalPurchases = totalPurchases;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAveragePurchase() { return totalPurchases / numberOfPurchases;}

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", customerName=" + customerName +
                ", city=" + city +
                ", cardNumber=" + cardNumber +
                ", accBalance=" + accBalance +
                ", numberOfPurchases=" + numberOfPurchases +
                ", totalPurchases=" + totalPurchases +
                '}';
    }


}