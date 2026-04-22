# Week08 - Java 인터페이스 심화
날짜: 2026 04 22
학번: 20220548 
이름: 양은찬 
## 프로젝트 소개

이번 실습에서는 자바 인터페이스의 심화 기능을 학습했습니다.

주요 내용은 다음과 같습니다.

- 인터페이스의 `default` 메서드
- 인터페이스의 `static` 메서드
- 인터페이스의 `private` 메서드
- 인터페이스 다중 구현
- `default` 메서드 충돌과 해결 방법

---

## 학습 내용 1: 인터페이스의 Default, Static, Private 메서드

### 1. Default 메서드

`default` 메서드는 인터페이스 안에서 **구현부를 가질 수 있는 메서드**입니다.

#### 특징
- 인터페이스에 기본 동작을 제공할 수 있음
- 구현 클래스에서 선택적으로 오버라이드 가능
- 기존 구현체를 깨뜨리지 않고 기능 확장 가능

#### 예시
```java
default void executePayment(double amount, String currency, String paymentMethod) {
    validatePaymentInput(amount, currency, paymentMethod);
    String formattedAmount = formatCurrency(amount, currency);
    processPayment(amount, currency);
    logTransaction(formattedAmount, paymentMethod, "SUCCESS");
}