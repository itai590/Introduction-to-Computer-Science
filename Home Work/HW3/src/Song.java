public class Song {
	// class behaviours
	private String songName = "";
	private String artistName = "";
	private int songLength;

	// constructors
	public Song(String songName, String artistName, int minutes, int seconds) {
		this(songName, artistName, (60 * minutes) + seconds);
	}

	public Song(String songName, String artistName, int seconds) {
		setSongName(songName);
		setArtistName(artistName);
		setSongLength(seconds);
	}

	// getters
	public String getSongName() {
		return this.songName;
	}

	public String getArtistName() {
		return this.artistName;
	}

	public int getSongLength() {
		return this.songLength;
	}

	// setters
	public void setSongName(String songName) {
		this.songName = songName.substring(0, 1).toUpperCase() + songName.substring(1).toLowerCase();
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName.substring(0, 1).toUpperCase() + artistName.substring(1).toLowerCase();
	}

	public void setSongLength(int minutes, int seconds) {
		this.songLength = 60 * minutes + seconds;
	}

	public void setSongLength(int seconds) {
		this.songLength = seconds;
	}

	// special Methods
	public boolean isSongEqaul(String songName) {
		return (this.songName.toLowerCase() == songName.toLowerCase());
	}

	public boolean isArtistEqaul(String artistName) {
		return (this.artistName.toLowerCase() == artistName.toLowerCase());
	}

	// to String
	@Override
	public String toString() {
		return "Song Name: " + this.songName + ", Artist Name: " + this.artistName + ", Song Length: " + this.songLength
				+ " seconds";
	}
}