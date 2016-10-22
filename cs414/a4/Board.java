/* 
 * Team cs414d
 */
package cs414.a4;

public class Board {
	public Square initialize(){
		/*
		 *  Board layout is based on traditional Monopoly Game US version
		 *  From 'Start' Square go counter clockwise.
		 *  As per the assignment: 
		 *  "While there will be positions on the monopoly board for Chance and Community Chest, 
		 *   you do not need to implement the corresponding cards."
		 */
		  
		
		Square start = new Square("GREY","GO");
		
		// First 10 squares creation
		Deed   ma = new Deed("PURPLE","MIDITERRANEAN AVENUE",60,50,50);
		Square cc = new Square("GREY","COMMUNITY CHEST");
		Deed   ba = new Deed("PURPLE","BALTIC AVENUE",60,50,50);
		Square it = new Square("GREY","INCOME TAX");
		
		// Connection of first 10 squares
		start.setNext(ma);
		ma.setNext(cc);
		cc.setNext(ba);
		ba.setNext(it);
		
		return start;
	}
	
	public void move(int steps, Token t){
		for(int i=0;i<steps;i++){
			t.move();
		}
	}
}
