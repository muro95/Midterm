package controller;

import model.Product;
import service.ProductService;
import service.ProductServiceImpl;

import java.util.List;

public class ProductController {
    ProductService productService = new ProductServiceImpl();

    public List<Product> getProducts() {
        List<Product> productList = productService.findAll();
        if (productList.size() <= 0) {
            System.out.println("It's empty!");
        }
        return productList;
    }

    public void addProduct(Product product){
        productService.add(product);
    }

    public void editProduct(int id, Product product){
        productService.update(id, product);
    }

    public void delete(int id){
        productService.remove(id);
    }

    public Product search(String name){
       return productService.search(name);
    }

    public void sortDown(){
        productService.sortDown();
    }

    public void sortUp(){
        productService.sortUp();
    }
}
