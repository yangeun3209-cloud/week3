package week13.reversi2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class Reversi2 extends JFrame {

    private static class GameLogic {
        public static final int BOARD_SIZE = 8;
        public static final int EMPTY = 0;
        public static final int BLACK = 1;
        public static final int WHITE = 2;

        private int[][] board;
        private int currentPlayer;
        private int blackCount;
        private int whiteCount;
        private boolean gameOver;
        private String result;

        public GameLogic() {
            initializeGame();
        }

        public void initializeGame() {
            board = new int[BOARD_SIZE][BOARD_SIZE];

            int mid = BOARD_SIZE / 2;
            board[mid - 1][mid - 1] = WHITE;
            board[mid - 1][mid] = BLACK;
            board[mid][mid - 1] = BLACK;
            board[mid][mid] = WHITE;

            currentPlayer = BLACK;
            gameOver = false;
            result = "";
            updateCounts();
        }

        public void setFirstPlayer(int player) {
            currentPlayer = player;
        }

        public boolean makeMove(int row, int col) {
            if (!isValidMove(row, col)) {
                return false;
            }

            board[row][col] = currentPlayer;
            flipStones(row, col);
            updateCounts();

            currentPlayer = (currentPlayer == BLACK) ? WHITE : BLACK;

            if (!hasValidMove()) {
                currentPlayer = (currentPlayer == BLACK) ? WHITE : BLACK;

                if (!hasValidMove()) {
                    gameOver = true;
                    determineWinner();
                }
            }

            if (isBoardFull()) {
                gameOver = true;
                determineWinner();
            }

            return true;
        }

        private boolean isValidMove(int row, int col) {
            if (row < 0 || row >= BOARD_SIZE || col < 0 || col >= BOARD_SIZE) {
                return false;
            }

            if (board[row][col] != EMPTY) {
                return false;
            }

            return hasOpponentStones(row, col);
        }

        private boolean hasOpponentStones(int row, int col) {
            int[][] directions = {
                    {-1, -1}, {-1, 0}, {-1, 1},
                    {0, -1},           {0, 1},
                    {1, -1},  {1, 0},  {1, 1}
            };

            for (int[] dir : directions) {
                if (canFlipInDirection(row, col, dir[0], dir[1])) {
                    return true;
                }
            }

            return false;
        }

        private boolean canFlipInDirection(int row, int col, int dRow, int dCol) {
            int r = row + dRow;
            int c = col + dCol;
            boolean hasOpponent = false;

            while (r >= 0 && r < BOARD_SIZE && c >= 0 && c < BOARD_SIZE) {
                int cell = board[r][c];

                if (cell == EMPTY) {
                    return false;
                }

                if (cell == currentPlayer) {
                    return hasOpponent;
                }

                hasOpponent = true;
                r += dRow;
                c += dCol;
            }

            return false;
        }

        private void flipStones(int row, int col) {
            int[][] directions = {
                    {-1, -1}, {-1, 0}, {-1, 1},
                    {0, -1},           {0, 1},
                    {1, -1},  {1, 0},  {1, 1}
            };

            for (int[] dir : directions) {
                flipInDirection(row, col, dir[0], dir[1]);
            }
        }

        private void flipInDirection(int row, int col, int dRow, int dCol) {
            if (!canFlipInDirection(row, col, dRow, dCol)) {
                return;
            }

            int r = row + dRow;
            int c = col + dCol;

            while (r >= 0 && r < BOARD_SIZE && c >= 0 && c < BOARD_SIZE) {
                if (board[r][c] == currentPlayer) {
                    break;
                }

                board[r][c] = currentPlayer;
                r += dRow;
                c += dCol;
            }
        }

        public boolean hasValidMove() {
            for (int i = 0; i < BOARD_SIZE; i++) {
                for (int j = 0; j < BOARD_SIZE; j++) {
                    if (board[i][j] == EMPTY && hasOpponentStones(i, j)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean isBoardFull() {
            for (int i = 0; i < BOARD_SIZE; i++) {
                for (int j = 0; j < BOARD_SIZE; j++) {
                    if (board[i][j] == EMPTY) {
                        return false;
                    }
                }
            }
            return true;
        }

        private void updateCounts() {
            blackCount = 0;
            whiteCount = 0;

            for (int i = 0; i < BOARD_SIZE; i++) {
                for (int j = 0; j < BOARD_SIZE; j++) {
                    if (board[i][j] == BLACK) {
                        blackCount++;
                    } else if (board[i][j] == WHITE) {
                        whiteCount++;
                    }
                }
            }
        }

        private void determineWinner() {
            updateCounts();

            if (blackCount > whiteCount) {
                result = "검정색이 이겼습니다! (검정: " + blackCount + " > 흰색: " + whiteCount + ")";
            } else if (whiteCount > blackCount) {
                result = "흰색이 이겼습니다! (흰색: " + whiteCount + " > 검정: " + blackCount + ")";
            } else {
                result = "무승부입니다! (검정: " + blackCount + " = 흰색: " + whiteCount + ")";
            }
        }

        public int[][] getBoard() {
            return board;
        }

        public int getCurrentPlayer() {
            return currentPlayer;
        }

        public boolean isGameOver() {
            return gameOver;
        }

        public String getResult() {
            return result;
        }

        public int getBlackCount() {
            return blackCount;
        }

        public int getWhiteCount() {
            return whiteCount;
        }
    }

    private class GameBoardPanel extends JPanel {
        private final int CELL_SIZE = 50;
        private final int MARGIN = 15;

        public GameBoardPanel() {
            setBackground(new Color(34, 139, 34));
            setPreferredSize(new Dimension(
                    CELL_SIZE * GameLogic.BOARD_SIZE + MARGIN * 2,
                    CELL_SIZE * GameLogic.BOARD_SIZE + MARGIN * 2
            ));

            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int col = (e.getX() - MARGIN) / CELL_SIZE;
                    int row = (e.getY() - MARGIN) / CELL_SIZE;

                    if (row >= 0 && row < GameLogic.BOARD_SIZE &&
                            col >= 0 && col < GameLogic.BOARD_SIZE &&
                            !game.isGameOver()) {
                        if (game.makeMove(row, col)) {
                            updateCursor();
                            updateStatus();
                            repaint();
                        }
                    }
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            g2d.setColor(Color.BLACK);
            g2d.setStroke(new BasicStroke(2));

            for (int i = 0; i <= GameLogic.BOARD_SIZE; i++) {
                g2d.drawLine(
                        MARGIN,
                        MARGIN + i * CELL_SIZE,
                        MARGIN + GameLogic.BOARD_SIZE * CELL_SIZE,
                        MARGIN + i * CELL_SIZE
                );

                g2d.drawLine(
                        MARGIN + i * CELL_SIZE,
                        MARGIN,
                        MARGIN + i * CELL_SIZE,
                        MARGIN + GameLogic.BOARD_SIZE * CELL_SIZE
                );
            }

            int[][] board = game.getBoard();

            for (int i = 0; i < GameLogic.BOARD_SIZE; i++) {
                for (int j = 0; j < GameLogic.BOARD_SIZE; j++) {
                    if (board[i][j] != GameLogic.EMPTY) {
                        int x = MARGIN + j * CELL_SIZE + 4;
                        int y = MARGIN + i * CELL_SIZE + 4;
                        int size = CELL_SIZE - 8;

                        if (board[i][j] == GameLogic.BLACK) {
                            g2d.setColor(Color.BLACK);
                        } else {
                            g2d.setColor(Color.WHITE);
                        }

                        g2d.fillOval(x, y, size, size);

                        g2d.setColor(Color.BLACK);
                        g2d.setStroke(new BasicStroke(1));
                        g2d.drawOval(x, y, size, size);
                    }
                }
            }
        }
    }

    private GameLogic game;
    private GameBoardPanel boardPanel;
    private JLabel statusLabel;
    private JLabel scoreLabel;
    private JButton resetButton;
    private Cursor cursorBlack;
    private Cursor cursorWhite;

    public Reversi2() {
        setTitle("Reversi 2 (2인 게임)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        game = new GameLogic();

        cursorBlack = createCustomCursor(Color.BLACK);
        cursorWhite = createCustomCursor(Color.WHITE);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBackground(Color.DARK_GRAY);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel topPanel = new JPanel(new GridLayout(2, 1, 0, 5));
        topPanel.setBackground(Color.DARK_GRAY);

        statusLabel = new JLabel("검정색(플레이어1)의 차례입니다");
        statusLabel.setFont(new Font("맑은 고딕", Font.BOLD, 16));
        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
        statusLabel.setForeground(Color.WHITE);

        scoreLabel = new JLabel("검정색: 2  |  흰색: 2");
        scoreLabel.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        scoreLabel.setForeground(Color.WHITE);

        topPanel.add(statusLabel);
        topPanel.add(scoreLabel);
        mainPanel.add(topPanel, BorderLayout.NORTH);

        boardPanel = new GameBoardPanel();
        mainPanel.add(boardPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.DARK_GRAY);

        resetButton = new JButton("새 게임");
        resetButton.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        resetButton.setPreferredSize(new Dimension(120, 40));
        resetButton.addActionListener(e -> showFirstPlayerDialog());

        buttonPanel.add(resetButton);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
        pack();
        setLocationRelativeTo(null);

        SwingUtilities.invokeLater(this::showFirstPlayerDialog);
    }

    private Cursor createCustomCursor(Color color) {
        int size = 32;
        Image image = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = (Graphics2D) image.getGraphics();

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setComposite(AlphaComposite.Clear);
        g2d.fillRect(0, 0, size, size);
        g2d.setComposite(AlphaComposite.SrcOver);

        g2d.setColor(color);
        g2d.fillOval(4, 4, size - 8, size - 8);

        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(2));
        g2d.drawOval(4, 4, size - 8, size - 8);

        g2d.dispose();

        return Toolkit.getDefaultToolkit().createCustomCursor(
                image,
                new Point(size / 2, size / 2),
                "Stone"
        );
    }

    private void showFirstPlayerDialog() {
        String[] options = {"검정색 먼저 (1P)", "흰색 먼저 (2P)"};

        int choice = JOptionPane.showOptionDialog(
                this,
                "누가 먼저 시작하시겠습니까?",
                "게임 시작",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        game.initializeGame();

        if (choice == 1) {
            game.setFirstPlayer(GameLogic.WHITE);
        }

        updateCursor();
        updateStatus();
        boardPanel.repaint();
    }

    private void updateCursor() {
        if (game.getCurrentPlayer() == GameLogic.BLACK) {
            boardPanel.setCursor(cursorBlack);
        } else {
            boardPanel.setCursor(cursorWhite);
        }
    }

    private void updateStatus() {
        scoreLabel.setText(String.format(
                "검정색: %d  |  흰색: %d",
                game.getBlackCount(),
                game.getWhiteCount()
        ));

        if (game.isGameOver()) {
            statusLabel.setText(game.getResult());
            JOptionPane.showMessageDialog(this, game.getResult());
            showFirstPlayerDialog();
        } else {
            String playerName = (game.getCurrentPlayer() == GameLogic.BLACK)
                    ? "검정색(플레이어1)"
                    : "흰색(플레이어2)";

            statusLabel.setText(playerName + "의 차례입니다");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Reversi2 game = new Reversi2();
            game.setVisible(true);
        });
    }
}