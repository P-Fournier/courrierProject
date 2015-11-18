package letterTest;

import static org.junit.Assert.*;

import org.junit.Test;

import courrierProject.City;
import Content.RegisterableContent;
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
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
