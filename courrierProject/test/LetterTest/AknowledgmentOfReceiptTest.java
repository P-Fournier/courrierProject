package LetterTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Letter.AknowledgmentOfReceipt;

public class AknowledgmentOfReceiptTest extends SimpleLetterTest {

	@Override
	public AknowledgmentOfReceipt createLetter() {
		MockRegisterableContent contentTest = new MockRegisterableContent();
		MockRegisteredLetter answerTest = new MockRegisteredLetter (sender,receiver,contentTest);
		return new AknowledgmentOfReceipt (answerTest);
	}
	
	@Override
	public AknowledgmentOfReceipt createLetterWithSenderIsReceiver() {
		MockRegisterableContent contentTest = new MockRegisterableContent();
		MockRegisteredLetter answerTest = new MockRegisteredLetter (sender,sender,contentTest);
		return new AknowledgmentOfReceipt (answerTest);
	}
	
	@Test
	@Override
	public void testLetterType() {
		AknowledgmentOfReceipt test = createLetter();
		String letterType = test.letterType();
		assertTrue(letterType.equals("an aknowledgment of receipt which is a simple letter"));
	}

}
