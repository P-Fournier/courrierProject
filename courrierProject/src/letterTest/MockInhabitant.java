package letterTest;

import courrierProject.City;
import courrierProject.Inhabitant;

public class MockInhabitant extends Inhabitant {
	
	boolean debit , credit ;

	public MockInhabitant(String name, City city) {
		super(name, city);
		debit = false;
		credit = false;
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



	@Override
	public void debit (int amount){
		debit = true;
	}
	
	@Override 
	public void credit(int amount){
		credit = true;
	}
}
