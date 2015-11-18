package letterTest;

import static org.junit.Assert.*;

import org.junit.Test;

import courrierProject.City;
import Content.Money;
import Letter.ThanksLetter;

public class ThanksLetterTest extends SimpleLetterTest {
	
	int amountGive = 1000;
	
	@Override
	public ThanksLetter createLetter() {
		City cityTest = new City ("CityTest");
		MockInhabitant inhabitantSender = new MockInhabitant ("senderOfPromissory",cityTest);
		MockInhabitant inhabitantReceiver = new MockInhabitant ("receiverOfPromissory",cityTest);
		Money moneyTest = new Money (amountGive);
		MockPromissoryNote answerTest = new MockPromissoryNote (inhabitantSender,inhabitantReceiver,moneyTest);
		return new ThanksLetter (answerTest);
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
