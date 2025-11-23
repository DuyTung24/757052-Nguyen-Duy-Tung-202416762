package hust.soict.dsai.aims.media;


public class DigitalVideoDisc extends Disc implements Playable {
	private static int nbDigitalVideoDiscs = 0;                            
	private String director;
	private int length;
	
    @Override
    public String toString() {
        return String.format("DVD - ID: %d - Title: %s - Category: %s - Director %s - Length: %d mins - Cost: %.2f $",
                this.getId(), this.getTitle(), this.getCategory(), director, length, this.getCost());
    }
    
    public void setTitle(String title) {
        this.setTitle(title);
    }

    public static int getNbDigitalVideoDiscs() {
        return nbDigitalVideoDiscs;
    }
    
    @Override
    public void play() {
        if (this.getLength() > 0) {
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength());
        } else {
            System.out.println("ERROR: DVD length is non-positive. Cannot play.");
        }
    }

    

    
    
//Constructor		
    
    
    public DigitalVideoDisc(String title) {
        this(++nbDigitalVideoDiscs, title, null, null, 0f, 0);
    }

    public DigitalVideoDisc(int id, String title, String category, float cost) {
        this(id, title, category, null, cost, 0);
    }
    
    public DigitalVideoDisc(String title, String category, String director,float cost, int length) {
        this(0, title, category, director ,cost, length); 
    }
    public DigitalVideoDisc(int id, String title, String category, String director, float cost) {
        this(id, title, category,director, cost, 0); // length = 0
    }

    // 4. Constructor nhận đủ tất cả thông tin
    public DigitalVideoDisc(int id, String title, String category, String director, float cost, int length) {
        super(id, title, category, director, cost, length); 
    }
}