package cs414.a4;

public class Utility extends Square{
	private int cost;
	
	public Utility(String color, String name, int cost){
		super(color,name);
		this.cost = cost;
	}
	
	public int getCost(){
		return cost;
	}
}
