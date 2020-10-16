package org.example;

public class Food extends Products {
    // Boolean to define wether food needs to be refrigitated or not
    private boolean refrigiration;

    // Constructor
    public Food(int productid,String name,double price,int amount,boolean refrigiration){
        super(productid,name,price,amount);
        this.refrigiration = refrigiration;
    }




    //Get-Method

    public boolean getRefrigiration(){
        return this.refrigiration;
    }
}
