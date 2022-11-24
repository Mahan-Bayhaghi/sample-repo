package ir.ac.kntu;

import ir.ac.kntu.Controllers.JSONReader;
import ir.ac.kntu.Controllers.ProductController;
import ir.ac.kntu.Models.Product;
import ir.ac.kntu.View.Menu;

import java.util.Scanner;

public class Main {

    final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        JsonGenerator jsonGenerator = new JsonGenerator();
        String receipt = jsonGenerator.generateBuyRecipe() ;
        System.out.println(receipt);

        ProductController.setReceiptProducts(JSONReader.readAllProducts(receipt));
        ProductController.showAllGoods();

        (new Menu()).run(scanner) ;
        scanner.close();
    }
 }
