package com.mycompany.e.commerce;

import Customer.Customer;
import cart.Cart;
import product.*;
import service.Service;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // List of available products
        Product tv = new ShippableProduct("TV" , 3 , 1200 , 10.0);
        Product cheese = new ExpiredShippableProduct("cheese" , 3 , 30 , 1.0, LocalDate.of(2026,10,10));
        Product scratchCard = new Product("scratch card" , 3 , 20);
        Product milk = new ExpirableProduct("Milk" , 10 , 10 , LocalDate.of(2026 , 12 , 20));

        Customer customer = new Customer("Rashed", 2500);

        // Add items to cart
        Cart cart = new Cart();
        cart.add(tv , 2);
        cart.add(cheese , 1);
        cart.add(scratchCard , 2);
        cart.add(milk , 2);

        Service.printCheckout(customer , cart); // print the checkout of cart's items
        Service.paymentOfPurchases(customer, cart); // payment of purchases
        Service.ShippingService(cart.getShippedItems()); // collect all items that need to be shipped and send them to ShippingService
    }
}