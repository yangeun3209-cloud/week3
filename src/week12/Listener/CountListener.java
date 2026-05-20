import javax.swing.*;
import java.awt.event.*;

public class CountListener implements ActionListener {
    private JLabel label;
    private int count = 0;

    public CountListener(JLabel label) {
        this.label = label;
    }

    public void actionPerformed(ActionEvent e) {
        count++;
        label.setText("클릭 횟수: " + count);
    }
}