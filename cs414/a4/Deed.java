package cs414.a4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class Deed extends Square {
	private int cost;
	private int houseCost;
	private int hotelCost;
	private Player owner;
	
	public Deed(String color, String name,int cost,int houseCost,int hotelCost) {
		super(color,name);
		this.cost = cost;
		this.houseCost = houseCost;
		this.hotelCost = hotelCost;
		owner = null;
	}
	
	public int getCost(){
		return cost;
	}
	
	public int getHouseCost(){
		return houseCost;
	}

	public int getHotelCost(){
		return hotelCost;
	}
}
