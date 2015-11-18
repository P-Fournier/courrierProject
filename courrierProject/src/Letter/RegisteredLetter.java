package Letter;

import Content.RegisterableContent;
import Content.UrgentContent;
import courrierProject.Inhabitant;

public class RegisteredLetter extends SpecialLetter<RegisterableContent> implements UrgentContent {

	/**
	 * create a registered letter  
	 * @param sender represent the inhabitant who send the letter
	 * @param receiver represent the inhabitant who receive the letter
	 * @param content represent the content of the letter
	 */
	public RegisteredLetter(Inhabitant sender, Inhabitant receiver,
			RegisterableContent content) {
		super(sender, receiver, content);
	}

	@Override
	public void doAction()   {
		super.doAction();
		AknowledgmentOfReceipt aknowledgment = new AknowledgmentOfReceipt(this);
		aknowledgment.send();
	}

	@Override
	public int getCost() {
		return content.getCost()+15;
	}

	@Override
	public String letterType() {
		return "a registered letter";
	}

}
