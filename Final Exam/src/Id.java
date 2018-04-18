// 98 see inside
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Id {
	final static String INPUT = "input1.txt";
	final static String OUTPUT = "output1.txt";
	final static int MaxNumberOfBooks = 10;
	final static int MaxNumberOfSameBook = 4;

	public static void matrixSort(int[][] m) {
		int index = 0;
		int[] array = new int[m.length * m[0].length];
		// ** copy from m to new 1 dimension array */
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				array[index] = m[i][j];
				index++;
			}
		}
		sort(array); // call sort

		index = 0; // init
		// **copy back from array to m */
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				m[i][j] = array[index];
				index++;
			}
		}
	}

	public static void printMat(int[][] m, PrintWriter pw) {
		// ** complexity O(n^2) */
		for (int i = 0; i < m.length; i++) {
			pw.println();
			for (int j = 0; j < m[0].length; j++)
				pw.print(m[i][j] + " ");
		}
		pw.println();
	}

	public static void sort(int[] list) {
		// ** bubble sort *
		
		// -- not the efficient bubble sort -2
		for (int i = 0; i < list.length; i++) {
			for (int j = 0; j < list.length - 1; j++) {
				if (list[j] > list[j + 1]) {
					int temp = list[j];
					list[j] = list[j + 1];
					list[j + 1] = temp;
				}
			}
		}
	}

	public static String reverseDisplay(int v) {
		if (v == 0)
			return "0";
		return (reverseDisplay(v, ""));
	}

	public static String reverseDisplay(int v, String s) {
		if (v < 10)
			return s.concat(v % 10 + "");
		else
			return s.concat(v % 10 + reverseDisplay(v / 10));
	}

	public static void printBookArray(Book1[] ca, int n, String s, PrintWriter pw) {
		int i = 0, j = 0;
		pw.println("\n" + s);
		while (i < n) {
			pw.println("");
			pw.println("Book name: " + ca[i].getBookName());
			pw.println("Book Author: " + ca[i].getBookAuthor());
			pw.println("Number Of Copies: " + ca[i].getNumberOfBooks());
			pw.print("Books Serial Numbers: ");
			j = 0;
			//** print all serial numbers */
			while (j < ca[i].getNumberOfBooks()) {
				pw.print(ca[i].getBooks()[j] + " ");
				j++;
			}
			pw.println("");
			i++;
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File(INPUT);
		Scanner in = new Scanner(file);
		;
		PrintWriter pw = new PrintWriter(OUTPUT);
		int[] v = new int[] { 0, 1234, 8, 888, 763, 123456789 };
		int[][] m = new int[][] { { 71, 1, 3, 1, 6 }, { 2, 5, 2, -1, 7 }, { 0, -12, 12, 11, 8 },
				{ 342, 901, -3, -1, 9 }, { 92, 55, 2, -123, 10 }, { -9, 9, -23, 23, 11 }, { 10, -112, 122, -11, 12 } };
		pw.println("Matrix Before Sort");
		printMat(m, pw);
		pw.println("\nreverse integers\n");
		for (int i = 0; i < v.length; i++)
			pw.println("number = " + v[i] + " reverse number = " + reverseDisplay(v[i]));
		matrixSort(m);
		pw.println("\nSorted Matrix Ascending Order");
		printMat(m, pw);
		int bookNumber = 0;
		int numberOfBooks = 0;
		int i = 0;
		Book1 bookArray[] = new Book1[MaxNumberOfBooks];
		while (in.hasNext() && bookNumber < MaxNumberOfBooks) {
			int[] books = new int[MaxNumberOfSameBook];
			String s1 = in.nextLine();
			String s2 = in.nextLine();
			numberOfBooks = Math.min(in.nextInt(), MaxNumberOfSameBook);
			for (i = 0; i < numberOfBooks; i++) {
				books[i] = in.nextInt();
			}
			in.nextLine();
			bookArray[bookNumber++] = new Book1(s1, s2, numberOfBooks, books);
		}
		printBookArray(bookArray, bookNumber, "Books, Authors and Books Serial Number\n", pw);
		in.close();
		pw.close();
	}
}

class Book1 {
	private String bookName;
	private String bookAuthor;
	private int numberOfBooks;
	private int[] books;

	public Book1(String bookName, String bookAuthor, int numberOfBooks, int[] books) {
		setBookName(bookName);
		setBookAuthor(bookAuthor);
		setNumberOfBooks(numberOfBooks);
		setBooks(books);
	}

	private static String setString(final String s) {
		String str = s.trim(); // trim
		// ** split */
		String[] strArr = null;
		strArr = str.split(" ");
		// ** declare return string */
		String resStr = "";

		for (int i = 0; i < strArr.length; i++) {
			if (strArr[i].length() >= 1) {
				if (Character.isLetter(strArr[i].charAt(0))) {

					// convert first letter to Upper case and the rest to lower
					// case
					strArr[i] = strArr[i].substring(0, 1).toUpperCase() + strArr[i].substring(1).toLowerCase();

					// collect words to the return string if the word starts
					// with letter (not " " - (space))
					resStr = resStr.concat(strArr[i] + " ");
				}
				if (Character.isDigit(strArr[i].charAt(0)))

					// collect words to the return string if the word starts
					// with digit (not " " - (space))
					resStr = resStr.concat(strArr[i] + " ");
			}
		}
		// get rid the last space of the word from the concatenation
		return resStr.trim();
	}

	public String getBookName() {
		return setString(bookName);
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return setString(bookAuthor);
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public int getNumberOfBooks() {
		return numberOfBooks;
	}

	public void setNumberOfBooks(int numberOfBooks) {
		this.numberOfBooks = numberOfBooks;
	}

	public int[] getBooks() {
		return books;
	}

	public void setBooks(int[] books) {
		this.books = books;
	}
}
