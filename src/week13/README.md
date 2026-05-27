# week13 학습 정리

## 학습 날짜
2026-05-27

---

## 1. package week13.ai__full
### TicTacToe (AI vs Human 틱택토)

- Java Swing을 활용하여 GUI 기반 틱택토 게임을 구현하였다.
- JFrame, JPanel, JButton, JLabel을 사용하여 게임 화면과 상태 표시 UI를 구성하였다.
- Minimax 알고리즘(Alpha-Beta Pruning)을 활용하여 AI가 최적의 수를 선택하도록 구현하였다.
- Queue 자료구조를 사용하여 3목 이동 규칙(최대 3개의 돌 유지)을 적용하였다.
- BufferedImage와 ImageIcon을 활용하여 흰 공/검정 공 이미지를 생성하고 게임 UI를 개선하였다.

---

## 2. package week13.ai__full
### TicTacToeGame (2인용 틱택토)

- Java Swing 기반의 2인용 틱택토 게임을 구현하였다.
- JButton 3x3 배열을 사용하여 게임 보드를 구성하였다.
- 현재 플레이어(X/O)를 번갈아 변경하며 게임 진행 로직을 구현하였다.
- 행, 열, 대각선 조건을 검사하여 승리 여부를 판단하였다.
- 게임 종료 후 JOptionPane을 통해 승패 결과를 출력하고 게임을 초기화하였다.

---

## 3. package week13.reversi2
### Reversi2 (2인용 오셀로)

- Java Swing과 Graphics2D를 활용하여 8x8 오셀로 게임을 구현하였다.
- 2차원 배열을 이용해 게임 보드 상태를 관리하였다.
- 돌을 놓을 수 있는 위치를 검사하고 상대 돌을 뒤집는 게임 규칙을 구현하였다.
- 사용자 클릭(MouseListener)을 통해 게임 입력을 처리하였다.
- 커스텀 Cursor와 BufferedImage를 활용하여 게임 UI를 개선하였다.

---

## 4. package week13.reversi
### Reversi (AI vs Human 오셀로)

- Java Swing 기반의 AI 대전 오셀로 게임을 구현하였다.
- ReversiGame, ReversiGUI 구조로 게임 로직과 UI를 분리하여 설계하였다.
- AI가 우선순위 기반으로 최적의 위치(모서리/가장자리)를 선택하도록 구현하였다.
- ImageIcon을 활용하여 흰색/검정색 돌 이미지를 표시하였다.
- Timer를 사용하여 AI가 생각하는 것처럼 보이는 딜레이 효과를 적용하였다.

---

## 학습 총정리

이번 학습에서는 Java Swing GUI 프로그래밍을 중심으로 게임 프로그램을 구현하였다.  
틱택토와 오셀로 게임을 제작하면서 이벤트 처리(ActionListener, MouseListener), 게임 상태 관리, AI 로직, Graphics2D 기반 이미지 처리, Timer 활용 등을 학습하였다.  
객체지향 구조를 활용하여 게임 로직과 UI를 분리하는 설계 방식도 함께 익혔다.