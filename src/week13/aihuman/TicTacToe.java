import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;

/**
 * AI vs Human 틱택토(Tic-Tac-Toe) GUI 게임
 * - 인당 최대 3개의 돌(블럭)만 유지됩니다. (3목 이동 틱택토 규칙)
 * - 4번째 돌을 둘 때는 가장 오래전에 두었던 자신의 돌이 자동으로 회수되어 다른 자리에 배치됩니다.
 * - AI는 Minimax 알고리즘(Alpha-Beta Pruning)을 활용해 가장 최적의 수를 찾아냅니다.
 * - 턴별로 마우스 커서가 다이내믹하게 변경(사람 차례일 때는 O 모양 커서)됩니다.
 */
public class TicTacToe extends JFrame {

    // 현대적인 플랫 테마 색상 팔레트 정의
    private static final Color COLOR_BG = new Color(240, 244, 248); // 전체 연한 배경색
    private static final Color COLOR_HEADER_BG = new Color(44, 62, 80); // 헤더 어두운 블루그레이
    private static final Color COLOR_GRID = new Color(200, 214, 229); // 격자 테두리 색상
    private static final Color COLOR_CELL_BG = Color.WHITE; // 격자 셀 기본 색상
    private static final Color COLOR_CELL_HOVER = new Color(235, 243, 250); // 셀 호버 배경색

    private static final Color COLOR_O = new Color(41, 128, 185); // 플레이어 O (사람 - 신뢰감 있는 파란색)
    private static final Color COLOR_O_FADED = new Color(41, 128, 185, 100); // 다음에 사라질 O 돌 (반투명)

    private static final Color COLOR_X = new Color(231, 76, 60); // 플레이어 X (AI - 활기찬 산호색/빨간색)
    private static final Color COLOR_X_FADED = new Color(231, 76, 60, 100); // 다음에 사라질 X 돌 (반투명)

    private static final Color COLOR_WIN_BG = new Color(46, 204, 113); // 승리 라인 배경색 (초록색)
    private static final Color COLOR_WIN_FG = Color.WHITE; // 승리 라인 텍스트색
    private static final Color COLOR_DRAW_BG = new Color(149, 165, 166); // 무승부 배경색 (회색)
    private static final Color COLOR_DRAW_FG = Color.WHITE;

    // 미니맥스 깊이 제한 (3목 이동 규칙 특성상 적당한 깊이로 설정)
    private static final int MAX_DEPTH = 6;
    private static final char HUMAN_SYMBOL = 'O';
    private static final char AI_SYMBOL = 'X';

    // 게임 상태 변수
    private char[][] board = new char[3][3];
    private boolean isOTurn = true; // true 이면 사람(O) 차례, false 이면 AI(X) 차례
    private int oScore = 0; // 사람 스코어
    private int xScore = 0; // AI 스코어
    private int drawCount = 0;
    private boolean gameOver = false;

    // 각 플레이어가 놓은 돌의 위치를 관리하는 큐 (최대 3개 유지)
    private Queue<int[]> oStones = new LinkedList<>();
    private Queue<int[]> xStones = new LinkedList<>();

    // 커스텀 커서 변수 (사람 차례용 O 커서)
    private Cursor cursorO;
    private Cursor cursorX;
    
    // 돌 이미지 아이콘 (흰 공과 검정 공)
    private ImageIcon whiteStoneIcon;
    private ImageIcon blackStoneIcon;
    private ImageIcon whiteStoneFadedIcon;
    private ImageIcon blackStoneFadedIcon;

    // GUI 컴포넌트
    private BoardButton[][] buttons = new BoardButton[3][3];
    private JLabel statusLabel; // 현재 차례 또는 상태 표시
    private JLabel scoreLabel; // 스코어 보드 표시
    private JButton restartBtn; // 다시 시작 버튼
    private JButton resetScoreBtn; // 스코어 초기화 버튼
    private final CommonButtonListener commonButtonListener = new CommonButtonListener();

