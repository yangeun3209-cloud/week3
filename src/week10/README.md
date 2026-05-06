# Week 10 - HashMap & Iterator 학습

**작성일**: 2026-05-06  
**차시**: 1차시

---

## 학습 목표

Java의 **HashMap**과 **Iterator**를 활용하여 데이터를 효율적으로 관리하고 순회하는 방법을 학습합니다.

---

## 학습 내용 정리

### 1. HashMap의 개념 및 활용

#### HashMap이란?
- **Key-Value 쌍**으로 데이터를 저장하는 Hash 기반의 Map 구현체
- 중복된 Key는 허용되지 않으며, Value는 중복 가능
- **O(1)의 빠른 조회 성능**을 제공

#### 주요 메서드
| 메서드 | 설명 |
|--------|------|
| `put(K key, V value)` | 키-값 쌍 저장 |
| `get(K key)` | 키에 해당하는 값 조회 |
| `containsKey(K key)` | 키 존재 여부 확인 |
| `remove(K key)` | 키-값 쌍 삭제 |
| `keySet()` | 모든 키를 Set으로 반환 |
| `entrySet()` | 모든 Entry(키-값)를 Set으로 반환 |
| `isEmpty()` | HashMap이 비어있는지 확인 |

---

### 2. 실습 예제

#### 📌 StudentMap.java
**HashMap을 이용한 학생 성적 관리 시스템**

```
기능:
- 초기 데이터: 5명의 학생 정보 저장
  김철수(85), 이영희(92), 박민수(78), 정수진(88), 최현준(95)
- 메뉴 기반 프로그램
  1. 모든 학생 조회 (keySet() 이용)
  2. 특정 학생 점수 조회
  3. 학생 점수 수정 (Scanner 이용)
  4. 새로운 학생 추가
  5. 학생 삭제
  6. 프로그램 종료

특징: null 키 사용 금지, 유효성 검사 (0-100점)
```

**주요 코드:**
```java
HashMap<String, Integer> students = new HashMap<>();
students.put("김철수", 85);

// keySet() 이용한 조회
Set<String> names = students.keySet();
for (String name : names) {
    System.out.println(name + " : " + students.get(name));
}
```

---

#### 📌 RemoveDuplicate.java
**중복 제거 성능 비교 분석**

```
개요:
- 20개의 정수 배열 (0~10 범위의 무작위 값)
- 두 가지 중복 제거 방법 비교

방법 1: 일반적인 방법 (중첩 반복문)
  - 시간 복잡도: O(n²)
  - 각 요소마다 이전 요소들과 비교
  - 더 느린 성능

방법 2: HashSet을 이용한 중복 제거
  - 시간 복잡도: O(n)
  - 자동으로 중복 제거
  - 훨씬 빠른 성능

결과: HashSet이 일반 방법보다 월등히 빠름
```

**주요 코드:**
```java
// HashSet을 이용한 중복 제거
HashSet<Integer> set = new HashSet<>();
for (int num : arr) {
    set.add(num);
}

// Set을 배열로 변환
int[] result = new int[set.size()];
int index = 0;
for (int num : set) {
    result[index++] = num;
}
```

---

#### 📌 StudentMapIter.java
**Iterator를 이용한 학생 성적 관리 시스템**

StudentMap.java를 기반으로 **Iterator 활용**에 중점을 둔 버전

```
특징: Map.Entry와 Iterator를 이용한 순회
```

**주요 코드:**
```java
// Iterator<Map.Entry> 사용
Iterator<Map.Entry<String, Integer>> iterator = students.entrySet().iterator();

while (iterator.hasNext()) {
    Map.Entry<String, Integer> entry = iterator.next();
    System.out.println(entry.getKey() + " : " + entry.getValue() + "점");
}
```

---

### 3. Iterator의 개념

#### Iterator란?
- **컬렉션의 요소를 순회**하기 위한 인터페이스
- 반복자 패턴(Iterator Pattern) 구현
- 컬렉션 타입에 관계없이 일관된 순회 방식 제공

#### Iterator의 주요 메서드
| 메서드 | 설명 |
|--------|------|
| `hasNext()` | 다음 요소 존재 여부 확인 |
| `next()` | 다음 요소 반환 및 포인터 이동 |
| `remove()` | 현재 요소 삭제 |

