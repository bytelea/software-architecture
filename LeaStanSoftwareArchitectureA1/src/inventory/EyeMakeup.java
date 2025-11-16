package inventory;

public class EyeMakeup {
    // Attributes
    private String brand;
    private String itemName;
    private String quantity;
    private String size;
    private double price;

    // Constructor
    public EyeMakeup(String brand, String itemName, String quantity2, String size2, double price) {
        this.brand = brand;
        this.itemName = itemName;
        this.quantity = quantity2;
        this.size = size2;
        this.price = price;
    }

    // Getters
    public String getBrand() { return brand; }
    public String getItemName() { return itemName; }
    public String getQuantity() { return quantity; }
    public String getSize() { return size; }
    public double getPrice() { return price; }

    // Setters
    public void setBrand(String brand) { this.brand = brand; }
    public void setItemName(String itemName) { this.itemName = itemName; }
    public void setQuantity(String quantity) { this.quantity = quantity; }
    public void setSize(String size) { this.size = size; }
    public void setPrice(double price) { this.price = price; }
}

