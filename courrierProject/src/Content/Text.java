package Content;

public class Text implements SimpleContent {

	String content ; // the text's content
	
	/**
	 * create a text containing the text
	 * @param content is the text contains
	 */
	public Text(String content) {
		this.content = content ;
	}

	// begin getters and setters
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	// end getters and setters
	
	@Override
	public String description() {
		return "text content ("+content+")";
	}

	@Override
	public int contentValue() {
		return 0;
	}
	
	

}
