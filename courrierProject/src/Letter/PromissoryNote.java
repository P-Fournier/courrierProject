package Letter;

import courrierProject.Inhabitant;
import Content.Money;

public class PromissoryNote extends SimpleLetter<Money> {
	
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
		return 1+(this.amount/100);
	}

}
