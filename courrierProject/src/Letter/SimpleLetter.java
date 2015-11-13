package Letter;

import courrierProject.Inhabitant;
import Content.Text;

public class SimpleLetter extends SimpleContentLetter<Text>{

	protected int cost = 1; 
	
	public SimpleLetter(Inhabitant sender, Inhabitant receiver, Text content) {
		super(sender, receiver, content);
	}
	
	@Override
	public String letterType() {
		return "a simple letter" ;
	}

	@Override
	public int getCost() {
		return cost ;
	}

	@Override
	public void doAction() {
		
	}
}
