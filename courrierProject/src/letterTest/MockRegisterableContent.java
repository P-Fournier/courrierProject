package letterTest;

import Content.RegisterableContent;

public class MockRegisterableContent implements RegisterableContent {

	public MockRegisterableContent (){
		
	}
	
	@Override
	public int getCost() {
		return 0;
	}

	@Override
	public void doAction() {
		
	}

	@Override
	public String description() {
		return "Mock registerable content";
	}

	@Override
	public int contentValue() {
		return 0;
	}

	
	
}
