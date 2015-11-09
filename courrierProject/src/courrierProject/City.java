package courrierProject;

import java.util.ArrayList;
import java.util.List;

import Letter.Letter;

public class City {
	
	protected String name ;		//	Name of the city
	protected List<Letter<?>> postbox;		//	Postbox with the letter waiting for sending of the city
	
	/**
	 * create a new city 
	 * @param name city's name
	 */
	public City (String name){
		this.name = name;
		this.postbox = new ArrayList<Letter<?>>();
	}
	
	/**
	 * send of the letter in the destination city
	 * @param letter sent
	 */
	public void sendLetter(Letter<?> letter){
		
	}
	
	/**
	 * deal all the letter of the same city to their receiver and send the other
	 * to the city of destination
	 */
	public void distributeLetters(){
		for (Letter<?> l : postbox){
			
		}
	}
	
	public boolean sameCity (Letter<?> letter){
		return equals(letter.getReceiver().getCity());
	}
	
	
}
