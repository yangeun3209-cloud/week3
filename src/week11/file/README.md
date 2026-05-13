# Week11 학습 정리

작성일: 2026-05-13

## 1차시 학습 내용 요약

### 객체지향 설계와 클래스 다이어그램 이해

이번 1차시에서는 객체지향 설계의 기본 개념과 클래스 다이어그램을 활용한 프로그램 구조 설계 방법을 학습하였다.

#### 학습 내용

- 클래스(Class)의 구조 이해
    - 클래스명
    - 속성(Attribute)
    - 메소드(Method)

- 클래스 간 관계 학습
    - 상속(Inheritance)
    - 연관 관계(Association)
    - 의존 관계(Dependency)

- UML 클래스 다이어그램 해석 방법
    - 클래스 이름 확인
    - 접근 제어자 확인
    - 메소드 및 속성 표현 방식 이해
    - 클래스 간 연결 관계 해석

- 객체지향 프로그래밍 개념 복습
    - 캡슐화(Encapsulation)
    - 상속(Inheritance)
    - 다형성(Polymorphism)
    - 추상화(Abstraction)

### 실습 내용

- 클래스 다이어그램을 기반으로 프로그램 구조 설계
- Java Swing 기반 GUI 프로그램 설계 준비
- 도형 그리기 프로그램 구현을 위한 클래스 구성 이해

### 느낀 점

클래스 다이어그램을 통해 프로그램 구조를 미리 설계하면 코드 작성이 훨씬 체계적이고 이해하기 쉬워진다는 점을 확인할 수 있었다. 객체 간 관계를 시각적으로 표현하여 프로그램 전체 구조를 파악하는 데 도움이 되었다.
## 2차시 학습 내용 요약

### Java Swing 레이아웃 매니저 및 대화상자 실습

이번 2차시에서는 Java Swing GUI 프로그래밍에서 자주 사용되는 레이아웃 매니저와 대화상자(Dialog) 활용 방법을 학습하였다.

#### 학습 내용

##### JFrame과 JDialog 활용
- JFrame을 이용한 기본 GUI 창 구성
- 창 제목, 크기, 위치 설정
- JLabel, JButton 컴포넌트 배치
- 버튼 클릭 이벤트 처리
- JDialog를 이용한 독립적인 대화상자 생성
- dispose()를 이용한 대화상자 종료 처리

##### Modal / Modeless Dialog 차이점 이해
- Modal Dialog
  - 대화상자가 열려 있는 동안 부모 창 조작 불가
  - 사용자 입력을 강제로 대화상자에 집중시킴

- Modeless Dialog
  - 대화상자가 열려 있어도 부모 창 조작 가능
  - 여러 창을 동시에 사용할 수 있음

##### FlowLayout 실습
- FlowLayout의 기본 동작 방식 이해
- 정렬 옵션 비교
  - LEFT
  - CENTER
  - RIGHT
- hgap / vgap 간격 조절
- JPanel과 FlowLayout 조합 사용

#### 실습 프로그램
- BasicFrameExample.java
- DialogExample.java
- ModalModelessDialogExample.java
- FlowLayoutExample.java

#### 느낀 점
Java Swing에서는 레이아웃 매니저를 적절히 활용하면 GUI 구성 요소를 효율적으로 배치할 수 있다는 점을 확인하였다. 또한 Modal과 Modeless Dialog의 차이를 직접 실습하면서 사용자 인터페이스 설계 시 상황에 맞는 대화상자 선택이 중요하다는 것을 이해하였다.
