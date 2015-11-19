package LetterTest;


import static org.junit.Assert.assertTrue;

import org.junit.Test;

import Content.Text;
import Letter.SimpleLetter;

public class SimpleLetterTest extends SimpleContentLetterTest<Text> {

	@Override
	public SimpleLetter createLetter() {
		Text textTest = new Text ("blabla test");
		return new SimpleLetter(sender,receiver,textTest);
	}
	
	@Override
	public SimpleLetter createLetterWithSenderIsReceiver() {
		Text textTest = new Text ("blabla test");
		return new SimpleLetter(sender,sender,textTest);
	}

	@Test
	@Override
	public void testLetterType() {
		SimpleLetter test = createLetter();
		String letterType = test.letterType();
		assertTrue(letterType.equals("a simple letter"));
	}

	@Test
	@Override
	public void testDoAction() {
		// do nothing very well :p
	}

	@Test
	@Override
	public void testGetCost() {
		SimpleLetter test = createLetter();
		assertTrue(test.getCost()==test.cost);
	}
	
	

}
