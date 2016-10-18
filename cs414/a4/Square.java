/*  
 * Edited by Victor Fuentes 10/17/2016 
 */
package cs414.a4;

public class Square {
	private String color;
	private String name;
	private boolean isPurchaseable;
	
	public Square(String color,String name){
		this.color = color.toUpperCase();
		this.name = name.toUpperCase();
		isPurchaseable = false;
	}
	
	public String getColor(){
		return color;
	}
	
	public String getName(){
		return name;
	}
	
	
}
