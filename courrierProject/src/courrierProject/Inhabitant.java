package courrierProject;

public class Inhabitant {
	
	protected String name ; //inhabitant's name
	protected City city ; //inhabitant's city
	protected int bankAccount ; //credit of the inhabitant's bank account

	/**
	 * create an inhabitant
	 * @param name inhabitant's name
	 * @param city inhabitant's city
	 * @param bankAccount credit of the inhabitant's bank account
	 */
	public Inhabitant(String name, City city, int bankAccount) {
		this.name = name;
		this.city = city;
		this.bankAccount = bankAccount;
	}
	
	/**
	 * create an inhabitant
	 * @param name inhabitant's name
	 * @param city inhabitant's city
	 */
	public Inhabitant(String name, City city) {
		this.name = name;
		this.city = city;
		this.bankAccount = 5000;
	}
	
	/**
	 * debit amount on the bank account
	 * @param int amount
	 */
	public void debit(int amount){
		this.bankAccount-=amount;
	}
	
	/**
	 * credit amount on the bank account
	 * @param int amount
	 */
	public void credit (int amount){
		this.bankAccount+=amount;
	}
	
	//getters and setters
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setCity(City city){
		this.city=city;
	}
	
	public City getCity(){
		return this.city;
	}
	
	public void setBankAccount(int n){
		this.bankAccount = n;
	}
	
	public int getBankAccount(){
		return this.bankAccount;
	}
}
