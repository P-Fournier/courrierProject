package letterTest;

import static org.junit.Assert.*;

import org.junit.Test;

import courrierProject.City;
import Content.Text;
import Letter.SimpleLetter;

public class SimpleLetterTest extends SimpleContentLetterTest<Text> {

	@Override
	public SimpleLetter createLetter() {
		City cityTest = new City ("CityTest");
		MockInhabitant inhabitantSender = new MockInhabitant ("sender",cityTest);
		MockInhabitant inhabitantReceiver = new MockInhabitant ("receiver",cityTest);
		Text textTest = new Text ("blabla test");
		return new SimpleLetter(inhabitantSender,inhabitantReceiver,textTest);
	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
