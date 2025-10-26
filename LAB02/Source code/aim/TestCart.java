package aim;

public class TestCart {
    public static void main(String[] args) {
        Cart cart = new Cart();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", 
                "Animation", "Roger Allers", 87, 19.95f);
        cart.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", 
                "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", 
                "Animation", "John Smith", 90, 18.99f);
        cart.addDigitalVideoDisc(dvd3);



        cart.printCart();
        System.out.println("\n--- Search by ID ---");
        cart.searchId(2);
        cart.searchId(5);

        System.out.println("\n--- Search by Title ---");
        cart.searchTitle("Aladin");
        cart.searchTitle("Avatar2"); 


    }
}