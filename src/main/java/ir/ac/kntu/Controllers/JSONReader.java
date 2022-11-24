package ir.ac.kntu.Controllers;

import ir.ac.kntu.JsonGenerator;
import ir.ac.kntu.Models.Product;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class JSONReader {

    static final String[] typeList = {"junkFood", "drink", "diary", "sanitary", "protein"};
    static final String[] proteinGoodsList = {"beef", "chicken", "turkey", "sausage", "fish", "egg"};
    static final String[] diaryGoodsList = {"milk", "cheese", "yogurt", "cream", "dough", "Curd"};
    static final String[] drinkGoodsList = {"coke", "hype", "delester", "hotChocolate", "coffee", "tea"};
    static final String[] sanitaryGoodsList = {"handWash", "shampoo", "tissue", "faceWash", "bodyWash", "washingPowder"};
    static final String[] junkFoodGoodsList = {"chips", "pofak", "tokhme", "popCorn", "lavashak", "chocolate"};

//    private static final Pattern productPattern =
//            Pattern.compile(
//                    "(?<nameOfProduct>\\w+)\\s*:\\s*price\\s*:\\s*(?<price>\\d+)\\s*quantity\\s*:\\s*(?<quantity>\\d+)\\s*productionDate\\s*:\\s*(?<productionDate>\\d{4}-\\d{1,2}-\\d{1,2})\\s*expirationDate\\s*:\\s*(?<expirationDate>\\d{4}-\\d{1,2}-\\d{1,2})\\s*") ;

    private static final Pattern productPattern =
            Pattern.compile("(?<nameOfProduct>\\w+) : price : (?<price>\\d+) quantity : (?<quantity>\\d+) productionDate : (?<productionDate>\\d{4}-\\d{1,2}-\\d{1,2}) expirationDate : (?<expirationDate>\\d{4}-\\d{1,2}-\\d{1,2})") ;
    public static ArrayList<Product> readAllProducts (String jsonString){
        jsonString = trimString(jsonString) ;
        System.out.println(jsonString);
        ArrayList<Product> products = new ArrayList<>();
        Matcher matcher ;

        while ((matcher=productPattern.matcher(jsonString)).find()) {
            products.add(handleProduct(matcher));
            jsonString = jsonString.substring(matcher.end());
        }
        return products ;
    }

    public static String trimString (String jsonString){
        String out = jsonString.replaceAll("[,\\[\\]\\}\\{\"]" , " ") ;
        out = out.replaceAll("\\s+" , " ");
        for (String s : typeList)
            out = out.replaceAll(s+" : " , "") ;
        return out ;
    }

    public static Product handleProduct (Matcher matcher){
        String typeOfProduct;
        String productName = matcher.group("nameOfProduct") ;
        int price = Integer.parseInt(matcher.group("price"));
        int quantity = Integer.parseInt(matcher.group("quantity")) ;
        String productionDate = matcher.group("productionDate") ;
        String expirationDate = matcher.group("expirationDate") ;

        if (List.of(proteinGoodsList).contains(productName)) typeOfProduct = "protein" ;
        else if (List.of(diaryGoodsList).contains(productName)) typeOfProduct = "diary" ;
        else if (List.of(drinkGoodsList).contains(productName)) typeOfProduct = "drink" ;
        else if (List.of(sanitaryGoodsList).contains(productName)) typeOfProduct = "sanitary" ;
        else typeOfProduct = "junkFood" ;

        return new Product(typeOfProduct , productName , price , quantity , productionDate , expirationDate) ;
    }


}
