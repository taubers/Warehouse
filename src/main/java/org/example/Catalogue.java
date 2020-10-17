package org.example;
// Contains a list with all products
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
;


public class Catalogue {
    ArrayList<Products> catalogue;


    // Constructor
    public Catalogue() {
        this.catalogue = new ArrayList<>();
    }

    //catalogue.add(new Food(123,"plovs",2.99,10,true));


    public void productdelivery() {
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);

            System.out.println("Please provide the product ID of the delivered product:");
            String input = br.readLine();
            int productid = Integer.parseInt(input);

            System.out.println("Please provide a number of amount:");
            input = br.readLine();
            int amount = Integer.parseInt(input);

            boolean existing = false;
            for (int i = 0; i < catalogue.size(); i++) {
                if (catalogue.get(i).getProductid() == productid) {
                    catalogue.get(i).productsin(amount);
                    System.out.println("This product is already existing in the catalogue.");
                    System.out.println("New products added.");
                    existing = true;
                    break;
                }
            }
            if (!existing) {
                System.out.println("What category does the product belong to?");
                System.out.println("1: Food");
                System.out.println("2. Pizza");
                System.out.println("3: Toys");
                System.out.println("4: Electrical");
                System.out.println("Please provide an appropriate number:");

                int typenr = -1;

                try {
                    input = br.readLine();
                    typenr = Integer.parseInt(input);
                } catch (NumberFormatException Exception) {
                    System.out.println("Please enter an integer number!");
                }

                System.out.println("Please provide a product name:");
                String name = br.readLine();

                System.out.println("Please enter the price:");
                input = br.readLine();
                double price = Double.parseDouble(input);



                switch (typenr) {
                    case 1:
                        System.out.println("Is refrigeration needed? (y/n):");
                        input = br.readLine();
                        boolean refrigiration = (input.equals("y"));
                        catalogue.add(new Food(productid, name, price, amount, refrigiration));
                        System.out.println("The product was added to the catalogue.");
                        break;
                    case 2:
                        System.out.println("Is refrigeration needed? (y/n):");
                        input = br.readLine();
                        refrigiration = (input.equals("j"));
                        System.out.println("Is the Pizza vegetarian? (y/n)");
                        input = br.readLine();
                        boolean vegetarian = input.equals("y");
                        System.out.println("What is the size of the Pizza? (20cm / 30cm / 50cm)");
                        input = br.readLine();
                        while(!input.matches("20|30|50")){
                            System.out.println("Please enter a valid size or Pizza! (20cm / 30cm / 50cm)");
                            input = br.readLine();
                        }
                        byte size = Byte.parseByte(input);
                        catalogue.add(new Pizza(productid, name, price, amount, refrigiration, vegetarian, size));
                        System.out.println("The product was added to the catalogue.");
                        break;
                    case 3:
                        System.out.println("Minimal age:");
                        input = br.readLine();
                        int minage = Integer.parseInt(input);
                        System.out.println("Maximal age:");
                        input = br.readLine();
                        int maxage = Integer.parseInt(input);
                        catalogue.add(new Toys(productid, name, price, amount, minage, maxage));
                        System.out.println("The product was added to the catalogue.");
                        break;
                    case 4:
                        System.out.println("Energy class of the gadget:");
                        input = br.readLine();
                        char energyclass = input.charAt(0);
                        System.out.println("Energy consumption:");
                        input = br.readLine();
                        int consumption = Integer.parseInt(input);
                        catalogue.add(new Electrical(productid, name, price, amount, energyclass, consumption));
                        System.out.println("The product was added to the catalogue.");
                        break;
                    default:
                        System.out.println("You've entered an invalid value.");

                }
            }
        } catch (IOException Exception) {
            System.out.println("There was a mistake in the data entry");
        } catch (NumberFormatException Exception) {
            System.out.println("Please provide correct number format next time!");
        }

    }

    public void sell() {
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            System.out.println("Please provide a product ID of the sold product:");
            String input = br.readLine();
            int productid = Integer.parseInt(input);
            System.out.println("Please provide the amount:");
            input = br.readLine();
            int amount = Integer.parseInt(input);
            boolean existing = false;
            for (int i = 0; i < catalogue.size(); i++) {
                if (catalogue.get(i).getProductid() == productid) {
                    if (catalogue.get(i).productsout(amount)) {
                        System.out.println("The product was sold successfully! The amount was adapted accordingly!");
                    } else {
                        System.out.println("Not enough products in the warehouse!");
                    }
                    existing = true;
                    break;
                }
            }
            if (!existing) {
                System.out.println("The product does not exist in the catalogue!");
            }
        } catch (IOException Exception) {
            System.out.println("There was a mistake in the data entry");
        } catch (NumberFormatException Exception) {
            System.out.println("Please provide correct number format next time!");
        }
    }

    public void specialoffer() {
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            System.out.println("Please provide the product ID to create a special offer for that product:");
            String input = br.readLine();
            int productid = Integer.parseInt(input);
            System.out.println("At what percentage to you want to reduce the price of the product?");
            input = br.readLine();
            int specialprice = Integer.parseInt(input);
            boolean existing = false;
            for (int i = 0; i < catalogue.size(); i++) {
                if (catalogue.get(i).getProductid() == productid) {
                    catalogue.get(i).setPrice(catalogue.get(i).getPrice() * 1 - (double) specialprice / 100);
                    System.out.println("The price was changed successfully!");
                    existing = true;
                    break;
                }
            }
            if (!existing) {
                System.out.println("The product does not exist in the catalogue.");
            }

        } catch (IOException Exception) {
            System.out.println("There was a mistake in the data entry");
        } catch (NumberFormatException Exception) {
            System.out.println("Please provide correct number format next time!");
        }
    }

    public void printcatalogue() {
        System.out.println("The catalogue contains following items:");

        for (Products product : catalogue) {
            if (product instanceof Food) {
                System.out.println("Food");
                System.out.println("Product ID: " + product.getProductid());
                System.out.println("Product name: " + product.getName());
                System.out.println("Price: " + product.getPrice());
                System.out.println("Amount: " + product.getAmount());
                System.out.println("Refrigeration needed?" + ((Food) product).getRefrigiration() + "\n");
            } else if (product instanceof Pizza) {
                System.out.println("Pizza");
                System.out.println("Product ID: " + product.getProductid());
                System.out.println("Product name: " + product.getName());
                System.out.println("Price: " + product.getPrice());
                System.out.println("Amount: " + product.getAmount());
                System.out.println("Refrigeration needed?" + ((Pizza) product).getRefrigiration());
                System.out.println("Is vegetarian?: " + ((Pizza) product).getVegetarian());
                System.out.println("Size: " + ((Pizza) product).getSize() + "\n");
            } else if (product instanceof Toys) {
                System.out.println("Toys");
                System.out.println("Product ID: " + product.getProductid());
                System.out.println("Product name: " + product.getName());
                System.out.println("Price: " + product.getPrice());
                System.out.println("Amount: " + product.getAmount());
                System.out.println("Minimal age: " + ((Toys) product).getMinage());
                System.out.println("Maximal age: " + ((Toys) product).getMaxage() + "\n");
            } else if (product instanceof Electrical) {
                System.out.println("Electrical gadgets");
                System.out.println("Product ID: " + product.getProductid());
                System.out.println("Product name: " + product.getName());
                System.out.println("Price: " + product.getPrice());
                System.out.println("Amount: " + product.getAmount());
                System.out.println("Energy efficiency / class: " + ((Electrical) product).getEnergyclass());
                System.out.println("Energy consumption: " + ((Electrical) product).getConsumption());
            }

            }
        }
        }






