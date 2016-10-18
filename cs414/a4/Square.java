/*  
 * Edited by Victor Fuentes 10/17/2016 
 */
package cs414.a4;

public class Square {
	private String color;
	private String name;
	private boolean isPurchasable;
	private Square next;
	private Player owner;
	
	public Square(String color,String name){
		this.color = color.toUpperCase();
		this.name = name.toUpperCase();
		isPurchasable = false;
		next = null;
		owner = null;
	}
	
	public String getColor(){
		return color;
	}
	
	public String getName(){
		return name;
	}
	
	public boolean isPurchasable(){
		return isPurchasable;
	}
	
	public Square getNext(){
		return next;
	}
	
	public void setNext(Square next){
		this.next = next;
	}
	
	public Player getOwner(){
		return owner;
	}
	
	@Override
	public boolean equals(Object o){
		if(o instanceof Square){
			return ((Square) o).getName().equals(this.getName());
		}
		return false;
	}
}
