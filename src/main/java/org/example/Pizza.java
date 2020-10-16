package org.example;

public class Pizza extends Food {
    //
    private boolean vegetarian;
    private byte size;

    // Constructor
    public Pizza(int productid,String name,double price,int amount,boolean refrigiration,boolean vegetarian,byte size){
        super(productid, name, price, amount, refrigiration);
        this.vegetarian = vegetarian;
        this.size = size;
    }


    // Get-Methods
    public boolean getVegetarian(){
        return this.vegetarian;
    }

    public int getSize() {
        return this.size;
    }
}
