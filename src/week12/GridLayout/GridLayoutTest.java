import javax.swing.*;
import java.awt.*;

public class GridLayoutTest extends JFrame {

    public GridLayoutTest() {
        setTitle("GridLayout Test");
        setSize(360, 240);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 4행 3열, 간격 5
        setLayout(new GridLayout(4, 3, 5, 5));

        // 버튼 16개 생성
        for (int i = 1; i <= 16; i++) {
            JButton button = new JButton(String.valueOf(i));
            add(button);
        }

        setVisible(true);
    }

    public static void main(String[] args) {
        new GridLayoutTest();
    }
}