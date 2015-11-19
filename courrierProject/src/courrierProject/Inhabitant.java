package CourrierProject;

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
	
	// begin getters and setters 
	
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

	// end getters and setters 
	
	
	/**
	 * credit the inhabitant's bank account of the amount
	 * @param amount add to the bank account
	 */
	public void credit (int amount){
		if (amount<=0){
			throw new IllegalArgumentException();
		}else{
			this.bankAccount += amount ;
			System.out.println("  + "+this+" account is credited with "+amount+" euros ;  its balance is now "+this.bankAccount);
		}
	}
	
	/**
	 * test if the inhabitant is solvable for the amount past in parameter
	 * @param amount which is tried
	 * @return true if the inhabitant is solvable
	 */
	public boolean solvable (int amount){
		return amount<=bankAccount ;
	}
	
	/**
	 * dedit the inhabitant's bank account of the amount
	 * @param amount substract to the bank account
	 */
	public void debit (int amount){
		if ((amount<=0)||(!solvable(amount))){
			throw new IllegalArgumentException("You tried to debit an invalid amount"
					+ " : "+amount+" , bank account : "+bankAccount);
		}else{
			this.bankAccount -= amount ;
			System.out.println("  - "+amount+" euros are debited from "+this+" account whose balance is now "+this.bankAccount);
		}
	}
	
	@Override
	public String toString() {
		return name ;
	}

	/**
	 * create a letter of a random type
	 * @param receiver the letter's receiver
	 * @return letter created 
	 */
	public Letter<?> createRandomLetter(Inhabitant receiver) {
		int randomChoose = (int) (Math.random()* 3);
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
			create = new UrgentLetter(this,receiver,createUrgentableLetter(receiver));
			break;
		default:
			throw new RuntimeException ("there is a probleme with a random number creation");
		}
		return create;
	}
	/**
	 * create a letter that urgent letter could content
	 * @param receiver the letter's receiver
	 * @return the created letter
	 */
	public UrgentContent createUrgentableLetter(Inhabitant receiver) {
		int randomChoose = (int) (Math.random()* 2);
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
			return new RegisteredLetter(this,receiver,createSimpleContentLetter(receiver)) ;
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
		int randomChoose = (int) (Math.random()* 2);
		
		switch (randomChoose){
		case 0:
			/*
			 * create a promissory note
			 */
			int amount = (int) ((Math.random()*(500-1))+1);
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
	
}
