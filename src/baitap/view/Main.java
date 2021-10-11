package baitap.view;

import baitap.controller.Manager;
import baitap.model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner  =new Scanner(System.in);
        List<Product> productList  =new ArrayList<>();
        Manager duclap = new Manager();
        productList.add(new Product("c01","Iphone","jp",1000,"old"));
        productList.add(new Product("c02","Samsung","korean",2000,"new"));
        productList.add(new Product("c03","Nokia","vn",3000,"new"));
        productList.add(new Product("c04","Dell","germany",1500,"old"));
        productList.add(new Product("c05","Vertu","usa",5000,"old"));

        while (true){
            System.out.println("------MENU-------");
            System.out.println("1:Thêm sản phẩm");
            System.out.println("2:Hiển thị sản phẩm");
            System.out.println("3:Tìm kiếm thông tin sản phẩm");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    duclap.addProduct(creatProduct());

                    writeFile("baitap.txt",productList);
                    break;
                case 2:
                    List<Product> products = readFile("baitap.txt");
                    for (Product p :products) {
                        System.out.println(p.toString());
                    }
                    break;
//                case 3:

            }
        }
    }
    public static void writeFile(String path, List<Product> productList){
        try{
            File file = new File(path);
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(productList);
            fos.close();
            oos.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            System.out.println("in ra file thành công");
        }
    }
    public static List<Product> readFile(String path){
        List<Product> products = new ArrayList<>();
        try {
            FileInputStream ios = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(ios);
            products = (List<Product>) ois.readObject();
            ios.close();
            ois.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("đọc file thành công");
        }
        return products;
    }
    public static Product creatProduct(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập vào tên sản phẩm");
        String name = scanner.nextLine();
        System.out.println("nhập vào mã sản phẩm");
        String code = scanner.nextLine();
        System.out.println("nhập vào hãng sản xuất");
        String brand = scanner.nextLine();
        System.out.println("nhập vào giá");
        int price = scanner.nextInt();
        System.out.println("nhập vào mô tả");
        scanner.nextLine();
        String description = scanner.nextLine();
        Product product = new Product(code,name,brand,price,description);
        return product;
    }
}