    public TicTacToe() {
        setTitle("Tic-Tac-Toe (vs AI)");
        setSize(420, 580);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // 화면 정중앙에 배치
        setResizable(false);

        // 턴별 커스텀 커서 생성
        cursorO = createCustomCursor(HUMAN_SYMBOL, COLOR_O);
        cursorX = createCustomCursor(AI_SYMBOL, COLOR_X);
        
        // 돌 이미지 생성 (흰 공과 검정 공)
        whiteStoneIcon = new ImageIcon(createStoneImage(Color.WHITE, 60, false));
        blackStoneIcon = new ImageIcon(createStoneImage(Color.BLACK, 60, false));
        whiteStoneFadedIcon = new ImageIcon(createStoneImage(Color.WHITE, 60, true));
        blackStoneFadedIcon = new ImageIcon(createStoneImage(Color.BLACK, 60, true));

        // 메인 프레임 설정
        JPanel mainPanel = new JPanel(new BorderLayout(0, 15));
        mainPanel.setBackground(COLOR_BG);
        mainPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
        setContentPane(mainPanel);

        // 1. 헤더 영역 (스코어 및 상태 정보)
        JPanel headerPanel = new JPanel(new GridLayout(2, 1, 0, 5));
        headerPanel.setBackground(COLOR_HEADER_BG);
        headerPanel.setBorder(new EmptyBorder(12, 15, 12, 15));

        scoreLabel = new JLabel("사람(O): 0  |  무승부: 0  |  AI(X): 0", SwingConstants.CENTER);
        scoreLabel.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        scoreLabel.setForeground(new Color(236, 240, 241));

        statusLabel = new JLabel("당신의 차례입니다 (O)", SwingConstants.CENTER);
        statusLabel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
        statusLabel.setForeground(COLOR_O);

        headerPanel.add(scoreLabel);
        headerPanel.add(statusLabel);
        mainPanel.add(headerPanel, BorderLayout.NORTH);

        // 2. 게임 판 (3x3 격자 구조)
        JPanel boardPanel = new JPanel(new GridLayout(3, 3, 6, 6));
        boardPanel.setBackground(COLOR_GRID);
        boardPanel.setBorder(BorderFactory.createLineBorder(COLOR_GRID, 3));

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                buttons[r][c] = new BoardButton();
                boardPanel.add(buttons[r][c]);
            }
        }
        mainPanel.add(boardPanel, BorderLayout.CENTER);

        // 3. 하단 컨트롤러 영역 (다시 시작 & 스코어 리셋)
        JPanel controlPanel = new JPanel(new GridLayout(1, 2, 10, 0));
        controlPanel.setBackground(COLOR_BG);

        restartBtn = new JButton("다시 시작 🔄");
        styleControlBtn(restartBtn, new Color(52, 152, 219));
        restartBtn.addActionListener(commonButtonListener);

        resetScoreBtn = new JButton("스코어 초기화 🧹");
        styleControlBtn(resetScoreBtn, new Color(127, 140, 141));
        resetScoreBtn.addActionListener(commonButtonListener);

        controlPanel.add(restartBtn);
        controlPanel.add(resetScoreBtn);
        mainPanel.add(controlPanel, BorderLayout.SOUTH);

        // 초기화
        resetGame(true);

        setVisible(true);
        
        // 게임 시작: 사람 먼저 vs AI 먼저 선택
        showFirstPlayerDialog();
    }

    /**
     * 문양별 커스텀 투명 커서 생성 메서드
     */
    private Cursor createCustomCursor(char symbol, Color color) {
        int size = 32;
        BufferedImage image = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = image.createGraphics();

        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        g.setColor(new Color(0, 0, 0, 0));
        g.fillRect(0, 0, size, size);

        g.setColor(color);
        g.setFont(new Font("Arial", Font.BOLD, 22));
        FontMetrics fm = g.getFontMetrics();
        int x = (size - fm.charWidth(symbol)) / 2;
        int y = (size - fm.getHeight()) / 2 + fm.getAscent();

        g.drawString(String.valueOf(symbol), x, y);
        g.dispose();

        return Toolkit.getDefaultToolkit().createCustomCursor(image, new Point(size / 2, size / 2), "Cursor_" + symbol);
    }

    /**
     * 보드판 배열 데이터 비우기
     */
    private void clearBoardData() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                board[r][c] = '\0';
            }
        }
        oStones.clear();
        xStones.clear();
    }

    /**
     * 돌 이미지 생성 (흰 공 또는 검정 공)
     */
    private BufferedImage createStoneImage(Color stoneColor, int size, boolean faded) {
        BufferedImage image = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();
        
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // 배경 투명하게
        g2d.setComposite(AlphaComposite.Clear);
        g2d.fillRect(0, 0, size, size);
        g2d.setComposite(AlphaComposite.SrcOver);
        
        // 돌 색상 (반투명 처리)
        if (faded) {
            g2d.setColor(new Color(stoneColor.getRed(), stoneColor.getGreen(), stoneColor.getBlue(), 100));
        } else {
            g2d.setColor(stoneColor);
        }
        
        // 원형 돌 그리기
        g2d.fillOval(2, 2, size - 4, size - 4);
        
        // 테두리 (검정색)
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(2.0f));
        g2d.drawOval(2, 2, size - 4, size - 4);
        
        // 그림자 효과
        g2d.setColor(new Color(0, 0, 0, 50));
        g2d.fillOval(4, size - 6, size - 8, 4);
        
        g2d.dispose();
        return image;
    }

    /**
     * 게임 시작 시 사람이 먼저 할 것인지, AI가 먼저 할 것인지 선택하는 대화상자
     */
    private void showFirstPlayerDialog() {
        SwingUtilities.invokeLater(() -> {
            String[] options = { "내가 먼저 (O)", "AI가 먼저 (X)" };
            int choice = JOptionPane.showOptionDialog(
                    this,
                    "게임을 시작합니다!\n누가 먼저 시작하시겠습니까?",
                    "게임 시작 선택",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);

            if (choice == JOptionPane.YES_OPTION || choice == -1) {
                // 사람이 먼저 (기본값)
                isOTurn = true;
                statusLabel.setText("당신의 차례입니다 (O)");
                statusLabel.setForeground(COLOR_O);
            } else {
                // AI가 먼저
                isOTurn = false;
                statusLabel.setText("AI가 최적의 수를 생각하고 있습니다... 🤖");
                statusLabel.setForeground(COLOR_X);
                
                // AI가 먼저 두도록 함
                Timer aiTimer = new Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int[] bestMove = findBestMove();
                        if (bestMove[0] != -1 && bestMove[1] != -1) {
                            makeMove(bestMove[0], bestMove[1]);
                        }
                    }
                });
                aiTimer.setRepeats(false);
                aiTimer.start();
            }
            updateCursors();
            updateStoneVisuals();
        });
    }

    /**
     * 게임 재시작 시에도 선택 대화상자 표시
     */
    private void resetGame(boolean resetScores) {
        clearBoardData();
        gameOver = false;

        if (resetScores) {
            oScore = 0;
            xScore = 0;
            drawCount = 0;
            updateScoreBoard();
        }

        // 격자 단추 상태 리셋
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                buttons[r][c].setText("");
                buttons[r][c].setIcon(null);
                buttons[r][c].setEnabled(true);
                buttons[r][c].setBackground(COLOR_CELL_BG);
                buttons[r][c].setForeground(Color.DARK_GRAY);
            }
        }

        updateCursors();
        updateStoneVisuals();
        
        // 재시작 시에도 누가 먼저 할 것인지 선택
        showFirstPlayerDialog();
    }

    /**
     * 스코어 라벨을 갱신
     */
    private void updateScoreBoard() {
        scoreLabel.setText(String.format("사람(O): %d  |  무승부: %d  |  AI(X): %d", oScore, drawCount, xScore));
    }

    /**
     * 턴 상태에 따라 마우스 커서를 변경
     */
    private void updateCursors() {
        if (gameOver) {
            for (int r = 0; r < 3; r++) {
                for (int c = 0; c < 3; c++) {
                    buttons[r][c].setCursor(Cursor.getDefaultCursor());
                }
            }
            return;
        }

        Cursor activeCursor = isOTurn ? cursorO : cursorX;
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (buttons[r][c].isEnabled() && board[r][c] == '\0') {
                    // 사람 차례이고 클릭 가능할 때만 O 모양 커서 적용
                    buttons[r][c].setCursor(isOTurn ? activeCursor : Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                } else {
                    buttons[r][c].setCursor(Cursor.getDefaultCursor());
                }
            }
        }
    }

    /**
     * 화면 상의 돌들의 투명도(색상) 비주얼 갱신
     */
    private void updateStoneVisuals() {
        // 모든 돌의 아이콘을 기본 선명한 상태로 복구
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (board[r][c] == HUMAN_SYMBOL) {
                    buttons[r][c].setIcon(whiteStoneIcon);
                } else if (board[r][c] == AI_SYMBOL) {
                    buttons[r][c].setIcon(blackStoneIcon);
                } else {
                    buttons[r][c].setIcon(null);
                }
            }
        }

        // 다음에 사라질 가장 첫 돌을 반투명(Faded) 처리
        if (isOTurn && oStones.size() == 3) {
            int[] oldest = oStones.peek();
            buttons[oldest[0]][oldest[1]].setIcon(whiteStoneFadedIcon);
        } else if (!isOTurn && xStones.size() == 3) {
            int[] oldest = xStones.peek();
            buttons[oldest[0]][oldest[1]].setIcon(blackStoneFadedIcon);
        }
    }

    /**
     * 특정 상태에서 한 명의 플레이어가 승리했는지 판단
     */
    private boolean checkWinForBoard(char[][] b, char symbol) {
        for (int r = 0; r < 3; r++) {
            if (b[r][0] == symbol && b[r][1] == symbol && b[r][2] == symbol)
                return true;
        }
        for (int c = 0; c < 3; c++) {
            if (b[0][c] == symbol && b[1][c] == symbol && b[2][c] == symbol)
                return true;
        }
        if (b[0][0] == symbol && b[1][1] == symbol && b[2][2] == symbol)
            return true;
        if (b[0][2] == symbol && b[1][1] == symbol && b[2][0] == symbol)
            return true;
        return false;
    }

    /**
     * 승리 여부 판단 (UI 용)
     *
     * @return 승리한 세 칸의 좌표 배열 (없으면 null)
     */
    private int[][] checkWin() {
        // 행 검사
        for (int r = 0; r < 3; r++) {
            if (board[r][0] != '\0' && board[r][0] == board[r][1] && board[r][1] == board[r][2]) {
                return new int[][] { { r, 0 }, { r, 1 }, { r, 2 } };
            }
        }
        // 열 검사
        for (int c = 0; c < 3; c++) {
            if (board[0][c] != '\0' && board[0][c] == board[1][c] && board[1][c] == board[2][c]) {
                return new int[][] { { 0, c }, { 1, c }, { 2, c } };
            }
        }
        // 대각선 검사
        if (board[0][0] != '\0' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return new int[][] { { 0, 0 }, { 1, 1 }, { 2, 2 } };
        }
        if (board[0][2] != '\0' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return new int[][] { { 0, 2 }, { 1, 1 }, { 2, 0 } };
        }
        return null;
    }

    /**
     * 무승부 검사
     */
    private boolean checkDraw() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (board[r][c] == '\0') {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 사람 플레이어의 입력 클릭 제어
     */
    private void handleCellClick(int r, int c) {
        // 게임이 종료되었거나, 이미 돌이 있거나, AI의 턴인 경우 클릭 거부
        if (gameOver || board[r][c] != '\0' || !isOTurn) {
            return;
        }
        makeMove(r, c);
    }

    /**
     * 실제 돌 놓기 처리 및 게임 규칙 적용 (인당 3개 제한)
     */
    private void makeMove(int r, int c) {
        Queue<int[]> activeQueue = isOTurn ? oStones : xStones;

        // 돌은 인당 3개만 허용. 이미 3개가 격자판에 존재하는 경우 가장 처음에 두었던 돌을 회수
        if (activeQueue.size() == 3) {
            int[] oldest = activeQueue.poll();
            int oldR = oldest[0];
            int oldC = oldest[1];

            // 보드 데이터에서 제거
            board[oldR][oldC] = '\0';

            // 이전 칸 복구
            BoardButton oldBtn = buttons[oldR][oldC];
            oldBtn.setText("");
            oldBtn.setIcon(null);
            oldBtn.setEnabled(true);
            oldBtn.setBackground(COLOR_CELL_BG);
            oldBtn.setForeground(Color.DARK_GRAY);
        }

        // 신규 돌 배치
        char currentSymbol = isOTurn ? HUMAN_SYMBOL : AI_SYMBOL;
        board[r][c] = currentSymbol;
        activeQueue.offer(new int[] { r, c });

        BoardButton btn = buttons[r][c];
        btn.setText("");
        if (isOTurn) {
            btn.setIcon(whiteStoneIcon);
        } else {
            btn.setIcon(blackStoneIcon);
        }
        btn.setEnabled(false);

        // 승리 검사
        int[][] winningCells = checkWin();
        if (winningCells != null) {
            gameOver = true;
            highlightWinningCells(winningCells);

            if (isOTurn) {
                oScore++;
                statusLabel.setText("축하합니다! 당신의 승리입니다! 🎉");
                statusLabel.setForeground(COLOR_O);
            } else {
                xScore++;
                statusLabel.setText("AI가 승리했습니다! 🤖");
                statusLabel.setForeground(COLOR_X);
            }
            updateScoreBoard();
            updateCursors();
            showResultDialog(isOTurn ? "당신의 승리!" : "AI의 승리!");
            return;
        }

        // 무승부 검사
        if (checkDraw()) {
            gameOver = true;
            highlightDrawCells();
            drawCount++;
            statusLabel.setText("아쉽네요! 무승부입니다 🤝");
            statusLabel.setForeground(Color.DARK_GRAY);
            updateScoreBoard();
            updateCursors();
            showResultDialog("무승부!");
            return;
        }

        // 턴 전환
        isOTurn = !isOTurn;

        updateCursors();
        updateStoneVisuals();

        // AI의 턴인 경우
        if (!isOTurn && !gameOver) {
            statusLabel.setText("AI가 최적의 수를 생각하고 있습니다... 🤖");
            statusLabel.setForeground(COLOR_X);

            // 사람 입력 방지를 위해 커서 대기 형태로 전환
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    if (buttons[row][col].isEnabled()) {
                        buttons[row][col].setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                    }
                }
            }

            // 500ms 지연 연출 후 AI 최적의 수 실행
            Timer aiTimer = new Timer(500, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int[] bestMove = findBestMove();
                    if (bestMove[0] != -1 && bestMove[1] != -1) {
                        makeMove(bestMove[0], bestMove[1]);
                    }
                }
            });
            aiTimer.setRepeats(false);
            aiTimer.start();
        } else {
            statusLabel.setText("당신의 차례입니다 (O)");
            statusLabel.setForeground(COLOR_O);
        }
    }

    /**
     * AI의 Minimax 의사결정 메서드 (Alpha-Beta Pruning 기반)
     */
    private int[] findBestMove() {
        int bestScore = Integer.MIN_VALUE;
        int[] bestMove = new int[] { -1, -1 };

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (board[r][c] == '\0') {
                    char[][] tempBoard = cloneBoard(board);
                    Queue<int[]> tempOStones = cloneQueue(oStones);
                    Queue<int[]> tempXStones = cloneQueue(xStones);

                    // AI의 3목 이동 규칙 모사
                    if (tempXStones.size() == 3) {
                        int[] oldest = tempXStones.poll();
                        tempBoard[oldest[0]][oldest[1]] = '\0';
                    }

                    tempBoard[r][c] = AI_SYMBOL;
                    tempXStones.offer(new int[] { r, c });

                    // 바로 승리할 수 있다면 미니맥스 연산 생략하고 즉시 선택
                    if (checkWinForBoard(tempBoard, AI_SYMBOL)) {
                        return new int[] { r, c };
                    }

                    int score = minimax(tempBoard, tempOStones, tempXStones, false, 0, Integer.MIN_VALUE,
                            Integer.MAX_VALUE);

                    if (score > bestScore) {
                        bestScore = score;
                        bestMove = new int[] { r, c };
                    }
                }
            }
        }
        return bestMove;
    }

    /**
     * Minimax 알고리즘 코어
     */
    private int minimax(char[][] curBoard, Queue<int[]> curOStones, Queue<int[]> curXStones, boolean isMax, int depth,
                        int alpha, int beta) {
        if (checkWinForBoard(curBoard, AI_SYMBOL)) {
            return 10 - depth;
        }
        if (checkWinForBoard(curBoard, HUMAN_SYMBOL)) {
            return depth - 10;
        }
        if (depth >= MAX_DEPTH) {
            return 0; // 한계 깊이에 도달 시 뉴트럴 값 반환
        }

        if (isMax) {
            int maxEval = Integer.MIN_VALUE;
            for (int r = 0; r < 3; r++) {
                for (int c = 0; c < 3; c++) {
                    if (curBoard[r][c] == '\0') {
                        char[][] nextBoard = cloneBoard(curBoard);
                        Queue<int[]> nextOStones = cloneQueue(curOStones);
                        Queue<int[]> nextXStones = cloneQueue(curXStones);

                        // AI의 3목 이동 규칙 모사
                        if (nextXStones.size() == 3) {
                            int[] oldest = nextXStones.poll();
                            nextBoard[oldest[0]][oldest[1]] = '\0';
                        }

                        nextBoard[r][c] = AI_SYMBOL;
                        nextXStones.offer(new int[] { r, c });

                        int eval = minimax(nextBoard, nextOStones, nextXStones, false, depth + 1, alpha, beta);
                        maxEval = Math.max(maxEval, eval);
                        alpha = Math.max(alpha, eval);
                        if (beta <= alpha) {
                            break;
                        }
                    }
                }
            }
            return maxEval;
        } else {
            int minEval = Integer.MAX_VALUE;
            for (int r = 0; r < 3; r++) {
                for (int c = 0; c < 3; c++) {
                    if (curBoard[r][c] == '\0') {
                        char[][] nextBoard = cloneBoard(curBoard);
                        Queue<int[]> nextOStones = cloneQueue(curOStones);
                        Queue<int[]> nextXStones = cloneQueue(curXStones);

                        // AI의 3목 이동 규칙 모사
                        if (nextOStones.size() == 3) {
                            int[] oldest = nextOStones.poll();
                            nextBoard[oldest[0]][oldest[1]] = '\0';
                        }

                        nextBoard[r][c] = HUMAN_SYMBOL;
                        nextOStones.offer(new int[] { r, c });

                        int eval = minimax(nextBoard, nextOStones, nextXStones, true, depth + 1, alpha, beta);
                        minEval = Math.min(minEval, eval);
                        beta = Math.min(beta, eval);
                        if (beta <= alpha) {
                            break;
                        }
                    }
                }
            }
            return minEval;
        }
    }

    private char[][] cloneBoard(char[][] src) {
        char[][] dest = new char[3][3];
        for (int i = 0; i < 3; i++) {
            System.arraycopy(src[i], 0, dest[i], 0, 3);
        }
        return dest;
    }

    private Queue<int[]> cloneQueue(Queue<int[]> src) {
        return new LinkedList<>(src);
    }

    /**
     * 승리한 격자 하이라이트 효과 적용
     */
    private void highlightWinningCells(int[][] cells) {
        for (int[] cell : cells) {
            BoardButton btn = buttons[cell[0]][cell[1]];
            btn.setBackground(COLOR_WIN_BG);
            btn.setOpaque(true);
        }
    }

    /**
     * 무승부 시 격자 전체 하이라이트 효과 적용
     */
    private void highlightDrawCells() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                BoardButton btn = buttons[r][c];
                btn.setBackground(COLOR_DRAW_BG);
                btn.setOpaque(true);
            }
        }
    }

    /**
     * 게임 결과 알림 팝업 창
     */
    private void showResultDialog(String resultMessage) {
        SwingUtilities.invokeLater(() -> {
            String title = "게임 종료";
            String detailMessage = String.format(
                    "<html><body style='width: 220px; font-family: \"맑은 고딕\", sans-serif;'>" +
                            "<h3 style='color: #2c3e50; margin-bottom: 8px;'>🏆 %s</h3>" +
                            "<p style='color: #555; margin-bottom: 12px;'>한 번 더 대결하시겠습니까?</p>" +
                            "</body></html>",
                    resultMessage);

            int option = JOptionPane.showOptionDialog(
                    this,
                    detailMessage,
                    title,
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    new Object[] { "다시 시작", "그만하기" },
                    "다시 시작");

            if (option == JOptionPane.YES_OPTION) {
                resetGame(false);
            }
        });
    }

    /**
     * 컨트롤 버튼들의 스타일 처리
     */
    private void styleControlBtn(JButton btn, Color baseColor) {
        btn.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        btn.setBackground(baseColor);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setOpaque(true);
        btn.setBorderPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btn.setBackground(baseColor.brighter());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btn.setBackground(baseColor);
            }
        });
    }

    /**
     * 모든 버튼의 클릭 이벤트를 공통으로 처리하는 내부 클래스 ActionListener
     */
    private class CommonButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();
            if (source == restartBtn) {
                resetGame(false);
            } else if (source == resetScoreBtn) {
                int confirm = JOptionPane.showConfirmDialog(
                        TicTacToe.this,
                        "정말로 스코어를 초기화하시겠습니까?",
                        "스코어 초기화 확인",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if (confirm == JOptionPane.YES_OPTION) {
                    resetGame(true);
                }
            } else if (source instanceof BoardButton) {
                for (int r = 0; r < 3; r++) {
                    for (int c = 0; c < 3; c++) {
                        if (buttons[r][c] == source) {
                            handleCellClick(r, c);
                            return;
                        }
                    }
                }
            }
        }
    }

    /**
     * 3x3 격자의 개별 셀 커스텀 버튼 클래스
     */
    private class BoardButton extends JButton {

        public BoardButton() {
            setFont(new Font("Arial", Font.BOLD, 48));
            setBackground(COLOR_CELL_BG);
            setForeground(Color.DARK_GRAY);
            setFocusPainted(false);
            setOpaque(true);
            setBorderPainted(true);
            setBorder(BorderFactory.createLineBorder(COLOR_GRID, 1));

            addActionListener(commonButtonListener);

            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    if (isEnabled() && getText().isEmpty() && isOTurn) {
                        setBackground(COLOR_CELL_HOVER);
                    }
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    if (isEnabled() && getText().isEmpty()) {
                        setBackground(COLOR_CELL_BG);
                    }
                }
            });
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TicTacToe());
    }
}