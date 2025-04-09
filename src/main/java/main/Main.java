package main;

import main.factory.*;
import main.controller.Controller;

public class Main {
    private final Controller Controller = new Controller();

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    private void run() {
        Controller.controller(Factory.createCustomers());
    }

}