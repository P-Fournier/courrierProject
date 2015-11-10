package Letter;

import Content.Text;

public class ThanksLetter extends SimpleLetter{

	public ThanksLetter( PromissoryNote recept) {
		super(recept.getReceiver(),recept.getSender(), new Text("thanks for a "+recept.description()));
	}
	
	@Override
	public String letterType(){
		return "thanks letter which is a "+super.letterType();
	}

}
