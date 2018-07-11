
public class Player {
   private static String playerName;
   private static String pName;
   private static int playerCount;
   
   
   Player(String name){
      playerName = name;
   }
   Player(){
	   pName = "Computer";
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
	private void setPlayerCount(int s) {
		playerCount = s;
	}
	public String toString() {
		return "Player: " + this.getPlayerName() + " Score: " + this.getPlayerCount();
	}
}