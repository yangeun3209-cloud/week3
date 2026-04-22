package multiple_interface;

/**
 * interface Cacheable: default 메서드 serialize() (의도적 충돌)
 */
public interface Cacheable {
    default void serialize() {
        System.out.println("캐시 직렬화 실행");
    }
}