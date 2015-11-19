package LetterTest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import Content.UrgentContent;
import Letter.UrgentLetter;

public class UrgentLetterTest extends SpecialLetterTest<UrgentContent> {

	@Override
	public UrgentLetter createLetter() {
		MockRegisterableContent mockContent = new MockRegisterableContent(); // a registerable content is an urgent content
		return new UrgentLetter (sender , receiver , mockContent);
	}

	@Override
	public UrgentLetter createLetterWithSenderIsReceiver() {
		MockRegisterableContent mockContent = new MockRegisterableContent(); // a registerable content is an urgent content
		return new UrgentLetter (sender , sender , mockContent);
	}

	@Test
	@Override
	public void testLetterType() {
		UrgentLetter test = createLetter();
		String letterType = test.letterType();
		assertTrue(letterType.equals("an urgent letter"));
	}

	@Test
	@Override
	public void testGetCost() {
		UrgentLetter test = createLetter();
		int costContent = test.getContent().getCost();
		int cost = costContent*2;
		assertTrue(cost==test.getCost());
		
	}

}
