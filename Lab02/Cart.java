
public class Cart {
	
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;
	
	public DigitalVideoDisc[] getItemsOrdered() {
	    return itemsOrdered;
	}
	
	public int getQtyOrdered() {
	    return qtyOrdered;
	}
	

	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered < MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered] = disc;
			qtyOrdered += 1;
			
			System.out.println("The disc " + disc.getTitle() + " has been added to the cart");
		}
		else if (qtyOrdered == MAX_NUMBERS_ORDERED) {
			System.out.println("The cart is currently full");
		}
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		boolean check = false;
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i] == disc) {
				check = true;
				for (int j = i; j < qtyOrdered - 1; j++) {
					itemsOrdered[j] = itemsOrdered[j + 1]; // to make sure that when delete a disc, the position of that disc is not empty
				}
			
			itemsOrdered[qtyOrdered - 1] = null;
			qtyOrdered -= 1;
			System.out.println("The disc " + disc.getTitle() + " has been removed from the cart");
			break;
			}
		
		}
		if (check == false) {
			System.out.println("The disc was not found in the cart");
		}
	}
	
	public float totalCost() {
		float total_cost = 0;
		for (int i = 0; i < qtyOrdered; i++) {
			total_cost += itemsOrdered[i].getCost();
		}
		return total_cost;
	}
	
	// Adding search function for bonus point
	public void searchByTitle(String title) {
	    boolean found = false;
	    System.out.println("Search results for title: \"" + title + "\"");
	    for (int i = 0; i < qtyOrdered; i++) {
	        if (itemsOrdered[i].getTitle().toLowerCase().contains(title.toLowerCase())) {
	            System.out.println((i + 1) + ". " + itemsOrdered[i].getTitle() + " - " + itemsOrdered[i].getCategory() + " - " + itemsOrdered[i].getCost());
	            found = true;
	        }
	    }
	    if (!found) {
	        System.out.println("No DVD found with title containing \"" + title + "\"");
	    }
	}
	
	public void searchByCategory(String category) {
	    boolean found = false;
	    System.out.println("Search results for category: \"" + category + "\"");
	    for (int i = 0; i < qtyOrdered; i++) {
	        if (itemsOrdered[i].getCategory().equalsIgnoreCase(category)) {
	            System.out.println((i + 1) + ". " + itemsOrdered[i].getTitle() + " - " + itemsOrdered[i].getCategory() + " - " + itemsOrdered[i].getCost());
	            found = true;
	        }
	    }
	    if (!found) {
	        System.out.println("No DVD found in category \"" + category + "\"");
	    }
	}
	
	public void searchByCost(float minCost, float maxCost) {
	    boolean found = false;
	    System.out.println("Search results for DVDs with cost between " + minCost + "$ and " + maxCost + "$:");
	    for (int i = 0; i < qtyOrdered; i++) {
	        float cost = itemsOrdered[i].getCost();
	        if (cost >= minCost && cost <= maxCost) {
	            System.out.println((i + 1) + ". " + itemsOrdered[i].getTitle() + " - " + itemsOrdered[i].getCategory() + " - " + cost);
	            found = true;
	        }
	    }
	    if (!found) {
	        System.out.println("No DVD found within the given cost range.");
	    }
	}


}
