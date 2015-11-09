package Letter;

import courrierProject.Inhabitant;
import Content.Text;

public class TextLetter extends SimpleLetter<Text>{

	public TextLetter(Inhabitant sender, Inhabitant receiver, Text content) {
		super(sender, receiver, content);
	}

}
