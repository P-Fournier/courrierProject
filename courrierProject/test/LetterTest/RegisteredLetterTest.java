package LetterTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import Content.RegisterableContent;
import CourrierProject.City;
import Letter.AknowledgmentOfReceipt;
import Letter.RegisteredLetter;

public class RegisteredLetterTest extends SpecialLetterTest<RegisterableContent> {

	@Override
	public RegisteredLetter createLetter() {
		MockRegisterableContent mockContent = new MockRegisterableContent();
		return new RegisteredLetter (sender , receiver , mockContent);
	}

	@Override
	public RegisteredLetter createLetterWithSenderIsReceiver() {
		MockRegisterableContent mockContent = new MockRegisterableContent();
		return new RegisteredLetter (sender , sender , mockContent);
	}

	@Test
	@Override
	public void testLetterType() {
		RegisteredLetter test = createLetter();
		String letterType = test.letterType();
		assertTrue(letterType.equals("a registered letter"));
	}

	@Test
	@Override
	public void testDoAction() {
		RegisteredLetter test = createLetter();
		MockRegisterableContent content = (MockRegisterableContent) test.getContent();
		MockInhabitant sender = (MockInhabitant) test.getSender();
		MockInhabitant receiver = (MockInhabitant) test.getSender();
		int amount = test.getContent().getValue();
		City cityTest = sender.getCity();
		
		// check initial situation
		assertTrue(cityTest.getPostbox().isEmpty());
		assertFalse(content.isActionDo());
		
		
		// check correct condition
		assertTrue(sender.solvable(amount)); // could pay
		assertTrue(receiver.solvable(1)); //could answer
		
		
		test.doAction();
		
		//check final statement
		assertFalse(cityTest.getPostbox().isEmpty());
		assertTrue(content.isActionDo());
		
		AknowledgmentOfReceipt answer = (AknowledgmentOfReceipt) cityTest.getPostbox().get(0);
		assertTrue(answer.getRecept().equals(test));
	}
	
	@Test
	public void testDoActionWithNotMoneyEnoughForReceiver() {
		
		RegisteredLetter test = createLetter();
		MockRegisterableContent content = (MockRegisterableContent) test.getContent();
		MockInhabitant sender = (MockInhabitant) test.getSender();
		MockInhabitant receiver = (MockInhabitant) test.getReceiver();
		int amount = test.getContent().getValue();
		City cityTest = sender.getCity();
		receiver.unsolvable();
		
		// check initial situation
		assertTrue(cityTest.getPostbox().isEmpty());
		assertFalse(content.isActionDo());
		
		// check correct condition
		assertTrue(sender.solvable(amount)); // could pay
		assertFalse(receiver.solvable(1)); //couldn't answer
		
		test.doAction();
		// aknowledgment of receipt never send
		
		//check final statement
		assertTrue(cityTest.getPostbox().isEmpty());
		assertTrue(content.isActionDo());
		
	}
	
	@Test(expected=RuntimeException.class)
	public void testDoActionWithNotMoneyEnoughForSender() {
		
		RegisteredLetter test = createLetter();
		MockRegisterableContent content = (MockRegisterableContent) test.getContent();
		MockInhabitant sender = (MockInhabitant) test.getSender();
		MockInhabitant receiver = (MockInhabitant) test.getReceiver();
		int amount = test.getContent().getValue();
		City cityTest = sender.getCity();
		sender.unsolvable();
		
		// check initial situation
		assertTrue(cityTest.getPostbox().isEmpty());
		assertFalse(content.isActionDo());
		
		
		// check correct condition
		assertFalse(sender.solvable(amount)); // could pay
		assertTrue(receiver.solvable(1)); //could answer
		
		
		test.doAction();
		
		// exception expected
	
		
	}

	@Test
	@Override
	public void testGetCost() {
		RegisteredLetter test = createLetter();
		int contentCost = test.getContent().getCost();
		int cost = contentCost+15;
		assertTrue (cost==test.getCost());
	}
	
	

}
