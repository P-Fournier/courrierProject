package Letter;

import Content.RegisterableContent;
import courrierProject.Inhabitant;


public abstract class SpecialLetter<R extends RegisterableContent> extends Letter<RegisterableContent> {

	public SpecialLetter(Inhabitant sender, Inhabitant receiver,
			R content) {
		super(sender, receiver, content);
	}

}
