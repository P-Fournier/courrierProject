package Letter;

import Content.Text;

public class ThanksLetter extends SimpleLetter{

	/**
	 * create a thanks letter answer to the letter past in parameter
	 * @param recept promissory note which is concern
	 */
	public ThanksLetter( PromissoryNote recept) {
		super(recept.getReceiver(),recept.getSender(), new Text("thanks for a "+recept.description()));
	}
	
	@Override
	public String letterType(){
		return "a thanks letter which is a "+super.letterType();
	}

}
