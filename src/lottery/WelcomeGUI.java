package lottery;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
  
public class WelcomeGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JLabel labelWelcome;

	private JButton button;
	private JButton rules;

	public WelcomeGUI(){
		// frame
        ImagePanel image = new ImagePanel("src/lottery/TOLO(5).jpg");
		setContentPane(image);
		setTitle("TOLO Bet Game ");//modif apres

		setSize(450, 350);
		setLocation(800, 300);
		getContentPane().setBackground(Color.LIGHT_GRAY); // Set the background color here

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		labelWelcome = new JLabel("TOLO GAME");
		labelWelcome.setFont(new Font("Serif", Font.PLAIN, 20));
		

		button = new JButton("Play");
		rules = new JButton("Rules");
		
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				BetGUI b = new BetGUI();
				b.setVisible(true);
				setVisible(false);
			}
		});

		getContentPane().setLayout(null);
		setResizable(false);
		
		rules.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				RulesGUI r = new RulesGUI();
				r.setVisible(true);
				setVisible(false);
			}
		});
		
		button.setBounds(265, 250, 100, 30);
		rules.setBounds(265, 200, 100, 30);

		add(button);
		add(rules);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new WelcomeGUI().setVisible(true);
			}
		});
	}
	class ImagePanel extends JPanel {
	    private static final long serialVersionUID = 1L;
		private BufferedImage backgroundImage;

	    public ImagePanel(String imagePath) {
	        try {
	            backgroundImage = ImageIO.read(new File("src/lottery/TOLO.jpg"));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        if (backgroundImage != null) {
	            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
	        }
	    }
	}
	
}
