package letterTest;


import org.junit.Test;

import courrierProject.City;
import Content.Text;
import Letter.Letter;
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
	
	@Override
	public Letter<Text> createLetterWithSenderIsReceiver() {
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
