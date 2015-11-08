package Content;

public class Text implements Content {
	
	protected String content;
	
	public Text(String content){
		this.content=content;
	}
	
	public void setContent(String content){
		this.content=content;
	}
	
	public String getContent(){
		return content;
	}

}
