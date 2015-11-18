package letterTest;

import static org.junit.Assert.*;

import org.junit.Test;

import courrierProject.City;
import Letter.AknowledgmentOfReceipt;

public class AknowledgmentOfReceiptTest extends SimpleLetterTest {

	@Override
	public AknowledgmentOfReceipt createLetter() {
		City cityTest = new City ("CityTest");
		MockInhabitant inhabitantSender = new MockInhabitant ("sender of the registered letter",cityTest);
		MockInhabitant inhabitantReceiver = new MockInhabitant ("receiver of the registered letter",cityTest);
		MockRegisterableContent contentTest = new MockRegisterableContent();
		MockRegisteredLetter answerTest = new MockRegisteredLetter (inhabitantSender,inhabitantReceiver,contentTest);
		return new AknowledgmentOfReceipt (answerTest);
	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
