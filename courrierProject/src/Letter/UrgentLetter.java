package Letter;

import courrierProject.Inhabitant;
import Content.UrgentContent;

public class UrgentLetter extends SpecialLetter<UrgentContent>{

	public UrgentLetter(Inhabitant sender, Inhabitant receiver,
			UrgentContent content) {
		super(sender, receiver, content);
	}

	@Override
	public int getCost() {
		return content.getCost()*2;
	}

	@Override
	public String letterType() {
		return "an urgent letter";
	}

}
