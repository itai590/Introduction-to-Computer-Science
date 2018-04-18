//	Student Name: Itai ,		Student ID:
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class Ex03_Main {

	public static void main(String[] args) throws FileNotFoundException {
		AlbumSet myAlbums = new AlbumSet("Itai");

		// Phase A
		// getting file name and open it
		String inputFileName = JOptionPane.showInputDialog("Please enter input file name (full path)",
				"/home/itai/myGarbage/mySongs.txt");
		// fileName = "/home/itai/myGarbage/" + fileName + ".txt";
		// c:\\myGarbage\mySong.txt
		// fileName = "/home/itai/myGarbage/mySongs.txt";
		File inputfile = new File(inputFileName);
		Scanner input = new Scanner(inputfile);

		// reading input file and creating the albums
		while (input.hasNext()) {
			String line = input.nextLine();
			// line format: "songName;ArtistName;mm:ss;AlbumName:
			line = line.replaceAll("\\s+", " "); // replace multitude space chars with one space char
			String[] tokens = line.split(";"); // split spaces entire line by ';' to 4 strings
			String songName = tokens[0].trim(); // get spaces trimmed song name
			String artistName = tokens[1].trim(); // get trimmed artist name
			String[] mmss = tokens[2].split(":"); // split time string (foramt:mm:ss) by ':' to 2 integers: minutes and
													// seconds
			int minutes = Integer.parseInt(mmss[0].trim()); // get spaces trimmed minutes integer
			int seconds = Integer.parseInt(mmss[1].trim()); // get spaces trimmed seconds integer
			String albumName = tokens[3].trim();
			// create new song with line parameters
			Song newSong = new Song(songName, artistName, minutes, seconds);
			// create Albums in AlbumSet
			myAlbums.addSongToAlbum(albumName, newSong); // if album exist: adds song to album; if not: create new album
															// and adds the song
		}
		input.close(); // close file
		System.out.println(myAlbums + "\n"); // print to console AlbumSet

		// Phase B
		// album and song ordering
		myAlbums.sortByAlbumsName(); // sort AlbumSet by Album name

		// sort each album by Artist name (sorting by song length for same Artist)
		for (int i = 0; i < myAlbums.getNumAlbums(); i++) {
			myAlbums.getOneAlbumByIndex(i).sortByArtist();
		}

		// Phase C
		// statistical information
		System.out.println(myAlbums); // print to console AlbumSet

		// Phase D
		// ask user for song search
		int n = JOptionPane.showConfirmDialog(null, "Do you want to search a song?", "", JOptionPane.YES_NO_OPTION);
		if (n == 0) {// if yes
			String songName = JOptionPane.showInputDialog("Please enter the Song name for search");
			boolean flag = false; // song wasn't found
			String str = "";
			// searching for a song
			for (int i = 0; i < myAlbums.getNumAlbums(); i++) {
				if (myAlbums.getOneAlbumByIndex(i).isSongExist(songName) >= 0) { // song exist
					flag = true;
					// print Album name & Song index
					str = "Song: " + songName + " exists at Album: " + myAlbums.getOneAlbumByIndex(i).getAlbumName()
							+ " as song number: " + (myAlbums.getOneAlbumByIndex(i).isSongExist(songName) + 1);
					System.out.println(str);
				}
			}
			if (!flag)
				System.out.println("Song: " + songName + " is not exists at your albums!");
		}

		// Phase E
		// getting output file name and write it
		//"/home/itai/myGarbage/albumOutputFile-myGarbage.txt");
		String outputFileName = JOptionPane.showInputDialog("Please Enter output file name (full path)",
				"albumOutputFile.txt");
		PrintWriter output = new PrintWriter(outputFileName);
		// Write formatted output to the file
		String lineSep = "=============";
		for (int i = 0; i < myAlbums.getNumAlbums(); i++) {
			output.println("Album no' " + (i + 1));
			output.println(lineSep);
			output.println(myAlbums.getOneAlbumByIndex(i));
			output.println();
			// output.println( Song Name
		}
		// Close the file
		output.close();
	}
}
