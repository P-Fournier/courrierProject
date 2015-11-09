package Letter;

import Content.RegisterableContent;
import Content.UrgentContent;
import courrierProject.Inhabitant;

public class RegisteredLetter<R extends RegisterableContent> extends SpecialLetter<RegisterableContent> implements UrgentContent {

	public RegisteredLetter(Inhabitant sender, Inhabitant receiver,
			R content) {
		super(sender, receiver, content);
	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getCost() {
		// TODO Auto-generated method stub
		return 0;
	}

}
