import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class OnePlayerScreen extends JPanel{

	private JLabel draw, exit, playerone, playertwo, deck;
	private JComboBox sortlist;
	
	public OnePlayerScreen (){		
		setLayout(null);
		
		addMouseListener(new MouseADT("oneplayerscreen"));
		
		String[] algorithms = {"Binary Search Tree", "Insertion Sort"};
		sortlist = new JComboBox(algorithms);
		
		draw = new JLabel(); // clickable label to "draw" a card
		exit = new JLabel(); // clickable label to exit
		playerone = new JLabel(); // labels for players (names)
		playertwo = new JLabel();
		deck = new JLabel();

		draw.addMouseListener(new MouseADT("draw")); // mouse listeners to recognize when a label is clicked
		exit.addMouseListener(new MouseADT("exit"));
		playerone.addMouseListener(new MouseADT("playerone"));
		//playertwo.addMouseListener(new MouseADT("playertwo"));

		playerone.setBounds(10, 520, 150, 40); // sets the location and size of names of players
		playertwo.setBounds(10, 10, 150, 40);
		deck.setBounds(400, 225, 100, 150);
		
		deck.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		//add(draw);
		//add(exit);
		add(playerone); // adds these labels to the screen
		add(playertwo);
		add(deck);
		//add(sortlist);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g); 
		final ImageIcon gamebackground = new ImageIcon (getClass().getResource("/gameback.png"));
		final ImageIcon cardback = new ImageIcon (getClass().getResource("/back.png"));

			g.drawImage(gamebackground.getImage(), 0, 0, getWidth(), getHeight(), null);
				
			g.drawImage(cardback.getImage(), (900/2)-(cardback.getIconWidth()/2), 
				  	   (600/2)-(cardback.getIconHeight()/2), cardback.getIconWidth(), cardback.getIconHeight(), null);
		
		playerone.setText("PLAYER 1: "+Model.cardadt.getPlayer1Name()); // gets the names of the players in order to use them for the labels
		playertwo.setText("PLAYER 2: "+Model.cardadt.getPlayer2Name());
		
		playerone.setFont(new Font("Calibri", Font.ITALIC, 25)); // sets the font and size of the labels 
		playertwo.setFont(new Font("Calibri", Font.ITALIC, 25));
		
		try{
			drawCards(g);
		}catch(Exception e){}
	}
	
	private void drawCards (Graphics g){		
		for(int i = 0; i < Model.cardadt.getPlayer1Array().length; i++){
			String file = ("/"+Model.cardadt.getPlayer1Array()[i].cardnumber+Model.cardadt.getPlayer1Array()[i].cardtype+".png");
			Model.cardadt.setImageName(file);
			g.drawImage(Model.cardadt.getImageName().getImage(), 175+(25*(i+1)), 430, 100, 150, null);
		}
		
		for(int i = 0; i < Model.cardadt.getPlayer2Array().length; i++){
			String file = ("/"+Model.cardadt.getPlayer2Array()[i].cardnumber+Model.cardadt.getPlayer2Array()[i].cardtype+".png");
			Model.cardadt.setImageName(file);
			g.drawImage(Model.cardadt.getImageName().getImage(), 175+(25*(i+1)), 0, 100, 150, null);
		}
	}
}