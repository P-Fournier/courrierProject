package LetterTest;

import CourrierProject.City;
import CourrierProject.Inhabitant;

public class MockInhabitant extends Inhabitant {
	
	protected boolean debit , credit , solvable ;

	public MockInhabitant(String name, City city) {
		super(name, city);
		debit = false;
		credit = false;
		solvable = true;
	}
	
	public boolean isDebit() {
		return debit;
	}

	public void setDebit(boolean debit) {
		this.debit = debit;
	}

	public boolean isCredit() {
		return credit;
	}

	public void setCredit(boolean credit) {
		this.credit = credit;
	}
	
	/**
	 * makes the inhabitant unsolvable no matter the amount
	 */
	public void unsolvable (){
		solvable = false;
	}

	/**
	 * makes the inhabitant solvable no matter the amount
	 */
	public void beSolvable (){
		solvable = true;
	}

	@Override
	public void debit (int amount){
		debit = true;
	}
	
	@Override 
	public void credit(int amount){
		credit = true;
	}
	
	@Override
	public boolean solvable (int amount){
		return solvable;
	}
}
