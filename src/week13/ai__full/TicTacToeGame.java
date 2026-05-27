package week13.ai__full;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

public class TicTacToeGame extends JFrame {
    private final JButton[][] buttons = new JButton[3][3];
    private final JLabel statusLabel = new JLabel("현재 차례: X", SwingConstants.CENTER);
    private String currentPlayer = "X";
    private int moves = 0;

    public TicTacToeGame() {
        setTitle("틱택토 (2인용)");
        setSize(360, 420);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel boardPanel = new JPanel(new GridLayout(3, 3, 6, 6));
        Font buttonFont = new Font(Font.SANS_SERIF, Font.BOLD, 48);

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                JButton button = new JButton();
                button.setFont(buttonFont);
                int r = row;
                int c = col;
                button.addActionListener(e -> handleMove(r, c));
                buttons[row][col] = button;
                boardPanel.add(button);
            }
        }

        setLayout(new BorderLayout(10, 10));
        add(statusLabel, BorderLayout.NORTH);
        add(boardPanel, BorderLayout.CENTER);
    }

    private void handleMove(int row, int col) {
        JButton button = buttons[row][col];
        if (!button.getText().isEmpty()) {
            return;
        }

        button.setText(currentPlayer);
        button.setEnabled(false);
        moves++;

        if (hasWinner(currentPlayer)) {
            JOptionPane.showMessageDialog(this, currentPlayer + " 승리! 다시 시작합니다.");
            resetGame();
            return;
        }

        if (moves == 9) {
            JOptionPane.showMessageDialog(this, "무승부! 다시 시작합니다.");
            resetGame();
            return;
        }

        currentPlayer = currentPlayer.equals("X") ? "O" : "X";
        statusLabel.setText("현재 차례: " + currentPlayer);
    }

    private boolean hasWinner(String player) {
        for (int i = 0; i < 3; i++) {
            if (player.equals(buttons[i][0].getText())
                    && player.equals(buttons[i][1].getText())
                    && player.equals(buttons[i][2].getText())) {
                return true;
            }
            if (player.equals(buttons[0][i].getText())
                    && player.equals(buttons[1][i].getText())
                    && player.equals(buttons[2][i].getText())) {
                return true;
            }
        }

        return player.equals(buttons[0][0].getText())
                && player.equals(buttons[1][1].getText())
                && player.equals(buttons[2][2].getText())
                || player.equals(buttons[0][2].getText())
                && player.equals(buttons[1][1].getText())
                && player.equals(buttons[2][0].getText());
    }

    private void resetGame() {
        for (JButton[] row : buttons) {
            for (JButton button : row) {
                button.setText("");
                button.setEnabled(true);
            }
        }
        moves = 0;
        currentPlayer = "X";
        statusLabel.setText("현재 차례: " + currentPlayer);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TicTacToeGame frame = new TicTacToeGame();
            frame.setVisible(true);
        });
    }
}
