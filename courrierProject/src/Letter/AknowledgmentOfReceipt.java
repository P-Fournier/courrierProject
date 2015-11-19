package Letter;

import Content.Text;

public class AknowledgmentOfReceipt extends SimpleLetter {

	protected RegisteredLetter recept ;
	
	/**
	 * create an aknowledgment of receipt answer to the letter past in parameter
	 * @param recept registered letter which is concern
	 */
	public AknowledgmentOfReceipt( RegisteredLetter recept) {
		super(recept.getReceiver(),recept.getSender(), new Text("aknowledgment of receipt for a "+recept.description()));
		this.recept = recept ;
	}
	
	// begin getters and setters
	
	public RegisteredLetter getRecept() {
		return recept;
	}

	public void setRecept(RegisteredLetter recept) {
		this.recept = recept;
	}

	// end getters and setters

	@Override
	public String letterType(){
		return "an aknowledgment of receipt which is "+super.letterType();
	}

}
