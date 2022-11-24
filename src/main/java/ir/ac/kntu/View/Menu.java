package ir.ac.kntu.View;

import ir.ac.kntu.Controllers.JSONReader;
import ir.ac.kntu.Controllers.ProductController;
import ir.ac.kntu.JsonGenerator;
import ir.ac.kntu.Models.Product;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    public void run (Scanner scanner , JsonGenerator jsonGenerator){
        boolean flag = true ;
        while (flag) {
            System.out.println("To add a receipt choose Buy or Sell");
            System.out.println("To enter inventory menu enter Inventory");
            System.out.println("To exit the program , enter Exit");
            String input = scanner.nextLine();
            // ab sex va ab chaghal hardo abe jensian
            switch (input.trim()) {
                case "Exit" , "exit" -> flag = false;
                case "Buy" , "buy" -> buyOptionsMenu(jsonGenerator);
                case "Sell" , "sell" -> sellOptionsMenu(jsonGenerator) ;
                case "Inventory" , "inventory" -> (new ProductsMenu()).run(scanner , jsonGenerator);
                default -> System.out.println("Invalid command !");
            }
        }
    }

    public void buyOptionsMenu (JsonGenerator jsonGenerator){
        System.out.println("A new Buy receipt is created as follows :");
        String json = jsonGenerator.generateBuyRecipe() ;
        ArrayList<Product> buyProducts = JSONReader.readAllProducts(json);
        for (Product buyProduct : buyProducts) buyProduct.printOut();
        ProductController.addProducts(buyProducts);
    }

    public void sellOptionsMenu(JsonGenerator jsonGenerator){
        System.out.println("A new Sell receipt is created as follows :");
        String json = jsonGenerator.generateBuyRecipe() ;
        ArrayList<Product> sellProducts = JSONReader.readAllProducts(json);
        for (Product sellProduct : sellProducts) sellProduct.printOut();
        ProductController.handleSellReceipt(sellProducts);
    }
}
