public class Album {
	// class behaviours
	private String albumName;
	private final int MAX_NUM_SONGS = 20;
	private Song[] songs;
	private int totalAlbumLength;
	private int numSongs;

	// constructor
	public Album(String albumName) {
		// init
		songs = new Song[MAX_NUM_SONGS];
		numSongs = 0;

		setAlbumName(albumName);
	}

	// getters
	public String getAlbumName() {
		return this.albumName;
	}

	public Song[] getAlbumSongs() {
		return this.songs;
	}

	public int getAlbumLength() {
		return this.totalAlbumLength;
	}

	public int getNumSongs() {
		return this.numSongs;
	}

	// setters
	public void setAlbumName(String albumName) {
		this.albumName = albumName.substring(0, 1).toUpperCase() + albumName.substring(1).toLowerCase();
	}

	// special setters: adding new song
	public void addSong(Song newSong) {
		if (isSongExist(newSong.getSongName()) == -1) {
			songs[numSongs] = newSong;
			totalAlbumLength += newSong.getSongLength();
			numSongs++;
		}
	}

	public void addSong(String songName, String artistName, int minutes, int seconds) {
		Song s1 = new Song(songName, artistName, minutes, seconds);
		addSong(s1);
	}

	// special Methods
	public int isSongExist(String songName) {
		songName = songName.toLowerCase();
		for (int i = 0; i < numSongs; i++) {
			if (this.songs[i].getSongName().toLowerCase().equals(songName))
				return i;
		}
		return -1;
	}

	public void sortByArtist() {
		for (int i = 0; i < numSongs; i++) {
			for (int j = 0; j < numSongs - 1; j++) {
				Song s0 = songs[j];
				Song s1 = songs[j + 1];
				if (s0.getArtistName().equals(s1.getArtistName())) {
					sortBySongLength(s0, s1, j);

				} else if (s0.getArtistName().compareTo(s1.getArtistName()) > 0) {
					Song temp = songs[j + 1];
					songs[j + 1] = songs[j];
					songs[j] = temp;
				}
			}
		}
	}

	public void sortBySongLength(Song s0, Song s1, int j) {
		int s0Length = s0.getSongLength();
		int s1Length = s1.getSongLength();
		if (s0Length > s1Length) {
			Song temp = songs[j + 1];
			songs[j + 1] = songs[j];
			songs[j] = temp;
		}
	}

	// toString
	public String toString() {
		String str = "Album Name: " + this.albumName + ", number of Songs: " + this.numSongs
				+ ", Album Length (in seconds): " + this.totalAlbumLength;
		for (int i = 0; i < this.numSongs; i++)
			str += "\n" + this.songs[i];
		return str;
	}
}