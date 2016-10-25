package cs414.a4;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

import javax.swing.JButton;
import javax.swing.JComboBox;

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
	public JButton getBuyButton(){
		  JButton buyButton = new JButton("Buy");
		  
		  buyButton.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e){
				  System.out.println("Debug-Controller: " + "Buy button pressed");
				  model.buyDeed();
				  } 
		  });
		  return buyButton;
	}
	
	public JButton getSellButton(){
		  //Hand view class deeds for player to select which deed to sell
		  JButton sellButton = new JButton("Sell");
		  
		  sellButton.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent e)
			  {
				  System.out.println("Debug-Controller: " + "Sell button pressed");
				  HashSet<Square> playerDeeds = model.getDeeds();//deeds = property

				  view.chooseDeeds(playerDeeds);

			  } 
		  });
		  
		  return sellButton;
	}
	public JComboBox getSellComboBox(String[] label){
		  //Hand view class deeds for player to select which deed to sell
		
		  JComboBox sellCombo = new JComboBox(label);
		  
		  sellCombo.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent e)
			  {
				  System.out.println("Debug-Controller: " + "Sell combo box pressed");
				  //HashSet<Square> playerDeeds = model.getDeeds();//deeds = property
				

				  //model.sellDeedThroughButton(View.chooseDeeds(playerDeeds));
				  JComboBox cb = (JComboBox)e.getSource();
			      String nameOfDeed = (String) cb.getSelectedItem();
			      Square temp = new Square(Color.black,nameOfDeed);//A bought deed is black
			     
			      System.out.println(temp.getName());
			      model.sellDeed(temp);

			  } 
		  });
		  
		  return sellCombo;
	}
	
	public JButton getRollDiceButton(){
		  JButton rollButton = new JButton("Roll");
		  
		  rollButton.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e){
				  System.out.println("Debug-Controller: " + "Roll Dice button pressed");
				  model.rollDice();
				  } 
		  });
		  
		  return rollButton;
	}
	
	public JButton getEndTurnButton(){
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