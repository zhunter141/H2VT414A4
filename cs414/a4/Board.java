/* 
 * Team cs414d
 */
package cs414.a4;

import java.awt.Color;
import java.util.ArrayList;

public class Board {
	private Square start;
	private ArrayList<Square> mySquares;
	
	public Board(){
		mySquares = new ArrayList<Square>();
	}
	public Square initialize(){
		/*
		 *  Board layout is based on traditional Monopoly Game US version
		 *  From 'Start' Square go counter clockwise.
		 *  As per the assignment: 
		 *  "While there will be positions on the monopoly board for Chance and Community Chest, 
		 *   you do not need to implement the corresponding cards."
		 */
		  
		// First 10 squares creation
		start = new Square(Color.GRAY,"GO");
		Deed kr = new Deed(Color.BLUE,"OLD KENT ROAD",60,50,50,50);
		Square cc1 = new Square(Color.GRAY,"COMMUNITY CHEST");
		Deed wr = new Deed(Color.BLUE,"WHITECHAPEL ROAD",60,50,50,50);
		Square it = new Square(Color.GRAY,"INCOME TAX");
		RailRoad kc = new RailRoad(Color.GRAY,"KINGS CROSS STATION",200,50);
		Deed ai = new Deed(Color.CYAN,"THE ANGEL ISLINGTON",100,50,50,50);
		Square ch1 = new Square(Color.GRAY,"CHANCE");
		Deed er = new Deed(Color.CYAN,"EUSTON ROAD",100,50,50,50);
		Deed pr = new Deed(Color.CYAN,"PENTONVILLE ROAD",120,50,50,50);
		
		mySquares.add(start);
		mySquares.add(kr);
		mySquares.add(cc1);// this is the 11th 
		mySquares.add(wr);
		mySquares.add(it);
		mySquares.add(kc);
		mySquares.add(ai);
		mySquares.add(ch1);
		mySquares.add(er);
		mySquares.add(pr);
		
		// Connection of first 10 squares
		start.setNext(kr);
		kr.setNext(cc1);
		cc1.setNext(wr);
		wr.setNext(it);
		it.setNext(kc);
		kc.setNext(ai);
		ai.setNext(ch1);
		ch1.setNext(er);
		er.setNext(pr);
		
		
		// Second 10 Squares creation
		Square ja = new Square(Color.GRAY,"JAIL");
		Deed pm = new Deed(Color.MAGENTA,"PALL MALL",140,50,50,50);
		Utility ec = new Utility(Color.GRAY, "ELECTRIC COMPANY", 150, 25);
		Deed wh = new Deed(Color.MAGENTA,"WHITEHALL",140,50,50,50);
		Deed na = new Deed(Color.MAGENTA,"NORTHUMRLD AVENUE",160,50,50,50);
		RailRoad ms = new RailRoad(Color.GRAY,"MARYLEBONE STATION",200,50);
		Deed bs = new Deed(Color.ORANGE,"BOW STREET",180,50,50,50);
		Square cc2 = new Square(Color.GRAY,"COMMUNITY CHEST");
		Deed mso = new Deed(Color.ORANGE,"MARLBOROUGH STREET",180,50,50,50);
		Deed vs = new Deed(Color.ORANGE,"VINE STREET",200,50,50,50);

		mySquares.add(ja);
		mySquares.add(pm);
		// Dummy squares
		for(int i=0;i<9;i++){
			mySquares.add(new Square(Color.LIGHT_GRAY,""));
		}
		mySquares.add(ec);//12
		mySquares.add(wh);
		
		// Dummy squares
		for(int i=0;i<9;i++){
			mySquares.add(new Square(Color.LIGHT_GRAY,""));
		}
		mySquares.add(na);
		mySquares.add(ms);
		// Dummy squares
		for(int i=0;i<9;i++){
			mySquares.add(new Square(Color.LIGHT_GRAY,""));
		}
		mySquares.add(bs);
		mySquares.add(cc2);
		// Dummy squares
		for(int i=0;i<9;i++){
			mySquares.add(new Square(Color.LIGHT_GRAY,""));
		}
		mySquares.add(mso);
		mySquares.add(vs);
		
		// Connection of second 11 squares
		pr.setNext(ja);
		ja.setNext(pm);
		pm.setNext(ec);
		ec.setNext(wh);
		wh.setNext(na);
		na.setNext(ms);
		ms.setNext(bs);
		bs.setNext(cc2);
		cc2.setNext(mso);
		mso.setNext(vs);
		
		// third 10 Squares creation
		Square fp = new Square(Color.GRAY,"FREE PARKING");
		Deed sr = new Deed(Color.RED,"STRAND",220,50,50,50);
		Square ch2 = new Square(Color.GRAY,"CHANCE");
		Deed fs = new Deed(Color.RED,"FLEET STREET",220,50,50,50);
		Deed ts = new Deed(Color.RED,"TRAFLGAR SQUARE",240,50,50,50);
		RailRoad fsr = new RailRoad(Color.GRAY,"FENCHURCH ST. STATION",200,50);
		Deed ls = new Deed(Color.YELLOW,"LEICESTER SQUARE",260,50,50,50);
		Deed cs = new Deed(Color.YELLOW,"CONVENTRY STREET",260,50,50,50);
		Utility ww = new Utility(Color.GRAY, "WATER WORKS", 150, 25);
		Deed py = new Deed(Color.YELLOW,"PICCADILLY",280,50,50,50);

		// Dummy squares
		for(int i=0;i<9;i++){
			mySquares.add(new Square(Color.LIGHT_GRAY,""));
		}
		mySquares.add(fp);
		mySquares.add(sr);
		// Dummy squares
		for(int i=0;i<9;i++){
			mySquares.add(new Square(Color.LIGHT_GRAY,""));
		}
		mySquares.add(ch2);
		mySquares.add(fs);
		// Dummy squares
		for(int i=0;i<9;i++){
			mySquares.add(new Square(Color.LIGHT_GRAY,""));
		}
		mySquares.add(ts);
		mySquares.add(fsr);
		// Dummy squares
		for(int i=0;i<9;i++){
			mySquares.add(new Square(Color.LIGHT_GRAY,""));
		}
		mySquares.add(ls);
		mySquares.add(cs);
		// Dummy squares
		for(int i=0;i<9;i++){
			mySquares.add(new Square(Color.LIGHT_GRAY,""));
		}
		mySquares.add(ww);
		mySquares.add(py);
		
		// Connection of third 10 squares
		vs.setNext(fp);
		fp.setNext(sr);
		sr.setNext(ch2);
		ch2.setNext(fs);
		fs.setNext(ts);
		ts.setNext(fsr);
		fsr.setNext(ls);
		ls.setNext(cs);
		cs.setNext(ww);
		ww.setNext(py);

		// fourth 10 Squares creation
		Square gj = new Square(Color.GRAY,"GO TO JAIL");
		Deed rs = new Deed(Color.GREEN,"REGENT STREET",300,50,50,50);
		Deed os = new Deed(Color.GREEN,"OXFORD STREET",300,50,50,50);
		Square cc3 = new Square(Color.GRAY,"COMMUNITY CHEST");
		Deed bn = new Deed(Color.GREEN,"BOND STREET",320,50,50,50);
		RailRoad lsr = new RailRoad(Color.GRAY,"LIBERPOOL ST. STATION",200,50);
		Square ch3 = new Square(Color.GRAY,"CHANCE");
		Deed pl = new Deed(Color.GREEN,"PARK LANE",350,50,50,50);
		Square lt = new Square(Color.GRAY,"LUXURY TAX");
		Deed mr = new Deed(Color.GREEN,"MAYFAIR",400,50,50,50);

		mySquares.add(gj);
		mySquares.add(rs);
		mySquares.add(os);
		mySquares.add(cc3);
		mySquares.add(bn);
		mySquares.add(lsr);
		mySquares.add(ch3);
		mySquares.add(pl);
		mySquares.add(lt);
		mySquares.add(mr);
		
		// Connection of fourth 10 squares
		py.setNext(gj);
		gj.setNext(rs);
		rs.setNext(os);
		os.setNext(cc3);
		cc3.setNext(bn);
		bn.setNext(lsr);
		lsr.setNext(ch3);
		ch3.setNext(pl);
		pl.setNext(lt);
		lt.setNext(mr);
	
		// connect back to GO
		mr.setNext(start);
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
	
	public ArrayList<Square> getSquares(){
		return mySquares;
	}
}
