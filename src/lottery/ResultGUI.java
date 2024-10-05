package lottery;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ResultGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel labelTitle;
	private JLabel labelDraw;
	private JLabel labelLucky;
	private JLabel labelGain;
	private JLabel labelNumbers;
	private JLabel gain;
	private JLabel luckynb;
	private JLabel sign;//change its position depending of the number of digits composing the gain

	private JButton button;
	private JButton welcomeButton;
	
	private BetGUI betGUI;
	private RulesGUI rulesGUI;
	
	public ResultGUI() {
	}

	public ResultGUI(Tolo t, int computedGain) {
		basicFrame();
		ArrayList<Integer> drawnNumbers = t.getDrawnNumbers();

		gain = new JLabel(Integer.toString(computedGain));
		labelNumbers = new JLabel(drawnNumbers.toString());
		
		gain.setFont(new Font("Serif", Font.PLAIN | Font.ITALIC, 20));
		labelNumbers.setFont(new Font("Serif", Font.PLAIN | Font.ITALIC, 20));

		gain.setBounds(90, 140, 200, 30);
		labelNumbers.setBounds(40,110,200,30);

		add(labelNumbers);
		add(gain);
		
	}
	public ResultGUI(Tolo t, int computedGain, int luck) {
		basicFrame();
		ArrayList<Integer> drawnNumbers = t.getDrawnNumbers();

		labelLucky = new JLabel("Lucky number :");
		luckynb = new JLabel(Integer.toString(luck));
		labelGain = new JLabel("Gain = ");
		gain = new JLabel(Integer.toString(computedGain));
		labelNumbers = new JLabel(drawnNumbers.toString());

		
		labelLucky.setFont(new Font("Serif", Font.PLAIN | Font.ITALIC, 17));
		luckynb.setFont(new Font("Serif", Font.PLAIN | Font.ITALIC, 17));
		labelGain.setFont(new Font("Serif", Font.PLAIN | Font.ITALIC, 17));
		gain.setFont(new Font("Serif", Font.PLAIN | Font.ITALIC, 17));
		labelNumbers.setFont(new Font("Serif", Font.PLAIN | Font.ITALIC, 17));

		
		labelLucky.setBounds(220, 80, 200, 30);
		luckynb.setBounds(250, 110, 200, 30);
		gain.setBounds(90, 140, 200, 30);
		labelNumbers.setBounds(40,110,200,30);

		add(labelNumbers);
		add(labelLucky);
		add(luckynb);
		add(gain);

}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new ResultGUI().setVisible(true);

			}
		});
	}
	public void playAgain(JButton button) {
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				betGUI = new BetGUI();
				betGUI.setVisible(true);
				setVisible(false);
			}
		});
	}
	
	public void firstFrame(JButton button) {
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rulesGUI = new RulesGUI();
				rulesGUI.setVisible(true);
				setVisible(false);
		       //dispose();
			}
		});
	}
	
	public void basicFrame() {

		setTitle("Tolo bet interface");
		setSize(450, 350);
		setLocation(800, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		getContentPane().setBackground(Color.LIGHT_GRAY); // Set the background color here


		labelTitle = new JLabel("Results for the last draw");
		labelDraw = new JLabel("Drawn numbers:");
		labelGain = new JLabel("Gain = ");
		sign = new JLabel("$ ");
		button = new JButton("One more round");
		welcomeButton = new JButton("Game rules");
		
		labelTitle.setFont(new Font("Serif", Font.PLAIN | Font.ITALIC, 20));
		labelDraw.setFont(new Font("Serif", Font.PLAIN | Font.ITALIC, 17));
		labelGain.setFont(new Font("Serif", Font.PLAIN | Font.ITALIC, 17));
		sign.setFont(new Font("Serif", Font.PLAIN | Font.ITALIC, 17));
		button.setFont(new Font("Serif", Font.PLAIN | Font.ITALIC, 17));
		welcomeButton.setFont(new Font("Serif", Font.PLAIN | Font.ITALIC, 17));

		labelTitle.setBounds(60, 20, 260, 30);
		labelDraw.setBounds(20, 80, 200, 30);
		labelGain.setBounds(20, 140, 200, 30);
		sign.setBounds(200, 140, 80, 30);
		button.setBounds(120, 200, 200, 30);
		welcomeButton.setBounds(120, 250, 200, 30);
		
		add(labelTitle);
		add(labelDraw);
		add(labelGain);
		add(sign);
		add(button);
		add(welcomeButton);

		firstFrame(welcomeButton);
		playAgain(button);
		
		getContentPane().setLayout(null);
		setResizable(false);

	}
}
