package hust.soict.dsai.aims.cart;

import java.util.ArrayList;
import java.util.Collections;

import hust.soict.dsai.aims.media.Media;

public class Cart {

    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    public void addMedia(Media media) {
        itemsOrdered.add(media);
    }

    public void addMedia(Media... medias) {
        for (Media m : medias) {
            addMedia(m);
        }
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("Đã xóa: " + media.getTitle());
        } else {
            System.out.println("Không có to remove.");
        }
    }

    public float totalCost() {
        float sum = 0;
        for (Media m : itemsOrdered) {
            sum += m.getCost();
        }
        return sum;
    }

    public void printCart() {
        System.out.println("*********************CART*********************");
        System.out.println("\nOrdered Items:\n");
        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.println((i + 1) + ". " + itemsOrdered.get(i).toString());
        }
        System.out.println("\nTotal cost: " + totalCost());
        System.out.println("*************************************************");
    }

    public void searchId(int id) {
        boolean timthay = false;
        for (Media m : itemsOrdered) {
            if (m.getId() == id) {
                System.out.println(m.toString());
                timthay = true;
            }
        }
        if (!timthay) {
            System.out.println("No media with ID: " + id);
        }
    }

    public void searchTitle(String title) {
        boolean timthay = false;
        for (Media m : itemsOrdered) {
            if (m.getTitle().equalsIgnoreCase(title)) {
                System.out.println(m.toString());
                timthay = true;
            }
        }
        if (!timthay) {
            System.out.println("No media with title: " + title);
        }
    }


    public void searchByTitle(String title) {
        searchTitle(title);
    }


    public void sortMediaByTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        System.out.println("Sorted by title.");
    }


    public void sortMediaByCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        System.out.println("Sorted by cost.");
    }


    public void removeDVDbyNumber(int n) {
        if (n <= 0 || n > itemsOrdered.size()) {
            System.out.println("Invalid number.");
            return;
        }
        Media removed = itemsOrdered.remove(n - 1);
        System.out.println("Removed: " + removed.getTitle());
    }


    public Media searchMedia(String title) {
        if (title == null) return null;
        for (Media m : itemsOrdered) {
            if (m.getTitle().equalsIgnoreCase(title)) {
                return m;
            }
        }
        return null;
    }
}
