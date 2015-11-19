package LetterTest;

import Content.Content;
import CourrierProject.Inhabitant;
import Letter.Letter;

public class MockLetter extends Letter<Content> {

	protected boolean deal ;
	
	public MockLetter (Inhabitant sender , Inhabitant receiver , Content c ){
		super (sender,receiver,c);
		deal = false;
	}
	
	public boolean isDeal() {
		return deal;
	}



	public void setDeal(boolean deal) {
		this.deal = deal;
	}



	@Override
	public String letterType() {
		return "mock letter";
	}

	@Override
	public void doAction() {
		deal = true;
	}

	@Override
	public int getCost() {
		return 0;
	}

}
