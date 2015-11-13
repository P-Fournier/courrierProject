package Letter;

import courrierProject.Inhabitant;
import Content.RegisterableContent;
import Content.SimpleContent;

public abstract class SimpleContentLetter<S extends SimpleContent> extends Letter<S> implements RegisterableContent{
	
	protected int cost = 1 ; // sending cost of a simple letter

	public SimpleContentLetter(Inhabitant sender, Inhabitant receiver, S content) {
		super(sender, receiver, content);
	}

	public int contentValue (){
		return content.contentValue();
	}

}
