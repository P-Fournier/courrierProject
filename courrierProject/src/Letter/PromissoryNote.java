package Letter;

import courrierProject.Inhabitant;
import Content.Money;

public class PromissoryNote extends SimpleContentLetter<Money> {

	public PromissoryNote(Inhabitant sender, Inhabitant receiver, Money content) {
		super(sender, receiver, content);
		
	}

	@Override
	public void doAction() {
		sender.debit(content.getAmount());
		receiver.credit(content.getAmount());
		ThanksLetter thanks = new ThanksLetter(this);
		thanks.send();
	}

	@Override
	public int getCost() {
		return (content.getAmount()/100)+1;
	}

	@Override
	public String letterType() {
		return "promissory note letter";
	}

}
