package org.example;

import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Administration{
    public static void main(String[]args)throws IOException{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        String input;
        int choice;
        int further;

        Catalogue catalogue = new Catalogue();

        System.out.println("Welcome in Administration software of the Warehouse!\n\n\n");

        while(true){
            System.out.println("Please choose one of the options:\n");
            System.out.println("Receive new products: Option 1");
            System.out.println("Sell something: Option 2");
            System.out.println("Create a special offer: Option 3");
            System.out.println("List the catalogue: Option 4\n");
            System.out.println("Please provide a number of an Option you want to perform:");

            try{
                input = br.readLine();
                choice = Integer.parseInt(input);
            }

            catch (NumberFormatException Exception){
                System.out.println("Please type a number!");
                continue;
            }

            switch (choice) {
                case 1:
                    catalogue.productdelivery();
                    break;
                case 2:
                    catalogue.sell();
                    break;
                case 3:
                    catalogue.specialoffer();
                    break;
                case 4:
                    catalogue.printcatalogue();
                    break;
                default:
                    System.out.println("You've entered an invalid number.");

            }

            // Use JOptionPane, if true
            boolean ui = false;

            if (ui){
                further = JOptionPane.showConfirmDialog(null, "Do you want to perform any further action?", "Confirmation", JOptionPane.YES_NO_OPTION);
                if (further == 1) {
                    break;
                }
            }
            else{
                System.out.println("Do you want to perform any further action? (y/n)");
                String uireply = br.readLine();
                if (uireply.equals("n")){
                    break;
                }

            }
        }
        System.out.println("Good bye!");

        }
}
