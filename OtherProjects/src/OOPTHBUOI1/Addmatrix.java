package OOPTHBUOI1;
import javax.swing.JOptionPane;
public class Addmatrix {
    public static void main(String[] args) {
        int rows = Integer.parseInt(JOptionPane.showInputDialog("number of rows:"));
        int cols = Integer.parseInt(JOptionPane.showInputDialog("number of columns:"));
        int[][] A = new int[rows][cols];
        int[][] B = new int[rows][cols];
        int[][] C = new int[rows][cols];


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                A[i][j] = Integer.parseInt(JOptionPane.showInputDialog("A[" + i + "][" + j + "]:"));
            }
        }


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                B[i][j] = Integer.parseInt(JOptionPane.showInputDialog("B[" + i + "][" + j + "]:"));
            }
        }


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }

        JOptionPane.showMessageDialog(null,"Matrix A:\n" + matrixToString(A) +"\nMatrix B:\n" + matrixToString(B) +"\nA + B:\n" + matrixToString(C));}

    public static String matrixToString(int[][] M) {
        String s = "";
        for (int[] row : M) {
            for (int x : row) s += x + " ";
            s += "\n";
        }
        return s;
    }
}