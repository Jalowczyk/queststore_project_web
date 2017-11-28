package com.school.onlineshop.part1;

import java.util.ArrayList;

public class Product {

    private String name;
    private Float defaultPrice;
    private ProductCategory category;
    private Integer id;
    private static ArrayList<Product> productList = new ArrayList<Product>();

    public Product(String name, Float defaultPrice, ProductCategory productCategory) {

        this.name = name;
        this.defaultPrice = defaultPrice;
        this.category = productCategory;
        this.id = IdGenerator.generateId();

        productList.add(this);

    }

    public static ArrayList<Product> getAllProducts() {
        return productList;
    }

    public static ArrayList<Product> getProductsByCategory(ProductCategory category) {

        ArrayList<Product> allProductsByCat = new ArrayList<>();
        for (Product product : getAllProducts()) {
            if (product.category.getName().equals(category.getName())) {
                allProductsByCat.add(product);
            }
        }
        return allProductsByCat;
    }

    public String toString() {

        String info = String.format("Id: %s\nProduct name: %s%n\nprice: $%s%ncategory: %s%n",id, name, defaultPrice, category.getName());
        return info;
    }


    public String getName() {
        return this.name;
    }

    public Float getDefaultPrice(){
        return this.defaultPrice;
    }
}
