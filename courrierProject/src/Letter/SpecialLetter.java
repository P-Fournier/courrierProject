package Letter;

import Content.UrgentContent;
import courrierProject.Inhabitant;


public abstract class SpecialLetter<U extends UrgentContent> extends Letter<U> {

	public SpecialLetter(Inhabitant sender, Inhabitant receiver,
			U content) {
		super(sender, receiver, content);
	}
	
	public int contentValue (){
		return content.contentValue();
	}
	
	public void doAction()  {
		content.doAction();
	}
}
