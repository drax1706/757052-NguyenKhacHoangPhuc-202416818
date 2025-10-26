package aim;

public class Store {
    public static final int MAX_NUMBERS_STORE = 20;
    private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[MAX_NUMBERS_STORE];
    private int qtyInStore = 0;

    public void addDVD(DigitalVideoDisc dvd) {
        if (qtyInStore < MAX_NUMBERS_STORE) {
            itemsInStore[qtyInStore] = dvd;
            qtyInStore++;
            System.out.println("DVD has been added tostore: " + dvd.getTitle());
        } else {
            System.out.println("The store is full");
        }
    }


    public void removeDVD(DigitalVideoDisc dvd) {
        boolean timthay = false;
        for (int i = 0; i < qtyInStore; i++) {
            if (itemsInStore[i] == dvd) {
                timthay = true;
                for (int j = i; j < qtyInStore - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[qtyInStore - 1] = null;
                qtyInStore--;
                System.out.println("DVD has been removed from the store: " + dvd.getTitle());
                break;
            }
        }
        if (!timthay) {
            System.out.println("DVD not found in store" );
        }
    }

    public void printStore() {
        System.out.println("Item in store:");
        for (int i = 0; i < qtyInStore; i++) {
            System.out.println( itemsInStore[i].toString());
        }
    }
}
