package com.main;

import com.config.AppConfig;
import com.dto.ProductDTO;
import com.model.Category;
import com.model.Product;
import com.model.Vendor;
import com.service.CategoryService;
import com.service.ProductService;
import com.service.VendorService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AppECom {
    public static void main(String[] args) {

        // create a context to use the object references.
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        ProductService productService = context.getBean(ProductService.class);
        CategoryService categoryService = context.getBean(CategoryService.class);
        VendorService vendorService = context.getBean(VendorService.class);
        // ops to perform
        //1.INSERT product with FK
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("-----------E-Commerce-----------");

            System.out.println("-----------Main Menu ------------");
            System.out.println("1.Upload Product");
            System.out.println("2.Find the Product By Id");
            System.out.println("3.Update Stock Quantity");
            System.out.println("4.Count the Product Based on Vendor");
            System.out.println("0.Enter 0 to Exit");

            System.out.println("Enter the option from Above: ");
            int input = sc.nextInt();
            switch (input) {
                case 1 -> {

                    System.out.println("-----------Enter the product Details----------");

                    // let the user choose the categories of the product

                    System.out.println("Enter the Category ID from below: ");

                    List<Category> categories= categoryService.getCategory(); // get the Category from DB
                    categories.forEach(v->System.out.println(v.getId() + " - "+v.getName()));

                    System.out.print("Enter Category ID: ");
                    int categoryId = sc.nextInt();
                    Category category = categoryService.getCategoryById(categoryId);

                    // let the user give the vendor of the product
                    System.out.println("Enter the Vendor ID from below: ");
                    List<Vendor> vendors = vendorService.getVendors(); // get the vendor from DB
                    vendors.forEach(v->System.out.println(v.getId() + " - "+v.getName()));

                    System.out.print("Enter Vendor ID: ");
                    int vendorId = sc.nextInt();
                    Vendor vendor = vendorService.getVendorsById(vendorId);

                    // get the product details
                    System.out.println("Enter the ProductName: ");
                    String name = sc.next();

                    System.out.println("Enter the Price: ");
                    double price = sc.nextDouble();

                    System.out.println("Enter the StockQuantity : ");
                    Long stockQty = sc.nextLong();

                    productService.save(name , price , stockQty , category, vendor);
                    System.out.println("Product Registered Successfully...");

                    break;

                }
                case 2->{
                    System.out.println("Enter the ProductId: ");
                    int productId = sc.nextInt();
                    ProductDTO product = productService.findById(productId);

                    System.out.println("Product fetched Successfully...");
                    System.out.println(product);
                    break;
                }
                case  3->{
                    System.out.println("--Enter the following to Update Stock--");
                    System.out.println("Enter the ProductId: ");
                    int productId = sc.nextInt();

                    System.out.println("Enter the New StockQuantity : ");
                    Long newStockQty = sc.nextLong();

                    try {
                        productService.updateStock(productId , newStockQty );
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                }
                case 4->{
                    System.out.println("Count the Product with Vendor");
                    Map<String , Integer> map =  productService.countProductsByVendor();
                    map.forEach((key, value) -> System.out.println(key + " -> " + value));
                    break;
                }
                case 0-> {
                    System.out.println("Exiting System.....");
                    break;
                }
                default -> {
                    System.out.println("Invalid Option . Enter Correctly..");
                    return;
                }

            }
        }
    }
}
