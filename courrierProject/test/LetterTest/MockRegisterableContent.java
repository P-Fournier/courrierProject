package LetterTest;

import Content.RegisterableContent;

public class MockRegisterableContent implements RegisterableContent {

	protected boolean actionDo ;
	
	public MockRegisterableContent (){
		actionDo = false;
	}
	
	@Override
	public int getCost() {
		return 0;
	}

	@Override
	public void doAction() {
		actionDo = true;
	}

	@Override
	public String description() {
		return "Mock registerable content";
	}

	@Override
	public int getValue() {
		return 0;
	}

	public boolean isActionDo() {
		return actionDo;
	}

	public void setActionDo(boolean actionDo) {
		this.actionDo = actionDo;
	}

	
	
	
}
