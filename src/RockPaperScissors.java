/**
 * RockPaperScissors.java
 * Created on 12/10/2021
 * Last modified on 03/11/2021
 * No copyright
 * This class represents the game of rock, paper and scissors.
 * Version History: 1.0 - only pure code; 2.0 - comments added.
 * 
 * @author Mathew Philip Peedikayil
 * @version 2.0
 */

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

	Scanner scn = new Scanner(System.in);
	Random random = new Random();
	
	private static final String WELCOME_MSG = "--- Welcome to Rock Paper Scissors ! ---";
	private static final String QUIT_MSG = "--- Type 'quit' to end game at anytime ---";
	private static final String PLAYER_MOVE_MSG = "Make your move (rock/paper/scissors): ";
	private static final String COMPUTER_MOVE_MSG = "Move by computer (rock/paper/scissors): ";
	private static final String NOT_VALID_MSG = " is not valid !";
	private static final String THANKS_PLAYING_MSG = "Thanks for playing !";
	private static final String TIE_MSG = "Game was a tie !";
	private static final String WIN_MSG = "You win the game !";
	private static final String LOSE_MSG = "You lose the game !";
	
	private String[] choices = { "rock", "paper", "scissors" };
	private String moveByComputer;
	private String moveByPlayer;
	private boolean isEnded;

	/**
	 * initiates the game.
	 */
	public void playGame() {
		System.out.println(WELCOME_MSG);
		System.out.println(QUIT_MSG);
		System.out.println();
		isEnded = false;

		while (isEnded == false) {
			System.out.print(PLAYER_MOVE_MSG);
			moveByPlayer = scn.nextLine();
			moveByComputer = choices[new Random().nextInt(choices.length)];
			if (moveByPlayer.equals("quit")) {
				isEnded = true;
			} else {
				if (moveByPlayer.equals("rock") || moveByPlayer.equals("paper") || moveByPlayer.equals("scissors")) {
					System.out.println(COMPUTER_MOVE_MSG + moveByComputer);
					checksMoves(moveByPlayer, moveByComputer);
				} else {
					System.out.println(moveByPlayer + NOT_VALID_MSG);
				}
			}
		}
		scn.close();
		System.out.println(THANKS_PLAYING_MSG);
	}

	/**
	 * checks and compares the moves of the player and the computer while
	 * playing the game.
	 * 
	 * @param moveByPlayer
	 * @param moveByComputer
	 * @return output
	 */
	private String checksMoves(String moveByPlayer, String moveByComputer) {
		String output = "";
		if (moveByPlayer.equals(moveByComputer)) {
			System.out.println(TIE_MSG);
		} else if (moveByPlayer.equals("rock")) {
			if (moveByComputer.equals("paper")) {
				System.out.println(LOSE_MSG);
			} else if (moveByComputer.equals("scissors")) {
				System.out.println(WIN_MSG);
			}
		} else if (moveByPlayer.equals("paper")) {
			if (moveByComputer.equals("rock")) {
				System.out.println(WIN_MSG);
			} else if (moveByComputer.equals("scissors")) {
				System.out.println(LOSE_MSG);
			}
		} else if (moveByPlayer.equals("scissors")) {
			if (moveByComputer.equals("paper")) {
				System.out.println(WIN_MSG);
			} else if (moveByComputer.equals("rock")) {
				System.out.println(LOSE_MSG);
			}
		}
		return output;
	}

}