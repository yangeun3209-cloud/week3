package week13.reversi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

/**
 * Reversi(Othello) 8x8 게임
 * ReversiGame, ReversiGUI, ReversiMain을 하나로 통합한 클래스
 */
public class Reversi {
    
    /**
     * Reversi 게임의 로직을 담당하는 클래스
     */
    private static class ReversiGame {
        public static final int BOARD_SIZE = 8;
        public static final char EMPTY = ' ';
        public static final char BLACK = 'B'; // AI
        public static final char WHITE = 'W'; // 사람
        
        private char[][] board;
        private char currentPlayer;
        private int blackCount;
        private int whiteCount;
        private boolean gameOver;
        private String result;

        public ReversiGame() {
            initializeGame();
        }

        public void initializeGame() {
            board = new char[BOARD_SIZE][BOARD_SIZE];
            
            for (int i = 0; i < BOARD_SIZE; i++) {
                for (int j = 0; j < BOARD_SIZE; j++) {
                    board[i][j] = EMPTY;
                }
            }
            
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

        public boolean makeMove(int row, int col) {
            if (!isValidMove(row, col)) {
                return false;
            }

            board[row][col] = currentPlayer;
            flipStones(row, col);
            updateCounts();
            
            if (checkGameOver()) {
                gameOver = true;
                determineWinner();
                return true;
            }
            
            currentPlayer = (currentPlayer == BLACK) ? WHITE : BLACK;
            
            if (!hasValidMove()) {
                currentPlayer = (currentPlayer == BLACK) ? WHITE : BLACK;
                
                if (!hasValidMove()) {
                    gameOver = true;
                    determineWinner();
                }
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
                char cell = board[r][c];
                
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

        private boolean checkGameOver() {
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
            if (blackCount > whiteCount) {
                result = "검정색(AI)이 이겼습니다! (검정: " + blackCount + " > 흰색: " + whiteCount + ")";
            } else if (whiteCount > blackCount) {
                result = "축하합니다! 당신이 이겼습니다! (흰색: " + whiteCount + " > 검정: " + blackCount + ")";
            } else {
                result = "무승부입니다! (검정: " + blackCount + " = 흰색: " + whiteCount + ")";
            }
        }

        public char[][] getBoard() {
            return board;
        }

        public char getCurrentPlayer() {
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

        public void setCurrentPlayer(char player) {
            currentPlayer = player;
        }

        public void setGameOver(boolean gameOver) {
            this.gameOver = gameOver;
        }
    }

    /**
     * Reversi 게임의 GUI를 담당하는 클래스
     */
    private static class ReversiGUI extends JFrame {
        private ReversiGame game;
        private BoardButton[][] buttons;
        private JLabel statusLabel;
        private JLabel scoreLabel;
        private JButton resetButton;
        private ImageIcon whiteStoneIcon;
        private ImageIcon blackStoneIcon;
        private CommonActionListener actionListener;
        private boolean isHumanTurn;

        public ReversiGUI() {
            setTitle("Reversi (8x8 Othello)");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(700, 850);
            setLocationRelativeTo(null);
            setResizable(false);

            game = new ReversiGame();
            buttons = new BoardButton[ReversiGame.BOARD_SIZE][ReversiGame.BOARD_SIZE];
            isHumanTurn = false;
            
            whiteStoneIcon = new ImageIcon(createStoneImage(Color.WHITE, 50, false));
            blackStoneIcon = new ImageIcon(createStoneImage(Color.BLACK, 50, false));

            JPanel mainPanel = new JPanel();
            mainPanel.setLayout(new BorderLayout(10, 10));
            mainPanel.setBackground(new Color(200, 150, 80));
            mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            statusLabel = new JLabel("AI(검정색)의 차례입니다.");
            statusLabel.setFont(new Font("Arial", Font.BOLD, 16));
            statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
            statusLabel.setPreferredSize(new Dimension(700, 30));
            statusLabel.setForeground(Color.WHITE);
            mainPanel.add(statusLabel, BorderLayout.NORTH);

            scoreLabel = new JLabel("흰색(당신): 2  검정색(AI): 2");
            scoreLabel.setFont(new Font("Arial", Font.BOLD, 14));
            scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
            scoreLabel.setPreferredSize(new Dimension(700, 25));
            scoreLabel.setForeground(Color.WHITE);
            mainPanel.add(scoreLabel, BorderLayout.NORTH);

            JPanel boardPanel = new JPanel();
            boardPanel.setLayout(new GridLayout(ReversiGame.BOARD_SIZE, ReversiGame.BOARD_SIZE, 2, 2));
            boardPanel.setBackground(new Color(200, 150, 80));
            boardPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

            actionListener = new CommonActionListener();

            for (int i = 0; i < ReversiGame.BOARD_SIZE; i++) {
                for (int j = 0; j < ReversiGame.BOARD_SIZE; j++) {
                    buttons[i][j] = new BoardButton();
                    buttons[i][j].addActionListener(actionListener);
                    boardPanel.add(buttons[i][j]);
                }
            }

            mainPanel.add(boardPanel, BorderLayout.CENTER);

            JPanel buttonPanel = new JPanel();
            resetButton = new JButton("새 게임");
            resetButton.setFont(new Font("Arial", Font.BOLD, 14));
            resetButton.setPreferredSize(new Dimension(150, 40));
            resetButton.addActionListener(actionListener);

            buttonPanel.add(resetButton);
            mainPanel.add(buttonPanel, BorderLayout.SOUTH);

            add(mainPanel);
            updateBoard();
            setVisible(true);
            
            Timer timer = new Timer(1500, e -> makeAIMove());
            timer.setRepeats(false);
            timer.start();
        }

        private BufferedImage createStoneImage(Color stoneColor, int size, boolean faded) {
            BufferedImage image = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = image.createGraphics();
            
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            
            g2d.setComposite(AlphaComposite.Clear);
            g2d.fillRect(0, 0, size, size);
            g2d.setComposite(AlphaComposite.SrcOver);
            
            if (faded) {
                g2d.setColor(new Color(stoneColor.getRed(), stoneColor.getGreen(), stoneColor.getBlue(), 100));
            } else {
                g2d.setColor(stoneColor);
            }
            
            g2d.fillOval(0, 0, size - 1, size - 1);
            
            g2d.setColor(Color.BLACK);
            g2d.setStroke(new BasicStroke(2.0f));
            g2d.drawOval(0, 0, size - 1, size - 1);
            
            g2d.dispose();
            return image;
        }

        private void updateBoard() {
            char[][] board = game.getBoard();
            for (int i = 0; i < ReversiGame.BOARD_SIZE; i++) {
                for (int j = 0; j < ReversiGame.BOARD_SIZE; j++) {
                    char cell = board[i][j];
                    if (cell == ReversiGame.WHITE) {
                        buttons[i][j].setIcon(whiteStoneIcon);
                    } else if (cell == ReversiGame.BLACK) {
                        buttons[i][j].setIcon(blackStoneIcon);
                    } else {
                        buttons[i][j].setIcon(null);
                    }
                }
            }
            
            scoreLabel.setText(String.format("흰색(당신): %d  검정색(AI): %d", 
                    game.getWhiteCount(), game.getBlackCount()));
        }

        private void onBoardButtonClick(int row, int col) {
            if (game.isGameOver() || !isHumanTurn) {
                return;
            }

            if (game.makeMove(row, col)) {
                updateBoard();

                if (game.isGameOver()) {
                    statusLabel.setText(game.getResult());
                    showGameOverDialog();
                } else {
                    isHumanTurn = false;
                    statusLabel.setText("AI가 생각 중입니다...");
                    
                    Timer timer = new Timer(1000, e -> makeAIMove());
                    timer.setRepeats(false);
                    timer.start();
                }
            } else {
                JOptionPane.showMessageDialog(this, "유효하지 않은 이동입니다!");
            }
        }

        private void makeAIMove() {
            if (game.isGameOver()) {
                return;
            }

            if (!game.hasValidMove()) {
                statusLabel.setText("AI가 이동할 수 없습니다. (패스)");
                game.setCurrentPlayer(ReversiGame.WHITE);
                if (game.hasValidMove()) {
                    isHumanTurn = true;
                    statusLabel.setText("당신의 차례입니다. (흰색)");
                } else {
                    game.setGameOver(true);
                    statusLabel.setText(game.getResult());
                    showGameOverDialog();
                }
                return;
            }

            int bestRow = -1, bestCol = -1;
            int priority = -1;

            for (int i = 0; i < ReversiGame.BOARD_SIZE; i++) {
                for (int j = 0; j < ReversiGame.BOARD_SIZE; j++) {
                    if (game.getBoard()[i][j] == ReversiGame.EMPTY) {
                        char[][] tempBoard = game.getBoard();
                        if (isValidAIMove(i, j, tempBoard)) {
                            int currentPriority = calculatePriority(i, j);
                            if (currentPriority > priority) {
                                priority = currentPriority;
                                bestRow = i;
                                bestCol = j;
                            }
                        }
                    }
                }
            }

            if (bestRow != -1 && bestCol != -1) {
                if (game.makeMove(bestRow, bestCol)) {
                    updateBoard();

                    if (game.isGameOver()) {
                        statusLabel.setText(game.getResult());
                        showGameOverDialog();
                    } else {
                        if (game.hasValidMove()) {
                            isHumanTurn = true;
                            statusLabel.setText("당신의 차례입니다. (흰색)");
                        } else {
                            statusLabel.setText("이동할 수 없습니다. (패스) AI의 차례입니다.");
                            Timer timer = new Timer(1000, e -> makeAIMove());
                            timer.setRepeats(false);
                            timer.start();
                        }
                    }
                }
            }
        }

        private boolean isValidAIMove(int row, int col, char[][] board) {
            if (board[row][col] != ReversiGame.EMPTY) {
                return false;
            }
            
            int[][] directions = {
                {-1, -1}, {-1, 0}, {-1, 1},
                {0, -1},           {0, 1},
                {1, -1},  {1, 0},  {1, 1}
            };
            
            for (int[] dir : directions) {
                if (canFlipInDirection(row, col, dir[0], dir[1], board)) {
                    return true;
                }
            }
            
            return false;
        }

        private boolean canFlipInDirection(int row, int col, int dRow, int dCol, char[][] board) {
            int r = row + dRow;
            int c = col + dCol;
            boolean hasOpponent = false;
            
            while (r >= 0 && r < ReversiGame.BOARD_SIZE && c >= 0 && c < ReversiGame.BOARD_SIZE) {
                char cell = board[r][c];
                
                if (cell == ReversiGame.EMPTY) {
                    return false;
                }
                
                if (cell == ReversiGame.BLACK) {
                    return hasOpponent;
                }
                
                hasOpponent = true;
                r += dRow;
                c += dCol;
            }
            
            return false;
        }

        private int calculatePriority(int row, int col) {
            if ((row == 0 || row == 7) && (col == 0 || col == 7)) {
                return 3;
            }
            if (row == 0 || row == 7 || col == 0 || col == 7) {
                return 2;
            }
            return 1;
        }

        private void showGameOverDialog() {
            SwingUtilities.invokeLater(() -> {
                int option = JOptionPane.showOptionDialog(
                        this,
                        game.getResult() + "\n\n다시 게임하시겠습니까?",
                        "게임 종료",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        new Object[] { "새 게임", "종료" },
                        "새 게임");

                if (option == JOptionPane.YES_OPTION) {
                    resetGame();
                }
            });
        }

        private void resetGame() {
            game.initializeGame();
            isHumanTurn = false;
            updateBoard();
            statusLabel.setText("AI(검정색)의 차례입니다.");
            
            Timer timer = new Timer(1500, e -> makeAIMove());
            timer.setRepeats(false);
            timer.start();
        }

        private class CommonActionListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object source = e.getSource();

                if (source == resetButton) {
                    resetGame();
                    return;
                }

                for (int i = 0; i < ReversiGame.BOARD_SIZE; i++) {
                    for (int j = 0; j < ReversiGame.BOARD_SIZE; j++) {
                        if (source == buttons[i][j]) {
                            onBoardButtonClick(i, j);
                            return;
                        }
                    }
                }
            }
        }

        private class BoardButton extends JButton {
            public BoardButton() {
                setBackground(new Color(200, 150, 80));
                setOpaque(true);
                setFocusPainted(false);
                setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                
                addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        if (isEnabled()) {
                            setBackground(new Color(220, 170, 100));
                        }
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        setBackground(new Color(200, 150, 80));
                    }
                });
            }
        }
    }

    /**
     * 메인 메서드
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ReversiGUI());
    }
}
