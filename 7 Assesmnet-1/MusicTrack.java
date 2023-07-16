// Create MusicTrack Class.
public class MusicTrack {
    private String name;
    private int duration;

    public MusicTrack(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    public String getName() {
        return this.name;
    }

    public int getDuration() {
        return this.duration;
    }
}