# Week 9 학습 내용: equals, hashCode, Objects, 그리고 Wrapper 클래스

이 README는 Week 9의 주요 학습 주제를 다룹니다: `equals()`와 `hashCode()` 메서드 오버라이드, `Objects` 유틸리티 클래스 사용, 그리고 기본 타입을 위한 Wrapper 클래스 작업.

## 1. equals()와 hashCode() 오버라이드

### 목적
- `equals()`: 객체 간 논리적 동등성을 확인합니다.
- `hashCode()`: 객체의 해시 코드 값을 반환하며, 해시 기반 컬렉션(예: HashMap, HashSet)에서 사용됩니다.
- **계약**: 두 객체가 `equals()`로 같으면 `hashCode()`도 같아야 합니다. 같지 않다고 해서 해시 코드가 다를 보장은 없습니다.

### Student 클래스 요구사항
- 필드: `id` (int), `name` (String)
- `equals()`: `id` 기준으로 비교.
- `hashCode()`: `Objects.hash(id)` 사용.

### 예시 구현 (Student.java에서)
```java
@Override
public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Student student = (Student) obj;
    return id == student.id;
}

@Override
public int hashCode() {
    return Objects.hash(id);
}
```

### 실행 로직
- 같은 `id`(예: 1)를 가진 두 `Student` 객체를 생성하되, `name`은 다르게.
- `==` 비교: `false` (참조 다름).
- `equals()` 비교: `true` (같은 `id`).

## 2. Objects 유틸리티 클래스

### 주요 메서드
- `Objects.equals(a, b)`: null 안전 동등성 확인 (null 값 처리).
- `Objects.hash(values...)`: 여러 값에서 해시 코드 생성.
- `Objects.toString(obj)`: null 안전 toString.
- `Objects.requireNonNull(obj)`: null이면 NullPointerException 발생.

### hashCode()에서의 사용
- 수동 해싱 대신 `Objects.hash(id)`를 사용해 일관성과 null 안전성을 확보.

## 3. Wrapper 클래스

### 개요
- Wrapper 클래스(예: `Integer`, `Double`, `Boolean`)는 기본 타입(`int`, `double`, `boolean`)을 객체로 감쌉니다.
- 컬렉션에서 기본 타입을 객체로 사용할 수 있게 합니다.

### 변환 메서드
- **parseXXX(String)**: 문자열을 기본 타입으로 변환 (예: `Integer.parseInt("123")` → `int 123`).
- **valueOf(String)**: 문자열을 Wrapper 객체로 변환 (예: `Integer.valueOf("123")` → `Integer 123`).

### 비교
- `==`: 참조 비교 (Wrapper의 경우, 값이 같아도 다른 객체이면 보통 `false`).
- `equals()`: 값 비교 (값이 같으면 `true`).

### 예시 (StringConversionExample.java에서)
```java
String input = "123";
int primitive = Integer.parseInt(input);  // int 123
Integer wrapper = Integer.valueOf(input); // Integer 123

Integer wrapper2 = Integer.valueOf(input); // 또 다른 Integer 123
System.out.println(wrapper == wrapper2);     // false (객체 다름)
System.out.println(wrapper.equals(wrapper2)); // true (값 같음)
```

### 예외 처리
- `NumberFormatException`: 문자열을 파싱할 수 없을 때 발생 (예: `Integer.parseInt("abc")`).
- 변환 시 항상 try-catch로 감싸세요.

### 지원 타입
- `Integer` for `int`
- `Double` for `double`
- `Boolean` for `boolean`
- 기타: `Long`, `Float`, `Character`, `Byte`, `Short`

## 예시 실행
- 컴파일: `javac week6\*.java`
- Student 데모 실행: `java week6.Student`
- 변환 데모 실행: `java week6.StringConversionExample`

## 참고
- Lombok 미사용; 모든 오버라이드는 수동.
- 객체 동등성 vs 참조 동등성 이해에 집중.
- 예외를 처리하기 위해 다양한 입력으로 연습하세요.