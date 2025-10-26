import java.util.Scanner;

public class Aims {
    public static void main(String[] args) {

//        Cart anOrder = new Cart();
//
//        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
//                "Animation", "Roger Allers", 87, 19.95f);
//        anOrder.addDigitalVideoDisc(dvd1);
//
//        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
//                "Science Fiction", "George Lucas", 87, 24.95f);
//        anOrder.addDigitalVideoDisc(dvd2);
//
//        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
//                "Animation", 18.99f);
//        anOrder.addDigitalVideoDisc(dvd3);
//
//        System.out.println("Total cost is: ");
//        System.out.println(anOrder.totalCost());
//        
//        // check for the removedvd function
//        anOrder.removeDigitalVideoDisc(dvd3);
//        anOrder.removeDigitalVideoDisc(dvd1);
//        anOrder.removeDigitalVideoDisc(dvd2);
//        anOrder.removeDigitalVideoDisc(dvd2);
//        
//        System.out.println("Total cost is: ");
//        System.out.println(anOrder.totalCost());
//        
        
    	
    	Scanner sc = new Scanner(System.in);
        Cart anOrder = new Cart();

        int choice;
        do {
            System.out.println("1. Add a DVD to the cart");
            System.out.println("2. Remove a DVD from the cart");
            System.out.println("3. Display total cost");
            System.out.println("4. Search for DVD");
            System.out.println("0. Exit");
            System.out.print("Please choose an option: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter DVD title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter DVD category: ");
                    String category = sc.nextLine();

                    System.out.print("Enter DVD director: ");
                    String director = sc.nextLine();

                    System.out.print("Enter DVD length: ");
                    int length = sc.nextInt();

                    System.out.print("Enter DVD cost: ");
                    float cost = sc.nextFloat();
                    sc.nextLine();

                    DigitalVideoDisc newDisc = new DigitalVideoDisc(title, category, director, length, cost);
                    anOrder.addDigitalVideoDisc(newDisc);
                    break;

                case 2:
                    System.out.print("Enter the title of the DVD to remove: ");
                    String removeTitle = sc.nextLine();
                    boolean found = false;

                    for (int i = 0; i < anOrder.getQtyOrdered(); i++) {
                        DigitalVideoDisc d = anOrder.getItemsOrdered()[i];
                        if (d.getTitle().equalsIgnoreCase(removeTitle)) {
                            anOrder.removeDigitalVideoDisc(d);
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("No DVD in the cart match with your title");
                    }
                    break;

                case 3:

                    System.out.println("Total cost of all DVDs in the cart: " + anOrder.totalCost());
                    break;
                
                case 4:
                	int search_choice;
                	System.out.println("\nSearch options:");
                    System.out.println("1. Search by Title");
                    System.out.println("2. Search by Category");
                    System.out.println("3. Search by Cost Range");
                    search_choice = sc.nextInt();
                    sc.nextLine();
                    
                    switch (search_choice) {
                    	case 1:
                    		System.out.println("Enter the title: ");
                    		String Searchtitle = sc.nextLine();
                    		anOrder.searchByTitle(Searchtitle);
                    		break;
                    	case 2:
                    		System.out.println("Enter the category: ");
                    		String Searchcategory = sc.nextLine();
                    		anOrder.searchByCategory(Searchcategory);
                    		break;
                    	case 3:
                            System.out.print("Enter minimum cost: ");
                            float minCost = Float.parseFloat(sc.nextLine().trim());
                            System.out.print("Enter maximum cost: ");
                            float maxCost = Float.parseFloat(sc.nextLine().trim());
                            anOrder.searchByCost(minCost, maxCost);
                            break;
                        default:
                            System.out.println("Invalid search option.");
                            break;
                    }
                    break;
                    
                case 0:
                    System.out.println("Exiting the program");
                    break;

                default:
                    System.out.println("Invalid choice! Please enter again");
                    break;
            }
        } while (choice != 0);

        sc.close();
    }
    	
    	
    }
    
