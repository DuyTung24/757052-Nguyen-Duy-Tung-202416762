package hust.soict.dsai.aims.aim;

import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;

public class Aims {

    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
    	
    	
    	
        store.addMedia(new Book(1, "Sherlock Holmes", "Detective", 20f));
        store.addMedia(new DigitalVideoDisc(2, "Avengers", "Action", "Joss Whedon", 15f, 120 ));
        
        Track t1 = new Track("Opening", 10);
        Track t2 = new Track("Main", 100);
        Track t3 = new Track("Ending", 15);
        
        CompactDisc cd = new CompactDisc(3, "Lion King", "Animation", "Disney", 18f, 90, "Duy Tung");
        cd.addTrack(t1);
        cd.addTrack(t2);
        cd.addTrack(t3);
        store.addMedia(cd);

        showMenu();
    }

    // ---------------------- MAIN MENU -----------------------
    public static void showMenu() {
        while (true) {
            System.out.println("\nAIMS:");
            System.out.println("--------------------------------");
            System.out.println("1. View store");
            System.out.println("2. Update store");
            System.out.println("3. See current cart");
            System.out.println("0. Exit");
            System.out.println("--------------------------------");
            System.out.print("Please choose a number: 0-1-2-3: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    viewStore();
                    break;
                case "2":
                    updateStoreMenu();
                    break;
                case "3":
                    viewCart();
                    break;
                case "0":
                    System.out.println("Exiting AIMS...");
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    // ---------------------- VIEW STORE -----------------------
    public static void viewStore() {
        while (true) {
            System.out.println("\n******** STORE ********");
            store.displayStore();

            storeMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    seeMediaDetails();
                    break;
                case "2":
                    addMediaToCart();
                    break;
                case "3":
                    playMediaInStore();
                    break;
                case "4":
                    viewCart();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    public static void storeMenu() {
        System.out.println("\nOptions:");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Your choice: ");
    }

    // ---------------------- MEDIA DETAILS -----------------------
    public static void seeMediaDetails() {
        System.out.print("\nEnter media title: ");
        String title = scanner.nextLine();

        Media media = store.findMediaByTitle(title);

        if (media == null) {
            System.out.println("Media not found!");
            return;
        }

        System.out.println("\n" + media.toString());

        mediaDetailsMenu();

        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                cart.addMedia(media);
                System.out.println("Added to cart!");
                break;
            case "2":
                if (media instanceof Playable) {
                    ((Playable) media).play();
                } else {
                    System.out.println("This media cannot be played!");
                }
                break;
            case "0":
                return;
            default:
                System.out.println("Invalid option!");
        }
    }

    public static void mediaDetailsMenu() {
        System.out.println("\nOptions:");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Your choice: ");
    }

    // ---------------------- ADD MEDIA TO CART -----------------------
    public static void addMediaToCart() {
        System.out.print("\nEnter media title: ");
        String title = scanner.nextLine();

        Media media = store.findMediaByTitle(title);

        if (media == null) {
            System.out.println("Media not found!");
            return;
        }

        cart.addMedia(media);
        System.out.println("Added to cart!");
    }

    // ---------------------- PLAY MEDIA IN STORE -----------------------
    public static void playMediaInStore() {
        System.out.print("\nEnter media title: ");
        String title = scanner.nextLine();

        Media media = store.findMediaByTitle(title);

        if (media == null) {
            System.out.println("Media not found!");
            return;
        }

        if (media instanceof Playable) {
            ((Playable) media).play();
        } else {
            System.out.println("This media is not playable!");
        }
    }

    // ---------------------- UPDATE STORE -----------------------
    public static void updateStoreMenu() {
        while (true) {
            System.out.println("\nUPDATE STORE:");
            System.out.println("--------------------------------");
            System.out.println("1. Add media");
            System.out.println("2. Remove media");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.print("Your choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addMediaToStore();
                    break;
                case "2":
                    removeMediaFromStore();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    public static void addMediaToStore() {
        System.out.print("Media type (book/dvd/cd): ");
        String type = scanner.nextLine().trim().toLowerCase();

        System.out.print("ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Category: ");
        String category = scanner.nextLine();
        System.out.print("Cost: ");
        float cost = Float.parseFloat(scanner.nextLine());

        Media media = null;

        switch (type) {
            case "book":
                media = new Book(id, title, category, cost);
                break;

            case "dvd":
                System.out.print("Director: ");
                String dvdDirector = scanner.nextLine();
                System.out.print("Length: ");
                int length = Integer.parseInt(scanner.nextLine());

                media = new DigitalVideoDisc(id, title, category, dvdDirector, cost, length);
                break;

            case "cd":
                System.out.print("Artist: ");
                String artist = scanner.nextLine();
                System.out.print("Director: ");
                String director = scanner.nextLine();
                System.out.print("Length: ");
                int Length = scanner.nextInt();

                media = new CompactDisc(id, title, category, director, cost, Length, artist);
                break;

            default:
                System.out.println("Invalid media type!");
                return;
        }

        store.addMedia(media);
        System.out.println("Media added to store!");
    }

    public static void removeMediaFromStore() {
        System.out.print("\nEnter title of media to remove: ");
        String title = scanner.nextLine();

        Media media = store.findMediaByTitle(title);

        if (media == null) {
            System.out.println("Media not found!");
            return;
        }

        store.removeMedia(media);
        System.out.println("Removed from store!");
    }

    // ---------------------- VIEW CART -----------------------
    public static void viewCart() {
        while (true) {
            System.out.println("\n******** CART ********");
            cart.displayCart();

            cartMenu();

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    filterCart();
                    break;
                case "2":
                    sortCart();
                    break;
                case "3":
                    removeMediaFromCart();
                    break;
                case "4":
                    playMediaInCart();
                    break;
                case "5":
                    placeOrder();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    public static void cartMenu() {
        System.out.println("\nOptions:");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Your choice: ");
    }

    // ---------------------- CART FUNCTIONS -----------------------
    public static void filterCart() {
        System.out.print("Filter by (id/title): ");
        String type = scanner.nextLine().trim().toLowerCase();

        if (type.equals("id")) {
            System.out.print("Enter id: ");
            int id = Integer.parseInt(scanner.nextLine());
            cart.filterById(id);
        } else if (type.equals("title")) {
            System.out.print("Enter title: ");
            String title = scanner.nextLine();
            cart.filterByTitle(title);
        } else {
            System.out.println("Invalid filter!");
        }
    }

    public static void sortCart() {
        System.out.print("Sort by (title/cost): ");
        String type = scanner.nextLine().trim().toLowerCase();

        if (type.equals("title")) {
            cart.sortByTitleCost();
        } else if (type.equals("cost")) {
            cart.sortByCostTitle();
        } else {
            System.out.println("Invalid sorting type!");
        }
    }

    public static void removeMediaFromCart() {
        System.out.print("\nEnter media title to remove: ");
        String title = scanner.nextLine();

        Media media = cart.findMediaByTitle(title);

        if (media == null) {
            System.out.println("Media not found in cart!");
            return;
        }

        cart.removeMedia(media);
        System.out.println("Removed!");
    }

    public static void playMediaInCart() {
        System.out.print("Enter media title to play: ");
        String title = scanner.nextLine();

        Media media = cart.findMediaByTitle(title);

        if (media == null) {
            System.out.println("Media not found!");
            return;
        }

        if (media instanceof Playable) {
            ((Playable) media).play();
        } else {
            System.out.println("This item cannot be played!");
        }
    }

    public static void placeOrder() {
        System.out.println("\nOrder created!");
        cart.clear();
    }
}
