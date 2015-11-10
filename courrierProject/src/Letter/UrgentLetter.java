package Letter;

import courrierProject.Inhabitant;
import Content.UrgentContent;

public class UrgentLetter<U extends UrgentContent> extends SpecialLetter<U>{

	public UrgentLetter(Inhabitant sender, Inhabitant receiver,
			U content) {
		super(sender, receiver, content);
	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		
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
