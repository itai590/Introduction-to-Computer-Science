import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class HW2_ItaiCohen {
	// Itai_Cohen
	// ver.6
	final static int MAX = 127;
	final static int MIN = 1;

	public static void main(String args[]) {
		// EX4
		String message_1 = "Please Enter Four Numbers To Create Tow Matrices: \n(First Matrice[1][2],"
				+ " Second Matrice[3][4])";
		JOptionPane.showMessageDialog(null, message_1, "Message", JOptionPane.INFORMATION_MESSAGE);
		int[] sizeArray = new int[4]; // will contain 2 matrices sizes
		for (int i = 0; i < 4; i++)
			sizeArray[i] = Integer.parseInt(JOptionPane.showInputDialog("Enter Number " + (i + 1)));
		int[][] A = generateRandomMatrix(sizeArray[0], sizeArray[1]);
		int[][] B = generateRandomMatrix(sizeArray[2], sizeArray[3]);
		// check set
		// int[][] A = { { 1, 2, 0 }, { 4, 3, (-1) } };
		// int[][] B = { { 5, 1 }, { 2, 3 }, { 3, 4 } };
		// int[][] A = { { 1, 2, 3 }, { 4, 3, (-1) } };
		// int[][] B = { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };
		// printMatrix(A);
		// printMatrix(B);
		showMatrix(multiplyMatrix(A, B));
		// ----END-OF-EX4----

		// EX5
		// showMatrix(transposeMatrix(A));
		// ----END-OF-EX5----

		// EX7
		// generate random decimal number (1-127)
		int decimal = (int) (Math.random() * (MAX - MIN + 1) + MIN);
		// random binary number
		int binary = decimalToBinary(decimal);
		// generate random hex number in format: char array[size:2-3]
		char[] hexChar = { '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		int hexLength = (int) (Math.random() * (3 - 2 + 1) + 2);
		char[] hexNumber = new char[hexLength];
		for (int i = 0; i < hexLength; i++) {
			int hexCharIndex = (int) (Math.random() * (14 - 0 + 1) + 0);
			hexNumber[i] = hexChar[hexCharIndex];
		}
		String s = "(BIN)" + binary + " = (DEC)" + binaryToDecimal(binary) + "\n(Hex)" + hexCharToString(hexNumber)
				+ " = (Dec)" + hexToDecimal(hexNumber);
		JOptionPane.showMessageDialog(null, s, "Message", JOptionPane.WARNING_MESSAGE);
		// ----END-OF-EX7----

		// EX8
		int arrayLength = Integer.parseInt(JOptionPane.showInputDialog("Please Enter Size Of Array"));
		int[] arr = generateRandomArray(arrayLength);
		int[] sortArr = sortArray(arr);
		showArray(sortArr, true);
		int number = Integer.parseInt(JOptionPane.showInputDialog("Enter Simple Number Between 1 To 127"));
		//java.util.Arrays.binarySearch
		if (binarySearch(sortArr, number) > 0) {
			String str = "Number Location In The Array Is: " + binarySearch(sortArr, number) + "\n"
					+ number + "(Dec) = " + decimalToBinary(number) + "(Bin) = " + decimalToHex(number) + "(Hex)";
			JOptionPane.showMessageDialog(null, str, "Message", JOptionPane.WARNING_MESSAGE);
		}
		// ----END-OF-EX8----
	}

	// EX1 Function
	public static int[] generateRandomArray(int num) {
		int[] arr = new int[num];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * (MAX - MIN + 1) + MIN);
		}
		return arr;
	}

	// EX2 Function
	public static int[][] generateRandomMatrix(int row, int column) {
		int[][] matrix = new int[row][column];
		for (int i = 0; i < row; i++)
			matrix[i] = generateRandomArray(column);
		return matrix;
	}

	// EX3 Function
	public static int[][] multiplyMatrix(int[][] A, int[][] B) {
		int[][] result = new int[A.length][B[0].length];
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {
				for (int c = 0; c < B.length; c++)
					result[i][j] = result[i][j] + (A[i][c] * B[c][j]);
			}
		}
		return result;
	}

	// EX5 Function
	public static int[][] transposeMatrix(int[][] R) {
		int[][] rT = new int[R[0].length][R.length];
		for (int i = 0; i < rT.length; i++) {
			for (int j = 0; j < rT[i].length; j++) {
				rT[i][j] = R[j][i];
			}
		}
		return rT;
	}

	// EX6.1 Function
	public static int decimalToBinary(int decimal) {
		int binary = 0;
		int bit = 0;
		while (decimal > 0) {
			binary = binary + ((int) (Math.pow(10, bit)) * (decimal % 2));
			decimal = decimal / 2;
			bit++;
		}
		return binary;
	}

	// EX6.2 Function
	public static int binaryToDecimal(int binary) {
		int decimal = 0;
		int bit = 0;
		while (binary > 0) {
			decimal = decimal + ((int) (Math.pow(2, bit)) * (binary % 10));
			binary = binary / 10;
			bit++;
		}
		return decimal;
	}

	// EX6.3 Function
	public static String decimalToHex(int decimal) {
		String hex = "";
		char hexValue;
		while (decimal > 0) {
			if ((decimal % 16) <= 9 && decimal % 16 >= 0) {
				hexValue = (char) ((decimal % 16) + '0');
			} else {
				hexValue = (char) ((decimal % 16) - 10 + 'A');
			}
			hex = hexValue + hex;
			decimal = decimal / 16;
		}
		return hex;
	}

	// EX6.4 Function 1
	public static int hexToDecimal(char[] hex) {
		int decimal = 0;
		int bit = hex.length - 1;
		for (int i = 0; i < hex.length; i++) {
			decimal = decimal + (hexCharToDecimal(hex[i]) * (int) Math.pow(16, bit));
			bit--;
		}
		return decimal;
	}

	// EX6.4 Function 2
	public static int hexCharToDecimal(char hexChar) {
		int decimal;
		decimal = hexChar - '0';
		if (decimal > 9)
			decimal = hexChar - 'A' + 10;
		return decimal;
	}

	// EX8 Function
	public static int[] sortArray(int[] array) {
		int[] sortArray = new int[array.length];
		int temp = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - 1; j++) {
				if (array[j] > array[j + 1]) {
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
		sortArray = array;
		return sortArray;
	}
	
    public static int binarySearch(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if      (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

	// Auxiliary functions
	public static void showMatrix(int[][] matrix) {
		String s = "";
		for (int i = 0; i < matrix.length; i++) {
			s += showArray(matrix[i], false);
			s += "\n";
		}
		showWithTextArea(s);
	}

	public static String showArray(int[] array, boolean showJ) {
		String s = "";
		for (int i : array) {
			s += String.valueOf(i + "   ");
		}
		if (showJ)
			showWithTextArea(s);
		return s;
	}

	public static void showWithTextArea(String s) {
		JTextArea textArea = new JTextArea(s);
		textArea.setColumns(50);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setSize(textArea.getPreferredSize().width, 3);
		JOptionPane.showMessageDialog(null, new JScrollPane(textArea), "Message", JOptionPane.WARNING_MESSAGE);
	}

	public static void printMatrix(int[][] matrix) {
		String s = "";
		for (int[] array : matrix) {
			for (int num : array) {
				s += String.valueOf(num + " ");
			}
			s += "\n";
		}
		System.out.println(s);
	}

	public static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
			if (i != array.length - 1)
				System.out.print(", ");
		}
	}

	public static String hexCharToString(char[] hex) {
		String result = "";
		for (int i = 0; i < hex.length; i++) {
			result += hex[i];
		}
		return result;
	}
}
