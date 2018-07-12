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
import javax.swing.JOptionPane;

public class RPS {
	
	private String winnerName;
	private boolean win;
	private int choice;
	private int maxRound;
	private int players;
	private static Player p1;
	private static Player p2;
	private static int n;
	boolean replayBool = true;
	

	public RPS(int max, int numPlayers) {
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
	public  int choice(){
		double min = 1;
		double max = 3;
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
	public boolean winner(int a, int b) {
		Player temp = new Player();
		if(a == 1 && b == 3 || a == 2 && b == 1 || a == 3 && b == 2 ) {
			temp = getP1();
			temp.increasePCount();
			win = true;
		}
		else {
			temp = getP2();
			temp.increasePCount();
			win = false;
		}
		return win;
	}
	/*******************************************************************
     * 
     *  Function:       runGame()
     * 
     *  Description:    Starts and runs the rps game
     *
     **************************************************************/
	public void runGame() {
		String name = JOptionPane.showInputDialog("Please enter your name");
		p1 = new Player(name);
		p2 = new Player();
		while( p1.getPlayerCount() <= maxRound && p2.getPlayerCount() <= maxRound) {
			String[] choices = {"Rock", "Paper", "Scissors"};
			int ai = choice();
			n = JOptionPane.showOptionDialog(null, "Please make a choice","RPS",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,choices,choices[2]);
			winner(n, ai);
			String[] one = {"Ok"};
			String summary = p1.getPlayerName() + " has chosen: " + choices[n] + "\n" + p2.getPlayerName() + " has chosen: " + choices[ai - 1] + "\n" + winnerName(win) + "\n" + p1.getPlayerName() + " score: " + p1.getPlayerCount() + " \n" + p2.getPlayerName() + " score: " + p2.getPlayerCount();
			JOptionPane.showOptionDialog(null, summary ,"RPS",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,one,one[0]);
		}
			
	}
	public String winnerName(boolean r) {
		String temp = "";
		if( win ) {
			temp = p1.getPlayerName();
		}
		if( !win ) {
			temp = p2.getPlayerName();
		}
		return temp + " wins the round!";
	}

	public String getWinnerName() {
		return winnerName;
	}

	public void setWinnerName(String winnerName) {
		this.winnerName = winnerName;
	}
	public boolean isWin() {
		return win;
	}

	public void setWin(boolean win) {
		this.win = win;
	}
	public Player getP1() {
		return p1;
	}

	public  void setP1(Player p1) {
		this.p1 = p1;
	}

	public  Player getP2() {
		return p2;
	}

	public  void setP2(Player p2) {
		this.p2 = p2;
	}

	public  int getChoice() {
		return choice;
	}

	public  void setChoice(int choice) {
		this.choice = choice;
	}

	public  int getMaxRound() {
		return maxRound;
	}

	public  void setMaxRound(int maxRound) {
		this.maxRound = maxRound;
	}

	public  int getPlayers() {
		return players;
	}

	public void setPlayers(int players) {
		this.players = players;
	}
	
}
