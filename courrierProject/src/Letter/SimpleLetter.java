package Letter;

import courrierProject.Inhabitant;
import Content.Text;

public class SimpleLetter extends SimpleContentLetter<Text>{

	public SimpleLetter(Inhabitant sender, Inhabitant receiver, Text content) {
		super(sender, receiver, content);
	}
	
	@Override
	public String letterType() {
		return "simple letter" ;
	}


}
