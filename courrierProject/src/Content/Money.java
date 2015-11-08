package Content;

public class Money implements Content {
	
	protected double amount;
	
	public Money(double amount){
		this.amount = amount;
	}
	
	public void setContent(double amount){
		this.amount=amount;
	}
	
	public double getContent(){
		return this.amount;
	}
}
