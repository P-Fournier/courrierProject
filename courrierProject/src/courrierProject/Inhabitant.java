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
	 * @throws ExpeditionException 
	 */
	public void sendLetter (Letter<?> letter) throws ExpeditionException{
		if (!letter.getSender().equals(this)){
			throw new ExpeditionException("not the good sender");
		}
		if (letter.totalCost()>this.bankAccount){
			throw new ExpeditionException ("bank account not compatible with the letter cost");
		}
		System.out.println(this+" mails "+letter.description()+" to "+
				letter.getSender()+" for a cost of "+letter.getCost()+" euros");
		this.bankAccount -= letter.getCost();
		this.city.getPostbox().add(letter);
		System.out.println(letter.getCost()+" euros are debited from "+this+" account whose balance is now "+this.bankAccount);
		
	}
	
	/**
	 * create a letter of a random type
	 * @param receiver the letter's receiver
	 * @return letter created
	 * @throws ExpeditionException 
	 */
	public Letter<?> createRandomLetter(Inhabitant receiver) throws ExpeditionException{
		int randomChoose = (int) Math.random()* 3;
		Letter <?> create ;
		switch(randomChoose) {
		case 0:
			/*
			 * create a simpleContentLetter
			 */
			create = (Letter<?>)createSimpleContentLetter(receiver);
			break;
		case 1:
			/*
			 * create a RegisteredLetter
			 */
			create = (Letter<?>)createUrgentableLetter(receiver) ;
			break;
		case 2:
			/*
			 * create a UrgentLetter
			 */
			create = new UrgentLetter<UrgentContent>(this,receiver,createUrgentableLetter(receiver));
		default:
			throw new RuntimeException ("there is a probleme with a random number creation");
		}
		if (create.totalCost()<=bankAccount){
			return create;
		}else{
			throw new ExpeditionException("the letter you tried to create is to much expensive for you");
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
