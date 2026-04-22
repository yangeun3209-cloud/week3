package week08;

/**
 * interface Serializable: default 메서드 serialize()
 */
public interface Serializable {
    default void serialize() {
        System.out.println("직렬화 실행");
    }
}
