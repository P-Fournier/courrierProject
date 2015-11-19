package CourrierProject;

import java.util.ArrayList;
import java.util.List;

import Letter.Letter;

public class City {

	protected String name ;		//	Name of the city
	protected ArrayList<Letter<?>> postbox;		//	Postbox with the letter waiting for sending of the city
	
	/**
	 * create a new city 
	 * @param name city's name
	 */
	public City (String name){
		this.name = name;
		this.postbox = new ArrayList<Letter<?>>();
	}
	
	/**
	 * deal all the letter of the same city to their receiver and send the other
	 * to the city of destination
	 */
	public void distributeLetters(){
		ArrayList<Letter<?>> postalMan = new ArrayList<Letter<?>>(postbox);
		for (Letter<?> l : postalMan){
			postbox.remove(l);
			l.receive();
		}
	}
	
	// begin getters and setters
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Letter<?>> getPostbox() {
		return postbox;
	}

	public void setPostbox(ArrayList<Letter<?>> postbox) {
		this.postbox = postbox;
	}

	// end getters and setters 

	/**
	 * test is the postbox is empty
	 * @return true if the postbox is empty
	 */
	public boolean postboxEmty() {
		return postbox.isEmpty();
	}
	
	@Override
	public String toString() {
		return name ;
	}
	
	
}
