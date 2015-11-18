package letterTest;

import static org.junit.Assert.*;

import org.junit.Test;

import courrierProject.City;
import Content.UrgentContent;
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
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
