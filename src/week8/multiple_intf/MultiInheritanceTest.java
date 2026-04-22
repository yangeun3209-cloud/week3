package week08.inf_advanced;

// 1. Serializable 인터페이스
interface Serializable {
    default void serialize() {
        System.out.println("직렬화 실행");
    }
}

// 2. Cacheable 인터페이스
interface Cacheable {
    default void serialize() {
        System.out.println("캐시 직렬화 실행");
    }
}

// 3. 두 인터페이스를 동시에 구현
class CacheableData implements Serializable, Cacheable {

    /*
     * [충돌 해결 전 컴파일 오류]
     * 만약 serialize()를 오버라이드하지 않으면 아래와 같은 의미의 컴파일 오류 발생:
     * "class CacheableData inherits unrelated defaults for serialize() from types Serializable and Cacheable"
     *
     * 이유:
     * - Serializable, Cacheable 둘 다 동일한 default 메서드 serialize()를 제공
     * - 자바는 어느 쪽 메서드를 상속해야 할지 자동으로 결정하지 않음
     * - 따라서 구현 클래스에서 반드시 직접 오버라이드해야 함
     */

    @Override
    public void serialize() {
        System.out.println("=== 충돌 해결 후 serialize() 실행 ===");

        // 원하는 부모 인터페이스 메서드를 명시적으로 선택 호출
        Serializable.super.serialize();

        System.out.println("=== 직렬화 작업 완료 ===");
    }
}

public class MultiInheritanceTest {
    public static void main(String[] args) {
        CacheableData data = new CacheableData();
        data.serialize();

        System.out.println();

        // 다형성 확인
        Serializable s = new CacheableData();
        s.serialize();
    }
}

/*
 * [다중 구현의 장점]
 * 1. 여러 기능 계약을 동시에 구현 가능
 * 2. default 메서드로 코드 재사용 가능
 * 3. 다형성 확장에 유리
 *
 * [다중 구현의 단점]
 * 1. 같은 이름의 default 메서드 충돌 가능
 * 2. 설계가 복잡해질 수 있음
 * 3. 클래스의 책임이 많아질 수 있음
 */