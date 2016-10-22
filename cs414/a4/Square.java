/* 
 * Team cs414d
 */
package cs414.a4;

public class Square {
	private String color;
	private String name;
	private boolean isPurchasable;
	private Square next;
	
	public Square(String color,String name){
		this.color = color.toUpperCase();
		this.name = name.toUpperCase();
		setPurchasable(false);
		next = null;
	}
	// Getters
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
	
	public Player getOwner(){
		return null;
	}
	
	// Setters
	public void setNext(Square next){
		this.next = next;
	}
	
	public void setOwner(Player p){
		// Do nothing because regular squares cannot be owned by anyone
	}
	@Override
	public boolean equals(Object o){
		if(o instanceof Square){
			return ((Square) o).getName().equals(this.getName());
		}
		return false;
	}
	
	public boolean getPurchasable() {
		return isPurchasable;
	}
	
	public void setPurchasable(boolean isPurchasable) {
		this.isPurchasable = isPurchasable;
	}
}
