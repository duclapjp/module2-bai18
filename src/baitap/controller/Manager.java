package baitap.controller;

import baitap.model.Product;

import java.util.ArrayList;
import java.util.List;

public class Manager {
    List<Product> productList  =new ArrayList<>();

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Manager() {
    }

    public void addProduct(Product product){
        productList.add(product);
    }
    public void showAllProduct(){
        for (Product p:productList) {
            System.out.println(p);
        }
    }
    @Override
    public String toString() {
        return "Manager{" +
                "productList=" + productList +
                '}';
    }
}
