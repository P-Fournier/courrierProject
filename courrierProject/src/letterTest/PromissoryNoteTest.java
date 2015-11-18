package letterTest;



import org.junit.Test;

import courrierProject.City;
import Content.Money;
import Letter.Letter;
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

	@Override
	public Letter<Money> createLetterWithSenderIsReceiver() {
		// TODO Auto-generated method stub
		return null;
	}

	@Test
	@Override
	public void testLetterType() {
		// TODO Auto-generated method stub
		
	}

	@Test
	@Override
	public void testDoAction() {
		// TODO Auto-generated method stub
		
	}

	@Test
	@Override
	public void testGetCost() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
