package OOP.OOPTHBUOI1;
import javax.swing.JOptionPane;

public class Giaiphuongtrinh {
    public static void main(String[] args) {
        String[] options = {"Linear solver", "Linear 2 variables solver.", "Second-degree solver."};
        int chon = JOptionPane.showOptionDialog(null, "Choose type you want to solve", null, 0, 0, null, options, options[0]);
        // mot bien ne
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


        // hai bienn
        } else if (chon == 1) {
            JOptionPane.showMessageDialog(null, "You choose Linear 2 variables solver.");
            
            double a11 = Double.parseDouble(JOptionPane.showInputDialog("Enter a11:"));
            double a12 = Double.parseDouble(JOptionPane.showInputDialog("Enter a12:"));
            double b1  = Double.parseDouble(JOptionPane.showInputDialog("Enter b1:"));
            double a21 = Double.parseDouble(JOptionPane.showInputDialog("Enter a21:"));
            double a22 = Double.parseDouble(JOptionPane.showInputDialog("Enter a22:"));
            double b2  = Double.parseDouble(JOptionPane.showInputDialog("Enter b2:"));

            double D  = a11 * a22 - a21 * a12;
            double D1 = b1 * a22 - b2 * a12;
            double D2 = a11 * b2 - a21 * b1;

            if (D != 0) {
                double x1 = D1 / D;
                double x2 = D2 / D;
                JOptionPane.showMessageDialog(null, "Unique solution:\nx1 = " + x1 + "\nx2 = " + x2);
            } else {
                if (D1 == 0 && D2 == 0) {
                    JOptionPane.showMessageDialog(null, "The system has an infinite number of solutions.");
                } else {
                    JOptionPane.showMessageDialog(null, "The system has no solution.");
                }
            }

            
        // bac 2

        } else if (chon == 2) {
            JOptionPane.showMessageDialog(null, "You choose Second-degree solver.");


            double a = Double.parseDouble(JOptionPane.showInputDialog("Enter coefficient a:"));
            double b = Double.parseDouble(JOptionPane.showInputDialog("Enter coefficient b:"));
            double c = Double.parseDouble(JOptionPane.showInputDialog("Enter coefficient c:"));

            if (a == 0) {
                if (b != 0) {
                    double x = -c / b;
                    JOptionPane.showMessageDialog(null, "This is linear. Unique solution: x = " + x);
                } else if (c == 0) {
                    JOptionPane.showMessageDialog(null, "The equation has infinitely many solutions.");
                } else {
                    JOptionPane.showMessageDialog(null, "The equation has no solution.");
                }
            } else {
                double delta = b * b - 4 * a * c;
                if (delta > 0) {
                    double x1 = (-b - Math.sqrt(delta)) / (2 * a);
                    double x2 = (-b + Math.sqrt(delta)) / (2 * a);
                    JOptionPane.showMessageDialog(null, "Two distinct solutions:\nx1 = " + x1 + "\nx2 = " + x2);
                } else if (delta == 0) {
                    double x = -b / (2 * a);
                    JOptionPane.showMessageDialog(null, "Double root: x = " + x);
                } else {
                    JOptionPane.showMessageDialog(null, "The equation has no real solution.");
                }
            }

            
        }
    }    
}
