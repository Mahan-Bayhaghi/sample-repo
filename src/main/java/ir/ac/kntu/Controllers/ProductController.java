package ir.ac.kntu.Controllers;

import ir.ac.kntu.Models.Product;

import java.util.ArrayList;

import java.time.format.DateTimeFormatter ;
import java.time.LocalDateTime;

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

    }

    public static void sortByPrice(String sort_by_price_) {
    }

    public static void sortByExpirationDate(String sort_by_expiration_date_) {
    }

    public static void sortByQuantity() {
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
        for (Product product : receiptProducts){
            System.out.printf("%s :\n\tprice : %d\n\tquantity : %d\n\tproduction date : %s\n\texpiration date : %s\n"
                    , product.getProductName() , product.getPrice() , product.getQuantity()
                    , product.getProductionDate() , product.getExpirationDate()) ;
        }
    }
}
