package hust.soict.dsai.aims.disc;
import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.media.Playable;

public class CompactDisc extends Disc implements Playable{
	private String artist;
	private List<Track> tracks = new ArrayList<>();
	
	public String getArtist() {
		return artist;
	}

	public CompactDisc(int id, String title, String category, String director, float cost, int length, String artist) {
		super(id, title, category, director, cost, length);
		this.artist = artist;
	}
	
	public void addTrack(Track track) {
	    if (tracks.contains(track)) {
	        System.out.println("Track already exists.");
	    } else {
	        tracks.add(track);
	        System.out.println("Track added.");
	    }
	}
	
	public void removeTrack(Track track) {
	    if (tracks.contains(track)) {
	        tracks.remove(track);
	        System.out.println("Track removed.");
	    } else {
	        System.out.println("Track does not exist.");
	    }
	}
	
	@Override
    public String toString() {
        return String.format(
            "CD - ID: %d - Title: %s - Category: %s - Artist: %s - Director: %s - length: %d sec - Cost: %.2f $ - %d tracks",
            getId(), getTitle(), getCategory(), getArtist(), getDirector(),
            getLength(), getCost(), tracks.size()
        );
    }
	
	@Override
	public int getLength() {
	    int total = 0;
	    for (Track t : tracks) {
	        total += t.getLength();
	    }
	    return total;
	}
	
	@Override
	public void play() {
	    if (this.getLength() <= 0) {
	        System.out.println("ERROR: CD length is non-positive. Cannot play.");
	        return;
	    }

	    System.out.println("Playing CD: " + this.getTitle());
	    System.out.println("CD length: " + this.getLength());

	    for (Track t : tracks) {
	        t.play();   
	    }
	}


}
