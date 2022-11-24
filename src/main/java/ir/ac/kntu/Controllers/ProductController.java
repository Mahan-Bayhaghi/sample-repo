package ir.ac.kntu.Controllers;

import ir.ac.kntu.Models.Product;

import java.util.ArrayList;

import java.time.format.DateTimeFormatter ;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

public class ProductController {
    public static String currentReceipt = "" ;
    public static ArrayList<Product> receiptProducts = new ArrayList<>();

    public static void setCurrentReceipt(String currentReceipt) {
        ProductController.currentReceipt = currentReceipt;
    }

    public static String getCurrentReceipt() {
        return currentReceipt;
    }

    public static ArrayList<Product> getReceiptProducts() {
        return receiptProducts;
    }

    public static void setReceiptProducts(ArrayList<Product> receiptProducts) {
        ProductController.receiptProducts = receiptProducts;
    }

    public static void categorizeByType(String typeOfProduct){
        if (List.of(JSONReader.typeList).contains(typeOfProduct)) {
            System.out.println("Invalid type of product !");
            return;
        }
        System.out.println("Category " + typeOfProduct + " :");
        for (Product receiptProduct : receiptProducts) {
            if (receiptProduct.getTypeOfProduct().equals(typeOfProduct.trim()))
                receiptProduct.printOut();
        }
    }

    public static void sortByPrice(String sortType) {
        sortType = sortType.trim();
        if (sortType.contains("increasing")){
            receiptProducts.sort(Comparator.comparing(Product::getPrice));
        } else if (sortType.contains("decreasing")){
            receiptProducts.sort(Comparator.comparing(Product::getPrice).reversed());
        } else {
            System.out.println("Invalid command !");
            return;
        }
        showAllGoods();
    }

    public static void sortByExpirationDate(String sortType) {
        sortType = sortType.trim();
        if (sortType.contains("increasing")){
            receiptProducts.sort(Comparator.comparing(Product::getExpirationDate));
        } else if (sortType.contains("decreasing")){
            receiptProducts.sort(Comparator.comparing(Product::getExpirationDate).reversed());
        } else {
            System.out.println("Invalid command !");
            return;
        }
        showAllGoods();
    }

    public static void sortByQuantity(String sortType) {
        sortType = sortType.trim();
        if (sortType.contains("increasing")){
            receiptProducts.sort(Comparator.comparing(Product::getQuantity));
        } else if (sortType.contains("decreasing")){
            receiptProducts.sort(Comparator.comparing(Product::getQuantity).reversed());
        } else {
            System.out.println("Invalid command !");
            return;
        }
        showAllGoods();
    }

    public static void showOutOfDateGoods() {
        String currentTime = (DateTimeFormatter.ofPattern("yyyy-MM-dd")).format(LocalDateTime.now());
        System.out.println("Current date is : " + currentTime);
        for (Product product : receiptProducts)
            if (product.getExpirationDate().compareTo(currentTime) > 0) System.out.printf("%s : %s\n" , product.getProductName() , product.getExpirationDate());
    }

    public static void showTotalValue() {
        int total = 0 ;
        for (Product product : receiptProducts) total += product.getPrice() ;
        System.out.println(total);
    }

    public static void showAllGoods() {
        for (Product product : receiptProducts) product.printOut();
    }
}
