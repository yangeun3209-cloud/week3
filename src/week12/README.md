# Java Swing 학습 정리

## 학습 일자
- 1차시 ~ 2026-05-20

---

# 1차시 학습 내용

## Java Swing GUI 기본 개념 학습
Java에서 GUI(Graphical User Interface)를 구현하기 위해 Swing 라이브러리를 학습하였다.

### 주요 컴포넌트
- JFrame : GUI 창 생성
- JLabel : 텍스트 출력
- JButton : 버튼 생성
- JTextField : 한 줄 텍스트 입력
- JPasswordField : 비밀번호 입력
- JPanel : 컴포넌트 그룹화

### 기본 창 생성 구조
```java
JFrame frame = new JFrame();
frame.setSize(300, 200);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setVisible(true);