package repository;

import model.Product;

import java.util.*;

public class ProductRepositoryImpl implements ProductRepository {
    List<Product> productList = new ArrayList<>();

    {
        productList.add(new Product(1, "Iphone", 1000));
        productList.add(new Product(2, "SamSumg", 1000));
        productList.add(new Product(3, "Nokia", 700));
    }

    //private static ArrayList<Product> product = new ArrayList<>();
    @Override
    public List<Product> findALL() {
        return productList;
    }

    @Override
    public void add(Product product) {
        productList.add(product);
    }

    @Override
    public void update(int id, Product product) {
        productList.set(id-1, product);
    }

    @Override
    public void remove(int id) {
        productList.remove(id-1);
    }

    @Override
    public Product find(String name) {
        for (Product product : productList) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void sortUp() {
        productList.sort(Comparator.comparing(Product::getPrice).reversed());
    }

    @Override
    public void sortDown() {
        productList.sort(Comparator.comparing(Product::getPrice));
    }

}
