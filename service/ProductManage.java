package service;

import model.IO;
import model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ProductManage implements Manage, IO {
    private final Scanner scanner = new Scanner(System.in);
    private static List<Product> products;

    public ProductManage() {
        products = read();
    }

    @Override
    public void display() {
        System.out.printf("%-15s%-25s%-15s%-18s%s",
                "Id", "Name", "Brand", "Price", "Description\n");

        for (Product product : products) {
            product.display();
        }
    }

    @Override
    public List<Product> creat() {
        System.out.println("id :");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter name");
        String name = scanner.nextLine();
        double price;
        while (true) {
            System.out.println("Enter price");
            try {
                price = Double.parseDouble(scanner.nextLine());
                if (price < 0) {
                    throw new NumberFormatException();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
        int quantity;
        while (true) {
            System.out.println("Enter quantity");
            try {
                quantity = Integer.parseInt(scanner.nextLine());
                if (quantity < 0) {
                    throw new NumberFormatException();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Enter describe ");
        String mother = scanner.nextLine();
        Product product = new Product(id, name, price, quantity, mother);
        products.add(product);
        writer(products);
        return products;
    }

    public int getById(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Product update() {
        System.out.println("Nhập id : ");
        int id = -1;
        do {
            try {
                id = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println(e);
            }
        } while (true);
        int idEdit = getById(id);
        if (idEdit != -1) {
            System.out.println("Nhập tên mới: ");
            String name = scanner.nextLine();
            if (!name.equals("")) {
                products.get(idEdit).setName(name);
            }
            System.out.println("Nhập giá : ");
            double d = -1;
            do {
                try {
                    d = Double.parseDouble(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println(e);
                }
            } while (true);
            products.get(idEdit).setPrice(d);
            System.out.println("Nhập số lượng");
            int quantity = -1;
            do {
                try {
                    quantity = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println(e);
                }
            } while (true);
            products.get(idEdit).setQuantity(quantity);
            System.out.println("nhập mô tả: ");
            String mother = scanner.nextLine();
            products.get(idEdit).setMother(mother);
            writer(products);
            return products.get(idEdit);

        }
        return null;
    }

    @Override
    public Product delete() {
        System.out.println("Nhập id xóa: ");
        int id=-1;
        do{
            try {
                id = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println(e);
            }
        }while (true);
        int idDelete=getById(id);
        if(idDelete!=-1){
            System.out.println("Bạn có đồng ý xóa Y/N");
            String str=scanner.nextLine();
            if(str.equals("Y")){
                Product product=products.remove(idDelete);
                writer(products);
                return product;
            }else {
                return null;
            }
        }
        return null;
    }


    @Override
    public void sort() {
        products.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if (o1.getPrice() > o2.getPrice()) return 1;
                else if (o1.getPrice() < o2.getPrice()) return -1;
                else return 0;
            }
        });
        display();
    }

    @Override
    public void searchByPrice() {
        double max = 0;
        for (Product product : products) {
            if (product.getPrice() > max) {
                max = product.getPrice();
            }
        }
        for (Product product : products) {
            if (product.getPrice() == max) {
                System.out.println("The product with the highest price is:" + product);
            }
        }
    }

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