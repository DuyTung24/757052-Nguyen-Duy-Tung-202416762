public class Store {
    private static final int MAX_NUMBERS_DVDs = 100;
    private DigitalVideoDisc[] itemsInStore = new DigitalVideoDisc[MAX_NUMBERS_DVDs];
    private int qtyInStore = 0;


    public void addDVD(DigitalVideoDisc disc) {
        if (qtyInStore < MAX_NUMBERS_DVDs) {
            itemsInStore[qtyInStore++] = disc;
            System.out.println("Added DVD to store: " + disc.getTitle());
        } else {
            System.out.println("Store is full. Cannot add more DVDs.");
        }
    }


    public void removeDVD(DigitalVideoDisc disc) {
        boolean found = false;
        for (int i = 0; i < qtyInStore; i++) {
            if (itemsInStore[i].equals(disc)) {
                found = true;

                for (int j = i; j < qtyInStore - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[--qtyInStore] = null;
                System.out.println("Removed DVD from store: " + disc.getTitle());
                break;
            }
        }
        if (!found) {
            System.out.println("DVD not found in store: " + disc.getTitle());
        }
    }


    public void printStore() {
        System.out.println("***********************STORE***********************");
        if (qtyInStore == 0) {
            System.out.println("No DVD in store.");
        } else {
            for (int i = 0; i < qtyInStore; i++) {
                System.out.println((i + 1) + ". " + itemsInStore[i].toString());
            }
        }
        System.out.println("***************************************************");
    }
}