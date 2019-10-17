package views;

import controller.ProductController;
import model.Product;

import java.util.List;
import java.util.Scanner;

public class main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Product Management");
        ProductController productController = new ProductController();
        int choice;
        do {
            menu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    List<Product> productList = productController.getProducts();
                    for (Product product : productList) {
                        System.out.println("ID: " + product.getId()
                                + " Name: " + product.getName()
                                + " Price: " + product.getPrice());
                    }
                    break;
                }
                case 2: {
                    System.out.println("Adding Product");
                    Product productObject = inputProduct();
                    productController.addProduct(productObject);
                    break;
                }
                case 3: {
                    System.out.println("Edit Product ID: ");
                    int idInput = scanner.nextInt();
                    Product productObject = inputProduct();
                    productController.editProduct(idInput, productObject);
                    break;
                }
                case 4: {
                    System.out.println("Delete Product ID: ");
                    int idInput = scanner.nextInt();
                    productController.delete(idInput);
                    break;
                }
                case 5: {
                    scanner.nextLine();
                    System.out.println("Search by name: ");
                    String name = scanner.nextLine();
                    Product p = productController.search(name);
                    if (p == null) {
                        System.out.println("No result: " + name);
                    } else {
                        System.out.println("Product is in the list: " + p);
                    }
                    break;

                }
                case 6: {
                    System.out.println("Sort Up");
                    productController.sortUp();
                    break;
                }
                case 7: {
                    System.out.println("Sort Down");
                    productController.sortDown();
                    break;
                }
            }
        } while (choice != 0);
    }

    private static void menu() {
        System.out.println("1. Show All Product");
        System.out.println("2. Add");
        System.out.println("3. Edit");
        System.out.println("4. Delete");
        System.out.println("5. Search by Product name");
        System.out.println("6. Sort Up");
        System.out.println("7. Sort Down");
        System.out.println("0. Exit");
        System.out.print("Please select one: ");
    }

    private static Product inputProduct() {
        System.out.println("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        System.out.println("Enter price: ");
        Double price = scanner.nextDouble();
        Product product = new Product(id, name, price);
        return product;
    }
}
