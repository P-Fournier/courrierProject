package LetterTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Content.Content;
import CourrierProject.City;
import Letter.Letter;

public abstract class LetterTest<C extends Content> {
	
	City cityTest = new City ("CityTest");
	MockInhabitant sender = new MockInhabitant ("sender",cityTest);
	MockInhabitant receiver = new MockInhabitant ("receiver",cityTest);

	
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
	 * check that the letter type is correctly return
	 */
	@Test
	public abstract void testLetterType();
	
	/**
	 * check that the do action is correctly made
	 */
	@Test
	public abstract void testDoAction();
	
	/**
	 * check that the calcul of if the expedition is correct
	 */
	@Test
	public abstract void testGetCost();
	
	/**
	 * check that the total cost calculate is correct
	 */
	@Test
	public void testTotalCost() {
		Letter<C> letterTested = createLetter();
		int contentValue = letterTested.contentValue();
		int cost = letterTested.getCost();
		assertTrue(contentValue+cost==letterTested.totalCost());
	}

	/**
	 * check if the description of the letter is good
	 */
	@Test
	public void testDescription() {
		Letter<C> letterTested = createLetter();
		String letterType = letterTested.letterType();
		String contentDescription = letterTested.getContent().description();
		String middle = " whose content is a ";
		String total = letterType+middle+contentDescription ;
		assertTrue(total.equals(letterTested.description()));
	}
	
	/**
	 * check if the content value calculate is good
	 */
	@Test 
	public void testContentValue (){
		Letter<C> letterTested = createLetter();
		int contentValue = letterTested.getContent().getValue();
		assertTrue(contentValue==letterTested.contentValue());
	}
	
	/**
	 * check that a letter is send in a correct condition
	 */
	@Test
	public void testSendWithSuccess (){
		Letter<C> letterTested = createLetter();
		MockInhabitant sender = (MockInhabitant) letterTested.getSender();
		City postSender = sender.getCity();
		
		// test of the good sending condition
		
		assertTrue(sender.solvable(letterTested.totalCost()));
		
		// test the initial statement
		
		assertFalse(postSender.getPostbox().contains(letterTested));
		assertFalse(sender.isDebit());
		
		letterTested.send();
		
		// test the final condition
		
		assertTrue(postSender.getPostbox().contains(letterTested));
		assertTrue(sender.isDebit());
		
	}
	
	/**
	 * check that the letter is never send if the sender and the receiver are the same 
	 * inhabitant
	 */
	@Test(expected=RuntimeException.class)
	public void testSendWithFailSender(){
		Letter<C> letterTested = createLetterWithSenderIsReceiver();
		MockInhabitant sender = (MockInhabitant) letterTested.getSender();
		MockInhabitant receiver = (MockInhabitant) letterTested.getReceiver();
		
		// check initial condition
		
		assertTrue(sender.equals(receiver));
		
		letterTested.send();
		
	}
	
	/**
	 * check that the letter is not send if the sender is not solvable
	 */
	@Test
	public void testUnsendingLetterBecauseUnsolvable(){
		Letter<C> letterTested = createLetter();
		MockInhabitant sender = (MockInhabitant) letterTested.getSender();
		City postSender = sender.getCity();
		sender.unsolvable();
		
		//check initial condition
		
		assertFalse (postSender.getPostbox().contains(letterTested));
		assertFalse (sender.solvable(letterTested.totalCost()));
		
		letterTested.send();
		
		//check final condition
		
		assertFalse (sender.solvable(letterTested.totalCost()));
		
	}
	
}
