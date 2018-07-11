     /**************************************************************
     * 
     *            Simple Rock Paper Scissors game
     *  
     *  Author:      William Lindsey
     *  
     *  Created:     July 9th, 2018
     *  
     *  Description: Simple single player game with computer AI
     *  
     *  Project:     Game hub
     *
     **************************************************************/
import java.util.Scanner;

public class RPS {
	
	private static int count1;
	private static int count2;
	private static String playerName;
	private static String winnerName;
	private static Player p1;
	private static Player p2;
	private static int computerCount;
	private static boolean win;
	private static boolean catchEnd = true;
	private static int choice;
	private static int maxRound = 3; // set the max number of round wins
	private static int players;

	RPS(int max, int numPlayers) {
		maxRound = max;
		players = numPlayers;
		runGame();
	}
	
	/***************************************************************
     * 
     *  Function:       choice()
     * 
     *  Description:    Randomly chooses a number for computer player.
     *
     *  @return         integer between 1-3 inclusive
     *
     **************************************************************/
	private static int choice(){
		double min = 1;
		double max = 3;
		double range = (max - min) + 1;     
		return ((int)((Math.random() * range) + min));
	}
	/**************************************************************
     * 
     *  Function:       winner(int a, int b, int aCount, int bCount)
     * 
     *  Description:    Decides the winner of the round
     *
     *  @param          a - player choice  
     *  @param			b - computer AI choice
     *  @param 			aCount - player1 score count
     *  @param 			bCount - player2 score count
     *  
     *  @return         boolean- true on win for player,
     *  						 false on win for computer
     *
     **************************************************************/
	private static boolean winner(int a, int b, int aCount, int bCount) {
		String choice1 = "";
		String choice2 = "";
		System.out.println(p1.getPlayerName() + " choice is: " + intToText(a, choice1));
		System.out.println(p2.getPlayerName() + " choice is: " + intToText(b, choice2));
		if(a == 1 && b == 3 || a == 2 && b == 1 || a == 3 && b == 2 ) {
			aCount++;
			System.out.println(intToText(a, choice1) + " wins! Player score: " + count1 + " to Computer score: " + computerCount);
			win = true;
		}
		else {
			bCount++;
			System.out.println(intToText(b, choice2) + " wins! Player score: " + count2 + " to Computer score: " + computerCount);
			win = false;
		}
		return win;
	}
	private static String intToText(int a, String s) {
		if(a == 1) {
			s = "Rock";
		}
		if(a == 2) {
			s = "Paper";
		}
		if(a == 3) {
			s = "Scissors";
		}
		return s;
	}
	/*******************************************************************
     * 
     *  Function:       runGame()
     * 
     *  Description:    Starts and runs the rps game
     *
     **************************************************************/
	private static void runGame() {
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to rps! First to 3 score wins. In the case of tie, the computer wins.");
		System.out.println("Please enter your name");
		//String name = input.nextLine();
		p1 = new Player("Willaim");
		p2 = new Player("Computers");
		System.out.println(p1);
		System.out.println(p2);
		while( count1 <= maxRound && count2 <= maxRound) {
			System.out.println("Please make a choice: 1 = Rock, 2 = Paper, 3 = Scissors");
			choice = input.nextInt();
			winner(choice, choice(), count1, count2);
		System.out.println(winnerName(win));
		}
		System.out.println("Thanks for playing rps");
	}
	public static String winnerName(boolean r) {
		String temp = "";
		if( win ) {
			temp = p1.getPlayerName();
		}
		if( !win ) {
			temp = p2.getPlayerName();
		}
		return temp + " wins the round!";
	}
	
}
