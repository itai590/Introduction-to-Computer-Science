public class AlbumSet {
	// class behaviours
	private String owner;
	private Album[] albums;
	private int numAlbums;
	private final int MAX_NUM_ALBUMS = 20;

	// constructor
	public AlbumSet(String owner) {
		// init
		numAlbums = 0;
		albums = new Album[MAX_NUM_ALBUMS];

		setOwnerName(owner);
	}

	// getters
	public String getOwner() {
		return owner;
	}

	public int getNumAlbums() {
		return numAlbums;
	}

	public Album getOneAlbumByIndex(int index) {
		return albums[index];
	}

	// setters
	public void setOwnerName(String owner) {
		this.owner = owner.substring(0, 1).toUpperCase() + owner.substring(1).toLowerCase();
	}

	// special setter: adding song to album
	public void addSongToAlbum(String albumName, String songName, String artistName, int minutes, int seconds) {
		Song song = new Song(songName, artistName, minutes, seconds);
		addSongToAlbum(albumName, song);
	}

	public void addSongToAlbum(String albumName, Song song) {
		if (isAlbumExists(albumName)) {
			albums[getAlbumIndex(albumName)].addSong(song);

		} else {
			Album a0 = new Album(albumName);
			a0.addSong(song);
			addAlbum(a0);
		}
	}

	// special Methods
	public void addAlbum(String albumName) {
		Album a0 = new Album(albumName);
		addAlbum(a0);
	}

	public void addAlbum(Album newAlbum) {
		albums[numAlbums] = newAlbum;
		numAlbums++;
	}

	public boolean isAlbumExists(String albumName) {
		albumName = albumName.toLowerCase();
		for (int i = 0; i < numAlbums; i++) {
			if (albums[i].getAlbumName().toLowerCase().equals(albumName))
				return true;
		}
		return false;
	}

	public int getAlbumIndex(String albumName) {
		albumName = albumName.toLowerCase();
		for (int i = 0; i < numAlbums; i++) {
			if (albums[i].getAlbumName().toLowerCase().equals(albumName))
				return i;
		}
		return -1;
	}

	public void sortByAlbumsName() {
		for (int i = 0; i < numAlbums; i++) {
			for (int j = 0; j < numAlbums - 1; j++) {
				String a0 = albums[j].getAlbumName();
				String a1 = albums[j + 1].getAlbumName();
				if (a0.compareTo(a1) > 0) {
					Album temp = albums[j + 1];
					albums[j + 1] = albums[j];
					albums[j] = temp;
				}
			}
		}
	}

	public String toString() {
		String str = "Album set:  " + "Owner Name: " + this.owner + ", Number Of Albums: " + this.numAlbums
				+ "\n----------------";
		for (int i = 0; i < this.numAlbums; i++) {
			str += "\n" + "Album Name: " + this.albums[i].getAlbumName() + ", Number Of Songs: "
					+ this.albums[i].getNumSongs() + ", Album Length (in seconds): " + this.albums[i].getAlbumLength();
		}
		/*
		 * toSring with songs
		 * 
		 * for (int i = 0; i < this.numAlbums; i++) str += "\n*" + "Album " + i + ": " +
		 * this.albums[i] + "\n";
		 */
		str += "\n-----End-Of-AlbumSet-----";
		return str;
	}
}