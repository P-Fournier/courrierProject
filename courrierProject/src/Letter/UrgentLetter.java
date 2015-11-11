package Letter;

import courrierProject.Inhabitant;
import Content.UrgentContent;

public class UrgentLetter<U extends UrgentContent> extends SpecialLetter<UrgentContent>{

	public UrgentLetter(Inhabitant sender, Inhabitant receiver,
			U content) {
		super(sender, receiver, content);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getCost() {
		return this.content.getCost() *2;
	}

}
