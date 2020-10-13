package org.example;

public class Electrical extends Products {
    private char energyclass;
    private int consumption;

    // Constructor
    public Electrical(int productid,String name,double price,int amount,char energyclass,int consumption){
        super(productid,name,price,amount);
        this.energyclass = energyclass;
        this.consumption = consumption;
    }

    // Get-Methods

    public char getEnergyclass() {
        return this.energyclass;
    }

    public int getConsumption() {
        return this.consumption;
    }
}
