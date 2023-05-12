package controller;

import FileIO.IOFile;
import service.ProductManage;

import java.util.List;
import java.util.Scanner;

public class MainTest {
    public static void main(String[] args) {
        Scanner  scanner = new Scanner(System.in);
        ProductManage productManage = new ProductManage();
        IOFile ioFile = new IOFile();
        int choice ;
        do {
            System.out.println("----CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM----");
            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xóa");
            System.out.println("5. Sắp xếp");
            System.out.println("6. Tìm sản phẩm có giá đắt nhất");
            System.out.println("7. Đọc từ File");
            System.out.println("8. Ghi vào File");
            System.out.println("9. Thoát");
            System.out.println("Chọn chức năng : ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    productManage.display();
                    break;
                case 2:
                    productManage.creat();
                    break;
                case 3:
                    productManage.update();
                    break;
                case 4:
                    productManage.delete();
                    break;
                case 5:
                    productManage.sort();
                    break;
                case 6:
                    productManage.searchByPrice();
                    break;
                case 7:
                    productManage.read();
                    break;
                case 8:
                    break;
                case 9:
                    System.exit(0);
                    break;
            }

        }while (true);

    }
}
