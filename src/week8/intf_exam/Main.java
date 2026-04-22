package week08.intf_exam;

/**
 * 인터페이스 타입 변수로 두 객체를 참조하여 다형성 호출을 시연
 */
public class Main {
    public static void main(String[] args) {
        // 인터페이스 상수 사용 예시
        System.out.println("Playable.DEFAULT_MEDIA = " + Playable.DEFAULT_MEDIA);

        // Playable 타입으로 참조 (다형성)
        Playable player1 = new MusicPlayer("Acme Music");
        Playable player2 = new VideoPlayer("Acme Video");

        System.out.println("--- MusicPlayer actions ---");
        player1.play();
        player1.pause();
        player1.stop();

        System.out.println("--- VideoPlayer actions ---");
        player2.play();
        player2.pause();
        player2.stop();
    }
}