#### 사용 방법
```java
// 방법 1: keySet() 이용
Iterator<String> iterator = students.keySet().iterator();

// 방법 2: entrySet() 이용 (키-값 동시 처리)
Iterator<Map.Entry<String, Integer>> iterator = students.entrySet().iterator();
```

---

### 4. HashMap vs HashSet

| 특성 | HashMap | HashSet |
|------|---------|---------|
| 저장 형태 | Key-Value 쌍 | 단일 값 |
| 중복 | Key 중복 불가, Value 중복 가능 | 중복 불가 |
| 순서 | 삽입 순서 보장 안함 | 순서 보장 안함 |
| 성능 | O(1) 조회 | O(1) 조회 |
| 사용처 | 데이터 관리, 캐싱 | 중복 제거, 집합 연산 |

---

## 핵심 정리

✅ **HashMap**: 키-값 쌍을 빠르게 저장, 조회  
✅ **Iterator**: 컬렉션 요소를 안전하게 순회  
✅ **Map.Entry**: HashMap의 키-값을 동시에 처리  
✅ **HashSet**: 중복 제거에 효율적 (O(n))  
✅ **null 키 금지**: 데이터 무결성 보장

---

## 실습 성과

1. ✔️ HashMap을 이용한 실제 학생 성적 관리 시스템 구현
2. ✔️ Iterator를 이용한 안전한 순회 방식 습득
3. ✔️ 알고리즘 성능 비교 분석 (일반 방법 vs HashSet)
4. ✔️ Map.Entry를 이용한 효율적인 데이터 처리

---

## 다음 학습 내용 예상

- TreeMap (정렬된 맵)
- LinkedHashMap (삽입 순서 유지)
- 고급 Iterator 패턴
- 컬렉션 프레임워크 심화

---

# Week 10 - 스트림(Stream) & 파일 입출력 학습 (2차시)

**작성일**: 2026-05-06  
**차시**: 2차시

---

## 학습 목표

Java의 **바이트 스트림(Byte Stream)**과 **문자 스트림(Character Stream)**을 활용하여 파일 입출력을 구현하고, try-with-resources를 통한 안전한 리소스 관리 방법을 학습합니다.

---

## 2차시 학습 내용

### 1. 스트림(Stream) 개념

#### 스트림이란?
- **데이터의 흐름**을 추상화한 개념
- 입력(Input) 스트림과 출력(Output) 스트림으로 구분
- 바이트 스트림(InputStream/OutputStream)과 문자 스트림(Reader/Writer)

#### 스트림의 종류
| 스트림 종류 | 설명 | 단위 |
|-----------|------|------|
| **InputStream** | 표준 입력, 파일, 네트워크에서 데이터 읽기 | 1바이트 |
| **OutputStream** | 표준 출력, 파일, 네트워크로 데이터 쓰기 | 1바이트 |
| **FileReader** | 텍스트 파일 읽기 | 1문자 |
| **FileWriter** | 텍스트 파일 쓰기 | 1문자 |
| **BufferedInputStream** | InputStream에 버퍼링 추가 | 1바이트 |
| **BufferedOutputStream** | OutputStream에 버퍼링 추가 | 1바이트 |

---

### 2. 실습 예제

#### 📌 ByteStreamConverter.java
**System.in/System.out을 이용한 바이트 스트림 대문자 변환 프로그램**

```
기능:
- BufferedInputStream으로 키보드 입력 받기
- BufferedOutputStream으로 화면에 출력
- 입력한 텍스트를 대문자로 변환
- 'q' 또는 'Q' 입력 시 프로그램 종료

특징:
- System.in/System.out 직접 사용
- InputStream.read() 메서드로 바이트 단위 읽기
- Character.toUpperCase() 메서드로 대문자 변환
- output.flush()로 버퍼 즉시 출력
```

**주요 코드:**
```java
// 스트림 객체 생성
InputStream input = new BufferedInputStream(System.in);
OutputStream output = new BufferedOutputStream(System.out);

// 바이트 단위 읽기
while ((byteValue = input.read()) != -1) {
    char ch = (char) byteValue;
    char upperChar = Character.toUpperCase(ch);
    output.write(upperChar);
    output.flush();
}

// 리소스 정리
input.close();
output.close();
```

