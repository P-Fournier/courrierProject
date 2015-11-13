package Letter;

import Content.Text;

public class AknowledgmentOfReceipt extends SimpleLetter {

	public AknowledgmentOfReceipt( RegisteredLetter recept) {
		super(recept.getReceiver(),recept.getSender(), new Text("aknowledgment of receipt for a "+recept.description()));
	}
	
	@Override
	public String letterType(){
		return "an aknowledgment of receipt which is a "+super.letterType();
	}

}
