package Letter;

import courrierProject.City;
import courrierProject.Inhabitant;

public abstract class SpecialLetter<L extends Letter<?>> extends Letter<Letter<L>> {
	
	public SpecialLetter(Inhabitant receiver, Inhabitant sender, City city, Letter<L> content){
		super(receiver, sender, city, content);
	}
	
}
