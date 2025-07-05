package product;



import java.time.LocalDate;
import product.Intrface.Expirable;
import product.Intrface.Shippable;

public class ExpiredShippableProduct extends Product implements Expirable, Shippable {
    private double weight;
    private LocalDate expiredDate;
    public ExpiredShippableProduct(String name, int quantity, double price, double weight , LocalDate expiredDate) {
        super(name,quantity,price);
        this.weight = weight;
        this.expiredDate = expiredDate;
    }

    @Override
    public boolean isExpired(){
        return LocalDate.now().isAfter(expiredDate);
    }

    @Override
    public double getWeight() {
        return this.weight;
    }


}