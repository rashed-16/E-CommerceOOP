# E-Commerce System (Java)

This is a simple Java-based e-commerce system that simulates basic shopping cart functionalities.

## 📦 Features
- Add different types of products to a cart.
- Products may be:
  - Shippable
  - Expirable
  - Both (e.g. food products)
- Prevent adding expired products to the cart.
- Checkout and payment functionality.
- Shipping service handles only shippable products.

## 🧑‍💻 Technologies
- Java SE
- Java OOP (Inheritance, Interfaces, Polymorphism)
- NetBeans IDE

## 🛒 Sample Products Used
- **TV**: Shippable
- **Cheese**: ExpiredShippableProduct
- **Scratch Card**: General product
- **Milk**: Expirable

## ▶️ How to Run
1. Open the project in NetBeans.
2. Run the `Main.java` file from:  
   `com.mycompany.e.commerce.Main`
3. Console will show:
   - Checkout summary
   - Payment process
   - Shipping list

## ⚠️ Notes
- Expired products are rejected at cart level.
- Make sure your system date is appropriate for testing expiry features.

