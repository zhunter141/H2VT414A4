package cs414.a4;

public class Token {
	private String description;
	private Square currLoc;
	
	public Token(String description,Square loc){
		this.description = description;
		this.currLoc = loc;
	}
	
	public String getDescription(){
		return description;
	}
	
	public Square getLoc(){
		return currLoc;
	}
	public void move(){
		currLoc = currLoc.getNext();
	}
}
