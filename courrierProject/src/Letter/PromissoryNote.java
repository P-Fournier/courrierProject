package Letter;

import Content.Money;
import courrierProject.City;
import courrierProject.Inhabitant;

public class PromissoryNote extends Letter<Money> {

	public PromissoryNote(Inhabitant receiver, Inhabitant sender, City city, Money content){
		super( receiver, sender,city,content);
	}
	
	public String description(){
		return "PromissoryNote";
	}
}
