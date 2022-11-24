package ir.ac.kntu.Models;

public class Product {
    String typeOfProduct ;
    String productName ;
    int price ;
    int quantity ;
    String productionDate ;
    String expirationDate ;

    public Product(String typeOfProduct, String productName, int price, int quantity, String productionDate, String expirationDate) {
        this.typeOfProduct = typeOfProduct;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.productionDate = productionDate;
        this.expirationDate = expirationDate;
    }

    public String getTypeOfProduct() {
        return typeOfProduct;
    }

    public void setTypeOfProduct(String  typeOfProduct) {
        this.typeOfProduct = typeOfProduct;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(String productionDate) {
        this.productionDate = productionDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void printOut() {
        Product product = this ;
        System.out.printf("%s :\n\tprice : %d\n\tquantity : %d\n\tproduction date : %s\n\texpiration date : %s\n"
                , product.getProductName() , product.getPrice() , product.getQuantity()
                , product.getProductionDate() , product.getExpirationDate()) ;
    }
}
