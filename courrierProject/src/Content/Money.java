package Content;

public class Money implements SimpleContent {
	protected int amount ; // le value of money for this content
	
	/**
	 * create a money
	 * @param amount value of the content create
	 */
	public Money (int amount){
		this.amount = amount ;
	}
	
	// begin of getters and setters
	
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	// end of getters and setters
	
	@Override
	public String description() {
		return "money content ("+amount+")";
	}

	@Override
	public int contentValue() {
		return amount ;
	}

}
