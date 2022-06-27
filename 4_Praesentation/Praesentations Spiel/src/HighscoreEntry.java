
public class HighscoreEntry {
	int Punktzahl;
    String Name;
    /**
	 * creates a new object of Scores
	 * 
	 * @param   Punktzahl,  Name
	 * @return   -   
	 * @see       -
	 */
	public HighscoreEntry (int Punktzahl, String Name)
	
	{
	this.Punktzahl=Punktzahl;
	this.Name=Name;
	}
	  /**
		 * get method for Scores
		 * 
		 * @param   -
		 * @return  Score  
		 * @see       -
		 */
	public int getPunktzahl()
	{
	return  Punktzahl;	
	}
	  /**
		 * get method for names
		 * 
		 * @param   -
		 * @return   names
		 * @see       -
		 */
	public String  getName()
	{
		return Name;

	}
	
}
 