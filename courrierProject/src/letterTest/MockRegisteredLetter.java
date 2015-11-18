package letterTest;

import Letter.RegisteredLetter;

public class MockRegisteredLetter extends RegisteredLetter {

	public MockRegisteredLetter(MockInhabitant sender, MockInhabitant receiver,
			MockRegisterableContent content) {
		super(sender, receiver, content);
	}

	@Override
	public String description (){
		return "mock registered letter";
	}
	
	
}
