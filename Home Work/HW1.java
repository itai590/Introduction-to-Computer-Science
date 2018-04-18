import javax.swing.JOptionPane;

public class HW1_ItaiCohen {
	//2
	// Itai Cohen

	public static void main(String args[]) {
		int newGame = 0;
		// run a new game
		while (newGame == 0) {
			boolean currentGame = true;
			int player1_counter = 0;
			int player2_counter = 0;
			String player1_name = "";
			String player2_name = "";

			// registrations for both players #1 and #2
			final String message_1 = "Please enter full name or player ";
			final String message_11 = "For practice: \nHow many secret numbers do"
					+ " you want to show: \nPress 1,2,3 or Cancel for none:";
			player1_name = JOptionPane.showInputDialog(message_1 + "#1");
			player2_name = JOptionPane.showInputDialog(message_1 + "#2");

			// generate 3 different random numbers
			final int min = 1, max = 5;
			int num_1 = 0, num_2 = 0, num_3 = 0;
			while (num_1 == num_2 || num_1 == num_3 || num_2 == num_3) {
				num_1 = (int) (Math.random() * (max - min + 1) + min);
				num_2 = (int) (Math.random() * (max - min + 1) + min);
				num_3 = (int) (Math.random() * (max - min + 1) + min);
			}

			// prompt user to select mode
			String mode = JOptionPane.showInputDialog(message_11);

			// run while there is no valid input
			Boolean askAgain = true;
			while (askAgain) {
				
				// print the random numbers according to mode
				switch ((mode != null) ? mode : "") {
				case "1":
					System.out.println("num_1: " + num_1);
					askAgain = false;
					break;
				case "2":
					System.out.println("num_1: " + num_1);
					System.out.println("num_2: " + num_2);
					askAgain = false;
					break;
				case "3":
					System.out.println("num_1: " + num_1);
					System.out.println("num_2: " + num_2);
					System.out.println("num_3: " + num_3);
					askAgain = false;
					break;
				case "":
					askAgain = false;
					break;
				default:
					JOptionPane.showMessageDialog(null, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
					mode = JOptionPane.showInputDialog(message_11);
					break;
				}
			}
			// run while there is no winner
			while (currentGame) {
				// player #1 turn
				// ask player #1 to guess
				String message_21 = "Player #1, " + player1_name + "\nPlease enter your first guess: (1-5)";
				String message_22 = "Player #2, " + player2_name + "\nPlease enter your first guess: (1-5)";
				final String message_3 = "You have already entered this number, Please insert diffrent one";
				int guess_1 = Integer.parseInt(JOptionPane.showInputDialog(message_21));
				message_21 = message_21.replace("first", "second");
				int guess_2 = Integer.parseInt(JOptionPane.showInputDialog(message_21));
				while (guess_1 == guess_2) {
					JOptionPane.showMessageDialog(null, message_3, "Error", JOptionPane.ERROR_MESSAGE);
					guess_2 = Integer.parseInt(JOptionPane.showInputDialog(message_21));
				}
				message_21 = message_21.replace("second", "third");
				int guess_3 = Integer.parseInt(JOptionPane.showInputDialog(message_21));
				while (guess_3 == guess_2 || guess_3 == guess_1) {
					JOptionPane.showMessageDialog(null, message_3, "Error", JOptionPane.ERROR_MESSAGE);
					guess_3 = Integer.parseInt(JOptionPane.showInputDialog(message_21));
				}

				// check for the number of correct guesses
				player1_counter = 0;
				if (guess_1 == num_1 || guess_1 == num_2 || guess_1 == num_3)
					player1_counter++;
				if (guess_2 == num_1 || guess_2 == num_2 || guess_2 == num_3)
					player1_counter++;
				if (guess_3 == num_1 || guess_3 == num_2 || guess_3 == num_3)
					player1_counter++;

				// print in console guess history
				System.out.println("Player #1, " + player1_name + " gussed: " + guess_1 + "," + guess_2 + "," + guess_3
						+ " --> " + player1_counter + " of them were correct");

				// show how many numbers were guessed correctly
				JOptionPane.showMessageDialog(null, player1_counter + " numbers were guessed correctly!", "Message",
						JOptionPane.INFORMATION_MESSAGE);

				// break if player #1 won
				if (player1_counter == 3)
					currentGame = false;

				// player#2 turn
				if (player1_counter != 3) {

					// ask player #2 to guess
					guess_1 = Integer.parseInt(JOptionPane.showInputDialog(message_22));
					message_22 = message_22.replace("first", "second");
					guess_2 = Integer.parseInt(JOptionPane.showInputDialog(message_22));
					while (guess_1 == guess_2) {
						JOptionPane.showMessageDialog(null, message_3, "Error", JOptionPane.ERROR_MESSAGE);
						guess_2 = Integer.parseInt(JOptionPane.showInputDialog(message_22));
					}
					message_22 = message_22.replace("second", "third");
					guess_3 = Integer.parseInt(JOptionPane.showInputDialog(message_22));
					while (guess_3 == guess_2 || guess_3 == guess_1) {
						JOptionPane.showMessageDialog(null, message_3, "Error", JOptionPane.ERROR_MESSAGE);
						guess_3 = Integer.parseInt(JOptionPane.showInputDialog(message_22));
					}

					// check for the number of correct guesses
					player2_counter = 0;
					if (guess_1 == num_1 || guess_1 == num_2 || guess_1 == num_3)
						player2_counter++;
					if (guess_2 == num_1 || guess_2 == num_2 || guess_2 == num_3)
						player2_counter++;
					if (guess_3 == num_1 || guess_3 == num_2 || guess_3 == num_3)
						player2_counter++;

					// print in console guess history
					System.out.println("Player #2, " + player2_name + " gussed: " + guess_1 + "," + guess_2 + ","
							+ guess_3 + " --> " + player2_counter + " of them were correct");

					// show how many numbers were guessed correctly
					JOptionPane.showMessageDialog(null, player2_counter + " numbers were guessed correctly!", "Message",
							JOptionPane.INFORMATION_MESSAGE);
					if (player2_counter == 3)
						currentGame = false;
				}
			}

			// find out the winner
			String winner = "";
			if (player2_counter > player1_counter)
				winner = "Player #2, " + player2_name + " won!";
			else if (player1_counter > player2_counter)
				winner = "Player #1, " + player1_name + " won!";
			else
				winner = "It's a tie";

			// show the winner and ask for a new game
			newGame = JOptionPane.showConfirmDialog(null,
					"Congratulations! \n" + winner + "\nDo you want to start a new game?", "Select an Option",
					JOptionPane.YES_NO_CANCEL_OPTION);
		}

		// show Program terminated message
		JOptionPane.showMessageDialog(null, "Program terminated", "Information", JOptionPane.INFORMATION_MESSAGE);
	}
}
