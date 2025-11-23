package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.*;
import java.util.ArrayList;


public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<>();

    
    public void addMedia(Media media) {
        if (itemsInStore.contains(media)) {
            System.out.println("Media already exists in store.");
        } else {
            itemsInStore.add(media);
            System.out.println("Media added to the store.");
        }
    }
    
    public void removeMedia(Media media) {
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println("Media removed from the store.");
        } else {
            System.out.println("Media not found in store.");
        }
    }
    
    public ArrayList<Media> getItemsInStore() {
        return this.itemsInStore;
    }

    public void displayStore() {
        System.out.println("******** STORE ITEMS ********");
        for (Media m : itemsInStore) {
            System.out.println(m.toString());
        }
    }

    
    public Media findMediaByTitle(String title) {
        for (Media m : itemsInStore) {
            if (m.getTitle().equalsIgnoreCase(title)) {
                return m;
            }
        }
        return null;
    }

}