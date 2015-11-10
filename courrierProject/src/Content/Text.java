package Content;

public class Text implements SimpleContent {

	String content ;
	
	public Text(String content) {
		this.content = content ;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String description() {
		return "text content ("+content+")";
	}
	
	

}
