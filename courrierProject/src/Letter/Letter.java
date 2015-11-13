package Letter;


import courrierProject.Inhabitant;
import Content.Content;

public abstract class Letter<C extends Content> {
	protected Inhabitant sender;
	protected Inhabitant receiver;
	protected C content ;
	
	public Letter(Inhabitant sender , Inhabitant receiver , C content) {
		this.sender = sender;
		this.receiver = receiver;
		this.content = content ;
	}
	
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

	public int totalCost (){
		return getCost()+content.contentValue();
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
	 * send the letter to his receiver 
	 * @throws ExpeditionException 
	 */
	public void send () {
		if (totalCost()>receiver.getBankAccount()){
			System.out.println (sender+" can't send "+this.description()+" because "
					+ "he havn't enough of money");
		}else{
			System.out.println("-> "+this.sender+" mails "+this.description()+" to "+
				this.receiver+" for a cost of "+this.getCost()+" euros");
			sender.debit(this.getCost());
			sender.getCity().getPostbox().add(this);
	
		}
	}
	public abstract void doAction()  ;
	
	public abstract int getCost();
	
}
