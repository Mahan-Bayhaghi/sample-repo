package ir.ac.kntu.View;

import java.util.Scanner;

public class Menu {

    public void run (Scanner scanner){

        while (true) {
            System.out.println("Please choose what kind of receipt you want to add \nBuy or Sell");
            System.out.println("To exit the program , enter Exit");
            String input = scanner.nextLine();

            switch (input.trim()) {
                case "Exit" -> System.exit(0);
                case "Buy" , "Sell" -> (new ProductsMenu()).run(scanner);
                default -> System.out.println("Invalid command !");
            }
        }
    }

}
