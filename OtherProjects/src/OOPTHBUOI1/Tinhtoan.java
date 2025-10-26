package OOPTHBUOI1;
import javax.swing.JOptionPane;

public class Tinhtoan {
    public static void main(String[] args){
        String strNum1,strNum2;
        strNum1 = JOptionPane.showInputDialog(null,"Please input the first number: "," Input the first number", JOptionPane.INFORMATION_MESSAGE );
        strNum2 = JOptionPane.showInputDialog(null,"Please input the second number: ", "Input the second number" ,JOptionPane.INFORMATION_MESSAGE);
        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);
        double sum1,sub1,product1;
        sum1 = num1 + num2;
        sub1 = num1 - num2;
        product1 = num1 * num2;
        
        JOptionPane.showMessageDialog(null, "Sum: " + sum1 +  "\nSub: " + sub1 + "\nProduct: " + product1 +  "\nDivision: " + (num2 == 0 ? "Cannot divide by  0!" : (num1 / num2)),"Result",JOptionPane.INFORMATION_MESSAGE);
    }
}
