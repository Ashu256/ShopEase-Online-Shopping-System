 package service;

import java.util.ArrayList;
import model.Product;

public class ProductService {

    public static ArrayList<Product> getProducts() {
        ArrayList<Product> list = new ArrayList<>();

        list.add(new Product(1, "Shoes", 999));
        list.add(new Product(2, "T-Shirt", 499));
        list.add(new Product(3, "Watch", 1999));
        list.add(new Product(4, "Laptop", 55000));
        list.add(new Product(5, "Mobile Phone", 15000));
        list.add(new Product(6, "Headphones", 1999));
        list.add(new Product(7, "Bluetooth Speaker", 2499));
        list.add(new Product(8, "Backpack", 899));
        list.add(new Product(9, "Sunglasses", 799));
        list.add(new Product(10, "Jeans", 1299));

        list.add(new Product(11, "Jacket", 2499));
        list.add(new Product(12, "Sneakers", 2999));
        list.add(new Product(13, "Smart Watch", 3499));
        list.add(new Product(14, "Tablet", 12000));
        list.add(new Product(15, "Power Bank", 999));
        list.add(new Product(16, "Camera", 25000));
        list.add(new Product(17, "Keyboard", 799));
        list.add(new Product(18, "Mouse", 499));
        list.add(new Product(19, "Gaming Console", 35000));
        list.add(new Product(20, "LED Monitor", 7000));

        list.add(new Product(21, "Office Chair", 4500));
        list.add(new Product(22, "Study Table", 6000));
        list.add(new Product(23, "Water Bottle", 299));
        list.add(new Product(24, "Shoes (Sports)", 1599));
        list.add(new Product(25, "Cap", 199));
        list.add(new Product(26, "Perfume", 999));
        list.add(new Product(27, "Wallet", 499));
        list.add(new Product(28, "Belt", 399));
        list.add(new Product(29, "Hair Dryer", 1299));
        list.add(new Product(30, "Trimmer", 1499));

        return list;
    }
}
