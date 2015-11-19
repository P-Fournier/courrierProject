package LetterTest;


import org.junit.Test;

import Content.SimpleContent;
import Letter.SimpleContentLetter;

public abstract class SimpleContentLetterTest<S extends SimpleContent> extends LetterTest<S> {


	@Override
	public abstract SimpleContentLetter<S> createLetter() ;
	
	@Override
	public abstract SimpleContentLetter<S> createLetterWithSenderIsReceiver();

	@Override
	@Test
	public abstract void testLetterType();
	
	@Override
	@Test
	public abstract void testDoAction();
	
	@Override
	@Test
	public abstract void testGetCost();
}
