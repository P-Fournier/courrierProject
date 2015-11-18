package letterTest;

import org.junit.Test;

import courrierProject.City;
import Content.UrgentContent;
import Letter.Letter;
import Letter.UrgentLetter;

public class UrgentLetterTest extends SpecialLetterTest<UrgentContent> {

	@Override
	public UrgentLetter createLetter() {
		City cityTest = new City ("CityTest");
		MockInhabitant inhabitantSender = new MockInhabitant ("sender",cityTest);
		MockInhabitant inhabitantReceiver = new MockInhabitant ("receiver",cityTest);
		MockRegisterableContent mockContent = new MockRegisterableContent(); // a registerable content is an urgent content
		return new UrgentLetter (inhabitantSender , inhabitantReceiver , mockContent);
	}

	@Override
	public Letter<UrgentContent> createLetterWithSenderIsReceiver() {
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
