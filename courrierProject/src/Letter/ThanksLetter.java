package Letter;

import Content.Text;

public class ThanksLetter extends SimpleLetter{

	protected PromissoryNote recept;
	
	/**
	 * create a thanks letter answer to the letter past in parameter
	 * @param recept promissory note which is concern
	 */
	public ThanksLetter( PromissoryNote recept) {
		super(recept.getReceiver(),recept.getSender(), new Text("thanks for a "+recept.description()));
		this.recept = recept ;
	}
	
	// begin getters and setters 
	
	public PromissoryNote getRecept() {
		return recept;
	}

	public void setRecept(PromissoryNote recept) {
		this.recept = recept;
	}

	// end getters and setters

	@Override
	public String letterType(){
		return "a thanks letter which is "+super.letterType();
	}

}
