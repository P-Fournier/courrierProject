package Letter;

import Content.UrgentContent;
import courrierProject.Inhabitant;


public abstract class SpecialLetter<U extends UrgentContent> extends Letter<U> {

	/**
	 * create a special letter 
	 * @param sender represent the inhabitant who send the letter
	 * @param receiver represent the inhabitant who receive the letter
	 * @param content represent the content of the letter
	 */
	public SpecialLetter(Inhabitant sender, Inhabitant receiver,
			U content) {
		super(sender, receiver, content);
	}
	
	@Override
	public void doAction()  {
		content.doAction();
	}
	
	@Override
	public abstract String letterType();
	
	@Override
	public abstract int getCost();
}
