package letterTest;

import org.junit.Test;

import courrierProject.City;
import Content.RegisterableContent;
import Letter.Letter;
import Letter.RegisteredLetter;

public class RegisteredLetterTest extends SpecialLetterTest<RegisterableContent> {

	@Override
	public RegisteredLetter createLetter() {
		City cityTest = new City ("CityTest");
		MockInhabitant inhabitantSender = new MockInhabitant ("sender",cityTest);
		MockInhabitant inhabitantReceiver = new MockInhabitant ("receiver",cityTest);
		MockRegisterableContent mockContent = new MockRegisterableContent();
		return new RegisteredLetter (inhabitantSender , inhabitantReceiver , mockContent);
	}

	@Override
	public Letter<RegisterableContent> createLetterWithSenderIsReceiver() {
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
