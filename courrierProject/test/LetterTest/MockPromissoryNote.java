package LetterTest;

import Content.Money;
import Letter.PromissoryNote;

public class MockPromissoryNote extends PromissoryNote {

	public MockPromissoryNote(MockInhabitant sender, MockInhabitant receiver,
			Money content) {
		super(sender, receiver, content);
	}
	
	@Override
	public String description(){
		return "mock promissory note";
	}

}
