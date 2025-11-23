package hust.soict.dsai.test.cart;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class TestCart {
    public static void main(String[] args) {

        Cart cart = new Cart();
        Media dvd1 = new DigitalVideoDisc("The Lion King","Animation", "Roger Allers", 87, 19.95f);
        Media dvd2 = new DigitalVideoDisc("Star Wars","Science Fiction", "George Lucas", 87, 24.95f);
        Media dvd3 = new DigitalVideoDisc("Aladin","Animation", "John Smith", 90, 18.99f);

        cart.addMedia(dvd1);
        cart.addMedia(dvd2);
        cart.addMedia(dvd3);
        cart.printCart();

        System.out.println(" Search by ID");
        cart.searchId(2);
        cart.searchId(5);

        System.out.println(" Searc by Title");
        cart.searchTitle("Aladin");  
        cart.searchTitle("Avatar2");
    }
}
