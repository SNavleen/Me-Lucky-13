import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class TitleScreen extends JPanel{ // panel for the titlescreen

	private JLabel play, instruction, exit; 
	
	public TitleScreen (){
		setLayout(null);
		
		play = new JLabel("Play"); // clickable label that allows the player to start a game
		instruction = new JLabel("Instruction"); // clickable label that allows the player to go to the screen with the instructions
		exit = new JLabel("Exit"); // clickable label that allows the user to exit

		play.setCursor(new Cursor(Cursor.HAND_CURSOR)); // changes appearance of cursor ("clickable") when going over a label
		instruction.setCursor(new Cursor(Cursor.HAND_CURSOR));
		exit.setCursor(new Cursor(Cursor.HAND_CURSOR));

		play.setFont(new Font("Calibri", Font.BOLD, 50)); // sets up text for the labels
		instruction.setFont(new Font("Calibri", Font.BOLD, 50));
		exit.setFont(new Font("Calibri", Font.BOLD, 50));
		
		play.addMouseListener(new MouseADT("play")); // uses a mouse listener to know when a label is clicked
		instruction.addMouseListener(new MouseADT("instruction"));
		exit.addMouseListener(new MouseADT("exit"));

		play.setForeground(Color.YELLOW); // sets colour of text
		instruction.setForeground(Color.YELLOW);
		exit.setForeground(Color.YELLOW);

		play.setBounds(160, 460, 125, 50); // sets the size of the labels
		instruction.setBounds(310, 510, 300, 50);
		exit.setBounds(625, 460, 125, 50);
		
		add(play); // adds these labels
		add(instruction);
		add(exit);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);  
		final ImageIcon titlebackground = new ImageIcon (getClass().getResource("/titleback.png")); // gets titlescreen image

		g.drawImage(titlebackground.getImage(), 0, 0, getWidth(), getHeight(), null); // uses it as the background
		g.setFont(new Font("Arial Black", Font.PLAIN, 50));
		g.setColor(Color.GREEN);
		g.drawString("ME LUCKY 13!", (Model.window.windowGetWidth()/3)-20, Model.window.windowGetHeight()/6);
	}
}
