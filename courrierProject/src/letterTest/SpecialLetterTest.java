package letterTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Content.UrgentContent;
import Letter.SpecialLetter;

public abstract class SpecialLetterTest<U extends UrgentContent> extends LetterTest<U>  {

	@Override
	public abstract SpecialLetter<U> createLetter() ;
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
