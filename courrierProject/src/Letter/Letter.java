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



	public abstract void doAction();
	
	public abstract int getCost();
	
}
