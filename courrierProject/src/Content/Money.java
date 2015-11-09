package Content;

public class Money implements SimpleContent {
	protected int amount ;
	
	public Money (int amount){
		this.amount = amount ;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}
