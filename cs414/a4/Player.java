package cs414.a4;

import java.util.HashSet;
import java.util.Set;

public class Player {
	private int id;
	private String name;
	private HashSet<Square> myDeeds;
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
	
	public Token getToken(){
		return token;
	}
	
	public HashSet<Square> getMyDeeds(){
		return myDeeds;
	}
	
	public void addDeed(Square d){
		myDeeds.add(d);
	} 
	
	public void removeDeed(Square d){
		myDeeds.remove(d);
	}
}
