package service;

import java.util.ArrayList;
import model.Product;

public class CartService {
    private static ArrayList<Product> cart = new ArrayList<>();

    public static void addToCart(Product p) {
        cart.add(p);
    }

    public static ArrayList<Product> getCart() {
        return cart;
    }
}
