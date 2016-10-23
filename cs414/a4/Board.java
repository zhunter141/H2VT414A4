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
		  
		// First 10 squares creation
		start = new Square("GREY","GO");
		Deed   kr = new Deed("BROWN","OLD KENT ROAD",60,50,50,50);
		Square cc1 = new Square("GRAY","COMMUNITY CHEST");
		Deed   wr = new Deed("BROWN","WHITECHAPEL ROAD",60,50,50,50);
		Square it = new Square("GRAY","INCOME TAX");
		RailRoad kc = new RailRoad("GRAY","KINGS CROSS STATION",200,50);
		Deed ai = new Deed("TEAL","THE ANGEL ISLINGTON",100,50,50,50);
		Square ch1 = new Square("GRAY","CHANCE");
		Deed er    = new Deed("TEAL","EUSTON ROAD",100,50,50,50);
		Deed pr    = new Deed("TEAL","PENTONVILLE ROAD",120,50,50,50);
		
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
		Square ja = new Square("GRAY","JAIL");
		Deed pm = new Deed("PURPLE","PALL MALL",140,50,50,50);
		Utility ec = new Utility("GRAY", "ELECTRIC COMPANY", 150, 25);
		Deed wh = new Deed("PURPLE","WHITEHALL",140,50,50,50);
		Deed na = new Deed("PURPLE","NORTHUMRLD AVENUE",160,50,50,50);
		RailRoad ms = new RailRoad("GRAY","MARYLEBONE STATION",200,50);
		Deed bs = new Deed("ORANGE","BOW STREET",180,50,50,50);
		Square cc2 = new Square("GRAY","COMMUNITY CHEST");
		Deed mso = new Deed("ORANGE","MARLBOROUGH STREET",180,50,50,50);
		Deed vs = new Deed("ORANGE","VINE STREET",200,50,50,50);

		
		// Connection of second 10 squares
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
		Square fp = new Square("GRAY","FREE PARKING");
		Deed sr = new Deed("RED","STRAND",220,50,50,50);
		Square ch2 = new Square("GRAY","CHANCE");
		Deed fs = new Deed("RED","FLEET STREET",220,50,50,50);
		Deed ts = new Deed("RED","TRAFLGAR SQUARE",240,50,50,50);
		RailRoad fsr = new RailRoad("GRAY","FENCHURCH ST. STATION",200,50);
		Deed ls = new Deed("YELLOW","LEICESTER SQUARE",260,50,50,50);
		Deed cs = new Deed("YELLOW","CONVENTRY STREET",260,50,50,50);
		Utility ww = new Utility("GRAY", "WATER WORKS", 150, 25);
		Deed py = new Deed("YELLOW","PICCADILLY",280,50,50,50);

		
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
		Square gj = new Square("GRAY","GO TO JAIL");
		Deed rs = new Deed("GREEN","REGENT STREET",300,50,50,50);
		Deed os = new Deed("GREEN","OXFORD STREET",300,50,50,50);
		Square cc3 = new Square("GRAY","COMMUNITY CHEST");
		Deed bn = new Deed("GREEN","BOND STREET",320,50,50,50);
		RailRoad lsr = new RailRoad("GRAY","LIBERPOOL ST. STATION",200,50);
		Square ch3 = new Square("GRAY","CHANCE");
		Deed pl = new Deed("GREEN","PARK LANE",350,50,50,50);
		Square lt = new Square("GRAY","LUXURY TAX");
		Deed mr = new Deed("GREEN","MAYFAIR",400,50,50,50);


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
}
