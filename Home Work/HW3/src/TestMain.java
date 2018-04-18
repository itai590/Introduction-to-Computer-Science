
public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Song s1 = new Song("shape of you", "ed sheeran", 60);
		Song s2 = new Song("Californication1", "rhcp", 49);
		Song s3 = new Song("Californication2", "rhcp", 80);
		Song s4 = new Song("Californication3", "rhcp", 58);
		Song s5 = new Song("Californication4", "rhcp", 1, 10);
		Song s6 = new Song("Californication5", "rhcp", 25);
		Song s7 = new Song("malibu", "anderson Paak", 1, 60);
		Song s8 = new Song("caN't StoP", "rhCp", 69);

		Song s9 = new Song("shape of you", "z", 60);
		Song s10 = new Song("C1", "b", 49);
		Song s11 = new Song("C2", "d", 80);
		Song s12 = new Song("C3", "f", 58);
		Song s13 = new Song("C4", "e", 1, 10);
		Song s14 = new Song("C5", "rhcp", 25);
		Song s15 = new Song("malibu", "a", 1, 60);
		Song s16 = new Song("caN't StoP", "rhCp", 69);

		Album a1 = new Album("my album");
		a1.addSong(s1);
		a1.addSong(s2);
		a1.addSong(s3);
		a1.addSong(s4);
		a1.addSong(s5);
		a1.addSong(s6);
		a1.addSong(s7);
		a1.addSong(s8);
		a1.addSong("Paradise", "rhcp", 2, 1);

		Album a2 = new Album("my album2");
		a2.addSong(s9);
		a2.addSong(s10);
		a2.addSong(s11);
		a2.addSong(s12);
		a2.addSong(s13);
		a2.addSong(s14);
		a2.addSong(s15);
		a2.addSong(s16);
		a2.addSong("Paradise", "rhcp", 2, 1);

		AlbumSet as0 = new AlbumSet("itai");
		as0.addAlbum(a1);
		as0.addAlbum(a2);

		System.out.println(as0);

		// System.out.println(a1);
		// System.out.println("isExist:" + a1.isSongExist("malibu"));
		// a1.sortByArtist();
		// System.out.println("");
		// System.out.println(a1);

	}
}
