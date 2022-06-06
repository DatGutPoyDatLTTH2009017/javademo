package fpt.aptech.t2009m1helloworld.entity;

public class CartItem {
    public static Object CartItemBuilder;
    private int productId;
    private String productName;
    private String productThumbnail;
    private double unitPrice;
    private int quantity;

    public String toString(){
        return String.format("%s - %.2f -%d", productName, unitPrice, quantity);
    }

    public CartItem(){

    }
}
