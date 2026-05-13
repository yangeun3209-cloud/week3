package week11.file.frame;

import javax.swing.*;
import java.awt.*;

public class FlowLayoutExample extends JFrame {

    public FlowLayoutExample() {
        setTitle("FlowLayout 정렬 비교");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 1));

        JPanel leftPanel = createPanel("LEFT 정렬", FlowLayout.LEFT);
        JPanel centerPanel = createPanel("CENTER 정렬", FlowLayout.CENTER);
        JPanel rightPanel = createPanel("RIGHT 정렬", FlowLayout.RIGHT);

        mainPanel.add(leftPanel);
        mainPanel.add(centerPanel);
        mainPanel.add(rightPanel);

        add(mainPanel);

        setVisible(true);
    }

    private JPanel createPanel(String title, int alignment) {
        JPanel outerPanel = new JPanel(new BorderLayout());

        JLabel label = new JLabel(title, SwingConstants.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(alignment, 10, 10));

        for (int i = 1; i <= 4; i++) {
            buttonPanel.add(new JButton("버튼 " + i));
        }

        outerPanel.add(label, BorderLayout.NORTH);
        outerPanel.add(buttonPanel, BorderLayout.CENTER);

        return outerPanel;
    }

    public static void main(String[] args) {
        new FlowLayoutExample();
    }
}