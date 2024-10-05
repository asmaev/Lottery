package lottery;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RulesGUI extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private JLabel labelTitle;
	private JLabel labelRule1;
	private JLabel labelRule2;
	private JLabel labelPrize;
	
	private JButton play;

	public RulesGUI() {
		
		setTitle("Tolo bet game");
		setSize(450,450 );
		setLocation(800, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setBackground(Color.LIGHT_GRAY); // Set the background color here

		labelTitle = new JLabel("Game Rules");

		labelRule1 = new JLabel("<html>Bets: <ul>" +
                "<li>Normal Bet :" +
                "<ul>" + 
                "<li>Pick 4 distinct numbers.</li>" +
                "<li>Numbers have to be between 1 & 20." +
                "</li>" +
                "</ul>" +
                "</li>" +
                "<li>Super Bet" +
                "<ul>" + 
                "<li>Pick a lucky number within this range [1,10]</li>" +
                "</ul>" +
                "</li>" +
                "</ul></html>");
		
		labelRule2 = new JLabel("<html>Beware, no more than 1.000.000 $ for a bet! <ul>" );
                
				
		labelPrize = new JLabel("<html> Prize : <ul>" +
                "<li>Normal Bet :" +
                "<ul>" +
                "<li>4 good numbers = 50 * bet amount</li>" +
                "<li>3 good numbers = 5 * bet amount" +
                "</li>" +
                "</ul>" +
                "</li>" +
                "<li>Super Bet" +
                "<ul>" +
                "<li>4 good numbers = 50 * lucky number bet amount</li>" +
                "<li>3 good numbers = 5 * lucky number bet amount</li>" +
                "</ul>" +
                "</li>" +
                "</ul></html>");
		
		play = new JButton("Play");
		play.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				BetGUI b = new BetGUI();
				b.setVisible(true);
				setVisible(false);
			}
		});
		
		labelTitle.setFont(new Font("Serif", Font.PLAIN|Font.ITALIC, 20));
		labelRule1.setFont(new Font("Serif", Font.PLAIN|Font.ITALIC, 13));
		labelRule2.setFont(new Font("Serif", Font.PLAIN|Font.ITALIC, 13));
		labelPrize.setFont(new Font("Serif", Font.PLAIN|Font.ITALIC, 13));

        labelTitle.setForeground(Color.RED);
        labelRule1.setForeground(Color.BLUE);
        labelRule2.setForeground(Color.BLUE);
        labelPrize.setForeground(Color.BLUE);

        getContentPane().setLayout(null);
		setResizable(false);
		
		labelTitle.setBounds(150, 0, 400, 50);
		labelRule1.setBounds(20, 40, 400, 160);
		labelPrize.setBounds(20, 150, 400, 250);
		labelRule2.setBounds(20, 350, 400, 50);
		play.setBounds(165, 380, 100, 30);
		
		add(labelTitle);
		add(labelRule1);
		add(labelRule2);
		add(labelPrize);
		add(play);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new RulesGUI().setVisible(true);
			}
		});
	}
}
