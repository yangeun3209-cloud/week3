package week08.intf_exam;

/**
 * Playable 인터페이스: 재생 관련 메서드 선언 및 상수 예시
 */
public interface Playable {
    // 인터페이스 필드는 public static final 상수로 취급된다.
    String DEFAULT_MEDIA = "[default media]";

    void play();
    void pause();
    void stop();
}