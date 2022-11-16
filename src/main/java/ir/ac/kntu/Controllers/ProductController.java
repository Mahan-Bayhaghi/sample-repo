package ir.ac.kntu.Controllers;

public class ProductController {
    public static String currentReceipt ;

    public static void setCurrentReceipt(String currentReceipt) {
        ProductController.currentReceipt = currentReceipt;
    }

    public static String getCurrentReceipt() {
        return currentReceipt;
    }

    public static void categorizeByType(String typeOfProduct){

    }
}
