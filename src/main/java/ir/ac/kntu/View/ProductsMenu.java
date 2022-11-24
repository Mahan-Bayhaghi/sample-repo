package ir.ac.kntu.View;

import ir.ac.kntu.Controllers.ProductController;
import ir.ac.kntu.JsonGenerator;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductsMenu extends Menu{

    Pattern backPattern = Pattern.compile("^\\s*Back\\s*$") ;
    Pattern categorizePattern = Pattern.compile("^\\s*Categorize by type (diary|protein|junkFood|sanitary|drink)\\s*$") ;
    Pattern sortByPricePattern = Pattern.compile("^Sort by price (increasing|decreasing)$") ;
    Pattern sortByExpirationDatePattern = Pattern.compile("^Sort by expiration date (increasing|decreasing)$") ;
    Pattern sortByQuantityPattern = Pattern.compile("^\\s*Sort by quantity (increasing|decreasing)\\s*$") ;
    Pattern sortOutOfDatePattern = Pattern.compile("^\\s*Show out of date goods\\s*$") ;
    Pattern showTotalValuePattern = Pattern.compile("^\\s*Show total value\\s*$") ;
    Pattern showAllGoodsPattern = Pattern.compile("^\\s*Show all goods\\s*$") ;

    @Override
    public void run(Scanner scanner , JsonGenerator jsonGenerator) {
        while (true){
            System.out.println("Commands list :");
            System.out.println("Back                                            : go to welcome menu");
            System.out.println("Categorize by type <typeOfProduct>              : categorizing all goods by their type");
            System.out.println("Sort by price <increasing|decreasing>           : sort all goods in increasing or decreasing order");
            System.out.println("Sort by expiration date <increasing|decreasing> : sort all goods in increasing or decreasing order");
            System.out.println("Sort by quantity <increasing|decreasing>        : sort all goods based on their quantity");
            System.out.println("Show out of date goods                          : list of all out of date goods");
            System.out.println("Show total value                                : compute total value of receipt");
            System.out.println("Show all goods                                  : show all goods in readable form");

            String input = scanner.nextLine();

            Matcher matcher ;

            if (backPattern.matcher(input).matches()) return;

            else if ((matcher=categorizePattern.matcher(input)).matches())
                ProductController.categorizeByType(input.replace("Categorize by type " , "")) ;

            else if (sortByPricePattern.matcher(input).matches())
                ProductController.sortByPrice(input.replace("Sort by price " , "")) ;

            else if (sortByExpirationDatePattern.matcher(input).matches())
                ProductController.sortByExpirationDate(input.replace("Sort by expiration date " , "")) ;

            else if (sortByQuantityPattern.matcher(input).matches())
                ProductController.sortByQuantity(input.replace("Sort by quantity " , "")) ;

            else if (sortOutOfDatePattern.matcher(input).matches())
                ProductController.showOutOfDateGoods() ;

            else if (showTotalValuePattern.matcher(input).matches())
                ProductController.showTotalValue() ;

            else if (showAllGoodsPattern.matcher(input).matches())
                ProductController.showAllGoods() ;

            else
                System.out.println("Invalid command !");

        }
    }
}
