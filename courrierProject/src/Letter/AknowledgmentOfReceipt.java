package Letter;

import Content.RegisterableContent;
import Content.Text;

public class AknowledgmentOfReceipt<R extends RegisterableContent> extends SimpleLetter {

	public AknowledgmentOfReceipt( RegisteredLetter<R> recept) {
		super(recept.getReceiver(),recept.getSender(), new Text("aknowledgment of receipt for a "+recept.description()));
	}
	
	@Override
	public String letterType(){
		return "aknowledgment of receipt which is a "+super.letterType();
	}

}
