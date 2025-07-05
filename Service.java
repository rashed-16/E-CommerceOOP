package service;

import Customer.Customer;
import cart.Cart;
import cart.CartItem;

import java.util.List;
import product.Intrface.Shippable;

// Helper class that about a collection of Service
public class Service {

    // Print the checkout (include shipment notice and checkout receipt)
    public static void printCheckout(Customer customer , Cart cart){
        // Ensure that this cart is valid for this customer
        VerifyValidityOfPurchases(customer , cart);

        System.out.println("** Shipment notice **");
        for(CartItem item : cart.getItems()){
            if((item.getProduct() instanceof Shippable)){
                System.out.printf("2x %d %s %.2fkg%n",
                        item.getQuantity(),
                        item.getProduct().getName(),
                        item.getWeight())
                ;
            }
        }
        System.out.printf("TOTAL package weight %.1fkg%n%n", cart.getTotalWeight());

        System.out.println("** Checkout receipt **");
        for (CartItem item : cart.getItems()) {
            System.out.printf("%dx %s\t%.0f%n",
                    item.getQuantity(),
                    item.getProduct().getName(),
                    item.getSubtotal());
        }

        System.out.println("----------------------------------------");
        System.out.printf("Subtotal\t%.0f%n", cart.getSubtotal());
        System.out.printf("Shipping\t%.0f%n", cart.getShippedPrice());
        System.out.printf("Amount\t\t%.0f%n", cart.getTotalAmount());
        System.out.printf("Remaining Balance\t\t%.0f%n", customer.getBalance() - cart.getTotalAmount());
    }

    // Payment purchase through (decrease balance and item stock)
    public static void paymentOfPurchases(Customer customer, Cart cart){
        VerifyValidityOfPurchases(customer, cart);

        customer.withdraw(cart.getTotalWeight());
        for(CartItem item: cart.getItems()){
            item.getProduct().discount(item.getQuantity());
        }

        System.out.println("** Successfully payment **");
    }
    public static void ShippingService(List<Shippable> items){
        // TODO: Ship the item (Given names and its weight)
        System.out.println("** The shippable item are ready to ship **");
    }

    // Verify from the validity of purchases
    public static void VerifyValidityOfPurchases(Customer customer , Cart cart){
        if(cart.isEmpty()){
            throw new IllegalArgumentException("The cart can't be empty");
        }
        for(CartItem item : cart.getItems()){
            if(item.getProduct().inStock(item.getQuantity())){
                throw new IllegalArgumentException("There's enough quantity into stock");
            }
        }
        if(customer.getBalance() < cart.getTotalAmount()){
            throw new IllegalArgumentException("The balance 's insufficient");
        }

    }
}