package Letter;

import Content.Text;
import courrierProject.Inhabitant;

public class AcknowledgmentOfReceipt extends TextLetter {

	public AcknowledgmentOfReceipt(Inhabitant sender, Inhabitant receiver,
			Text content) {
		super(sender, receiver, content);
	}

}
