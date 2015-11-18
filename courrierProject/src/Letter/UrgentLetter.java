package Letter;

import courrierProject.Inhabitant;
import Content.UrgentContent;

public class UrgentLetter extends SpecialLetter<UrgentContent>{

	/**
	 * create an urgent letter 
	 * @param sender represent the inhabitant who send the letter
	 * @param receiver represent the inhabitant who receive the letter
	 * @param content represent the content of the letter
	 */
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
