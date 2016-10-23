/* 
 * Team cs414d
 */
package cs414.a4;

public class Board {
	private Square start;
	
	public Square initialize(){
		/*
		 *  Board layout is based on traditional Monopoly Game US version
		 *  From 'Start' Square go counter clockwise.
		 *  As per the assignment: 
		 *  "While there will be positions on the monopoly board for Chance and Community Chest, 
		 *   you do not need to implement the corresponding cards."
		 */
		  
		
		start = new Square("GREY","GO");
		
		// First 10 squares creation
		Deed   kr = new Deed("BROWN","OLD KENT ROAD",60,50,50,50);
		Square cc = new Square("GRAY","COMMUNITY CHEST");
		Deed   wr = new Deed("BROWN","WHITECHAPEL ROAD",60,50,50,50);
		Square it = new Square("GRAY","INCOME TAX");
		RailRoad kc = new RailRoad("GRAY","KINGS CROSS STATION",200,50);
		Deed ai = new Deed("BLUE","THE ANGEL ISLINGTON",100,50,50,50);
		Square ch1 = new Square("GRAY","CHANCE");
		Deed er    = new Deed("BLUE","EUSTON ROAD",100,50,50,50);
		
		// Connection of first 10 squares
		start.setNext(kr);
		kr.setNext(cc);
		cc.setNext(wr);
		wr.setNext(it);
		it.setNext(kc);
		kc.setNext(ai);
		ai.setNext(ch1);
		ch1.setNext(er);
		
		// Second 10 Squares creation
		Deed ma = new Deed("PURPLE","MIDITERRANEAN AVENUE",60,50,50,50);
		Deed ba = new Deed("PURPLE","BALTIC AVENUE",60,50,50,50);
		
		// Connection of second 10 squares
		er.setNext(ma);
		ma.setNext(ba);
		ba.setNext(start);
		
		return start;
	}
	
	public void move(int steps, Token t){
		for(int i=0;i<steps;i++){
			t.move();
		}
	}
	
	public Square getStart(){
		return start;
	}
}
