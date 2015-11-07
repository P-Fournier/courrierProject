package Letter;

import courrierProject.City;
import courrierProject.Inhabitant;

public class RegisteredLetter<L extends Letter<?>> extends SpecialLetter<L> {
	
	
	public RegisteredLetter(Inhabitant receiver, Inhabitant sender, City city, L content){
		
		
	}
	
	public String description(){
		return "RegisteredLetter";
	}
	

}
