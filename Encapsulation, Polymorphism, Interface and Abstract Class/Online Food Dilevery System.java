interface Discountable {
    void applyDiscount(double percent);
    String getDiscountDetails();
}

abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public abstract double calculateTotalPrice();

    public String getItemDetails() {
        return itemName + " x" + quantity + " @ ₹" + price;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}

class VegItem extends FoodItem implements Discountable {
    private double discount = 0;

    public VegItem(String name, double price, int qty) {
        super(name, price, qty);
    }

    public double calculateTotalPrice() {
        return (getPrice() * getQuantity()) - discount;
    }

    public void applyDiscount(double percent) {
        discount = (getPrice() * getQuantity()) * percent / 100;
    }

    public String getDiscountDetails() {
        return "Veg Discount: ₹" + discount;
    }
}

class NonVegItem extends FoodItem implements Discountable {
    private double discount = 0;

    public NonVegItem(String name, double price, int qty) {
        super(name, price, qty);
    }

    public double calculateTotalPrice() {
        return (getPrice() * getQuantity()) + 50 - discount;
    }

    public void applyDiscount(double percent) {
        discount = (getPrice() * getQuantity()) * percent / 100;
    }

    public String getDiscountDetails() {
        return "Non-Veg Discount: ₹" + discount;
    }
}

public class FoodDeliveryDemo {
    public static void main(String[] args) {
        FoodItem[] order = {
            new VegItem("Paneer Tikka", 250, 2),
            new NonVegItem("Chicken Biryani", 300, 1)
        };

        for (FoodItem item : order) {
            ((Discountable) item).applyDiscount(10);
            System.out.println(item.getItemDetails());
            System.out.println("Total Price: ₹" + item.calculateTotalPrice());
            System.out.println(((Discountable) item).getDiscountDetails());
            System.out.println();
        }
    }
}
