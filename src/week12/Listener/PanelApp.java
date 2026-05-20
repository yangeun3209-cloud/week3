import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PanelApp extends JFrame {
    private int innerCount = 0;
    private int anonymousCount = 0;
    private int lambdaCount = 0;

    public PanelApp() {
        setTitle("버튼 클릭 카운터");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridLayout(2, 2));

        add(createIndependentPanel());
        add(createInnerPanel());
        add(createAnonymousPanel());
        add(createLambdaPanel());

        setVisible(true);
    }

    private JPanel createIndependentPanel() {
        JPanel panel = new JPanel();
        JButton button = new JButton("클릭");
        JLabel label = new JLabel("독립 클래스 - 클릭 횟수: 0");

        button.addActionListener(new CountListener(label));

        panel.add(button);
        panel.add(label);
        return panel;
    }

    private JPanel createInnerPanel() {
        JPanel panel = new JPanel();
        JButton button = new JButton("클릭");
        JLabel label = new JLabel("내부 클래스 - 클릭 횟수: 0");

        button.addActionListener(new InnerListener(label));

        panel.add(button);
        panel.add(label);
        return panel;
    }

    class InnerListener implements ActionListener {
        private JLabel label;

        public InnerListener(JLabel label) {
            this.label = label;
        }

        public void actionPerformed(ActionEvent e) {
            innerCount++;
            label.setText("내부 클래스 - 클릭 횟수: " + innerCount);
        }
    }

    private JPanel createAnonymousPanel() {
        JPanel panel = new JPanel();
        JButton button = new JButton("클릭");
        JLabel label = new JLabel("익명 클래스 - 클릭 횟수: 0");

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                anonymousCount++;
                label.setText("익명 클래스 - 클릭 횟수: " + anonymousCount);
            }
        });

        panel.add(button);
        panel.add(label);
        return panel;
    }

    private JPanel createLambdaPanel() {
        JPanel panel = new JPanel();
        JButton button = new JButton("클릭");
        JLabel label = new JLabel("람다식 - 클릭 횟수: 0");

        button.addActionListener(e -> {
            lambdaCount++;
            label.setText("람다식 - 클릭 횟수: " + lambdaCount);
        });

        panel.add(button);
        panel.add(label);
        return panel;
    }

    public static void main(String[] args) {
        new PanelApp();
    }
}