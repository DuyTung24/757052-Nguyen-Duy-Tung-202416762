package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.*;
import java.util.ArrayList;
import java.util.Collections;

public class Cart {
	
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ArrayList<Media> itemsOrdered = new ArrayList<>();

	
	
	public void addMedia(Media media) {
	    if (itemsOrdered.contains(media)) {
	        System.out.println("This media is already in the cart.");
	    } else {
	        itemsOrdered.add(media);
	        System.out.println("Media added to cart.");
	    }
	}

	
	public float totalCost() {
	    float sum = 0;
	    for (Media m : itemsOrdered) {
	        sum += m.getCost();
	    }
	    return sum;
	}

	public void removeMedia(Media media) {
	    if (itemsOrdered.contains(media)) {
	        itemsOrdered.remove(media);
	        System.out.println("Media removed from cart.");
	    } else {
	        System.out.println("Media not found in the cart.");
	    }
	}
	
	public ArrayList<Media> getItemsOrdered() {
	    return this.itemsOrdered;
	}
	
	public void sortByTitleCost() {
	    Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
	    System.out.println("Cart sorted by title.");
	}

	public void sortByCostTitle() {
	    Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
	    System.out.println("Cart sorted by cost.");
	}
	
	public void filterById(int id) {
	    for (Media m : itemsOrdered) {
	        if (m.getId() == id) {
	            System.out.println(m);
	            return;
	        }
	    }
	    System.out.println("No item with given ID found.");
	}
	
	public void filterByTitle(String title) {
	    for (Media m : itemsOrdered) {
	        if (m.getTitle().equalsIgnoreCase(title)) {
	            System.out.println(m);
	            return;
	        }
	    }
	    System.out.println("No item with given title found.");
	}
	
	public void displayCart() {
	    System.out.println("******** CART ITEMS ********");
	    for (Media m : itemsOrdered) {
	        System.out.println(m);
	    }
	    System.out.println("Total cost: " + totalCost());
	}
	
	public Media findMediaByTitle(String title) {
	    for (Media m : itemsOrdered) {
	        if (m.getTitle().equalsIgnoreCase(title)) {
	            return m;
	        }
	    }
	    return null;
	}

	
	public void clear() {
	    itemsOrdered.clear();
	}
	


	// Adding search function for bonus point
//	public void searchByTitle(String title) {
//	    boolean found = false;
//	    System.out.println("Search results for title: \"" + title + "\"");
//	    for (int i = 0; i < qtyOrdered; i++) {
//	        if (itemsOrdered[i].getTitle().toLowerCase().contains(title.toLowerCase())) {
//	            System.out.println((i + 1) + ". " + itemsOrdered[i].getTitle() + " - " + itemsOrdered[i].getCategory() + " - " + itemsOrdered[i].getCost());
//	            found = true;
//	        }
//	    }
//	    if (!found) {
//	        System.out.println("No DVD found with title containing \"" + title + "\"");
//	    }
//	}
//	
//	public void searchByCategory(String category) {
//	    boolean found = false;
//	    System.out.println("Search results for category: \"" + category + "\"");
//	    for (int i = 0; i < qtyOrdered; i++) {
//	        if (itemsOrdered[i].getCategory().equalsIgnoreCase(category)) {
//	            System.out.println((i + 1) + ". " + itemsOrdered[i].getTitle() + " - " + itemsOrdered[i].getCategory() + " - " + itemsOrdered[i].getCost());
//	            found = true;
//	        }
//	    }
//	    if (!found) {
//	        System.out.println("No DVD found in category \"" + category + "\"");
//	    }
//	}
//	
//	public void searchByCost(float minCost, float maxCost) {
//	    boolean found = false;
//	    System.out.println("Search results for DVDs with cost between " + minCost + "$ and " + maxCost + "$:");
//	    for (int i = 0; i < qtyOrdered; i++) {
//	        float cost = itemsOrdered[i].getCost();
//	        if (cost >= minCost && cost <= maxCost) {
//	            System.out.println((i + 1) + ". " + itemsOrdered[i].getTitle() + " - " + itemsOrdered[i].getCategory() + " - " + cost);
//	            found = true;
//	        }
//	    }
//	    if (!found) {
//	        System.out.println("No DVD found within the given cost range.");
//	    }
//	}
//	
//	
//	public void printCart() {
//	    System.out.println("***********************CART***********************");
//	    System.out.println("Ordered Items:");
//
//	    float totalCost = 0;
//	    for (int i = 0; i < qtyOrdered; i++) {
//	        System.out.println((i + 1) + ". " + itemsOrdered[i].toString());
//	        totalCost += itemsOrdered[i].getCost();
//	    }
//
//	    System.out.printf("Total cost: %.2f $\n", totalCost);
//	    System.out.println("***************************************************");
//	}
//	
//	public void searchById(int id) {
//	    boolean found = false;
//	    System.out.println("Searching for DVD with ID: " + id);
//
//	    for (int i = 0; i < qtyOrdered; i++) {
//	        if (itemsOrdered[i].getId() == id) {
//	            System.out.println("Found: " + itemsOrdered[i].toString());
//	            found = true;
//	            break;
//	        }
//	    }
//
//	    if (!found) {
//	        System.out.println("No DVD found with ID = " + id);
//	    }
//	}


}
