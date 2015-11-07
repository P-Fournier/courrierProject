package courrierProject;

import java.util.ArrayList;
import java.util.List;

import Content.Content;
import Letter.Letter;

public class City {
	
	protected String name ;		//	Name of the city
	protected List<Letter<Content>> postbox;		//	Postbox with the letter waiting for sending of the city
	
	/**
	 * create a new city 
	 * @param name city's name
	 */
	public City (String name){
		this.name = name;
		this.postbox = new ArrayList<Letter<Content>>();
	}
	
	
	
}
