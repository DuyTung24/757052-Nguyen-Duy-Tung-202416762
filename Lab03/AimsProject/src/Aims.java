import java.util.Scanner;

public class Aims {
    public static void main(String[] args) {

    	DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", "Guy Ritchie", 120, 18.99f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Jungle Book", "Adventure", "Jon Favreau", 105, 21.50f);
        
        DigitalVideoDisc[] storeDVDs = { dvd1, dvd2, dvd3, dvd4 };
        
        Scanner sc = new Scanner(System.in);
        Cart anOrder = new Cart();

        int choice;
        do {
        	System.out.println("1. View available DVDs");        	
            System.out.println("2. Add a DVD to the cart");
            System.out.println("3. Remove a DVD from the cart");
            System.out.println("4. Display total cost");
            System.out.println("5. Search for DVD");
            System.out.println("0. Exit");
            System.out.print("Please choose an option: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
            	case 1:
            		System.out.println("\nAvaliable DVDs: ");
            		for (int i = 0;i < storeDVDs.length; i++ ) {
            			System.out.println((i + 1) + ". " + storeDVDs[i].getTitle() + " - " 
                                + storeDVDs[i].getCategory() + " - $" + storeDVDs[i].getCost());
                    }
            		System.out.println();
                    break;
                    
                case 2:
                	/*
                	 * Day la code de chi add mot dvds duy nhat 1 lan
                	System.out.println("\nWhich DVD do you want to add?");
                    for (int i = 0; i < storeDVDs.length; i++) {
                        System.out.println((i + 1) + ". " + storeDVDs[i].getTitle());
                    }
                    System.out.print("Enter number 1-" + storeDVDs.length + ": ");
                    int dvdChoice = sc.nextInt();
                    sc.nextLine();

                    if (dvdChoice >= 1 && dvdChoice <= storeDVDs.length) {
                        DigitalVideoDisc selected = storeDVDs[dvdChoice - 1];
                        anOrder.addDigitalVideoDisc(selected);
                        System.out.println("Added \"" + selected.getTitle() + "\" to your cart.");
                    } else {
                        System.out.println("Invalid choice!");
                    }
                    break;
                    */
                	
                	
                	/*
                	 * Day la code de add dvd by array
                	System.out.println("\nEnter the number of DVDs you want to add to the cart: ");
                	int numdvds = sc.nextInt();
                	sc.nextLine(); 

                	DigitalVideoDisc[] dvds_list = new DigitalVideoDisc[numdvds];

                	System.out.println("\nWhich DVDs do you want to add?");
                	for (int i = 0; i < storeDVDs.length; i++) {
                	    System.out.println((i + 1) + ". " + storeDVDs[i].getTitle());
                	}

                	boolean invalidInput = false;

                	for (int j = 0; j < numdvds; j++) {
                	    System.out.print("Enter number 1-" + storeDVDs.length + " for DVD " + (j + 1) + ": ");
                	    int dvdChoice = sc.nextInt();
                	    sc.nextLine(); 

                	    if (dvdChoice >= 1 && dvdChoice <= storeDVDs.length) {
                	        dvds_list[j] = storeDVDs[dvdChoice - 1];
                	        System.out.println("Added \"" + storeDVDs[dvdChoice - 1].getTitle() + "\" to the list.");
                	    } else {
                	        System.out.println("Invalid choice! Operation canceled.");
                	        invalidInput = true;
                	        break;
                	    }
                	}

                	if (!invalidInput) {
                	    anOrder.addDigitalVideoDisc(dvds_list);
                	    System.out.println("\nAll selected DVDs have been added to the cart!");
                	} else {
                	    System.out.println("\nNo DVDs were added due to invalid input.");
                	}
                	break;
                	*/
                	
                	// Day la phan add dvd varargs
                	System.out.println("\nWhich DVDs do you want to add?");
                	for (int i = 0; i < storeDVDs.length; i++) {
                	    System.out.println((i + 1) + ". " + storeDVDs[i].getTitle());
                	}
                	System.out.println("Enter 0 to finish.\n");

                	int remaining_slot = Cart.MAX_NUMBERS_ORDERED - anOrder.getQtyOrdered();
                	DigitalVideoDisc[] tempList = new DigitalVideoDisc[remaining_slot];
                	
                	int count = 0;

                	while (true) {
                	    System.out.print("Enter number 1-" + storeDVDs.length + " (or 0 to stop): ");
                	    int dvdChoice = sc.nextInt();
                	    sc.nextLine(); 

                	    if (dvdChoice == 0) {
                	        System.out.println("\nYou chose to stop adding DVDs.");
                	        break;
                	    }

                	    if (dvdChoice < 1 || dvdChoice > storeDVDs.length) {
                	        System.out.println("Invalid choice! Operation canceled.");
                	        count = 0;
                	        break;
                	    }

                	    if (count >= remaining_slot) {
                	        System.out.println("Cart is full! Cannot add more DVDs.");
                	        break;
                	    }

                	    tempList[count] = storeDVDs[dvdChoice - 1];
                	    System.out.println("Added \"" + storeDVDs[dvdChoice - 1].getTitle() + "\" to cart list.");
                	    count++;
                	}

                	if (count > 0) {
                	    DigitalVideoDisc[] selected = new DigitalVideoDisc[count];
                	    for (int i = 0; i < count; i++) {
                	        selected[i] = tempList[i];
                	    }

                	    anOrder.addDigitalVideoDisc(selected);
                	    System.out.println("\nAll selected DVDs have been added to the cart!");
                	} else {
                	    System.out.println("\nNo DVDs were added.");
                	}


                	if (count > 0) {
                	    DigitalVideoDisc[] selected = new DigitalVideoDisc[count];
                	    for (int i = 0; i < count; i++) {
                	        selected[i] = tempList[i];
                	    }
                	    anOrder.addDigitalVideoDisc(selected);
                	    System.out.println("\nAll selected DVDs have been added to the cart!");
                	} else {
                	    System.out.println("\nNo DVDs were added.");
                	}
                	break;
                
                case 3:
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

                case 4:

                    System.out.println("Total cost of all DVDs in the cart: " + anOrder.totalCost());
                    break;
                
                case 5:
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
    
