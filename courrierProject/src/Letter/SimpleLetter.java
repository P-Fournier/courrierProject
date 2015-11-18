package Letter;

import courrierProject.Inhabitant;
import Content.Text;

public class SimpleLetter extends SimpleContentLetter<Text>{

	protected int cost = 1;  // expedition's cost
	
	/**
	 * create a simple letter
	 * @param sender represent the inhabitant who send the letter
	 * @param receiver represent the inhabitant who receive the letter
	 * @param content represent the content of the letter
	 */
	public SimpleLetter(Inhabitant sender, Inhabitant receiver, Text content) {
		super(sender, receiver, content);
	}
	
	@Override
	public String letterType() {
		return "a simple letter" ;
	}

	@Override
	public int getCost() {
		return cost ;
	}

	@Override
	public void doAction() {
		
	}

	@Override
	public int getValue() {
		return content.getValue();
	}
}
