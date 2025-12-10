package hust.soict.dsai.swing;
import java.awt.*;
import java.awt.event.*;

public class AWTAccumulator extends Frame {
    private TextField tfInput;
    private TextField tfOutput;
    private int sum = 0;       // Tổng ban đầu = 0

    // Constructor để tạo GUI
    public AWTAccumulator() {
        setLayout(new GridLayout(2, 2));

        add(new Label("Enter an Integer: "));
        tfInput = new TextField(10);
        add(tfInput);

        tfInput.addActionListener(new TFInputListener());

        add(new Label("The Accumulated Sum is: "));
        tfOutput = new TextField("0", 10);
        tfOutput.setEditable(false);
        add(tfOutput);

        setSize(350, 120);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AWTAccumulator();
    }

    private class TFInputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            int number = Integer.parseInt(tfInput.getText());
            sum += number;
            tfInput.setText("");
            tfOutput.setText(sum + "");
        }
    }
}

