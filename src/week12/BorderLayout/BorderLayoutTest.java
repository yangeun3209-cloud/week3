import javax.swing.*;
import java.awt.*;

public class BorderLayoutTest extends JFrame {

    public BorderLayoutTest() {
        setTitle("BorderLayout Test");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // BorderLayout 설정
        setLayout(new BorderLayout());

        // 버튼 생성 및 배치
        add(new JButton("NORTH"), BorderLayout.NORTH);
        add(new JButton("SOUTH"), BorderLayout.SOUTH);
        add(new JButton("CENTER"), BorderLayout.CENTER);
        add(new JButton("WEST"), BorderLayout.WEST);
        add(new JButton("EAST"), BorderLayout.EAST);

        setVisible(true);
    }

    public static void main(String[] args) {
        new BorderLayoutTest();
    }
}