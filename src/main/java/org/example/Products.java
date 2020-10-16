package org.example;

public class Products {
    // Atributes of the class
    private int productid;
    private String name;
    private double price;
    private int amount;

    // Constructor
    public Products(int productid,String name,double price,int amount) {
        this.productid = productid;
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    // Get-Methods
    public int getProductid() {
        return this.productid;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public int getAmount() {
        return this.amount;
    }

    // Set-Methods
    // Question to Kārlis: why do set methods contain "void", but get methods do not?

    public void setPrice(double price) {
        this.price = price;
    }

    // For incoming products
    public void productsin(int number) {
        this.amount += number;
    }

    // For outgoing products
    public boolean productsout(int number) {
        if(number <= this.amount){
            this.amount -= number;
            return true;
        }
        else{
            return false;
        }
    }

}
