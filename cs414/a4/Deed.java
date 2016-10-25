package cs414.a4;

public class Deed extends Square {
	private int cost;
	private int houseCost;
	private int hotelCost;
	private Player owner;
	private int rentCost;
	
	public Deed(String color, String name,int cost,int houseCost,int hotelCost, int rentCost) {
		super(color,name);
		this.cost = cost;
		this.houseCost = houseCost;
		this.hotelCost = hotelCost;
		owner = null;
		this.setPurchasable(true);
		this.rentCost = rentCost;
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
	
	public void setOwner(Player o){
		this.owner = o;
		this.setPurchasable(false);
	}
	
	public int getRentCost(){
		return rentCost;
	}
	
	public Player getOwner(){
		return owner;
	}
}
