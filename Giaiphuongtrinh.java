package OOP.OOPTHBUOI1;
import javax.swing.JOptionPane;

public class Giaiphuongtrinh {
    public static void main(String[] args) {
        String[] options = {"Linear solver", "Linear 2 variables solver.", "Second-degree solver."};
        int chon = JOptionPane.showOptionDialog(null, "Choose type you want to solve", null, 0, 0, null, options, options[0]);
        if (chon == 0) {
            JOptionPane.showMessageDialog(null, "You choose Linear solver.");
            String strNum1 = JOptionPane.showInputDialog("Enter coefficient a:");
            String strNum2 = JOptionPane.showInputDialog("Enter coefficient b:");
            double num1 = Double.parseDouble(strNum1);
            double num2 = Double.parseDouble(strNum2);
            if (num1 != 0) {
                JOptionPane.showMessageDialog(null, "The equation has a unique solution." + (-num2/num1),null,1);
            } else if (num2 == 0){
                JOptionPane.showMessageDialog(null, "The equation has an infinite number of solutions.", null, 1);                
            } else {
                JOptionPane.showMessageDialog(null, "The equation has no solution.", null, 1);
            }
        } else if (chon == 1) {
            JOptionPane.showMessageDialog(null, "You choose Linear 2 variables solver.");
            // gọi hàm giải hệ 2 phương trình
        } else if (chon == 2) {
            JOptionPane.showMessageDialog(null, "You choose Second-degree solver.");
            // gọi hàm giải ax^2+bx+c=0
        }
    }    
}
