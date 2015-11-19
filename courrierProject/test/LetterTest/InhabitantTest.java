package LetterTest;

import static org.junit.Assert.*;

import org.junit.Test;

import CourrierProject.Inhabitant;

public class InhabitantTest {

	/**
	 * create an inhabitant with an empty bank account
	 * @return the inhabitant
	 */
	public Inhabitant createPoor (){
		return new Inhabitant ("poor",null,0);
	}
	
	/**
	 * create an inhabitant with some money
	 * @return the inhabitant
	 */
	public Inhabitant createInhabitant (){
		return new Inhabitant ("middle class",null,3000);
	}
	
	/**
	 * test method solvable
	 */
	@Test
	public void SolvableTest() {
		Inhabitant test = createInhabitant();
		int amountTestOkay = test.getBankAccount()-1;
		int amountTestNotOkay = test.getBankAccount()+1;
		
		assertTrue (test.solvable(amountTestOkay));
		assertFalse (test.solvable(amountTestNotOkay));
	}
	
	/**
	 * test a good use of credit()
	 */
	@Test
	public void CreditWithSuccess () {
		Inhabitant test = createInhabitant();
		int amountCredit = 1000;
		int amountBegin = test.getBankAccount();
		
		test.credit(amountCredit);
		
		assertTrue((amountCredit+amountBegin)==test.getBankAccount());
	}
	
	/**
	 * test the case of a negatif amount for credit()
	 */
	@Test(expected=IllegalArgumentException.class)
	public void CreditANegatifAmount(){
		Inhabitant test = createInhabitant();
		int amountNegatif = -1 ;
		test.credit (amountNegatif);
	}
	
	/**
	 * test a good use of debit()
	 */
	@Test
	public void DebitWithSuccess () {
		Inhabitant test = createInhabitant();
		int amountDebit = test.getBankAccount()-1;
		
		test.debit(amountDebit);
		
		assertTrue(1==test.getBankAccount());
	}
	
	/**
	 * test the case of a negatif amount for debit()
	 */
	@Test(expected=IllegalArgumentException.class)
	public void DebitANegatifAmount(){
		Inhabitant test = createInhabitant();
		int amountNegatif = -1 ;
		test.debit (amountNegatif);
	}
	
	/**
	 * test the case of an excessif amount for debit()
	 */
	@Test(expected=IllegalArgumentException.class)
	public void DebitTooManyMoney(){
		Inhabitant test = createInhabitant();
		int excessiveAmount = test.getBankAccount()+1 ;
		test.debit (excessiveAmount);
	}
	

}
