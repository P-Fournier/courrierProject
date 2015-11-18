package letterTest;

import static org.junit.Assert.*;

import org.junit.Test;

import courrierProject.City;
import Content.Money;

import Letter.PromissoryNote;

public class PromissoryNoteTest extends SimpleContentLetterTest<Money> {
	
	public int amount = 1000;

	@Override
	public PromissoryNote createLetter() {
		City cityTest = new City ("CityTest");
		MockInhabitant inhabitantSender = new MockInhabitant ("sender",cityTest);
		MockInhabitant inhabitantReceiver = new MockInhabitant ("receiver",cityTest);
		Money moneyTest = new Money (amount);
		return new PromissoryNote (inhabitantSender,inhabitantReceiver,moneyTest);
	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
}
