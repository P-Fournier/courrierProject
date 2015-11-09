package courrierProject;

import Content.Money;
import Content.Text;
import Letter.Letter;
import Letter.PromissoryNote;
import Letter.RegisteredLetter;
import Letter.SimpleLetter;

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
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public int getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(int bankAccount) {
		this.bankAccount = bankAccount;
	}

	/**
	 * credit the inhabitant's bank account of the amount
	 * @param amount add to the bank account
	 */
	public void credit (int amount){
		if (amount<=0){
			throw new IllegalArgumentException();
		}else{
			this.bankAccount += amount ;
		}
	}
	
	/**
	 * dedit the inhabitant's bank account of the amount
	 * @param amount substract to the bank account
	 */
	public void dedit (int amount){
		if (amount<=0){
			throw new IllegalArgumentException();
		}else{
			this.bankAccount -= amount ;
		}
	}
	
	/**
	 * send the letter past in parameter 
	 * @param letter sent
	 */
	public void sendLetter (Letter<?> letter){
		
	}

	public Letter<?> createRandomLetter(Inhabitant receiver) {
		int randomChoose = (int) Math.random()* 2;
		Letter <?> create ;
		switch(randomChoose) {
		case 0:
			boolean validAmount;
			int amount = (int) Math.random()*bankAccount;
			Money money = new Money (amount);
			create = new PromissoryNote (this,receiver,money);
			return create ;
		case 1:
			Text text = new Text("blabla");
			create = new SimpleLetter (this,receiver,text);
			return create ;
		case  2:
			Letter <?> content = createRandomLetter(receiver);
			create = new RegisteredLetter (this,receiver,content);
		}
	}
	
	/**
	 * receive the letter past in parameter
	 * @param letter received
	 */
	public void receiveLetter(Letter<?> letter){
		
	}
}
