# Week6 실습 정리
2026- 04-08 
이름: 양은찬
학번: 20220548
## 1) 실습 목표
- 클래스 설계와 캡슐화(`private` + getter/setter)
- 생성자 오버로딩과 생성자 체이닝(`this()`)
- 인스턴스 초기화 블록, static 필드/메소드, static 초기화 블록 이해
- 객체 배열, 통계 누적 같은 실전형 예제 구현

## 2) 파일별 학습 내용
- `Student.java`
  - `name`, `age` 필드
  - 인스턴스 초기화 블록으로 기본값 설정
  - 기본 생성자에서 `this("이름없음", 0)` 호출
  - `toString()` 형식: `이름:나이`

- `Studnt2.java`
  - 필드: `name`, `id`, `major`
  - 인스턴스 초기화 블록 + 생성자 오버로딩
  - `this()` 체이닝으로 초기화 경로 통일
  - `thString()` 출력 형식: `[id] name (major)`

- `Book.java`
  - 필드: `title`, `price`
  - 생성자, `toString()`, getter/setter 구현
  - 객체 배열 실습에서 사용

- `Counter.java`
  - static 필드 `count`를 `100`으로 시작
  - 객체 생성 시 `count` 누적 증가
  - static 메소드로 현재 count 출력
  - `main()`에서 여러 객체 생성 후 공유값 확인

- `AppConfig.java`
  - static 필드 선언 시 초기화
  - static 초기화 블록에서 연결 문자열 조합 및 유효성 검사
  - 클래스 로딩 시 실행 순서(선언 초기화 -> static 블록) 확인

- `Order.java`
  - 필드: `id`, `amount`
  - static 누적 필드: `totalCount`, `totalAmount`
  - 객체 생성 시 총 건수/총 금액 자동 누적

- `OrderStats.java`
  - static 유틸 메소드 제공
    - `getAverageAmount()`
    - `getTotalCount()`
    - `getTotalAmount()`

- `OrderTest.java`
  - `main()` 실행 파일
  - `Order` 3개 생성 후 주문 목록/통계 출력

- `Person.java`
  - `private` 필드: `name`, `age`
  - `public` getter/setter로만 접근 가능

- `PersonTest.java`
  - getter/setter 사용 예제
  - 직접 필드 접근 시 컴파일 오류가 나는 코드(주석 예시) 포함

## 3) 핵심 개념 요약
- **캡슐화**: 필드는 `private`, 외부 접근은 메소드로 제한
- **생성자 체이닝**: `this()`로 중복 초기화 로직 감소
- **초기화 순서**: 필드 초기화 -> 초기화 블록 -> 생성자
- **static 공유**: 클래스 단위 데이터(`count`, `totalCount`, `totalAmount`)는 모든 객체가 공유
- **역할 분리**: 데이터 클래스(`Order`)와 통계 유틸(`OrderStats`) 분리

## 4) 실행 예시(cmd)
아래는 대표 실행 예시입니다.

```cmd
cd /d c:\Users\양은찬\IdeaProjects\week3\src
javac week6\Counter.java
java week6.Counter
```

```cmd
cd /d c:\Users\양은찬\IdeaProjects\week3\src
javac week6\Order.java week6\OrderStats.java week6\OrderTest.java
java week6.OrderTest
```

```cmd
cd /d c:\Users\양은찬\IdeaProjects\week3\src
javac week6\Person.java week6\PersonTest.java
java week6.PersonTest
```

## 5) 회고
- static과 인스턴스 멤버의 차이를 실제 출력으로 확인함
- 캡슐화와 클래스 책임 분리를 코드 구조로 연습함
- 다음 실습에서는 유효성 검사 강화(예: 음수/빈 값 처리)와 테스트 코드 자동화를 시도하면 좋음
