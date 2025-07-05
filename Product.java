package product;

public class Product {
    private String name;
    private int quantity;
    private double price;
    public Product(String name , int quantity , double price){
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
    public String getName() {
        return this.name;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public double getPrice() {
        return this.price;
    }

    public void discount(int amount) {
        if(amount > quantity){
            throw new IllegalArgumentException("There 's no enough quantity into stock");
        }
        this.quantity -= amount;
    }


    public boolean inStock(int requiredQuantity) {
        return getQuantity() < requiredQuantity;
    }

}