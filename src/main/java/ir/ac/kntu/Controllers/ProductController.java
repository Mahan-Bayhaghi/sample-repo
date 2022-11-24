package ir.ac.kntu.Controllers;

import ir.ac.kntu.Models.Product;

import java.util.ArrayList;

import java.time.format.DateTimeFormatter ;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

public class ProductController {

    public static ArrayList<Product> inventory = new ArrayList<>();

    public static void categorizeByType(String typeOfProduct){
        if (!List.of(JSONReader.typeList).contains(typeOfProduct)) {
            System.out.println("Invalid type of product !");
            return;
        }
        System.out.println("Category " + typeOfProduct + " :");
        for (Product receiptProduct : inventory) {
            if (receiptProduct.getTypeOfProduct().equals(typeOfProduct.trim()))
                receiptProduct.printOut();
        }
    }

    public static void sortByPrice(String sortType) {
        sortType = sortType.trim();
        if (sortType.contains("increasing")){
            inventory.sort(Comparator.comparing(Product::getPrice));
        } else if (sortType.contains("decreasing")){
            inventory.sort(Comparator.comparing(Product::getPrice).reversed());
        } else {
            System.out.println("Invalid command !");
            return;
        }
        showAllGoods();
    }

    public static void sortByExpirationDate(String sortType) {
        sortType = sortType.trim();
        if (sortType.contains("increasing")){
            inventory.sort(Comparator.comparing(Product::getExpirationDate));
        } else if (sortType.contains("decreasing")){
            inventory.sort(Comparator.comparing(Product::getExpirationDate).reversed());
        } else {
            System.out.println("Invalid command !");
            return;
        }
        showAllGoods();
    }

    public static void sortByQuantity(String sortType) {
        sortType = sortType.trim();
        if (sortType.contains("increasing")){
            inventory.sort(Comparator.comparing(Product::getQuantity));
        } else if (sortType.contains("decreasing")){
            inventory.sort(Comparator.comparing(Product::getQuantity).reversed());
        } else {
            System.out.println("Invalid command !");
            return;
        }
        showAllGoods();
    }

    public static void showOutOfDateGoods() {
        String currentTime = (DateTimeFormatter.ofPattern("yyyy-MM-dd")).format(LocalDateTime.now());
        System.out.println("Current date is : " + currentTime);
        for (Product product : inventory)
            if (product.getExpirationDate().compareTo(currentTime) < 0) System.out.printf("%s : %s\n" , product.getProductName() , product.getExpirationDate());
    }

    public static void showTotalValue() {
        int total = 0 ;
        for (Product product : inventory) total += product.getPrice() ;
        System.out.println(total);
    }

    public static void showAllGoods() {
        if (inventory.isEmpty())
            System.out.println("Inventory is empty !");
        else
            for (Product product : inventory) product.printOut();
    }
    
    public static void addProducts (ArrayList<Product> products){
        for (Product product : products) {
            Product byName = getProductByName(product.getProductName()) ;
            if (byName==null)
                inventory.add(product);
            else {
                byName.setPrice(byName.getPrice() + product.getPrice());
                byName.setQuantity(byName.getQuantity() + product.getQuantity());
            }
        }
    }

    public static Product getProductByName (String name){
        for (Product product : inventory) {
            if (product.getProductName().equals(name))
                return product;
        }
        return null ;
    }

    public static void handleSellReceipt(ArrayList<Product> sellProducts) {
        for (Product sellProduct : sellProducts)
            handleSellAction(sellProduct);
    }

    public static void handleSellAction(Product product){
        Product byName = getProductByName(product.getProductName());
        if (byName == null)
            System.out.println("Product " + product.getProductName() + " unavailable in inventory\n\tThis item won't be processed");
        else if (byName.getQuantity()<product.getQuantity())
            System.out.println("Product " + product.getProductName() + " is available but not enough\n\tThis item won't be processed");
        else if (byName.getQuantity()>= product.getQuantity()){
            byName.setQuantity(byName.getQuantity() - product.getQuantity());
            System.out.println("Product " + product.getProductName() + " processed and inventory is now up to date");
        }
    }
}
