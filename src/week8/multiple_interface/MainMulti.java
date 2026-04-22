package week08;

public class MainMulti {
    public static void main(String[] args) {
        CacheableData cd = new CacheableData("example-data");

        // 오버라이드에서 Serializable.super.serialize()를 호출하도록 구현했으므로,
        // 실행 결과는 먼저 "직렬화 실행"이 출력되고 그 다음 추가 메시지가 출력된다.
        cd.serialize();

        // 만약 CacheableData에서 serialize()를 오버라이드하지 않았다면 컴파일 단계에서
        // "class CacheableData inherits unrelated defaults for serialize() from types Serializable and Cacheable"
        // 와 같은 오류가 발생했을 것임.
    }
}
