
public class Player {
    String playerName;
    int playerCount;
   
   
   public Player(String name){
	  playerName = name;
   }
   public Player(){
	   playerName = "Computer";
   }
     /**************************************************************
     * 
     *  Function:       getPlayerCount()
     * 
     *  Description:    Gets current player round count
     *
     *  @return         int playerCount
     *
     **************************************************************/
   public int getPlayerCount() {
		return playerCount;
	}
   public void increasePCount() {
		playerCount++;
	}
     /**************************************************************
     * 
     *  Function:       getPlayerName()
     * 
     *  Description:    Gets current player name
     *
     *  @return         String playerName
     *
     **************************************************************/
	public String getPlayerName() {
		return playerName;
	}
     /**************************************************************
     * 
     *  Function:       setPlayerName()
     * 
     *  Description:    Sets the current player name
     *
     *  @param          String s
     *
     **************************************************************/
	public void setPlayerName(String s) {
		playerName = s;
	}
     /**************************************************************
     * 
     *  Function:       setPlayerCount()
     * 
     *  Description:    Sets the current player round count
     *
     *  @param          int s
     *
     **************************************************************/
	public void setPlayerCount(int s) {
		playerCount = s;
	}
	public String toString() {
		return "Player: " + getPlayerName() + " Score: " + getPlayerCount();
	}
}