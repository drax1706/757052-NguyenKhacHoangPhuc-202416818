package aims;
import javax.swing.JOptionPane;


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
        
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Avengers: Endgame",
                "Action", "Anthony Russo & Joe Russo", 181, 29.99f);
        anOrder.addDigitalVideoDisc(dvd4);

        
        anOrder.removeDigitalVideoDisc(dvd2);
        // loop chon option
        String[] options = {"Add DVDs", "Remove DVDs", "Total", "Exit"};
        while (true) {
            int choice = JOptionPane.showOptionDialog(null,"Choose options",null,JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
            
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
       

        
        
        DigitalVideoDisc[] dvdsArray = {dvd2, dvd3};
        System.out.println("Adding DVDs from array:");
        anOrder.addDigitalVideoDisc(dvdsArray);       
        
        System.out.println("Adding exactly 2 DVDs:");
        anOrder.addDigitalVideoDisc(dvd1, dvd4);
        
        System.out.println("Total cost is: " + anOrder.totalCost());

        anOrder.printTitles();
        System.out.println("Exit");
        System.exit(0);
    }
}


