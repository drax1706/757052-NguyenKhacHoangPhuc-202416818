package aims;
import java.util.Scanner;
public class Aims {
	public static void main(String[] args) {
        Cart anOrder = new Cart();
        
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
                "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
                "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
                "Animation", 18.99f);
        anOrder.addDigitalVideoDisc(dvd3);
        
        anOrder.removeDigitalVideoDisc(dvd2);
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter DVD4 (title category director length cost):");
        String title = sc.next();
        String category = sc.next();
        String director = sc.next();
        int length = sc.nextInt();
        float cost = sc.nextFloat();

        DigitalVideoDisc dvd4 = new DigitalVideoDisc(title, category, director, length, cost);
        anOrder.addDigitalVideoDisc(dvd4);
        
        
        System.out.println("Total Cost is: ");
        System.out.println(anOrder.totalCost());
        
        sc.close();
        System.out.println("Exit");
        System.exit(0);
    }
}
