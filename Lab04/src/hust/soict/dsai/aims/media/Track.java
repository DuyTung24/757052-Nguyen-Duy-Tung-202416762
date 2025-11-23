package hust.soict.dsai.aims.disc;

import hust.soict.dsai.aims.media.Playable;

public class Track implements Playable{
	private String title;
	private int length;
	
	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}

	public Track(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}
	
	@Override
	public void play() {
	    System.out.println("Playing Track: " + this.getTitle());
	    System.out.println("Track length: " + this.getLength());
	}
	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) return true;
	    if (!(obj instanceof Track)) return false;

	    Track other = (Track) obj;

	    return this.title.equalsIgnoreCase(other.title)
	            && this.length == other.length;
	}

	public Track() {
		// TODO Auto-generated constructor stub
	}

}
