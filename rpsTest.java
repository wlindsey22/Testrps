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

public class rpsTest {
	
	private static int playerCount;
	private static String playerName;
	private static String winnerName;
	private static Player p;
	private static Computer c;
	private static int computerCount;
	private static boolean win;
	private static boolean catchEnd = true;
	private static int choice;
	private static int max = 3; // set the max number of round wins

	public static void main( String[] args) {
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
		double min = 1; // min number that computer AI can choose
		double max = 3; // max number that computer AI can choose
		double range = (max - min) + 1;     
		return ((int)((Math.random() * range) + min));
	}
	/**************************************************************
     * 
     *  Function:       winner(int a, int b)
     * 
     *  Description:    Decides the winner of the round
     *
     *  @param          a - player choice  
     *  @param			b - computer AI choice
     *
     *  @return         boolean- true on win for player,
     *  						 false on win for computer
     *
     **************************************************************/
	private static boolean winner(int a, int b) {
		String playerChoice = "";
		String computerChoice = "";
		System.out.println("Player choice is: " + intToText(a, playerChoice));
		System.out.println("Computer choice is: " + intToText(b, computerChoice));
		if(a == 1 && b == 3 || a == 2 && b == 1 || a == 3 && b == 2 ) {
			playerCount++;
			System.out.println(intToText(a, playerChoice) + " wins! Player score: " + playerCount + " to Computer score: " + computerCount);
			win = true;
		}
		else {
			computerCount++;
			System.out.println(intToText(b, computerChoice) + " wins! Player score: " + playerCount + " to Computer score: " + computerCount);
			win = false;
		}
		catchEnd();
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
		String name = input.nextLine();
		p = new Player(name);
		c = new Computer();
		System.out.println(p);
		while( catchEnd == true ) {
			System.out.println("Please make a choice: 1 = Rock, 2 = Paper, 3 = Scissors");
			choice = input.nextInt();
			winner(choice, choice());
		}
		System.out.println(winnerName(win));
		System.out.println("Thanks for playing rps");
	}
	public static String winnerName(boolean r) {
		String temp = "";
		if( win ) {
			temp = p.getPlayerName();
		}
		if( !win ) {
			temp = "Computer Wins!";
		}
		return temp;
	}
	
}