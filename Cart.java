package cart;

import product.Product;

import java.util.ArrayList;
import java.util.List;
import product.Intrface.Expirable;
import product.Intrface.Shippable;

public class Cart {
    private List<CartItem> items;

    public Cart(){
        items = new ArrayList<>();
    }

    public void add(Product product , int quantity){
        // Ensure that the quantity is positive
        if(quantity <= 0){
            throw new IllegalArgumentException("You can't be a non-positive no. of quantity");
        }
        // Ensure that there's enough quantity in stock
        if(product.inStock(quantity)){
            throw new IllegalArgumentException("There 's no enough quantity into stock");
        }
        // Ensure that the product isn't expired
        if(product instanceof Expirable && ((Expirable) product).isExpired()){
            throw new IllegalArgumentException("This product is expired");
        }
        items.add(new CartItem(product,quantity));
    }

    // Getters
    public boolean isEmpty(){
        return items.isEmpty();
    }
    public List<CartItem> getItems() {
        return items;
    }
    public List<Shippable> getShippedItems(){
        List<Shippable> shippedItems = new ArrayList<>();
        for(CartItem item: items){
            if(item.getProduct() instanceof Shippable){
                shippedItems.add((Shippable) item.getProduct());
            }
        }
        return shippedItems;
    }

    // Compute the total price of shipment based on shippable items
    public double getShippedPrice(){
        double total = 0;
        for(CartItem item : items){
            total += item.getShippedPrice();
        }
        return total;
    }

    // Compute the total weight of shipment items
    public double getTotalWeight(){
        double total = 0;
        for(CartItem item : items){
            if(item.getProduct() instanceof Shippable){
                total += item.getWeight();
            }
        }
        return total;
    }

    // Compute the total price of items in cart (Not includes shipment fee)
    public double getSubtotal(){
        double total = 0;
        for(CartItem item : items){
            total += item.getSubtotal();
        }
        return total;
    }

    // Compute the total price of items in cart (includes shipment fee)
    public double getTotalAmount(){
        double total = 0;
        for(CartItem currentItem: items){
            total += currentItem.getTotalAmount();
        }
        return total;
    }


}