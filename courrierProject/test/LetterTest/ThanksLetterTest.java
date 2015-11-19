package LetterTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Content.Money;
import Letter.ThanksLetter;

public class ThanksLetterTest extends SimpleLetterTest {
	
	int amountGive = 1000;
	
	@Override
	public ThanksLetter createLetter() {
		Money moneyTest = new Money (amountGive);
		MockPromissoryNote answerTest = new MockPromissoryNote (sender,receiver,moneyTest);
		return new ThanksLetter (answerTest);
	}

	@Override
	public ThanksLetter createLetterWithSenderIsReceiver() {
		Money moneyTest = new Money (amountGive);
		MockPromissoryNote answerTest = new MockPromissoryNote (sender,sender,moneyTest);
		return new ThanksLetter (answerTest);
	}
	
	@Test
	@Override
	public void testLetterType() {
		ThanksLetter test = createLetter();
		String letterType = test.letterType();
		assertTrue(letterType.equals("a thanks letter which is a simple letter"));
	}

}