---

#### 📌 FileCopyProgram.java
**FileReader/FileWriter를 이용한 텍스트 파일 복사 프로그램**

```
기능:
- Scanner로 입력 파일명 받기
- FileReader로 텍스트 파일 1자씩 읽기
- FileWriter로 출력 파일(out.txt)에 쓰기
- try-with-resources로 안전한 리소스 관리
- 파일 미존재 시 예외 처리

특징:
- try-with-resources 사용 (자동 close)
- 파일 미존재 예외 처리
- 복사된 문자 수 카운팅
- 상세한 오류 메시지 제공
```

**주요 코드:**
```java
// try-with-resources로 자동 리소스 정리
try (FileReader reader = new FileReader(inputFileName);
     FileWriter writer = new FileWriter("out.txt")) {
    
    int charCode;
    // FileReader로 1자씩 읽기
    while ((charCode = reader.read()) != -1) {
        writer.write(charCode);
    }
} catch (IOException e) {
    // 파일 미존재 예외 처리
    System.out.println("오류: " + e.getMessage());
}
```

---

### 3. try-with-resources 문법

#### try-with-resources란?
- Java 7부터 제공하는 **자동 리소스 관리** 기능
- 스트림/리더/라이터 등 AutoCloseable 인터페이스 구현 객체 자동 정리
- 예외 발생 여부와 관계없이 리소스 자동 close

#### 기존 방식 vs try-with-resources

**기존 방식 (finally 필수):**
```java
FileReader reader = null;
try {
    reader = new FileReader("input.txt");
    // 작업
} catch (IOException e) {
    // 예외 처리
} finally {
    if (reader != null) {
        reader.close();
    }
}
```

**try-with-resources 방식:**
```java
try (FileReader reader = new FileReader("input.txt")) {
    // 작업
} catch (IOException e) {
    // 예외 처리
}
// 자동으로 reader.close() 호출됨
```

---

### 4. 문자 스트림 vs 바이트 스트림

| 특성 | 바이트 스트림 | 문자 스트림 |
|------|-------------|----------|
| **단위** | 1바이트 (0-255) | 1문자 (Unicode) |
| **클래스** | InputStream/OutputStream | Reader/Writer |
| **사용처** | 이진 파일, 네트워크 | 텍스트 파일, 인코딩 처리 |
| **속도** | 느림 | 빠름 (문자 단위) |
| **예시** | ByteInputStream, BufferedInputStream | FileReader, FileWriter |

---

## 핵심 정리

✅ **바이트 스트림**: System.in/out, 바이트 단위 처리  
✅ **문자 스트림**: FileReader/Writer, 문자 단위 처리  
✅ **try-with-resources**: 자동 리소스 정리 (Java 7+)  
✅ **예외 처리**: 파일 미존재, 접근 권한 오류 등 대응  
✅ **버퍼링**: BufferedInputStream/OutputStream으로 성능 향상  

---

## 실습 성과 (2차시)

1. ✔️ System.in/out을 이용한 바이트 스트림 프로그래밍 실습
2. ✔️ FileReader/FileWriter를 이용한 파일 복사 구현
3. ✔️ try-with-resources를 이용한 안전한 리소스 관리
4. ✔️ 파일 입출력 예외 처리 능력 습득
5. ✔️ 스트림 기반 프로그래밍의 기초 확립

---

## 전체 학습 요약

### 1차시: Collections Framework (HashMap, Iterator)
- HashMap을 이용한 데이터 관리
- Iterator를 이용한 안전한 순회
- 성능 비교 및 분석

### 2차시: Stream & File I/O
- 바이트 스트림과 문자 스트림
- FileReader/FileWriter를 이용한 파일 복사
- try-with-resources를 이용한 리소스 관리

---

## 다음 학습 내용 예상

- BufferedReader/BufferedWriter (한 줄 단위 읽기/쓰기)
- ObjectInputStream/ObjectOutputStream (직렬화)
- File 클래스 (파일 정보 조회, 생성, 삭제)
- NIO (New I/O) - Channel, Buffer
