package cs414.a4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

import javax.swing.JButton;

public class Controller {
	private Model model;
	private View view;

	public void addModel(Model m)
	  {model = m;}
	 
	public void addView(View v)
	  {view = v;}
	
	//Build/Return a Buy button: it calls the buyDeedThroughButton method in model
	JButton getBuyButton(){
		  JButton a = new JButton();
		  
		  a.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e)
			  {
				  System.out.println("Debug-Controller: " + "Buy button pressed");
				  model.buyDeedThroughButton();} 
		  });
		  
		  return a;
	}
	/*
	JButton getSellButton(){
		  HashSet<Square> temp = model.getDeeds();//deeds = property
		  //Hand view class deeds for player to select which deed to sell
		  Deed d = View.chooseDeeds(temp);
		  JButton b = new JButton();
		  
		  b.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e)
			  {
				  System.out.println("Debug-Controller: " + "Sell button pressed");
				  model.sellDeedThroughButton(d);} 
		  });
		  
		  return b;
	}
	*/
	JButton getRollDiceButton(){
		  JButton c = new JButton("Roll");
		  
		  c.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e){
				  System.out.println("Debug-Controller: " + "Roll Dice button pressed");
				  model.rollDiceThroughButton();
				  } 
		  });
		  
		  return c;
	}
	 
}

