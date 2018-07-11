
public class Computer {
   private static String computerName;
   private static int computerCount;
   
   
   Computer(String name){
      computerName = name;
   }
   Computer(){
	   
   }
     /**************************************************************
     * 
     *  Function:       getcomputerCount()
     * 
     *  Description:    Gets current computer round count
     *
     *  @return         int computerCount
     *
     **************************************************************/
   private int getcomputerCount() {
		return computerCount;
	}
     /**************************************************************
     * 
     *  Function:       getcomputerName()
     * 
     *  Description:    Gets current computer name
     *
     *  @return         String computerName
     *
     **************************************************************/
	private String getcomputerName() {
		return computerName;
	}
     /**************************************************************
     * 
     *  Function:       setcomputerName()
     * 
     *  Description:    Sets the current computer name
     *
     *  @param          String s
     *
     **************************************************************/
	private void setcomputerName(String s) {
		computerName = s;
	}
     /**************************************************************
     * 
     *  Function:       setcomputerCount()
     * 
     *  Description:    Sets the current computer round count
     *
     *  @param          int s
     *
     **************************************************************/
	private void setcomputerCount(int s) {
		computerCount = s;
	}
}