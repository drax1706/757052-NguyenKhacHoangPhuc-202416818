package aim;


public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc items0rdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;


    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            items0rdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added");
        } else {
            System.out.println("The cart is almost full");
        }
    }


    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        for (int i = 0; i < dvdList.length; i++) {
            if (qtyOrdered < MAX_NUMBERS_ORDERED) {
                items0rdered[qtyOrdered] = dvdList[i];
                qtyOrdered++;
                System.out.println("the disc " + i + "th has been added");
            } else {
                System.out.println("The cart is almost full");
                break;
            }
        }
    }


    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        addDigitalVideoDisc(dvd1);
        addDigitalVideoDisc(dvd2);
    }

    
    
    
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        boolean timthay = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (items0rdered[i] == disc) {
                timthay = true;
                for (int j = i; j < qtyOrdered - 1; j++) {
                    items0rdered[j] = items0rdered[j + 1];
                }
                items0rdered[qtyOrdered - 1] = null;
                qtyOrdered--;
                System.out.println("The disc has been removed.");
                break;
            }
        }
        if (!timthay) {
            System.out.println("Disc not found in cart.");
        }
    }

    public float totalCost() {
        float sum = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            sum += items0rdered[i].getCost();
        }
        return sum;
    }
    
    
    public void printCart() {
        System.out.println("*********************CART*********************");
        System.out.println("\nOrdered Items:\n");
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println((i + 1) + ". " + items0rdered[i].toString());
        }
        System.out.println("\nTotal cost: " + totalCost());
        System.out.println("*************************************************");
    }
}
