package Letter;


import Content.Content;
import CourrierProject.Inhabitant;

public abstract class Letter<C extends Content> {
	protected Inhabitant sender;	// inhabitant who send the letter
	protected Inhabitant receiver;	// inhabitant who receive the letter
	protected C content ;	// the content of the letter 
	
	/**
	 * create a letter 
	 * @param sender represent the inhabitant who send the letter
	 * @param receiver represent the inhabitant who receive the letter
	 * @param content represent the content of the letter
	 */
	public Letter(Inhabitant sender , Inhabitant receiver , C content) {
		this.sender = sender;
		this.receiver = receiver;
		this.content = content ;
	}
	
	// begin getters and setters
	
	public Inhabitant getSender() {
		return sender;
	}

	public void setSender(Inhabitant sender) {
		this.sender = sender;
	}

	public Inhabitant getReceiver() {
		return receiver;
	}

	public void setReceiver(Inhabitant receiver) {
		this.receiver = receiver;
	}

	public C getContent() {
		return content;
	}

	public void setContent(C content) {
		this.content = content;
	}
	
	// end getters and setters

	/**
	 * give a description of the letter
	 * @return description of the letter
	 */
	public String description(){
		return this.letterType()+" whose content is a "+content.description();
	}
	
	/**
	 * give letter's class name
	 * @return letter's class name
	 */
	public abstract String letterType ();

	/**
	 * calculate the total cost of the letter and his content
	 * @return the value of the total cost
	 */
	public int totalCost (){
		return getCost()+contentValue();
	}
	
	/**
	 * the inhabitant receive the letter 
	 */
	public void receive (){
		System.out.println("<- "+this.receiver+" receives "+this.description()+" from "+
	this.sender);
		this.doAction();
	}
	
	/**
	 * send the letter to his receiver if it's possible 
	 */
	public void send () {
		if (sender.equals(receiver)){
			throw new RuntimeException("receiver and sender are the same personne");
		}
		if (!sender.solvable(totalCost())){
			System.out.println (sender+" can't send "+this.description()+" because "
					+ "he havn't enough of money");
		}else{
			System.out.println("-> "+this.sender+" mails "+this.description()+" to "+
				this.receiver+" for a cost of "+this.getCost()+" euros");
			sender.debit(this.getCost());
			sender.getCity().getPostbox().add(this);
	
		}
	}
	
	/**
	 * the action to do when the letter is receive
	 */
	public abstract void doAction()  ;
	
	/**
	 * calculate the letter's expedition cost
	 * @return expedition cost
	 */
	public abstract int getCost();
	
	/**
	 * give the total value of this content
	 * @return the value of the content
	 */
	public int contentValue (){
		return content.getValue();
	}
	
}
