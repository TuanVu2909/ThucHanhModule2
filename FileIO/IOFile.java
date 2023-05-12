package FileIO;

import model.IO;
import model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOFile implements IO {
    @Override
    public void writer(List<Product> products) {
        File file = new File("C:\\Users\\Admin\\Desktop\\BaiThiThucHanhModule2\\untitled\\src\\FileIO\\Text.txt");
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            for (Product product : products) {
                bufferedWriter.write(product.getId() + ", " + product.getName() +
                        ", " + product.getPrice() + ", " + product.getQuantity() +
                        ", " + product.getMother() + "\n");
            }
        } catch (IOException ioException) {
            System.err.println(ioException.getMessage());
        }
    }

    @Override
    public List<Product> read() {
        File file = new File("C:\\Users\\Admin\\Desktop\\BaiThiThucHanhModule2\\untitled\\src\\FileIO\\Text.txt");
        ArrayList<Product> product = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String data;
            while ((data = bufferedReader.readLine()) != null) {
                String[] strings = data.split(", ");
                product.add(new Product(Integer.parseInt(strings[0]), strings[1], Double.parseDouble(strings[2]), Integer.parseInt(strings[3]), strings[4]));
            }

        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }
        return product;
    }
}

