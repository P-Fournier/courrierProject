package Letter;

import courrierProject.Inhabitant;
import Content.RegisterableContent;
import Content.SimpleContent;

public class SimpleLetter<S extends SimpleContent> extends Letter<SimpleContent> implements RegisterableContent{
	
	protected int cost = 1 ; // sending cost of a simple letter

	public SimpleLetter(Inhabitant sender, Inhabitant receiver, S content) {
		super(sender, receiver, content);
	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getCost() {
		// TODO Auto-generated method stub
		return 0;
	}

}
