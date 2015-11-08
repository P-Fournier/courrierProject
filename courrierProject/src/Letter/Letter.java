package Letter;

import Content.Content;
import courrierProject.City;
import courrierProject.Inhabitant;

public abstract class Letter<C extends Content> implements Content{
	
	//attributes
	protected Inhabitant receiver;
	protected Inhabitant sender;
	protected City city;
	protected C content;
	protected double cost;
	
	public Letter(Inhabitant receiver, Inhabitant sender, City city, C content){
		this.receiver = receiver;
		this.sender = sender;
		this.city = city;
		this.content = content;
	}
	
	public abstract String description();
	
	public void setCost(double cost){
		this.cost = cost;
	}
	
	public double getCost(){
		return this.cost;
	}
}
