package Letter;

import Content.Text;
import courrierProject.City;
import courrierProject.Inhabitant;

public class SimpleLetter extends Letter<Text> {
	
	public SimpleLetter(Inhabitant receiver, Inhabitant sender, City city, Text content){
		super(receiver, sender, city, content);
	}
	
	public String description(){
		return "SimpleLetter";
	}

}
