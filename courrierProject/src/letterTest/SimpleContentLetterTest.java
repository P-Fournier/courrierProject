package letterTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Content.SimpleContent;
import Letter.SimpleContentLetter;

public abstract class SimpleContentLetterTest<S extends SimpleContent> extends LetterTest<S> {


	@Override
	public abstract SimpleContentLetter<S> createLetter() ;
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
