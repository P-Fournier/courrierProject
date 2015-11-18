package Content;


public interface UrgentContent extends Content {
	// represent the content wich can be stock in an urgent letter
	/**
	 * return the cost of expedition of this content
	 * @return the cost
	 */
	public int getCost();
	/**
	 * made the action associate to the content
	 */
	public void doAction() ;
}
