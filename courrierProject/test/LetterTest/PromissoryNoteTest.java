package LetterTest;



import static org.junit.Assert.*;

import org.junit.Test;

import Content.Money;
import CourrierProject.City;
import Letter.PromissoryNote;
import Letter.ThanksLetter;

public class PromissoryNoteTest extends SimpleContentLetterTest<Money> {
	
	public int amount = 1000;

	@Override
	public PromissoryNote createLetter() {
		Money moneyTest = new Money (amount);
		return new PromissoryNote (sender,receiver,moneyTest);
	}

	@Override
	public PromissoryNote createLetterWithSenderIsReceiver() {
		Money moneyTest = new Money (amount);
		return new PromissoryNote (sender,sender,moneyTest);
	}

	@Test
	@Override
	public void testLetterType() {
		PromissoryNote test = createLetter();
		String letterType = test.letterType();
		assertTrue(letterType.equals("promissory note letter"));
		
	}

	@Test
	@Override
	public void testDoAction() {
		
		PromissoryNote test = createLetter();
		MockInhabitant sender = (MockInhabitant) test.getSender();
		MockInhabitant receiver = (MockInhabitant) test.getReceiver();
		int amount = test.getContent().getValue();
		City cityTest = sender.getCity();
		
		// check initial situation
		assertTrue(cityTest.getPostbox().isEmpty());
		assertFalse(sender.isDebit());
		assertFalse(receiver.isCredit());
		
		// check correct condition
		assertTrue(sender.solvable(amount)); // could pay
		assertTrue(receiver.solvable(1)); //could answer
		
		
		test.doAction();
		
		//check final statement
		assertFalse(cityTest.getPostbox().isEmpty());
		assertTrue(sender.isDebit());
		assertTrue(receiver.isCredit());
		
		ThanksLetter answer = (ThanksLetter) cityTest.getPostbox().get(0);
		assertTrue(answer.getRecept().equals(test));
		
	}
	
	@Test
	public void testDoActionWithNotMoneyEnoughForReceiver() {
		
		PromissoryNote test = createLetter();
		MockInhabitant sender = (MockInhabitant) test.getSender();
		MockInhabitant receiver = (MockInhabitant) test.getReceiver();
		int amount = test.getContent().getValue();
		City cityTest = receiver.getCity();
		receiver.unsolvable();
		
		// check initial situation
		assertTrue(cityTest.getPostbox().isEmpty());
		assertFalse(sender.isDebit());
		assertFalse(receiver.isCredit());
		
		// check correct condition
		assertTrue(sender.solvable(amount)); // could pay
		assertFalse(receiver.solvable(1)); //couldn't answer
		
		test.doAction();
		// thanks letter never send
		
		//check final statement
		assertTrue(cityTest.getPostbox().isEmpty());
		assertTrue(sender.isDebit());
		assertTrue(receiver.isCredit());
	
		
	}
	
	@Test(expected=RuntimeException.class)
	public void testDoActionWithNotMoneyEnoughForSender() {
		
		PromissoryNote test = createLetter();
		MockInhabitant sender = (MockInhabitant) test.getSender();
		MockInhabitant receiver = (MockInhabitant) test.getReceiver();
		int amount = test.getContent().getValue();
		City cityTest = sender.getCity();
		sender.unsolvable();
		
		// check initial situation
		assertTrue(cityTest.getPostbox().isEmpty());
		assertFalse(sender.isDebit());
		assertFalse(receiver.isCredit());
		
		// check correct condition
		assertFalse(sender.solvable(amount)); // couldn't pay
		assertTrue(receiver.solvable(1)); //could answer
		
		test.doAction();
		//exception expected
	
		
	}

	@Test
	@Override
	public void testGetCost() {
		PromissoryNote test = createLetter();
		int amount = test.getContent().getAmount();
		int cost = 1+ (amount /100);
		assertTrue(test.getCost()==cost);
		
	}
	
	
	
}
