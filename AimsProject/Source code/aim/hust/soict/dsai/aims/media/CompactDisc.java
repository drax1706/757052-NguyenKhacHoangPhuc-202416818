package hust.soict.dsai.aims.media;
import hust.soict.dsai.aims.exception.PlayerException;
import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {

    private String artist;
    private ArrayList<Track> tracks = new ArrayList<>();

    public CompactDisc() {
        super();
    }

    public CompactDisc(String title, String category, float cost,
                       String director, String artist) {
        super(title, category, cost, director, 0);
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }


    public void addTrack(Track track) {
        if (track == null) return;

        if (tracks.contains(track)) {
            System.out.println("Đã có: " + track.getTitle());
        } else {
            tracks.add(track);
            System.out.println("Đã thêm: " + track.getTitle());
        }
    }
    public void removeTrack(Track track) {
        if (track == null) return;
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("đã xóa  trac: " + track.getTitle());
        } else {
            System.out.println("không có : " + track.getTitle());
        }
    }

    @Override
    public int getLength() {
        int total = 0;
        for (Track t : tracks) {
            total += t.getLength();
        }
        return total;
    }
    //play co excep
    @Override
    public void play() throws PlayerException {
        if (this.getLength() <= 0) {
            System.err.println("ERROR: CD length is non-positive!");
            throw new PlayerException("ERROR: CD length is non-positive!");
        }

        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("CD length: " + this.getLength());
        boolean hasError = false;
        for (Track track : tracks) {
            try {
                track.play();
            } catch (PlayerException e) {
                hasError = true;
                System.err.println("Error while playing track: " + track.getTitle());
                e.printStackTrace();
            }
        }
        if (hasError) {
            throw new PlayerException("ERROR: One or more tracks could not be played on this CD");
        }
    }
    @Override
    public String toString() {
        return "CD - " + getTitle()
                + " - " + getCategory()
                + " - " + getDirector()
                + " - Artist: " + artist
                + " - Length: " + getLength()
                + " - " + getCost() + " $";
    }

}
