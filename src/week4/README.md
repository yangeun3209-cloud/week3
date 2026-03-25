//2026-03-25 
// week4 자바프로그래밍 실습
# 학번: 20220548
# 이름: 양은찬 
# Week 4 - Java 연산자와 데이터 타입 심화 학습

## 오늘의 학습 내용

### 1. Java 비트 연산 (Bitwise Operations)
- **연산자**: AND(&), OR(|), XOR(^), NOT(~)
- **예제 파일**: `BitwiseOperationsExample.java`
- **활용**: 플래그 처리, 마스크 연산, 권한 제어 등
- **특징**: 이진수 단위로 연산 수행

### 2. Java 강제형변환 (Force Casting)
- **개념**: 큰 타입에서 작은 타입으로 변환 시 데이터 손실 가능
- **예제 파일**: `ForceCastingExample.java`
- **주의사항**:
    - double → int: 소수점 부분 버려짐
    - int → byte: 범위 초과 시 오버플로우
- **위험성**: 데이터 손실이 발생할 수 있으므로 주의

### 3. Java 증감 연산자와 삼항 연산자
- **증감 연산자**:
    - 전위 증감(++a): 1 증가 후 값 반환
    - 후위 증감(a++): 값 반환 후 1 증가
- **삼항 연산자**: `(조건) ? 참_값 : 거짓_값`
- **예제 파일**: `OperatorsExample.java`
- **활용**: 조건부 값 선택, 간단한 if-else 대체

### 4. Java Scanner 클래스 입력
- **기능**: 사용자 입력 받기
- **메서드**: `nextLine()`, `nextInt()`, `nextDouble()`
- **예제 파일**: `ScannerInputExample.java`
- **사용법**: 이름(String), 나이(int), 키(double) 입력 예제

### 5. Java 시프트 연산 (Shift Operations)
- **연산자**:
    - 왼쪽 시프트(<<): 값 × 2^shift
    - 오른쪽 시프트(>>): 값 ÷ 2^shift, 부호 유지
    - 부호 없는 오른쪽 시프트(>>>): 값 ÷ 2^shift, 부호 무시
- **예제 파일**: `ShiftOperationsExample.java`
- **중요 차이**: 음수에서 >>와 >>>의 처리 방식

### 6. Java 자동 타입 변환 (Widening Casting)
- **순서**: byte → short → int → long → float → double
- **예제 파일**: `WideningCastingExample.java`
- **특징**: 작은 타입에서 큰 타입으로 자동 변환, 데이터 손실 없음
- 
## 참고 사항
- 모든 예제는 `src/` 폴더에 위치
- 각 예제를 실행하여 출력 결과를 확인하며 학습
- 실무에서는 데이터 손실 가능성을 항상 고려