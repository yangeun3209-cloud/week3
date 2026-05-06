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

