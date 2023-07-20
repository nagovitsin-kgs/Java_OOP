package Seminar_01.vending_machine;

import Seminar_01.vending_machine.products.Bottle;
import Seminar_01.vending_machine.products.Product;
import Seminar_01.vending_machine.vending.VendingMachine;

public class Main {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();

        Product product1 = new Bottle("coca-cola", 150, 1.5);
        Product product2 = new Product("milko", 100);

        vendingMachine.addProduct(product1);
        vendingMachine.addProduct(product2);

        System.out.println(vendingMachine.getProductsInfo());
        // Список продуктов:
        // id: 0, name: coca-cola, price: 150.0р., volume: 1.5л.
        // id: 1, name: milko, price: 100.0р.
    }
}
