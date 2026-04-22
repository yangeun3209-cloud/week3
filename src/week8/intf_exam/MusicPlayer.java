package week08.intf_exam;

public class MusicPlayer implements Playable {
    private final String name;

    public MusicPlayer(String name) {
        this.name = name;
    }

    @Override
    public void play() {
        System.out.println("[MusicPlayer] '" + name + "' is playing music. (using: " + DEFAULT_MEDIA + ")");
    }

    @Override
    public void pause() {
        System.out.println("[MusicPlayer] '" + name + "' paused the track.");
    }

    @Override
    public void stop() {
        System.out.println("[MusicPlayer] '" + name + "' stopped playback.");
    }
}
