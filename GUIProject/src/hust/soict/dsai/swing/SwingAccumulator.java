package hust.soict.dsai.swing;

import javax.swing.*;      // JFrame, JLabel, JTextField, ...
import java.awt.*;         // Container, GridLayout, ...
import java.awt.event.*;   // ActionListener, ActionEvent

public class SwingAccumulator extends JFrame {
    private JTextField tfInput;
    private JTextField tfOutput;
    private int sum = 0;   // Tổng ban đầu = 0

    // Constructor: thiết lập GUI và event handler
    public SwingAccumulator() {
        Container cp = getContentPane();           // Lấy content pane của JFrame
        cp.setLayout(new GridLayout(2, 2));        // Layout 2 hàng 2 cột

        cp.add(new JLabel("Enter an Integer: "));  // Label 1

        tfInput = new JTextField(10);              // TextField nhập
        cp.add(tfInput);
        tfInput.addActionListener(new TFInputListener()); // Gắn listener

        cp.add(new JLabel("The Accumulated Sum is: "));   // Label 2

        tfOutput = new JTextField(10);             // TextField hiển thị tổng
        tfOutput.setEditable(false);               // Chỉ đọc
        cp.add(tfOutput);

        setTitle("Swing Accumulator");             // Tiêu đề cửa sổ
        setSize(350, 120);                         // Kích thước
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Đóng là thoát
        setVisible(true);                          // Hiển thị
    }

    public static void main(String[] args) {
        new SwingAccumulator();                    // Tạo và hiển thị GUI
    }

    private class TFInputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            int numberIn = Integer.parseInt(tfInput.getText()); // Lấy số nhập
            sum += numberIn;                                    // Cộng dồn
            tfInput.setText("");                                // Xóa ô nhập
            tfOutput.setText(sum + "");                         // Cập nhật tổng
        }
    }
}
