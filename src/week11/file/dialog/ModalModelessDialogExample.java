package week11.file.frame;

import javax.swing.*;
import java.awt.*;

public class ModalModelessDialogExample extends JFrame {

    private JLabel label;

    public ModalModelessDialogExample() {
        setTitle("Modal / Modeless Dialog 예제");
        setSize(450, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label = new JLabel("모달 또는 모드리스 대화상자를 실행해보세요.", SwingConstants.CENTER);

        JButton modalButton = new JButton("모달 Dialog 열기");
        JButton modelessButton = new JButton("모드리스 Dialog 열기");

        modalButton.addActionListener(e -> openModalDialog());
        modelessButton.addActionListener(e -> openModelessDialog());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(modalButton);
        buttonPanel.add(modelessButton);

        add(label, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void openModalDialog() {
        JDialog dialog = new JDialog(this, "모달 Dialog", true);

        dialog.setSize(300, 150);
        dialog.setLocationRelativeTo(this);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setLayout(new BorderLayout());

        JLabel message = new JLabel("모달: 이 창을 닫기 전까지 부모 창을 사용할 수 없습니다.", SwingConstants.CENTER);
        JButton closeButton = new JButton("닫기");

        closeButton.addActionListener(e -> dialog.dispose());

        dialog.add(message, BorderLayout.CENTER);
        dialog.add(closeButton, BorderLayout.SOUTH);

        label.setText("모달 Dialog 실행 중");
        dialog.setVisible(true);
        label.setText("모달 Dialog가 닫혔습니다.");
    }

    private void openModelessDialog() {
        JDialog dialog = new JDialog(this, "모드리스 Dialog", false);

        dialog.setSize(330, 150);
        dialog.setLocationRelativeTo(this);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setLayout(new BorderLayout());

        JLabel message = new JLabel("모드리스: 대화상자가 열려 있어도 부모 창 사용 가능", SwingConstants.CENTER);
        JButton closeButton = new JButton("닫기");

        closeButton.addActionListener(e -> dialog.dispose());

        dialog.add(message, BorderLayout.CENTER);
        dialog.add(closeButton, BorderLayout.SOUTH);

        label.setText("모드리스 Dialog 실행 중 - 부모 창 사용 가능");
        dialog.setVisible(true);
    }

    public static void main(String[] args) {
        new ModalModelessDialogExample();
    }
}