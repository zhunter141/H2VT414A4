package cs414.a4;

import java.util.Set;

public class Player {
	private int id;
	private String name;
	private Set myDeeds;
	private Token token;
	
	public Player(int id, String name, Token token) {
		this.id = id;
		this.name = name;
		this.token = token;
	}
	
	public int getId(){
		return id;
	}
	
	public String getName(){
		return name;
	}
	
	public Set getMyDeeds(){
		return myDeeds;
	}
}
