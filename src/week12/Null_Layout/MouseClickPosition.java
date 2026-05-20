import javax.swing.*;
import java.awt.event.*;

public class MouseClickPosition extends JFrame {
    private int clickCount = 0;

    public MouseClickPosition() {
        setTitle("Mouse Click Position");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // 절대 배치 (Null Layout)
        setLayout(null);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // 왼쪽 버튼 + 10번까지만 허용
                if (e.getButton() == MouseEvent.BUTTON1 && clickCount < 10) {
                    clickCount++;

                    // 클릭된 위치 좌표 표시
                    JLabel label = new JLabel("(" + e.getX() + ", " + e.getY() + ")");
                    label.setBounds(e.getX(), e.getY(), 80, 20);

                    add(label);
                    repaint();
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new MouseClickPosition();
    }
}