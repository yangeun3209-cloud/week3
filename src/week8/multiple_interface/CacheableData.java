package week08;

/**
 * CacheableData는 Serializable과 Cacheable을 둘 다 구현한다.
 * 두 인터페이스가 동일한 시그니처의 default 메서드(serialize)를 제공하므로
 * 다이아몬드 문제(모호한 기본 구현)가 발생한다. 이를 해결하기 위해 클래스에서
 * 명시적으로 serialize()를 오버라이드하고, 필요하면 특정 인터페이스의
 * default 구현을 Serializable.super.serialize() 같은 문법으로 호출할 수 있다.
 *
 * 충돌 해결 전 컴파일 오류(주석):
 * // class CacheableData inherits unrelated defaults for serialize() from types Serializable and Cacheable
 *
 * 장점:
 * - 여러 인터페이스를 통해 행동을 재사용하고 타입으로서의 유연성 제공
 * - default 메서드로 기존 인터페이스에 기능 추가 가능
 * 단점:
 * - 서로 다른 인터페이스의 default 구현 충돌 가능(오버라이드 필요)
 * - 구현 클래스가 복잡해질 수 있음
 */
public class CacheableData implements Serializable, Cacheable {
    private String data;

    public CacheableData(String data) {
        this.data = data;
    }

    // 충돌 해결: serialize()를 오버라이드하여 어떤 부모 구현을 사용할지 명시
    @Override
    public void serialize() {
        // 부모 인터페이스의 default 구현을 선택적으로 호출 가능
        Serializable.super.serialize(); // 요구사항: Serializable의 구현을 호출

        // 추가 작업
        System.out.println("CacheableData: 추가 처리 완료 (데이터=" + data + ")");
    }
}
