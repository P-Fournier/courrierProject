package LetterTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Content.UrgentContent;
import Letter.SpecialLetter;

public abstract class SpecialLetterTest<U extends UrgentContent> extends LetterTest<U>  {

	@Override
	public abstract SpecialLetter<U> createLetter() ;
	
	@Override
	public abstract SpecialLetter<U> createLetterWithSenderIsReceiver();
	
	@Override
	@Test
	public abstract void testLetterType();
	
	@Override
	@Test
	public void testDoAction(){
		SpecialLetter<U> letterTest = createLetter();
		MockRegisterableContent specialLetterContent = (MockRegisterableContent)letterTest.getContent();
		
		// check init
		
		assertFalse (specialLetterContent.isActionDo());
		
		letterTest.doAction();
		
		//check final statement
		
		assertTrue (specialLetterContent.isActionDo());
	
	}
	
	@Override
	@Test
	public abstract void testGetCost();

}
