package cart;

import product.Intrface.Shippable;
import product.Product;

public class CartItem {
    private Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    // Getters
    public Product getProduct() {
        return product;
    }
    public int getQuantity() {
        return quantity;
    }

    // Compute the total weight (In case shippable item)
    public double getWeight(){
        return product instanceof Shippable ? ((Shippable) product).getWeight() * quantity : 0;
    }

    // Compute the total price (Not included shipment fee)
    public double getSubtotal(){
        return product.getPrice() * quantity;
    }

    // Compute the shipment fee (In case shippable item)
    public double getShippedPrice(){
        return  product instanceof  Shippable ? ((Shippable) product).getWeight() * quantity * Shippable.RATE_PRE_KG : 0;
    }

    // Compute the total price of item (includes shipment fee if exits)
    public double getTotalAmount(){
        return getSubtotal() + getShippedPrice();
    }

}