package hust.soict.dsai.aims;

import java.util.Scanner;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;

public class Aims {

    private Store store = new Store();  
    private Cart cart = new Cart();        
    private Scanner scanner = new Scanner(System.in); 

    public static void main(String[] args) {
        Aims app = new Aims(); 
        app.initStore();      
        app.showMenu();         
    }

    public void showMenu() {
        while (true) {
            System.out.println("\n--- AIMS MENU ---");
            System.out.println("1. View store");
            System.out.println("2. Update store");
            System.out.println("3. See current cart");
            System.out.println("0. Exit");

            System.out.print("Choose: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    storeMenuLoop();         //60
                    break;
                case 2:
                    updateStoreMenu();       // 171
                    break;
                case 3:
                    cartMenuLoop();          // 183
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid");
            }
        }
    }

    
    ////// INIT STORE
    public void initStore() {

        store.addMedia(new DigitalVideoDisc("Lion King", "Animation", "Roger Allers", 87, 19.95f));
        store.addMedia(new Book("Star Wars","Science Fiction", 29.95f));
        store.addMedia(new Book("Aladin","Animation", 9.95f));
    }

    ////// STORE MENU LOOP
    public void storeMenuLoop() {
        while (true) {
            storeMenu();                     // 88
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    store.printStore();
                    break;
                case 2:
                    seeMediaDetails();  //99
                    break;
                case 3:
                    addMediaToCartFromStore(); //148
                    break;
                case 4:
                    playMediaFromStore();   //161
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid");
            }
        }
    }


    public void storeMenu() {
        System.out.println("\n--- STORE MENU ---");
        System.out.println("1. See all items in store");
        System.out.println("2. Media details");
        System.out.println("3. Add media to cart");
        System.out.println("4. Play media");
        System.out.println("0. Back");
        System.out.print("Choose: ");
    }


    public void seeMediaDetails() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        Media m = store.searchMediaByTitle(title); 

        if (m == null) {
            System.out.println("Not found.");
        } else {
            System.out.println("\nDetails: " + m.toString());
            mediaDetailsMenuLoop(m);         //113
        }
    }

    ////// MEDIA DETAILS MENU LOOP
    public void mediaDetailsMenuLoop(Media m) {
        while (true) {
            mediaDetailsMenu();              // 139
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    cart.addMedia(m);
                    break;
                case 2:
                    if (m instanceof Playable) {
                        ((Playable) m).play();
                    } else {
                        System.out.println("Not playable.");
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid");
            }
        }
    }


    public void mediaDetailsMenu() {
        System.out.println("\n--- MEDIA DETAILS MENU ---");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.print("Choose: ");
    }


    public void addMediaToCartFromStore() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        Media m = store.searchMediaByTitle(title);

        if (m != null) {
            cart.addMedia(m);
        } else {
            System.out.println("Not found.");
        }
    }

    public void playMediaFromStore() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        Media m = store.searchMediaByTitle(title);

        if (m instanceof Playable) {
            ((Playable) m).play();
        } else {
            System.out.println("Media not playable or not found.");
        }
    }
    public void updateStoreMenu() {
        System.out.print("Enter title to remove from store: ");
        String title = scanner.nextLine();
        Media m = store.searchMediaByTitle(title);

        if (m != null) {
            store.removeMedia(m);
            System.out.println("Removed from store.");
        } else {
            System.out.println("Not found.");
        }
    }
    public void cartMenuLoop() {
        while (true) {
            cartMenu();   
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    cart.printCart();  
                    break;
                case 2:
                    filterCart();       
                    break;
                case 3:
                    sortCart();         
                    break;
                case 4:
                    removeFromCart();
                    break;
                case 5:
                    playMediaFromCart(); 
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid");
            }
        }
    }

    ////// CART MENU
    public void cartMenu() {
        System.out.println("\n--- CART MENU ---");
        System.out.println("1. View cart");
        System.out.println("2. Filter cart (title)");
        System.out.println("3. Sort cart");
        System.out.println("4. Remove by number");
        System.out.println("5. Play media");
        System.out.println("0. Back");
        System.out.print("Choose: ");
    }


    public void filterCart() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        cart.searchByTitle(title);
    }

    /// sort
    public void sortCart() {
        System.out.println("Sort by:");
        System.out.println("1. Title");
        System.out.println("2. Cost");

        int x = scanner.nextInt();
        scanner.nextLine();

        if (x == 1) {
            cart.sortMediaByTitle();
        } else {
            cart.sortMediaByCost();
        }
    }

    public void removeFromCart() {
        System.out.print("Enter number to remove: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        cart.removeDVDbyNumber(n);
    }

    public void playMediaFromCart() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();

        Media m = cart.searchMedia(title);
        if (m instanceof Playable) {
            ((Playable) m).play();
        } else {
            System.out.println("Not playable or not found.");
        }
    }
}
