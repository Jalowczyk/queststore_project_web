package com.school.onlineshop.part1;

import java.util.ArrayList;
import java.util.Iterator;



public class Basket {

    ArrayList<Product> productList = new ArrayList<Product>();


    public void addProduct(Product product) {
        productList.add(product);
    }

    public Iterator<Product> getIterator() {

        Iterator<Product> ProductIterator = new ProductIterator();
        return ProductIterator;
    }

    public ArrayList<Product> getProductList() {

        return this.productList;
    }

    public void iterateThroughList() {

        Iterator<Product> it = getIterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public Float calculateOrderPrice() {

        Float sum = 0f;
        for (Product item : this.productList) {
            sum += item.getDefaultPrice();
        }
        return sum;
    }

    public void removeProduct(Product product) {

        productList.remove(product);
    }

    public void clearBasket(){

        productList.clear();
    }


    private class ProductIterator implements Iterator {

        private int index;

        public ProductIterator() {
        }

        @Override
        public boolean hasNext() {
            return index < getProductList().size();
        }


        @Override
        public Object next() {
            return getProductList().get(index++);
        }

    }
}




