package model;

import java.util.List;

public interface IO {
    void writer(List<Product> products);

    List<Product> read();
}
