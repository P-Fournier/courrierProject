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
}
