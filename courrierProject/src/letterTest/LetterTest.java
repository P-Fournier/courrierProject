package letterTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Content.Content;
import Letter.Letter;

public abstract class LetterTest<C extends Content> {

	
	/**
	 * create a Letter
	 * @return 
	 */
	public abstract Letter<C> createLetter();
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
