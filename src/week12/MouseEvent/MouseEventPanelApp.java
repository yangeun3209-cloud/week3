import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseEventPanelApp extends JFrame {
    private JLabel clickLabel;
    private JLabel positionLabel;
    private JLabel wheelLabel;

    public MouseEventPanelApp() {
        setTitle("마우스 이벤트 정보");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel westPanel = new JPanel();
        westPanel.setLayout(new GridLayout(3, 1));

        clickLabel = new JLabel("클릭 정보: ");
        positionLabel = new JLabel("좌표 정보: ");
        wheelLabel = new JLabel("휠 정보: ");

        westPanel.add(clickLabel);
        westPanel.add(positionLabel);
        westPanel.add(wheelLabel);

        add(westPanel, BorderLayout.WEST);

        MousePanel mousePanel = new MousePanel();
        add(mousePanel, BorderLayout.CENTER);

        setVisible(true);
    }

    class MousePanel extends JPanel implements MouseListener, MouseMotionListener, MouseWheelListener {
        public MousePanel() {
            setBackground(Color.LIGHT_GRAY);

            addMouseListener(this);
            addMouseMotionListener(this);
            addMouseWheelListener(this);
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            int buttonNumber = -1;

            if (e.getButton() == MouseEvent.BUTTON1) {
                buttonNumber = 0; // left
            } else if (e.getButton() == MouseEvent.BUTTON3) {
                buttonNumber = 1; // right
            } else if (e.getButton() == MouseEvent.BUTTON2) {
                buttonNumber = 2; // middle
            }

            clickLabel.setText("클릭 정보: " + buttonNumber);
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            positionLabel.setText("좌표 정보: (" + e.getX() + ", " + e.getY() + ")");
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            positionLabel.setText("좌표 정보: (" + e.getX() + ", " + e.getY() + ")");
        }

        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {
            wheelLabel.setText("휠 정보: " + e.getWheelRotation());
        }

        @Override
        public void mousePressed(MouseEvent e) {}

        @Override
        public void mouseReleased(MouseEvent e) {}

        @Override
        public void mouseEntered(MouseEvent e) {}

        @Override
        public void mouseExited(MouseEvent e) {}
    }

    public static void main(String[] args) {
        new MouseEventPanelApp();
    }
}