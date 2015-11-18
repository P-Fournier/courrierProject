package letterTest;

import static org.junit.Assert.*;

import org.junit.Test;

import courrierProject.City;
import Content.Content;
import Letter.Letter;

public abstract class LetterTest<C extends Content> {
	
	/*City cityTest = new City ("CityTest");
	MockInhabitant sender = new MockInhabitant ("sender",cityTest);
	MockInhabitant receiver = new MockInhabitant ("receiver",cityTest);*/

	
	/**
	 * create a correct Letter
	 * @return the letter created 
	 */
	public abstract Letter<C> createLetter();
	
	/**
	 * create a letter wich sender is the receiver
	 * @return the letter created
	 */
	public abstract Letter<C> createLetterWithSenderIsReceiver();
	
	/**
	 * 
	 */
	@Test
	public abstract void testLetterType();
	
	/**
	 * 
	 */
	@Test
	public abstract void testDoAction();
	
	/**
	 * 
	 */
	public abstract void testGetCost();
	
	@Test
	public void testTotalCost() {
		Letter<C> letterTested = createLetter();
		int contentValue = letterTested.contentValue();
		int cost = letterTested.getCost();
		assertTrue(contentValue+cost==letterTested.totalCost());
	}

	@Test
	public void testDescription() {
		Letter<C> letterTested = createLetter();
		String letterType = letterTested.letterType();
		String contentDescription = letterTested.getContent().description();
		String middle = " whose content is a ";
		String total = letterType+middle+contentDescription ;
		assertTrue(total==letterTested.description());
	}
	
	@Test 
	public void testContentValue (){
		Letter<C> letterTested = createLetter();
		int contentValue = letterTested.getContent().getValue();
		assertTrue(contentValue==letterTested.contentValue());
	}
	
	@Test
	public void testSendWithSuccess (){
		Letter<C> letterTested = createLetter();
		MockInhabitant sender = (MockInhabitant) letterTested.getSender();
		City postSender = sender.getCity();
		
		// test of the good sending condition
		
		assertTrue(letterTested.totalCost()<sender.getBankAccount());
		assertTrue(letterTested.totalCost()>0);
		
		// test the initial statement
		
		assertFalse(postSender.getPostbox().contains(letterTested));
		assertFalse(sender.isDebit());
		
		letterTested.send();
		
		// test the final condition
		
		assertTrue(postSender.getPostbox().contains(letterTested));
		assertTrue(sender.isDebit());
		
	}
	
	@Test(expected=RuntimeException.class)
	public void testSendWithFailSender(){
		Letter<C> letterTested = createLetterWithSenderIsReceiver();
		MockInhabitant sender = (MockInhabitant) letterTested.getSender();
		MockInhabitant receiver = (MockInhabitant) letterTested.getReceiver();
		
		// check initial condition
		
		assertTrue(sender.equals(receiver));
		
		letterTested.send();
		
		
	}
	
}
