package hust.soict.dsai.aims;
import javax.swing.JOptionPane;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.cart.Cart;


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
        
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Avengers: Endgame",
                "Action", "Anthony Russo & Joe Russo", 181, 29.99f);

        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Frozen",
                "Animation", "Unknown", 90, 21.50f);
        
        String[] options = {"Add", "Remove", "Total", "Exit"};
        while (true) {int choice = JOptionPane.showOptionDialog(null,"What you want to do","null",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);

            if (choice == 0) {
                String t = JOptionPane.showInputDialog("Enter title:");
                String c = JOptionPane.showInputDialog("Enter category:");
                String d = JOptionPane.showInputDialog("Enter director:");
                int l = Integer.parseInt(JOptionPane.showInputDialog("Enter length:"));
                float co = Float.parseFloat(JOptionPane.showInputDialog("Enter cost:"));
                anOrder.addDigitalVideoDisc(new DigitalVideoDisc(t, c, d, l, co));
                JOptionPane.showMessageDialog(null,"Added");
            }
            
            
            else if (choice == 1) {
                String title = JOptionPane.showInputDialog("Enter title to remove:");
                anOrder.removeDigitalVideoDisc(new DigitalVideoDisc(title));
                JOptionPane.showMessageDialog(null,"Removed (if existed)");
            }
            
            
            else if (choice == 2) {
                JOptionPane.showMessageDialog(null, "Total cost = " + anOrder.totalCost());
            }
            
            
            else if (choice == 3 || choice == JOptionPane.CLOSED_OPTION) {
                break;
            }
        }
        
        DigitalVideoDisc[] list = { dvd1, dvd2, dvd3 };
        anOrder.addDigitalVideoDisc(list);


        anOrder.addDigitalVideoDisc(dvd4, dvd5);
        
    
        
        System.out.println("Total Cost is: ");
        System.out.println(anOrder.totalCost());
        System.out.println("Exit");
        System.exit(0);
    }
}
