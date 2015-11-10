package Letter;

import courrierProject.Inhabitant;
import Content.Money;

public class PromissoryNote extends SimpleContentLetter<Money> {
	
	protected int amount ; // amount of money in the letter

	public PromissoryNote(Inhabitant sender, Inhabitant receiver, Money content) {
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

	@Override
	public String letterType() {
		return "promissory note letter";
	}

}
