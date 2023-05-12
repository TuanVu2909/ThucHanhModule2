package model;

public class Product {
    private String id;
    private String name;
    private int price;
    private double quantity;
    private String mother;

    public Product() {
    }

    public Product(String id, String name, int price, double quantity, String mother) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.mother = mother;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getMother() {
        return mother;
    }

    public void setMother(String mother) {
        this.mother = mother;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", mother='" + mother + '\'' +
                '}';
    }
}
