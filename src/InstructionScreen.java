import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class InstructionScreen extends JPanel{

	private JLabel title;
	
	public InstructionScreen (){
		setLayout(null);
		
		title = new JLabel("Go Back", SwingConstants.CENTER); // label to allow user to go back to title screen

		title.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		title.setFont(new Font("Calibri", Font.BOLD, 25));
		
		title.addMouseListener(new MouseADT("title")); // mouse listener added so we know where the cursor is clicking

		title.setForeground(new Color(0, 255, 0));
		
		title.setBounds(80, 70, 125, 50);
		
		add(title);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);  
		final ImageIcon infobackground = new ImageIcon (getClass().getResource("/instructionsback.png"));

		g.drawImage(infobackground.getImage(), 0, 0, getWidth(), getHeight(), null);
		g.setColor(new Color(0, 255, 0));
		g.fill3DRect(55, 87, 30, 15, true);
		int [] x = {55, 40, 55}; // creates arrow for "go back" label
		int [] y = {80, 94, 108};
		g.fillPolygon(x, y, 3);
	}
}