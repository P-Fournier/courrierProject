package Letter;

import courrierProject.Inhabitant;
import Content.Money;

public class PromissoryNote extends SimpleContentLetter<Money> {

	/**
	 * create a promissory note
	 * @param sender represent the inhabitant who send the letter
	 * @param receiver represent the inhabitant who receive the letter
	 * @param content represent the content of the letter
	 */
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

	@Override
	public int getValue() {
		return content.getValue();
	}

}
