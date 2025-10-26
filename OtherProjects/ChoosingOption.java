package OOP.OOPTHBUOI1;

import javax.swing.JOptionPane;

public class ChoosingOption {
    public static void main(String[] args) {
        int options = JOptionPane.showConfirmDialog(null, "Do you want to change to the first class ticket?", null, 1);

        JOptionPane.showMessageDialog(null, "You've chosen: " + (options == JOptionPane.YES_OPTION?"Yes":"No"), null, options);

        System.exit(0);
    }
}
