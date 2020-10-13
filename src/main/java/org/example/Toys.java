package org.example;

public class Toys extends Products{
    // Min and Max ages of usage of the toys
    private int minage;
    private int maxage;

    // Constructor
    public Toys(int productid,String name,double price,int amount,int minage,int maxage) {
        super(productid,name,price,amount);
        this.minage = minage;
        this.maxage = maxage;
    }

    // Get-Methods

    public int getMinage() {
        return this.minage;
    }

    public int getMaxage() {
        return this.maxage;
    }
}
