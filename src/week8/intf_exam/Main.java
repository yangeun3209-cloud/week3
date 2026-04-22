interface Playable {
    // 인터페이스 필드(상수) - public static final 자동 적용
    int MAX_VOLUME = 100;

    void play();
    void pause();
    void stop();
}

class MusicPlayer implements Playable {
    private String songTitle;
    private int volume;

    public MusicPlayer(String songTitle, int volume) {
        this.songTitle = songTitle;
        // 상수 활용 예시
        this.volume = Math.min(volume, Playable.MAX_VOLUME);
    }

    @Override
    public void play() {
        System.out.println("[MusicPlayer] 음악 재생 시작: " + songTitle + " / 볼륨: " + volume);
    }

    @Override
    public void pause() {
        System.out.println("[MusicPlayer] 음악 일시정지: " + songTitle);
    }

    @Override
    public void stop() {
        System.out.println("[MusicPlayer] 음악 정지: " + songTitle);
    }
}

class VideoPlayer implements Playable {
    private String videoTitle;
    private int volume;

    public VideoPlayer(String videoTitle, int volume) {
        this.videoTitle = videoTitle;
        // 상수 활용 예시
        this.volume = Math.min(volume, Playable.MAX_VOLUME);
    }

    @Override
    public void play() {
        System.out.println("[VideoPlayer] 영상 재생 시작: " + videoTitle + " / 볼륨: " + volume);
    }

    @Override
    public void pause() {
        System.out.println("[VideoPlayer] 영상 일시정지: " + videoTitle);
    }

    @Override
    public void stop() {
        System.out.println("[VideoPlayer] 영상 정지: " + videoTitle);
    }
}

public class Main {
    public static void main(String[] args) {
        // Playable 타입 변수로 객체 참조
        Playable player1 = new MusicPlayer("Spring Breeze", 120);
        Playable player2 = new VideoPlayer("Java Interface Tutorial", 80);

        // 인터페이스 상수 활용 예시
        System.out.println("최대 볼륨 값: " + Playable.MAX_VOLUME);
        System.out.println();

        // 다형성 호출 시연
        player1.play();
        player1.pause();
        player1.stop();

        System.out.println();

        player2.play();
        player2.pause();
        player2.stop();
    }
}