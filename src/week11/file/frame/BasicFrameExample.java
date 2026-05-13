package week11.file.frame;

import javax.swing.*;
import java.awt.*;

public class BasicFrameExample extends JFrame {

    private JLabel label;

    public BasicFrameExample() {
        setTitle("JFrame 기본 창 구성");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label = new JLabel("버튼을 클릭해보세요.", SwingConstants.CENTER);

        JButton button1 = new JButton("인사하기");
        JButton button2 = new JButton("초기화");

        button1.addActionListener(e -> label.setText("안녕하세요! 버튼 1을 클릭했습니다."));
        button2.addActionListener(e -> label.setText("버튼을 클릭해보세요."));

        add(label, BorderLayout.CENTER);
        add(button1, BorderLayout.WEST);
        add(button2, BorderLayout.EAST);

        setVisible(true);
    }

    public static void main(String[] args) {
        new BasicFrameExample();
    }
}