package Letter;

import Content.RegisterableContent;
import Content.SimpleContent;
import CourrierProject.Inhabitant;

public abstract class SimpleContentLetter<S extends SimpleContent> extends Letter<S> implements RegisterableContent{

	/**
	 * create a simple content letter
	 * @param sender represent the inhabitant who send the letter
	 * @param receiver represent the inhabitant who receive the letter
	 * @param content represent the content of the letter
	 */
	public SimpleContentLetter(Inhabitant sender, Inhabitant receiver, S content) {
		super(sender, receiver, content);
	}
	
	@Override
	public abstract void doAction();
	
	@Override
	public abstract String letterType();
	
	@Override
	public abstract int getCost();
	

}
