package Letter;

import Content.Text;

public class AknowledgmentOfReceipt extends SimpleLetter {

	/**
	 * create an aknowledgment of receipt answer to the letter past in parameter
	 * @param recept registered letter which is concern
	 */
	public AknowledgmentOfReceipt( RegisteredLetter recept) {
		super(recept.getReceiver(),recept.getSender(), new Text("aknowledgment of receipt for a "+recept.description()));
	}
	
	@Override
	public String letterType(){
		return "an aknowledgment of receipt which is a "+super.letterType();
	}

}
