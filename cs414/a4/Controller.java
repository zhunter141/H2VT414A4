package cs414.a4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

import javax.swing.JButton;

public class Controller {
	private Model model;
	private View view;

	public void addModel(Model m){
		model = m;
	}
	 
	public void addView(View v){
		view = v;
	}
	
	// Buttons and Action Listeners
	JButton getBuyButton(){
		  JButton buyButton = new JButton("Buy");
		  
		  buyButton.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e){
				  System.out.println("Debug-Controller: " + "Buy button pressed");
				  //model.buyDeedThroughButton();
				  } 
		  });
		  
		  return buyButton;
	}
	
	JButton getSellButton(){
		  //Hand view class deeds for player to select which deed to sell
		  JButton sellButton = new JButton("Sell");
		  
		  sellButton.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent e)
			  {
				  System.out.println("Debug-Controller: " + "Sell button pressed");
				  //HashSet<Square> playerDeeds = model.getDeeds();//deeds = property
				  // Square deedToSell = View.chooseDeeds(playerDeeds);
				  //model.sellDeedThroughButton(d);
			  } 
		  });
		  
		  return sellButton;
	}
	
	JButton getRollDiceButton(){
		  JButton rollButton = new JButton("Roll");
		  
		  rollButton.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e){
				  System.out.println("Debug-Controller: " + "Roll Dice button pressed");
				  //model.rollDiceThroughButton();
				  } 
		  });
		  
		  return rollButton;
	}
	
	JButton getEndTurnButton(){
		JButton endTurnButton = new JButton("End Turn");
		
		endTurnButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.println("Debug-Controller: "+ "End turn button pressed");
				model.endTurn();
			}
		});
		return endTurnButton;
	}
}

