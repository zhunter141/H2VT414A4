package cs414.a4;

public class RailRoad extends Square{
	private int cost;
	
	public RailRoad(String color, String name,int cost) {
		super(color, name);
		this.cost = cost;
	}
	
	public int getCost(){
		return cost;
	}
}
