package service;

import model.Product;

import java.util.List;

public interface Manage {
    void display();
    List<Product> creat();
    Product update();
    Product delete();
    void sort();
    void searchByPrice();
}
