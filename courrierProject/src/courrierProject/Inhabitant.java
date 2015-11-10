package courrierProject;

import Content.Money;
import Content.RegisterableContent;
import Content.Text;
import Content.UrgentContent;
import Letter.Letter;
import Letter.PromissoryNote;
import Letter.RegisteredLetter;
import Letter.SimpleLetter;
import Letter.UrgentLetter;

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
	
	/**
	 * create a letter of a random type
	 * @param receiver the letter's receiver
	 * @return letter created
	 */
	public Letter<?> createRandomLetter(Inhabitant receiver){
		int randomChoose = (int) Math.random()* 3;
		switch(randomChoose) {
		case 0:
			/*
			 * create a simpleContentLetter
			 */
			return (Letter<?>)createSimpleContentLetter(receiver);
		case 1:
			/*
			 * create a RegisteredLetter
			 */
			return (Letter<?>)createUrgentableLetter(receiver) ;
		case 2:
			/*
			 * create a UrgentLetter
			 */
			return new UrgentLetter<UrgentContent>(this,receiver,createUrgentableLetter(receiver));
		default:
			throw new RuntimeException ("there is a probleme with a random number creation");
		}
	}
	/**
	 * create a letter that urgent letter could content
	 * @param receiver the letter's receiver
	 * @return the created letter
	 */
	public UrgentContent createUrgentableLetter(Inhabitant receiver) {
		int randomChoose = (int) Math.random()* 2;
		switch(randomChoose) {
		case 0:
			/*
			 * create a simpleContentLetter
			 */
			return createSimpleContentLetter(receiver);
		case 1:
			/*
			 * create a RegisteredLetter
			 */
			return new RegisteredLetter<RegisterableContent>(this,receiver,createSimpleContentLetter(receiver)) ;
		default:
			throw new RuntimeException ("there is a probleme with a random number creation");
		}
	}
	
	/**
	 * create a letter that a registered letter could content
	 * @param receiver the letter's receiver
	 * @return the letter created
	 */
	public RegisterableContent createSimpleContentLetter(Inhabitant receiver){
		int randomChoose = (int) Math.random()* 4;
		switch (randomChoose){
		case 0:
			/*
			 * create a promissory note
			 */
			int amount = (int) Math.random()*bankAccount;
			Money money = new Money (amount);
			return new PromissoryNote (this,receiver,money);
		case 1:
			/*
			 * create a simple letter
			 */
			Text text = new Text("blabla");
			return new SimpleLetter (this,receiver,text);
		default:
			throw new RuntimeException ("there is a probleme with a random number creation");
		}
	}
	
	/**
	 * receive the letter past in parameter
	 * @param letter received
	 */
	public void receiveLetter(Letter<?> letter){
		
	}
}
