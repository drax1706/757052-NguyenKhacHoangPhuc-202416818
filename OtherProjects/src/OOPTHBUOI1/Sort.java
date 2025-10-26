package OOPTHBUOI1;
import javax.swing.JOptionPane;

public class Sort {
    public static void main(String[] args) {
        int[] arr;

        String[] options = {"input manually", "constant array"};
        int choice = JOptionPane.showOptionDialog(null,"choose input type","array input",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);

        if (choice == 0) {int n = Integer.parseInt(JOptionPane.showInputDialog("array size:"));
            arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(JOptionPane.showInputDialog("arr[" + i + "]:"));
            }
        } else { // constant array
            arr = new int[]{1789, 2035, 1899, 1456, 2013};
            JOptionPane.showMessageDialog(null, "using constant array");
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        int sum = 0;
        for (int num : arr) sum += num;
        double avg = (double) sum / arr.length;

        JOptionPane.showMessageDialog(null,"sorted: " + arrayToString(arr) + "\nsum: " + sum +"\naverage: " + avg);
    }
    public static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int x : arr) sb.append(x).append(" ");
        return sb.toString();
    }
}